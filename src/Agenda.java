import Data.Classroom;
import Data.Lesson;
import Data.Teacher;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Agenda implements Serializable {

    private ArrayList<Lesson> lessons;

    public Agenda(){
        this.lessons = new ArrayList<>();
    }

    public void addLesson(Lesson lesson){
        this.lessons.add(lesson);
    }

    public int getSize(){
       return this.lessons.size();
    }



    public void printSchedule(){

        for (Lesson lesson : lessons) {
            System.out.println(lesson);
        }

    }

    public void saveToBinaryFile(String fileName){


          try (ObjectOutputStream outputFile = new ObjectOutputStream(new FileOutputStream(fileName))) {
              outputFile.writeObject(lessons);
          }
       catch (IOException e){
          e.printStackTrace();
      }

    }

    public static void main(String[] args) throws IOException {
        Teacher teacher = new Teacher();
        Teacher teacher2 = new Teacher();

        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher);
        teachers.add(teacher2);



        Lesson lesson = new Lesson(teachers,new Classroom());
        Lesson lesson2 = new Lesson(teachers,new Classroom());

        Agenda agenda = new Agenda();
        agenda.addLesson(lesson);
        agenda.addLesson(lesson2);
        agenda.getSize();
        agenda.printSchedule();
        agenda.saveToBinaryFile("outputTest.object");


    }
}