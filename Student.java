import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Student extends User {
    private String email;
    private List<Course> enrolledCourses = new ArrayList<>();
    private Map<Course, Boolean> attendanceStatus = new HashMap<>();

    public Student(String id, String name, String email) {
        super(id, name, email);
        this.email = email;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollInCourse(Course course) {
        this.enrolledCourses.add(course);
    }

    public void updateAttendanceStatus(Course course, boolean isPresent) {
        this.attendanceStatus.put(course, isPresent);
    }

    public void viewDetails() {
        System.out.println("Name: " + this.getName());
        System.out.println("Email: " + this.email);
        System.out.println("Enrolled Courses:");
        if (enrolledCourses.isEmpty()) {
            System.out.println("No courses enrolled.");
        } else {
            for (Course course : enrolledCourses) {
                System.out.println(course.getName());
                String status = attendanceStatus.getOrDefault(course, false) ? "Present" : "Absent";
                System.out.println("Attendance Status: " + status);
            }
        }
    }

}


