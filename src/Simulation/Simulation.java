package Simulation;

import Data.Agenda;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.jfree.fx.FXGraphics2D;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class Simulation extends Application {

    private Agenda agenda;
    private Camera camera;
    private Tileset tileset;
    private Canvas canvas;
    private Stage stage;
    private ArrayList<Visitor> visitors;
    private Map map;
    private List<Area> walls;
    private PathFinder pathFinder;
    private int c = 32;
    private int speedFactor;
    private int minutes;
    private int hours;
    private Timer timer;




    public Simulation() throws Exception {

        this.tileset = new Tileset();
        this.agenda = new Agenda();
        this.speedFactor = 1;
        this.minutes = 0;
        this.hours = 8;

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.canvas = new Canvas(1980, 1080);
        this.stage = primaryStage;
        FXGraphics2D g2d = new FXGraphics2D(canvas.getGraphicsContext2D());
        camera = new Camera(canvas, graphics -> {

            draw(graphics);

        }, g2d);
        map = new Map(this, this.camera);


        primaryStage.setScene(new Scene(new Group(canvas)));
        primaryStage.setTitle("Simulation");
        primaryStage.show();


        new AnimationTimer() {
            long last = -1;
            @Override
            public void handle(long now) {
                if (last == -1)
                    last = now;
                update((now - last) / 1.0e9);
                last = now;
                draw(g2d);
                primaryStage.setTitle(getTimeAsString());
            }
        }.start();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                timer.cancel();

            }

        });
        this.startTimer();





        canvas.setOnMouseClicked(e -> {
            System.out.println(speedFactor);
              this.speedFactor++;

              if(this.speedFactor == 5) {
                  speedFactor = 1;
              }

            visitors.forEach(visitor -> {
                visitor.setSpeedFactor(speedFactor) ;
            });


        });


    }

    public void init() throws Exception {
        pathFinder = new PathFinder();
        walls = createWallArea();
        visitors = new ArrayList<>();


       // visitors.get(0).setMainTarget(newTarget);


    }


    public void draw(FXGraphics2D graphics) {
        graphics.setBackground(Color.pink);
        graphics.clearRect(0, 0, (int) stage.getWidth(), (int) stage.getHeight());

        map.draw(graphics);
        for (Visitor visitor : visitors) {
            visitor.draw(graphics);
        }
         //debug
        walls.forEach(e->{
            graphics.setColor(Color.BLACK);
            graphics.fill(e);
        });
    }

    private List<Area> createWallArea() {
        List<Point> a = pathFinder.getWalls();
        List<Area> b = new ArrayList<>();
        a.forEach(e -> b.add(new Area(new Rectangle2D.Double(e.getX() * c, e.getY() * c, c, c))));
        return b;
    }


    public void update(double deltaTime) {
        for (Visitor visitor : visitors) {
            visitor.update(visitors, deltaTime);
            }
        }





    public ArrayList<Visitor> getVisitors() {
        return visitors;
    }

    public static void main(String[] args) {
        launch(Simulation.class);
    }


    public Canvas getCanvas() {
        return this.canvas;
    }

    public List<Area> getWalls() {
        return walls;
    }

    public void startTimer() throws InterruptedException {
        TimerTask task = new TimerTask() {
            public void run() {
               updateKlonk();
               handleVisitors();
            }
        };
        this.timer = new Timer("Timer");
        timer.scheduleAtFixedRate(task, 0, 1000L/speedFactor);

    }

    public void updateKlonk(){
        minutes++;
        if(minutes%60==0){
            hours++;
            minutes=0;
        }
        if(hours%24==0) {
            hours++;
            minutes=0;
        }
    }


    public String getTimeAsString(){
        String hour;
        String minutes;
        if(hours<10){
            hour = "0"+Integer.toString(hours);
        }else hour = Integer.toString(hours);

        if(this.minutes<10){
            minutes = "0" + Integer.toString(this.minutes);
        } else minutes = Integer.toString(this.minutes);
        return hour+":"+minutes;
    }


    public void handleVisitors(){

        if(hours==8 && minutes == 5){
            double x = 35;
            double y = 70;

            int amountOfGroups = this.agenda.getAmountOfGroups();
            for(int i = 0; i<amountOfGroups; i++){
                int groupSize = agenda.getGroups().get(i).getGroupSize();
                for(int j = 0; j<groupSize; j++){
                    Point2D spawnPoint = new Point2D.Double(x*c,y*c);
                    visitors.add(new Visitor(spawnPoint,pathFinder,this,spawnPoint));
                    y-=2;
                }
                y=69;
                x+=2;


            }
        }

        agenda.getLessons().forEach(lesson -> {
            System.out.println(lesson.getInterval().getStart().minuteOfDay().toString());
        });

        if(hours==8 && minutes==10){
            double x = 32;
            double y = 9;

            for(Visitor visitor: visitors){
                visitor.setMainTarget(new Point2D.Double(x*c,y*c));
                x+=2;
            }
        }
        if(hours==8 && minutes==30){
            double x = 36;
            double y = 70;
            visitors.forEach(visitor -> {
                visitor.setMainTarget(new Point2D.Double(x*c,y*c));
            });
        }




    }



}