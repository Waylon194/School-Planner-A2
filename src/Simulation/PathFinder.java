package Simulation;

import javafx.scene.effect.Light;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class PathFinder extends JPanel {
    public Map<Point2D,Integer> distanceMap;
    private ArrayList<Integer> collision;
    private List<Point> path;

    {
        try {
            collision = new ArrayList<>(new Tileset().getLayerData(5, 6));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    boolean[][] map = new boolean[100][100];
    double[][] distance = new double[100][100];

    int targetX;
    int targetY;

    boolean fillValue;

    PathFinder() {
//        for (int i = 0; i < 1000; i++)
//            map[(int) (Math.random() * 100)][(int) (Math.random() * 100)] = true; // map randomizer
        for (int i = 0; i < 100; i++)
            map[0][i] = map[99][i] = map[i][0] = map[i][99] = true; // map border init

        //TODO Dit moet weg in de echte code anders klopt de targetX en targetY niet dan voert hij altijd de distancemap voor dit punt uit
        calculateDistanceMap(45, 18);
        calculatePath(18, 20);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Color color;

        int w = getWidth() / 100;
        int h = getHeight() / 100;
        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                if (map[x][y]) {
                    g2.setColor(Color.black);
                } else {
                    float dist = (float) distance[x][y] / 100;
                    if (dist > 1)
                        dist = 1;
                    g2.setColor(new Color(dist, 1 - dist, 0.0f));
                }
                g2.fillRect(x * w, y * h, w, h);
                g2.setColor(Color.black);
                g2.drawString("" + distanceMap.get(new Point(x, y)), x * w, y * h);
            }
        }

        g2.setColor(Color.green);
        g2.fillRect(targetX * w, targetY * h, w, h);

        for (int x = 0; x < 99; x++) {
            for (int y = 0; y < 99; y++) {
                g2.setColor(Color.black);
                Point cur = new Point(x, y);
                for (Point e : path) {
                    if (e.equals(cur))

                        g2.fillRect(x * w, y * h, w, h);
                }
            }

        }

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
        points.offer(current);
        double currentDistance = distanceMap.get(current);
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

                    if (checkNew == currentDistance-1) {
                        currentDistance = checkNew;
                        points.offer(neighbour);
                        path.add(neighbour);
                    }
                }
            }
        }
        System.out.println(path);
    }

    public void calculateDistanceMap(int targetX, int targetY) {
        distanceMap = new HashMap<>();
        ArrayList<Point> collisionTilesList = new ArrayList<>();
        for (int x = 0; x < 100-1; x++) {
            for (int y = 0; y < 100-1; y++) {
                if (this.collision.get(y * 100 + x) > 0) {
                    collisionTilesList.add(new Point(x, y));
                }
            }
        }

//        System.out.println(collisionTilesList);
//        System.out.println(collisionTilesList.size());

        for (int x = 0; x < 100; x++)
            for (int y = 0; y < 100; y++)
                distance[x][y] = Integer.MAX_VALUE;

        map[targetX][targetY] = false;

        Queue<Point> points = new LinkedList<>();
        points.offer(new Point(targetX, targetY));
        distance[targetX][targetY] = 0;

        while (!points.isEmpty()) {
            Point2D p = points.poll();

            for (int x = -1; x <= 1; x++) {
                if (p.getX() + x < 0 || p.getX() >= 100) {
                    continue;
                }
                for (int y = -1; y <= 1; y++) {
                    // Check new point is inside field
                    if (p.getY() + y < 0 || p.getY() + y >= 100 || Math.abs(x) == Math.abs(y)) {
                        continue;
                    }

                    double d = distance[(int) p.getX()][(int) p.getY()] + Math.sqrt(x * x + y * y);

                    if (collisionTilesList.contains(p)) {
                        d = Integer.MAX_VALUE;
                        distanceMap.put(p,(int)d);
                    }

                    if (d < distance[(int) p.getX() + x][(int) p.getY() + y] && !map[(int) p.getX() + x][(int) p.getY() + y]) {

                        distance[(int) p.getX() + x][(int) p.getY() + y] = d;
                        map[(int) p.getX() + x][(int) p.getY() + y] = false;
                        points.offer(new Point(((Point) p).x + x, ((Point) p).y + y));
                        distanceMap.put(new Point(((Point) p).x + x, ((Point) p).y + y), (int)d);
                    }
                }
            }
        }
        int test = 0;
    }
}