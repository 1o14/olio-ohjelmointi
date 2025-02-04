package Assignment3_4_3;

import java.io.*;

// Student-luokka, joka sisältää id-, nimi- ja ikä-attribuutit
class Student implements Serializable {
    private int id;
    private String name;
    private int age;

    // Konstruktori
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getterit ja setterit
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age + "}";
    }
}

// Course-luokka, joka sisältää kurssikoodin, kurssin nimen ja opettajan tiedot
class Course implements Serializable {
    private String courseCode;
    private String courseName;
    private String instructor;

    // Konstruktori
    public Course(String courseCode, String courseName, String instructor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
    }

    // Getterit ja setterit
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{courseCode='" + courseCode + "', courseName='" + courseName + "', instructor='" + instructor + "'}";
    }
}

// Enrollment-luokka, joka yhdistää Student- ja Course-luokat
class Enrollment implements Serializable {
    private Student student;
    private Course course;
    private String enrollmentDate;

    // Konstruktori
    public Enrollment(Student student, Course course, String enrollmentDate) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
    }

    // Getterit ja setterit
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return "Enrollment{student=" + student + ", course=" + course + ", enrollmentDate='" + enrollmentDate + "'}";
    }
}

public class Main {
    public static void main(String[] args) {
        // Luodaan Student-, Course- ja Enrollment-oliot
        Student student = new Student(1, "John Doe", 20);
        Course course = new Course("CS101", "Introduction to Computer Science", "Dr. Smith");
        Enrollment enrollment = new Enrollment(student, course, "2025-02-04");

        // Tiedosto, johon objektit tullaan sarjoittamaan
        String filename = "enrollments.ser";

        // Sarjoitetaan Enrollment-objekti tiedostoon
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(enrollment);
            System.out.println("Object serialized to file: " + filename); // Output on englanniksi
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage()); // Output on englanniksi
        }

        // Puretaan objekti tiedostosta
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Enrollment deserializedEnrollment = (Enrollment) in.readObject();
            System.out.println("Deserialized object: " + deserializedEnrollment); // Output on englanniksi
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage()); // Output on englanniksi
        }
    }
}
