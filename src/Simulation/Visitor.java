package Simulation;

import org.json.simple.parser.ParseException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Visitor {
    private Point2D position;
    private double angle;

    private double speed = 5;
    private BufferedImage image;
    double frameTime = 0.1;
    int frame = 0;
    private Point2D target;
    private int currentFrame;
    private List<Area> collisionAreas;
    private BufferedImage[] tilesGeorge;

    private BufferedImage[] walkRight;
    private BufferedImage[] walkLeft;
    private BufferedImage[] walkForward;
    private BufferedImage[] walkBackward;
    private PathFinder pathFinder;


    public Visitor(Point2D position) throws IOException, ParseException {
        this.pathFinder = new PathFinder();
        this.currentFrame = 0;
        this.position = position;
        this.angle = 0;
        try {
            this.collisionAreas = hasCollisionBlock();
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

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        this.speed += Math.random();
        this.angle = Math.random() * 2 * Math.PI;

        this.target = new Point2D.Double(500, 500);
    }

    public List<Area> hasCollisionBlock() throws IOException, ParseException {
        List<Point> otherVisitors = new ArrayList<>();
        List<Point> collisionLayer = pathFinder.getWalls();
        List<Area> hasCollision = new ArrayList<>();

        if (collisionLayer.contains(this.position) || otherVisitors.contains(this.position))
            hasCollision.add(new Area(new Ellipse2D.Double(this.position.getX() + 16, this.position.getY(), 32, 32)));

        return hasCollision;
    }


    public void update(ArrayList<Visitor> visitors, double deltaTime) {
        if (currentFrame < 3) {
            currentFrame++;
        } else currentFrame = 0;
        Point2D newPosition = new Point2D.Double(this.position.getX() + this.speed * Math.cos(angle),
                this.position.getY() + this.speed * Math.sin(angle));


        boolean hasCollision = false;
        for (Visitor visitor : visitors) {
            //TODO check collision with walls, etc...
			/*
			for(Area area: collisionAreas){
				if(visitor.hasCollision(area.getBounds().getLocation())){
					hasCollision = true;
					break;

				}
			}*/
            if (visitor != this && visitor.hasCollision(newPosition)) {
                hasCollision = true;
                break;
            }
        }

        if (!hasCollision) {
            this.position = newPosition;
        } else {
            this.angle += 0.2;
        }


        Point2D diff = new Point2D.Double(target.getX() - this.position.getX(), target.getY() - this.position.getY());
        double targetAngle = Math.atan2(diff.getY(), diff.getX());

        double angleDiff = targetAngle - angle;
        while (angleDiff > Math.PI)
            angleDiff -= 2 * Math.PI;
        while (angleDiff < -Math.PI)
            angleDiff += 2 * Math.PI;

        if (angleDiff < -0.1)
            angle -= 0.1;
        else if (angleDiff > 0.1)
            angle += 0.1;
        else
            this.angle = targetAngle;

        frameTime -= deltaTime;
        if (frameTime < 0) {
            frameTime = 1 / 30.0;
            frame = (frame + 1) % 8;
        }

    }


    public void draw(Graphics2D g) {
        AffineTransform tx = new AffineTransform();
        tx.translate(position.getX() - 32, position.getY() - 32);
        tx.rotate(angle, 32, 32);


        if (angle > -Math.PI / 2 && angle < 0) {
            g.drawImage(walkRight[currentFrame], tx, null);
        } else if (angle > -Math.PI && angle < -Math.PI / 2) {
            g.drawImage(walkForward[currentFrame], tx, null);
        } else if (angle > Math.PI / 2) {
            g.drawImage(walkLeft[currentFrame], tx, null);
        } else {
            g.drawImage(walkBackward[currentFrame], tx, null);

        }


    }


    public boolean hasCollision(Point2D otherPosition) {
        return otherPosition.distance(position) < 32;
    }


    public void setTarget(Point2D target) {
        this.target = target;
    }
}
