package Data;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Agenda implements Serializable {
    private Map<String,Teacher> teachers;
    private ArrayList<Class> classes;
    private ArrayList<Classroom> classrooms;
    private ArrayList<Lesson> lessons;
    private ArrayList<Student> students;
    private ArrayList<Interval> intervals;
    private ArrayList<Group> groups;
    private ArrayList<Subject> subjects;
    private ArrayList<DateTime> times;

    public Agenda() {
        this.subjects=  new ArrayList<>();
        this.teachers = new HashMap<>();
        this.classes = new ArrayList<>();
        this.classrooms = new ArrayList<>();
        this.lessons = new ArrayList<>();
        this.intervals = new ArrayList<>();
        this.groups = new ArrayList<>();
        this.subjects = new ArrayList<>();
        this.times = new ArrayList<>();
        this.students = new ArrayList<>();



        final DateTime NINE = new DateTime(2019, 1, 1, 9, 0, 0);
        final DateTime TEN = new DateTime(2019, 1, 1, 10, 0, 0);
        final DateTime ELEVEN = new DateTime(2019, 1, 1, 11, 0, 0);
        final DateTime TWELVE = new DateTime(2019, 1, 1, 12, 0, 0);
        final DateTime ONE = new DateTime(2019, 1, 1, 13, 0, 0);
        final DateTime TWO = new DateTime(2019, 1, 1, 14, 0, 0);
        final DateTime THREE = new DateTime(2019, 1, 1, 15, 0, 0);
        final DateTime FOUR = new DateTime(2019, 1, 1, 16, 0, 0);
        final DateTime FIVE = new DateTime(2019, 1, 1, 17, 0, 0);

        this.times.add(NINE);
        this.times.add(TEN);
        this.times.add(ELEVEN);
        this.times.add(TWELVE);
        this.times.add(ONE);
        this.times.add(TWO);
        this.times.add(THREE);
        this.times.add(FOUR);
        this.times.add(FIVE);

        final Interval FIRST_LESSON = new Interval(NINE, TEN);
        final Interval SECOND_LESSON = new Interval(TEN, ELEVEN);
        final Interval THIRD_LESSON = new Interval(ELEVEN, TWELVE);
        final Interval FOURTH_LESSON = new Interval(TWELVE, ONE);
        final Interval FIFTH_LESSON = new Interval(ONE, TWO);
        final Interval SIXTH_LESSON = new Interval(TWO, THREE);
        final Interval SEVENTH_LESSON = new Interval(THREE, FOUR);
        final Interval EIGHT_LESSON = new Interval(FOUR, FIVE);

        Student kees = new Student("Kees", "de", "Bruin", 19, 0, 0, 108);
        Student stijn = new Student("Stijn", "de", "Bruin", 19, 0, 0, 109);
        Student sarah = new Student("Sarah", "de", "Vos", 20, 0, 0, 111);
        Student lydia = new Student("Lydia", "de", "Vos", 18, 0, 0, 112);
        Student hans = new Student("Hans", "a", "Bruin", 21, 0, 0, 113);
        Student ella = new Student("Ella", "van", "Roodhart", 20, 0, 0, 114);
        Student john = new Student("John", "de", "Ree", 18, 0, 0, 115);
        Student jan = new Student("Jan", "van", "Hoven", 17, 0, 0, 116);
        Student stan = new Student("Stan", "de", "Vaart", 17, 0, 0, 117);
        Student stanley = new Student("Stanley", "van", "Houten", 17, 0, 0, 118);
        Student anna = new Student("Anna", "van", "Nert", 19, 0, 0, 119);
        Student lisane = new Student("Lisane", "van", "Boeken", 20, 0, 0, 120);

        this.students.add(kees);
        this.students.add(stijn);
        this.students.add(sarah);
        this.students.add(lydia);
        this.students.add(hans);
        this.students.add(ella);
        this.students.add(john);
        this.students.add(jan);
        this.students.add(stan);
        this.students.add(stanley);
        this.students.add(anna);
        this.students.add(lisane);

        Teacher maurice = new Teacher("Maurice", "", "Snoeren", 45, 0, 0, "100");
        Teacher johan = new Teacher("Johan", "", "Talboom", 43, 0, 0, "110");
        Teacher hansen = new Teacher("Hansen", "van", "Bergen", 40, 0, 0, "130");
        Teacher etienne = new Teacher("Etienne", "van", "Goosens", 43, 0, 0, "140");
        Teacher pieter = new Teacher("Pieter", "Kop", "Jansen", 41, 0, 0, "150");
        Teacher jessica = new Teacher("Jessica", "van der", "Heijden", 42, 0, 0, "160");
        Teacher peter = new Teacher("Peter", "", "Kailuhu", 50, 0, 0, "170");

        Group a2 = new Group(studentRandomizer('a'), "A2", maurice);
        Group b1 = new Group(studentRandomizer('b'), "B1", pieter);

        Classroom classroom = new Classroom(1, 20, "LA201", false, false);
        Classroom classroom1 = new Classroom(2, 20, "LA302", false, false);
        Classroom classroom2 = new Classroom(3, 20, "LA115", false, false);
        Classroom classroom3 = new Classroom(4, 20, "LX401b", false, false);
        Classroom classroom4 = new Classroom(5, 20, "LD221", false, false);
        Classroom classroom5 = new Classroom(6, 20, "LD406", false, false);
        Classroom classroom6 = new Classroom(7, 20, "LA226", false, false);
        Classroom classroom7 = new Classroom(8, 20, "LA236", false, false);

        Data.Class classe = new Data.Class(groups, "12TIAV");

        //teachers
        this.teachers.put(maurice.getTeacherNumber(),maurice);
        this.teachers.put(johan.getTeacherNumber(),johan);
        this.teachers.put(hansen.getTeacherNumber(),hansen);
        this.teachers.put(etienne.getTeacherNumber(),etienne);
        this.teachers.put(peter.getTeacherNumber(),peter);
        this.teachers.put(pieter.getTeacherNumber(),pieter);
        this.teachers.put(jessica.getTeacherNumber(),jessica);

        //groups of
        this.groups.add(a2);
        this.groups.add(b1);

        //class with 2 groups or more
        this.classes.add(classe);

        // classrooms
        this.classrooms.add(classroom);
        this.classrooms.add(classroom1);
        this.classrooms.add(classroom2);
        this.classrooms.add(classroom3);
        this.classrooms.add(classroom4);
        this.classrooms.add(classroom5);
        this.classrooms.add(classroom6);
        this.classrooms.add(classroom7);

        //lesson times in hour intervals
        this.intervals.add(FIRST_LESSON);
        this.intervals.add(SECOND_LESSON);
        this.intervals.add(THIRD_LESSON);
        this.intervals.add(FOURTH_LESSON);
        this.intervals.add(FIFTH_LESSON);
        this.intervals.add(SIXTH_LESSON);
        this.intervals.add(SEVENTH_LESSON);
        this.intervals.add(EIGHT_LESSON);

        Subject calculus = new Subject("CALCULUS");
        Subject linearAlgebra = new Subject("LINEAR ALGEBRA");

        this.subjects.add(calculus);
        this.subjects.add(linearAlgebra);


    }

    public ArrayList<Lesson> returnLessons() {
        return this.lessons;
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.put(teacher.getTeacherNumber(),teacher);
    }

    public void addClass(Class schoolClass) {
        this.classes.add(schoolClass);
    }

    public void addClassroom(Classroom classroom) {
        this.classrooms.add(classroom);
    }

    public void addLesson(Lesson lesson) {
        this.lessons.add(lesson);
    }



    // TODO: 17-02-19 fix student array
    public void addStudents(Student student) {
        this.students.add(student);
    }

    public void addGroup(Group group) {
        this.groups.add(group);
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public Map<String, Teacher> getTeachers() {
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

    public ArrayList<Interval> getIntervals() {
        return intervals;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public int getAmountOfGroups() {
        return this.groups.size();
    }

    public void printLessons() {
        for (Lesson l : lessons) {
            System.out.println(l);
        }
    }

    public int amountOfLessons() {
        return lessons.size();
    }

    public void deleteLesson(int i) {
        this.lessons.remove(i);
    }

    public ArrayList<DateTime> getTimes() {
        return this.times;
    }

    //TODO Redo the method!
    public ArrayList<Student> studentRandomizer(char a){
        ArrayList<Student> klass = new ArrayList<>();
        if (a == 'a'){
            for(int i = 0; i < students.size(); i++){
                if(i % 3 == 0) {
                    klass.add(students.get(i));
                }
            }
            return klass;
        }
        else if (a == 'b'){
            for(int i = 0; i < students.size(); i++){
                if(i % 2 == 0) {
                    klass.add(students.get(i));
                }
            }
            return klass;
        }
        else {
            return klass;
        }
    }

    public ArrayList<Group> groupRandomizer(char a){
        ArrayList<Group> classs = new ArrayList<>();
        classs.add(groups.get(0));
        return classs;
    }
}