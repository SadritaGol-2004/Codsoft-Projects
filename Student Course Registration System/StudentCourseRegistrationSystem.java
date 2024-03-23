import java.util.ArrayList;
import java.util.List;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private int enrolledStudents;

    public Course(String code, String title, String description, int capacity) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolledStudents = 0;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent() {
        if (enrolledStudents < capacity) {
            enrolledStudents++;
        } else {
            System.out.println("Course is already full.");
        }
    }

    public void dropStudent() {
        if (enrolledStudents > 0) {
            enrolledStudents--;
        } else {
            System.out.println("No students enrolled in this course.");
        }
    }

    public int availableSlots() {
        return capacity - enrolledStudents;
    }

    @Override
    public String toString() {
        return "Course Code: " + code + ", Title: " + title + ", Description: " + description + ", Capacity: " + capacity + ", Enrolled Students: " + enrolledStudents;
    }
}

class Student {
    private String studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
        course.enrollStudent();
    }

    public void dropCourse(Course course) {
        registeredCourses.remove(course);
        course.dropStudent();
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + ", Name: " + name + ", Registered Courses: " + registeredCourses.size();
    }
}

class CourseRegistrationSystem {
    private List<Course> courses;
    private List<Student> students;

    public CourseRegistrationSystem() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayCourses() {
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public void displayAvailableCourses() {
        for (Course course : courses) {
            System.out.println(course.getTitle() + " - Available Slots: " + course.availableSlots());
        }
    }

    public static void main(String[] args) {
        CourseRegistrationSystem system = new CourseRegistrationSystem();

        // Adding courses
        Course c1 = new Course("CSE101", "Introduction to Computer Science", "An introductory course covering basics of programming", 50);
        Course c2 = new Course("ENG201", "English Composition", "A writing course focusing on composition skills", 40);
        Course c3 = new Course("MAT301", "Calculus I", "A fundamental course in calculus", 60);
        system.addCourse(c1);
        system.addCourse(c2);
        system.addCourse(c3);

        // Adding students
        Student s1 = new Student("1001", "Alice");
        Student s2 = new Student("1002", "Bob");
        system.addStudent(s1);
        system.addStudent(s2);

        // Test registration and dropping courses
        s1.registerCourse(c1);
        s1.registerCourse(c2);
        s2.registerCourse(c2);

        s1.dropCourse(c1);

        // Display available courses
        System.out.println("Available Courses:");
        system.displayAvailableCourses();
    }
}