import java.util.ArrayList;
import java.util.List;

public class Lecturer extends User {
    private List<Course> courses; // Generic Collection: List

    public Lecturer(String id, String name, String email) {
        super(id, name, email);
        this.courses = new ArrayList<Course>();
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public void viewDetails() {
        System.out.println("Lecturer Details:");
        System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
        System.out.println("Teaching Courses:");
        courses.forEach(course -> System.out.println(course.getName())); // Lambda function
    }

    public void modifyAttendance() {
        System.out.println(name + " is modifying attendance.");
    }

    public void modifyGrades() {
        System.out.println(name + " is modifying grades.");
    }

    public void addCourse(Course course1) {
    }

    public void viewCourses() {
    }
}
