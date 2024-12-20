public interface UserActions {

    void viewDetails();

    default void logout() {
        System.out.println("Logging out...");
    }

    default void viewLectures() {
        throw new UnsupportedOperationException("Not available for this user type.");
    }

    default void viewAttendance() {
        throw new UnsupportedOperationException("Not available for this user type.");
    }

    default void enrollStudentToLecture(Student student, Course course) {
        throw new UnsupportedOperationException("Not available for this user type.");
    }

    default void deleteStudentFromLecture(Student student, Course course) {
        throw new UnsupportedOperationException("Not available for this user type.");
    }


    default void markAttendance(Student student, Course course, boolean present) {
        throw new UnsupportedOperationException("Not available for this user type.");
    }

    default void addLecturer(Lecturer lecturer) {
        throw new UnsupportedOperationException("Not available for this user type.");
    }

    default void deleteLecturer(Lecturer lecturer) {
        throw new UnsupportedOperationException("Not available for this user type.");
    }
}
