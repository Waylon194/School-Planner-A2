package Simulation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Visitor {
    private Point2D position;
    private double angle;
    private int c = 32;
    private double size = 1;
    private double speed;
    double frameTime = 0.1;
    private double simSpeed = 2;
    int frame = 0;
    private Point2D target;
    private int currentFrame;
    private double turn = 1;
    private double sValue = 1.5 * simSpeed;
    private Point2D mainTarget;
    private BufferedImage[] tilesGeorge;
    private PathFinder p;
    private Queue<Point> path;
    private Point current;
    private List<Area> walls;
    private BufferedImage[] walkRight;
    private BufferedImage[] walkLeft;
    private BufferedImage[] walkForward;
    private BufferedImage[] walkBackward;


    public Visitor(Point2D position, PathFinder p, Simulation sim) {

        this.p = p;
        this.walls = sim.getWalls();
        this.currentFrame = 0;
        this.position = position;
        this.angle = 0;
        this.target = new Point2D.Double(18 * c, 22 * c);
        this.mainTarget = target;
        this.path = p.createPath(position, target);
        this.current = path.poll();
        this.target = new Point2D.Double(current.getX() * c, current.getY() * c);

        try {
            BufferedImage imageGeorge = ImageIO.read(new File("Resources/Character/george.png"));
            tilesGeorge = new BufferedImage[16];

            walkRight = new BufferedImage[4];
            walkForward = new BufferedImage[4];
            walkBackward = new BufferedImage[4];
            walkLeft = new BufferedImage[4];

            for (int i = 0; i < 16; i++) {
                tilesGeorge[i] = imageGeorge.getSubimage(48 * (i % 4), 48 * (i / 4), 48, 48);
            }
            walkRight[0] = tilesGeorge[3];
            walkRight[1] = tilesGeorge[7];
            walkRight[2] = tilesGeorge[11];
            walkRight[3] = tilesGeorge[15];

            walkLeft[0] = tilesGeorge[1];
            walkLeft[1] = tilesGeorge[5];
            walkLeft[2] = tilesGeorge[9];
            walkLeft[3] = tilesGeorge[13];

            walkForward[0] = tilesGeorge[2];
            walkForward[1] = tilesGeorge[6];
            walkForward[2] = tilesGeorge[10];
            walkForward[3] = tilesGeorge[14];

            walkBackward[0] = tilesGeorge[0];
            walkBackward[1] = tilesGeorge[4];
            walkBackward[2] = tilesGeorge[8];
            walkBackward[3] = tilesGeorge[12];

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Point2D getPosition() {
        return position;
    }


    public void update(ArrayList<Visitor> visitors, double deltaTime) {

        //implementation of the pathing
        target = new Point2D.Double(current.getX() * c, current.getY() * c);
        if (position.distance(target) < 16 + simSpeed)
            if (path.isEmpty())
                speed = 0;
            else current = path.poll();
        else speed = sValue;

        // switches animation frame and calculates new position
        if (currentFrame < 3) {
            currentFrame++;
        } else currentFrame = 0;
        Point2D newPosition = new Point2D.Double(
                this.position.getX() + this.speed * Math.cos(angle),
                this.position.getY() + this.speed * Math.sin(angle));

        //checks collision with visitors and walls
        boolean hasCollision = false;
        Point2D wallPos = null;
        for (Area wall : walls) {
            if (wallCollision(newPosition, wall)) {
                hasCollision = true;
                wallPos = new Point2D.Double(wall.getBounds2D().getCenterX(), wall.getBounds2D().getCenterY());
                break;
            }
        }
        for (Visitor visitor : visitors) {
            if (visitor != this && visitor.hasCollision(newPosition)) {
                hasCollision = true;
                while (visitor.hasCollision(this.position))
                    this.position = new Point2D.Double(
                            this.position.getX(),
                            this.position.getY() + 1);
                break;
            }
        }
        if (!hasCollision) {
            this.position = newPosition;
        } else {
            if (target.getX() - position.getX() > 0)
                this.angle += turn;
            else
                this.angle -= turn;
            if (wallPos != null)
                WallCorrection(stuckSolver(wallPos));
        }

        Point2D diff = new Point2D.Double(target.getX() - this.position.getX(), target.getY() - this.position.getY());
        double targetAngle = Math.atan2(diff.getY(), diff.getX());
        double angleDiff = targetAngle - angle;
        while (angleDiff > Math.PI)
            angleDiff -= 2 * Math.PI;
        while (angleDiff < -Math.PI)
            angleDiff += 2 * Math.PI;
        if (angleDiff < -0.1)
            angle -= 0.2 * simSpeed;
        else if (angleDiff > 0.1)
            angle += 0.2 * simSpeed;
        else
            this.angle = targetAngle;

        frameTime -= deltaTime;
        if (frameTime < 0) {
            frameTime = 1 / 30.0;
            frame = (frame + 1) % 8;
        }
    }

    public double getSValue() {
        return this.sValue;
    }

    public void draw(Graphics2D g) {
        AffineTransform tx = new AffineTransform();
        tx.translate(position.getX() - 24*size, position.getY() - 24*size);
        tx.scale(size,size);

        if (angle < 0) {
            tx.rotate(angle - Math.PI / 2, 24, 24);
            g.drawImage(walkBackward[currentFrame], tx, null);
        } else {
            tx.rotate(angle - 3 * Math.PI / 2, 24, 24);
            g.drawImage(walkForward[currentFrame], tx, null);
        }

        //debug
        g.setColor(Color.RED);
        g.fill(new Ellipse2D.Double(target.getX(), target.getY(), 10, 10));
    }

    private Point2D stuckSolver(Point2D wallPos) {
        if (wallPos != null)
            return new Point2D.Double(
                    wallPos.getX() - (wallPos.getX() + position.getX()),
                    wallPos.getY() - (wallPos.getY() + position.getY()));
        else return this.position;
    }

    public boolean wallCollision(Point2D newPos, Area v) {
        Area a = v;
        Area b = new Area(new Rectangle2D.Double(newPos.getX(), newPos.getY(), 20, 20));
        return a.intersects(b.getBounds2D());
    }


    public boolean hasCollision(Point2D otherPosition) {
        return otherPosition.distance(position) < 24*size;
    }

    public void setMainTarget(Point2D mainTarget) {
        this.mainTarget = mainTarget;
        path = p.createPath(this.position, mainTarget);
    }

    public void WallCorrection(Point2D target) {
        this.target = target;
    }
}
