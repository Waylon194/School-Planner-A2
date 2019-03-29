package Simulation;

import Data.Agenda;
import Data.Room;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.jfree.fx.FXGraphics2D;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
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
    private ArrayList<Space> spaces;
    private AnimationTimer animationTimer;
    private TimerTask task;

    public Simulation() throws Exception {
    }



    public void startSim(Stage primaryStage, Agenda agenda) throws Exception {
        this.agenda = agenda;
        init();

        this.canvas = new Canvas(1280, 720);
        FXGraphics2D g2d = new FXGraphics2D(canvas.getGraphicsContext2D());
        this.stage = primaryStage;
        this.camera = new Camera(canvas, graphics -> {
            draw(graphics);
        }, g2d);
        this.map = new Map(this, this.camera);
        this.animationTimer = new AnimationTimer() {
            long last = -1;
            @Override
            public void handle(long now) {
                if (last == -1)
                    last = now;
                update((now - last) / 1.0e9);
                this.last = now;
                draw(g2d);
                primaryStage.setTitle(getTimeAsString());
            }
        };
        this.startTimer();
        //cancels the timer when the application is closed.
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                timerOnCloseEvent();
            }
        });





        canvas.setOnMouseClicked(e -> {
            if (e.getButton().equals(MouseButton.SECONDARY))
              this.speedFactor++;
              if(this.speedFactor == 3) {
                  speedFactor = 1;
              }


            visitors.forEach(visitor -> {
                visitor.setSpeedFactor(speedFactor) ;
            });
          this.timer.cancel();
            try {
                startTimer();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        startSim(primaryStage, this.agenda);
        primaryStage.setScene(new Scene(new Group(canvas)));
        primaryStage.setTitle("Simulation");
        primaryStage.show();
    }

    public void init() throws Exception {
        pathFinder = new PathFinder();
        walls = createWallArea();
        visitors = new ArrayList<>();





    }


    public void draw(FXGraphics2D graphics) {
        graphics.setBackground(Color.pink);
        graphics.clearRect(0, 0, (int) stage.getWidth(), (int) stage.getHeight());

        map.draw(graphics);
        for (Visitor visitor : visitors) {
            visitor.draw(graphics);
        }

        /*    //debug
        walls.forEach(e->{
            graphics.setColor(Color.BLACK);
            graphics.fill(e);
        });*/

    }

    private List<Area> createWallArea() {
        List<Point> a = this.pathFinder.getWalls();
        List<Area> b = new ArrayList<>();
        a.forEach(e -> b.add(new Area(new Rectangle2D.Double(e.getX() * c, e.getY() * c, c, c))));
        return b;
    }


    public void update(double deltaTime) {

        this.canvas.setHeight(stage.getHeight());
        this.canvas.setWidth(stage.getWidth());
        for (Visitor visitor : visitors)
            visitor.update(visitors, deltaTime);
    }

    public ArrayList<Visitor> getVisitors() {
        return this.visitors;
    }

    public static void main(String[] args) {
        launch(Simulation.class);
    }


    public Canvas getCanvas() {
        return this.canvas;
    }

    public List<Area> getWalls() {
        return this.walls;
    }

    public void startTimer() throws InterruptedException {
        this.task = new TimerTask() {
            public void run() {
               updateKlonk();
               handleVisitors();
            }
        };
        this.timer = new Timer("Timer");
        this.timer.scheduleAtFixedRate(task, 0, (1000L)/speedFactor);
        this.animationTimer.start();
    }



    public void updateKlonk(){
        this.minutes++;
        if(this.minutes%60==0){
            this.hours++;
            this.minutes=0;
        }
        if(this.hours%24==0) {
            this.hours = 0;
        }
    }


    public String getTimeAsString(){
        String hour;
        String minutes;
        if(this.hours<10){
            hour = "0"+Integer.toString(hours);
        }else hour = Integer.toString(hours);

        if(this.minutes<10){
            minutes = "0" + Integer.toString(this.minutes);
        } else minutes = Integer.toString(this.minutes);
        return hour+":"+minutes;
    }

    public void handleVisitors(){

        if(hours==8 && minutes == 55){
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

        if(minutes==00){
            checkHour(this.hours);
        }

    }

    private void checkHour(int hours) {
        this.agenda.getLessons().forEach(lesson -> {
            if (this.hours == lesson.getInterval().getStart().getHourOfDay()){
                this.spaces.forEach(space -> {
                    if (space.getName().equals(lesson.getClassroom().getLocation())){
                        visitors.forEach(visitor -> {
                            visitor.setMainTarget(new Point2D.Double(space.getX()+0.5*space.getWidht(),space.getY()+0.5*space.getHeight()));
                        });
                    }
                });
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