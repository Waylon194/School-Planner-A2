package Simulation;

import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class PathFinder extends JPanel {
    public Map<Point2D, Integer> distanceMap;
    private List<Integer> collision;
    private List<Point> path;
    private List<Point> walls;
    boolean[][] map = new boolean[100][100];
    double[][] distance = new double[100][100];

    PathFinder() throws IOException, ParseException {
        collision = new Tileset().getLayer(5);
        walls = collisionLayer();
        for (int i = 0; i < 100; i++)
            map[0][i] = map[99][i] = map[i][0] = map[i][99] = true; // map border init
    }

    public Queue<Point> createPath(Point2D start, Point2D target) {
        calculateDistanceMap((int) target.getX() / 32, (int) target.getY() / 32);
        calculatePath((int) start.getX() / 32, (int) start.getY() / 32);
        return new LinkedList<>(path);
    }

    public static void main(String[] args) throws IOException, ParseException {
        JFrame frame = new JFrame("Path finder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new PathFinder());
        frame.setSize(950, 950);
        frame.setVisible(true);
    }

    public void calculatePath(int targetX, int targetY) {
        Point current = new Point(targetX, targetY);
        Queue<Point> points = new LinkedList<>();
        double currentDistance;
        points.offer(current);
        if (distanceMap.get(current) != null)
            currentDistance = distanceMap.get(current);
        else currentDistance = 0;
        path = new ArrayList<>();
        path.add(current);


        while (!points.isEmpty()) {
            current = points.poll();
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {

                    Point neighbour = new Point(current.x + x, current.y + y);

                    if (distanceMap.get(neighbour) == null) {
                        path.add(current);
                        path.add(neighbour);
                        continue;
                    }

                    double checkNew = distanceMap.get(neighbour);

                    if (checkNew == currentDistance - 1) {
                        currentDistance = checkNew;
                        points.offer(neighbour);
                        path.add(neighbour);
                    }
                }
            }
        }
    }

    public List<Point> collisionLayer() {
        List<Point> a = new ArrayList<>();
        for (int x = 0; x < 99; x++) {
            for (int y = 0; y < 99; y++) {
                if (this.collision.get(y * 100 + x) ==1873) {
                    a.add(new Point(x, y));
                }
            }
        }
        return a;
    }

    public List<Integer> getCollision() {
        return collision;
    }

    public List<Point> getWalls() {
        return walls;
    }

    public void calculateDistanceMap(int targetX, int targetY) {
        distanceMap = new HashMap<>();
        double d;

        for (int x = 0; x < 100; x++)
            for (int y = 0; y < 100; y++)
                distance[x][y] = Integer.MAX_VALUE;

        map[targetX][targetY] = false;

        Queue<Point> points = new LinkedList<>();
        points.offer(new Point(targetX, targetY));
        distance[targetX][targetY] = 0;

        while (!points.isEmpty()) {
            Point2D p = points.poll();
            if (walls.contains(p)) {
                d = Integer.MAX_VALUE;
                distanceMap.put(p, (int) d);
                continue;
            }

            for (int x = -1; x <= 1; x++) {
                if (p.getX() + x < 0 || p.getX() >= 100) {
                    continue;
                }
                for (int y = -1; y <= 1; y++) {
                    // Check new point is inside field
                    if (p.getY() + y < 0 || p.getY() + y >= 100 || Math.abs(x) == Math.abs(y)) {
                        continue;
                    }

                    d = distance[(int) p.getX()][(int) p.getY()] + Math.sqrt(x * x + y * y);

                    if (d < distance[(int) p.getX() + x][(int) p.getY() + y] && !map[(int) p.getX() + x][(int) p.getY() + y]) {

                        distance[(int) p.getX() + x][(int) p.getY() + y] = d;
                        map[(int) p.getX() + x][(int) p.getY() + y] = false;
                        points.offer(new Point(((Point) p).x + x, ((Point) p).y + y));
                        distanceMap.put(new Point(((Point) p).x + x, ((Point) p).y + y), (int) d);
                    }
                }
            }
        }
    }

}