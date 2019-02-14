package Data;


import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.util.ArrayList;

public class DataBank {

    private ArrayList<Teacher> teachers;
    private ArrayList<Class> classes;
    private ArrayList<Classroom> classrooms;
    private ArrayList<Lesson> lessons;
    private ArrayList<Student> students;
    private ArrayList<Interval> intervals;
    private ArrayList<Group> groups;
    private ArrayList<Subject> subjects;

    private Agenda agenda;


    public DataBank() {
        this.teachers = new ArrayList<>();
        this.classes = new ArrayList<>();
        this.classrooms = new ArrayList<>();
        this.lessons = new ArrayList<>();
        this.students = new ArrayList<>();
        this.intervals = new ArrayList<>();
        this.groups = new ArrayList<>();
        this.subjects = new ArrayList<>();
        this.agenda = new Agenda(lessons);

        Interval interval = new Interval(new DateTime(2013, 10, 25, 8, 0, 0, 0), new DateTime(2013, 10, 25, 9, 0, 0, 0));
        Student kees = new Student("Kees" , "de" , "Bruin", 19, 0,0,108);
        Student stijn = new Student("Stijn" , "de" , "Bruin", 19, 0,0,109);
        Student niffauw = new Student("Niffauw" , "a" , "Bruin", 19, 0,0,109);
        Teacher maurice = new Teacher("Maurice", "", "Snoeren", 45, 0,0,100, Subject.PRORAMMING);
        Group a2 = new Group(students, "A2",maurice);

        Classroom classroom = new Classroom(8,8,"Cantene",false, false);

        Data.Class classe = new Data.Class(groups, "12Tiav");
        this.teachers.add(maurice);
        this.students.add(kees);
        this.students.add(stijn);
        this.students.add(niffauw);
        this.groups.add(a2);
        this.classes.add(classe);

        Lesson les = new Lesson(this.teachers,classroom,classes,Subject.PRORAMMING,interval);
        this.lessons.add(les);



    }


    public Agenda returnAgenda(){
        return this.agenda;
    }
    public ArrayList<Lesson> returnLessons(){
        return this.lessons;
    }
    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public void addTeacher(Teacher teacher){
        this.teachers.add(teacher);

    }
    public void addClass(Class schoolClass){
        this.classes.add(schoolClass);
    }

    public void addClassroom(Classroom classroom){
        this.classrooms.add(classroom);
    }

    public void addLesson(Lesson lesson){
        this.lessons.add(lesson);
    }

    public void addStudents(Student student){
        this.students.add(student);
    }

   /* public void addIntervals(Data.Interval interval){
            this.intervals.add(interval);
    }*/

    public void addGroup(Group group){
        this.groups.add(group);
    }

    public void addSubject(Subject subject){
        this.subjects.add(subject);
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public ArrayList<Classroom> getClassrooms() {
        return classrooms;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Interval> getIntervals() {
        return intervals;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public int getAmountOfGroups(){
        return this.groups.size();
    }
}
