/*
import java.util.*;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, String> credentials = new HashMap<>();
    private static final DataStore<AttendanceRecord> attendanceDataStore = new DataStore<>();
    private static final List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        // Predefined credentials
        credentials.put("student1", "password!");
        credentials.put("student2", "password!");
        credentials.put("lecturer1", "passw00rd");
        credentials.put("admin1", "Passw00rd!");

        Lecturer lecturer1 = new Lecturer("lecturer1", "Dr. Ali Kılınç", "akilinc@stu.pirireis.edu.tr");
        Lecturer lecturer2 = new Lecturer("lecturer2", "Dr. Volkan Uslan", "vuslan@stu.pirireis.edu.tr");
        Course course1 = new Course("YBS316", "Nesne Yönelimli Programlama", lecturer1);
        Course course2 = new Course("YBS405", "Büyük Veri Yönetimi", lecturer2);
        Course course3 = new Course("YBS308", "Sanallaştırma", lecturer1);
        Student student1 = new Student("student1", "Kaan Karaağaç", "kaankaraagac@stu.pirireis.edu.tr");
        Student student2 = new Student("student2", "Ege Argun", "egeargun@stu.pirireis.edu.tr");

        lecturer1.setCourses(List.of(course1));
        lecturer1.setCourses(List.of(course3));
        lecturer2.setCourses(List.of(course2));
        course1.getEnrolledStudents().add(student1);
        course1.getEnrolledStudents().add(student2);
        course2.getEnrolledStudents().add(student1);

        users.addAll(List.of(lecturer1, lecturer2, student1, student2, new Admin("admin1", "Admin User", "admin@domain.com")));

    }

}
 */
import java.util.*;


