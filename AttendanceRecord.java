class AttendanceRecord {
    private Course course;
    private Student student;
    private boolean isPresent;

    public AttendanceRecord(Course course, Student student, boolean isPresent) {
        this.course = course;
        this.student = student;
        this.isPresent = isPresent;
    }

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }
}

