package Data;


import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.util.ArrayList;

public class Database {

    private ArrayList<Teacher> teachers;
    private ArrayList<Class> classes;
    private ArrayList<Classroom> classrooms;
    private ArrayList<Lesson> lessons;
    private ArrayList<Student> students;
    private ArrayList<Interval> intervals;
    private ArrayList<Group> groups;
    private ArrayList<Subject> subjects;
    private ArrayList<DateTime> times;

    private Agenda agenda;


    public Database() {

        Subject values[] = Subject.values();
        this.teachers = new ArrayList<>();
        this.classes = new ArrayList<>();
        this.classrooms = new ArrayList<>();
        this.lessons = new ArrayList<>();
        this.students = new ArrayList<>();
        this.intervals = new ArrayList<>();
        this.groups = new ArrayList<>();
        this.subjects = new ArrayList<>();
        this.times = new ArrayList<>();
        this.agenda = new Agenda(lessons);

        for (Subject value : values) {
            this.subjects.add(value);
        }


        final DateTime EIGHT = new DateTime(2019, 1, 1, 8, 0, 0);
        final DateTime NINE = new DateTime(2019, 1, 1, 9, 0, 0);
        final DateTime TEN = new DateTime(2019, 1, 1, 10, 0, 0);
        final DateTime ELEVEN = new DateTime(2019, 1, 1, 11, 0, 0);
        final DateTime TWELEVE = new DateTime(2019, 1, 1, 12, 0, 0);
        final DateTime ONE = new DateTime(2019, 1, 1, 13, 0, 0);
        final DateTime TWO = new DateTime(2019, 1, 1, 14, 0, 0);
        final DateTime THREE = new DateTime(2019, 1, 1, 15, 0, 0);
        final DateTime FOUR = new DateTime(2019, 1, 1, 16, 0, 0);
        final DateTime FIVE = new DateTime(2019, 1, 1, 17, 0, 0);
        final DateTime SIX = new DateTime(2019, 1, 1, 18, 0, 0);

        this.times.add(EIGHT);
        this.times.add(NINE);
        this.times.add(TEN);
        this.times.add(ELEVEN);
        this.times.add(TWELEVE);
        this.times.add(ONE);
        this.times.add(TWO);
        this.times.add(THREE);
        this.times.add(FOUR);
        this.times.add(FIVE);
        this.times.add(SIX);

        final Interval FIRST_LESSON = new Interval(NINE, TEN);
        final Interval SECOND_LESSON = new Interval(TEN, ELEVEN);
        final Interval THIRD_LESSON = new Interval(ELEVEN, TWELEVE);
        final Interval FOURTH_LESSON = new Interval(TWELEVE, ONE);
        final Interval FIFTH_LESSON = new Interval(ONE, TWO);
        final Interval SIXTH_LESSON = new Interval(TWO, THREE);
        final Interval SEVENTH_LESSON = new Interval(THREE, FOUR);
        final Interval EIGHT_LESSON = new Interval(FOUR, FIVE);


        Student kees = new Student("Kees", "de", "Bruin", 19, 0, 0, 108);
        Student stijn = new Student("Stijn", "de", "Bruin", 19, 0, 0, 109);
        Student niffauw = new Student("Niffauw", "a", "Bruin", 19, 0, 0, 109);
        Teacher maurice = new Teacher("Maurice", "", "Snoeren", 45, 0, 0, 100, Subject.PRORAMMING);
        Group a2 = new Group(students, "A2", maurice);
        this.groups.add(a2);
        Classroom classroom = new Classroom(1, 20, "LA201", false, false);
        Classroom classroom1 = new Classroom(2, 20, "LA302", false, false);
        Classroom classroom2 = new Classroom(3, 20, "LA115", false, false);
        Classroom classroom3 = new Classroom(4, 20, "LX401b", false, false);
        Classroom classroom4 = new Classroom(5, 20, "LD221", false, false);
        Classroom classroom5 = new Classroom(6, 20, "LD406", false, false);
        Classroom classroom6 = new Classroom(7, 20, "LA226", false, false);
        Classroom classroom7 = new Classroom(8, 20, "LA236", false, false);


        Data.Class classe = new Data.Class(groups, "12Tiav");
        this.teachers.add(maurice);
        this.students.add(kees);
        this.students.add(stijn);
        this.students.add(niffauw);
        this.groups.add(a2);
        this.classes.add(classe);
        this.classrooms.add(classroom);
        this.classrooms.add(classroom1);
        this.classrooms.add(classroom2);
        this.classrooms.add(classroom3);
        this.classrooms.add(classroom4);
        this.classrooms.add(classroom5);
        this.classrooms.add(classroom6);
        this.classrooms.add(classroom7);

//        Lesson les1 = new Lesson(maurice, classroom, groups, Subject.PRORAMMING, FIRST_LESSON);
//        Lesson les2 = new Lesson(maurice, classroom1, groups, Subject.PRORAMMING, SECOND_LESSON);
//        Lesson les3 = new Lesson(maurice, classroom2, groups, Subject.PRORAMMING, THIRD_LESSON);
//        this.lessons.add(les1);
//        this.lessons.add(les2);
//        this.lessons.add(les3);

        this.intervals.add(FIRST_LESSON);
        this.intervals.add(SECOND_LESSON);
        this.intervals.add(THIRD_LESSON);
        this.intervals.add(FOURTH_LESSON);
        this.intervals.add(FIFTH_LESSON);
        this.intervals.add(SIXTH_LESSON);
        this.intervals.add(SEVENTH_LESSON);
        this.intervals.add(EIGHT_LESSON);


    }


    public Agenda returnAgenda() {
        return this.agenda;
    }

    public ArrayList<Lesson> returnLessons() {
        return this.lessons;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);

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

    public void addStudents(Student student) {
        this.students.add(student);
    }


    public void addGroup(Group group) {
        this.groups.add(group);
    }

    public void addSubject(Subject subject) {
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
}
