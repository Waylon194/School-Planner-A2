import Data.Lesson;
import Data.Student;
import Data.Teacher;
import Simulation.Classroom;

import java.util.ArrayList;

public class Agenda{

    private ArrayList<Lesson> lessons;

    public Agenda{
        this.lessons = new ArrayList<>();
    }


    public void addLesson(Lesson lesson){
        this.lessons.add(lesson);
    }

    public int getSize(){
       return this.lessons.size()
    }








}