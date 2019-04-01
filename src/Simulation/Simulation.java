package Simulation;

import Data.Agenda;
import Data.Classroom;
import Data.Group;
import Data.Lesson;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
    private ArrayList<Visitor> A2;
    private ArrayList<Visitor> B1;
    private ArrayList<Visitor> C1;
    private ArrayList<Visitor> teachers;


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
                if (last == -1) last = now;
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


        //TODO change this to keyboard listener.
        canvas.setOnMouseClicked(e -> {
            if (e.getButton().equals(MouseButton.SECONDARY)) this.speedFactor++;
            if (this.speedFactor == 3) {
                speedFactor = 1;
            }


            visitors.forEach(visitor -> {
                visitor.setSpeedFactor(speedFactor);
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
        primaryStage.setScene(new Scene(new javafx.scene.Group(canvas)));
        primaryStage.setTitle("Simulation");
        primaryStage.show();
    }

    public void init() throws Exception {

        this.pathFinder = new PathFinder();
        this.walls = createWallArea();
        this.visitors = new ArrayList<>();
        this.tileset = new Tileset();
        this.spaces = tileset.getSpaces();
        this.speedFactor = 1;
        this.minutes = 0;
        this.hours = 8;
        this.A2 = new ArrayList<Visitor>();
        this.B1 = new ArrayList<Visitor>();
        this.C1 = new ArrayList<Visitor>();
        this.teachers = new ArrayList<Visitor>();


    }


    public void draw(FXGraphics2D graphics) {
        graphics.setBackground(Color.BLACK);
        graphics.clearRect(0, 0, (int) stage.getWidth(), (int) stage.getHeight());
        this.map.draw(graphics);
        for (Visitor visitor : visitors) {
            visitor.draw(graphics);
        }

        //debug
//        walls.forEach(e->{
//            graphics.setColor(Color.BLACK);
//            graphics.fill(e);
//        });

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
        for (Visitor visitor : this.visitors) {
            visitor.setSpeedFactor(speedFactor);
            visitor.update(this.visitors, deltaTime);
        }
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
        this.timer.scheduleAtFixedRate(task, 0, (2000L) / speedFactor);
        this.animationTimer.start();
    }


    public void updateKlonk() {
        this.minutes++;
        if (this.minutes % 60 == 0) {
            this.hours++;
            this.minutes = 0;
        }
        if (this.hours % 24 == 0) {
            this.hours = 0;
        }
    }


    public String getTimeAsString() {
        String hour;
        String minutes;
        if (this.hours < 10) {
            hour = "0" + Integer.toString(hours);
        } else hour = Integer.toString(hours);

        if (this.minutes < 10) {
            minutes = "0" + Integer.toString(this.minutes);
        } else minutes = Integer.toString(this.minutes);
        return hour + ":" + minutes;
    }

    public void handleVisitors() {

        if (hours == 8 && minutes == 10) {
            double x = 0.1;
            double y = 0.3;

            /**
             * spaces[0] = kantine
             * spaces[1] = spawn
             * spaces[2] = WC2
             * spaces[3] = WC1
             * spaces[4] = TeachersRoom
             *
             */

            int amountOfGroups = this.agenda.getAmountOfGroups();
            for (int i = 0; i < amountOfGroups; i++) {
                int groupSize = agenda.getGroups().get(i).getGroupSize();
                for (int j = 0; j < groupSize; j++) {
                    Point2D spawnPoint = new Point2D.Double(spaces.get(2).getX() + x * spaces.get(2).getWidht(), spaces.get(2).getY() + y * spaces.get(2).getHeight());
                    if (i == 0) {
                        A2.add(new Visitor(spawnPoint, pathFinder, this, spawnPoint));
                    } else if (i == 1) {
                        B1.add(new Visitor(spawnPoint, pathFinder, this, spawnPoint));
                    } else C1.add(new Visitor(spawnPoint, pathFinder, this, spawnPoint));
                    x += 0.1;
                }
                x = 0.2;
                y += 0.2;
            }

            int amountOfTeachers = this.agenda.getAmountOfTeachers();
            x = 0.05;
            y = 0.9;
            for (int i = 0; i < amountOfTeachers; i++) {
                Point2D spawnPoint = new Point2D.Double(spaces.get(4).getX() + x * spaces.get(4).getWidht(), spaces.get(4).getY() + y * spaces.get(4).getHeight());
                teachers.add(new Visitor(spawnPoint, pathFinder, this, spawnPoint));
                x += 0.15;
                //y+=0.1;


            }

            this.visitors.addAll(A2);
            this.visitors.addAll(B1);
            this.visitors.addAll(C1);
            this.visitors.addAll(teachers);
        }
        if (minutes == 40) {
            checkHour(this.hours);
        }

    }

    private void checkHour(int hours) {
        boolean aFree = true;
        boolean bFree = true;
        boolean cFree = true;

        for (Lesson lesson : agenda.getLessons()) {
            ArrayList<Group> groups = lesson.getGroups();
            if (this.hours + 1 == lesson.getInterval().getStart().getHourOfDay()) {
                for (Space space : this.spaces) {
                    if (space.getName().equals(lesson.getClassroom().getLocation())) {
                        for (Group group : groups) {
                            double xConst = 0.1;
                            if (group.getGroupName().equals("A2")) {
                                aFree = false;
                                for (Visitor visitor : A2) {
                                    visitor.setMainTarget(new Point2D.Double(space.getX() + xConst * space.getWidht(), space.getY() + 0.7 * space.getHeight()));
                                    xConst += 0.1;
                                }
                                xConst = 0.1;
                            } else if (group.getGroupName().equals("B1")) {
                                bFree = false;
                                for (Visitor visitor : B1) {
                                    visitor.setMainTarget(new Point2D.Double(space.getX() + xConst * space.getWidht(), space.getY() + 0.7 * space.getHeight()));
                                    xConst += 0.1;
                                }
                                xConst = 0.1;
                            } else if (group.getGroupName().equals("C1")) {
                                cFree = false;
                                for (Visitor visitor : C1) {
                                    visitor.setMainTarget(new Point2D.Double(space.getX() + xConst * space.getWidht(), space.getY() + 0.7 * space.getHeight()));
                                    xConst += 0.1;
                                }
                            }
                        }
                    }
                }
            }
        }


        double xConst = 0.1;
        double yConst = 0.9;
        for (Lesson lesson : agenda.getLessons()) {


                if (this.hours + 1 == lesson.getInterval().getStart().getHourOfDay()) {
                    for (Space space : this.spaces) {
                        if (space.getName().equals(lesson.getClassroom().getLocation())) {
                            for (int i = 0; i < agenda.getAmountOfTeachers(); i++) {
                                if (lesson.getTeachers().contains(agenda.getTeachers().get(i))) {
                                    this.teachers.get(i).setMainTarget(new Point2D.Double(space.getX() + xConst * space.getWidht(), space.getY() + 0.2 * space.getHeight()));

                                } else
                                    this.teachers.get(i).setMainTarget(new Point2D.Double(spaces.get(4).getX() + xConst * spaces.get(4).getWidht(), spaces.get(4).getY() + yConst * spaces.get(4).getHeight()));
                                xConst += 0.15;
                                //yConst+=0.1;
                            }
                        }
                    }
                }

        }

        xConst = 0.1;
        if (aFree) {
            for (Visitor visitor : A2) {
                visitor.setMainTarget(new Point2D.Double(spaces.get(0).getX() + xConst * spaces.get(0).getWidht(), spaces.get(0).getY() + 0.3 * spaces.get(0).getHeight()));
                xConst += 0.1;
            }
        }
        if (bFree) {
            xConst = 0.1;
            for (Visitor visitor : B1) {
                visitor.setMainTarget(new Point2D.Double(spaces.get(0).getX() + xConst * spaces.get(0).getWidht(), spaces.get(0).getY() + 0.5 * spaces.get(0).getHeight()));
                xConst += 0.1;
            }
        }
        if (cFree) {
            xConst = 0.1;
            for (Visitor visitor : C1) {
                visitor.setMainTarget(new Point2D.Double(spaces.get(0).getX() + xConst * spaces.get(0).getWidht(), spaces.get(0).getY() + 0.7 * spaces.get(0).getHeight()));
                xConst += 0.1;
            }
        }
    }

    public void timerOnCloseEvent() {
        this.timer.cancel();
        this.hours = 8;
        this.minutes = 0;
        this.animationTimer.stop();
        try {
            finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
    }


}