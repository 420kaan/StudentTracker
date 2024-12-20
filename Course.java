import java.util.HashSet;
import java.util.Set; // Generic Collection Set

public class Course {
    private String id;
    private String name;
    private Lecturer lecturer;
    private Set<Student> enrolledStudents; // Generic Collection Set

    public Course(String id, String name, Lecturer lecturer) {
        this.id = id;
        this.name = name;
        this.lecturer = lecturer;
        this.enrolledStudents = new HashSet<Student>();
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(Set<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public void viewEnrolledStudents() {
        System.out.println("Students enrolled in " + name + ":");
        enrolledStudents.forEach(student -> System.out.println(student.getName())); // Lambda function
    }
}