public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, String> credentials = new HashMap<>();
    private static final DataStore<AttendanceRecord> attendanceDataStore = new DataStore<>();
    private static final List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        credentials.put("student1", "passw00rd");
        credentials.put("student2", "passw00rd");
        credentials.put("student3", "passw00rd");
        credentials.put("lecturer1", "password!");
        credentials.put("lecturer2", "password!");
        credentials.put("lecturer3", "password!");
        credentials.put("admin1", "adminpass");

        Lecturer lecturer1 = new Lecturer("lecturer1", "Dr. Ali Kılınç", "akilinc@stu.pirireis.edu.tr");
        Lecturer lecturer2 = new Lecturer("lecturer2", "Dr. Volkan Uslan", "vuslan@stu.pirireis.edu.tr");
        Lecturer lecturer3 = new Lecturer("lecturer3", "Dr. Kenan Tata", "ktata@stu.pirireis.edu.tr");
        Course course1 = new Course("YBS316", "Nesne Yönelimli Programlama", lecturer1);
        Course course2 = new Course("YBS405", "Büyük Veri Yönetimi", lecturer2);
        Course course3 = new Course("YBS308", "Sanallaştırma", lecturer1);
        Course course4 = new Course("EF314", "Finansal Yönetim", lecturer3);
        Student student1 = new Student("student1", "Kaan Karaağaç", "kaankaraagac@stu.pirireis.edu.tr");
        Student student2 = new Student("student2", "Ege Argun", "egeargun@stu.pirireis.edu.tr");
        Student student3 = new Student("student3", "Alper Çamlı", "alper.camli@stu.pirireis.edu.tr");

        lecturer1.setCourses(List.of(course1, course3));
        lecturer2.setCourses(List.of(course2));
        lecturer3.setCourses(List.of(course4));

        student1.enrollInCourse(course1);
        student1.enrollInCourse(course2);
        student2.enrollInCourse(course1);
        student2.enrollInCourse(course2);
        student2.enrollInCourse(course3);
        student3.enrollInCourse(course4);

        course1.getEnrolledStudents().add(student1);
        course2.getEnrolledStudents().add(student1);
        course2.getEnrolledStudents().add(student2);
        course1.getEnrolledStudents().add(student2);
        course2.getEnrolledStudents().add(student1);
        course4.getEnrolledStudents().add(student3);

        users.addAll(List.of(lecturer1, lecturer2, student1, student2, student3, lecturer3, new Admin("admin1", "Admin User", "admin@domain.com")));

        loginAndNavigate(users);
    }


    private static void loginAndNavigate(List<User> users) {
        System.out.println("Welcome to the Attendance System");
        String username;
        String password;

        while (true) {
            System.out.print("Enter Username: ");
            username = scanner.nextLine();
            System.out.print("Enter Password: ");
            password = scanner.nextLine();

            // Check if the username exists and the password matches
            if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
                break;
            } else {
                System.out.println("Invalid username or password. Try again.");
            }
        }

        String finalUsername = username;
        User loggedInUser = users.stream()
                .filter(user -> user.getId().equals(finalUsername))
                .findFirst()
                .orElse(null);
        if (loggedInUser == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("\nLogin Successful! Welcome, " + loggedInUser.getName());

        if (loggedInUser instanceof Student) {
            studentMenu((Student) loggedInUser);
        } else if (loggedInUser instanceof Lecturer) {
            lecturerMenu((Lecturer) loggedInUser);
        } else if (loggedInUser instanceof Admin) {
            adminMenu((Admin) loggedInUser);
        }
    }



    private static void studentMenu(Student student) {
        int choice = 0;
        do {
            System.out.println("\nStudent Menu");
            System.out.println("1. View Attendance");
            System.out.println("2. Logout");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1 -> student.viewDetails();
                case 2 -> {
                    System.out.println("Logging out...");
                    loginAndNavigate(users);
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 2);
    }


    private static void lecturerMenu(Lecturer lecturer) {
        int choice = 0;
        do {
            System.out.println("\nLecturer Menu");
            System.out.println("1. View Details");
            System.out.println("2. Mark Attendance");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid choice. choose again.");
                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> lecturer.viewDetails();
                case 2 -> markAttendance(lecturer);
                case 3 -> {
                    System.out.println("Logging out...");
                    loginAndNavigate(users);
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 3);
    }


    private static void adminMenu(Admin admin) {
        int choice;
        do {
            System.out.println("\nAdmin Menu");
            System.out.println("1. View Details");
            System.out.println("2. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> admin.viewDetails();
                case 2 -> {
                    System.out.println("Logging out...");
                    loginAndNavigate(users);
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 2);
    }


    private static void markAttendance(Lecturer lecturer) {
        System.out.println("Select a course to mark attendance:");
        List<Course> courses = lecturer.getCourses();
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getName());
        }
        int courseIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (courseIndex < 0 || courseIndex >= courses.size()) {
            System.out.println("Invalid course selection.");
            return;
        }

        Course selectedCourse = courses.get(courseIndex);
        System.out.println("Marking attendance for " + selectedCourse.getName());
        List<Student> enrolledStudents = new ArrayList<>(selectedCourse.getEnrolledStudents());

        for (Student student : enrolledStudents) {
            System.out.print("Is " + student.getName() + " present? (yes/no): ");
            String response = scanner.nextLine();
            boolean isPresent = "yes".equalsIgnoreCase(response);

            student.updateAttendanceStatus(selectedCourse, isPresent);

            AttendanceRecord record = new AttendanceRecord(selectedCourse, student, isPresent);
            attendanceDataStore.addRecord(record);
        }
        System.out.println("Attendance marked successfully.");
    }



    private static void viewAttendance(Student student) {
        System.out.println("Attendance Records for " + student.getName() + ":");
        attendanceDataStore.getRecords().stream()
                .filter(record -> record.getStudent().equals(student))
                .forEach(record -> {
                    if (record.isPresent()) {
                        System.out.println("Course: " + record.getCourse().getName() + " +");
                    } else {
                        System.out.println("Course: " + record.getCourse().getName());
                    }
                });
    }

}







