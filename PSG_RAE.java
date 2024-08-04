import java.util.List;
import java.util.ArrayList;

interface Enrollable {
    int getStudentID();
    String getName();
    double getCGPA();
}

class Student implements Enrollable {
    private int studentID;
    private String name;
    private List<Double> grades;

    public Student(int studentID, String name, List<Double> grades) {
        this.studentID = studentID;
        this.name = name;
        this.grades = grades;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        double sum = 0;
        for (Double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}

class GraduateStudent extends Student {
    private String researchTopic;

    public GraduateStudent(int studentID, String name, List<Double> grades, String researchTopic) {
        super(studentID, name, grades);
        this.researchTopic = researchTopic;
    }

    public String getResearchTopic() {
        return researchTopic;
    }
}

class Course {
    private List<Enrollable> enrolledStudents;

    public Course() {
        this.enrolledStudents = new ArrayList<>();
    }

    public void enrollStudent(Enrollable student) {
        // Common enrollment logic...

        // Polymorphism: Specific logic based on the type of student
        if (student instanceof GraduateStudent) {
            GraduateStudent gradStudent = (GraduateStudent) student;
            String researchTopic = gradStudent.getResearchTopic();
            // Additional logic for graduate students...
            System.out.println("Enrolled Graduate Student with Research Topic: " + researchTopic);
        } else {
            System.out.println("Enrolled Student: " + student.getName());
        }

        enrolledStudents.add(student);
    }
}

public class PSG_RAE {
    public static void main(String[] args) {
        List<Double> studentGrades = new ArrayList<>();
        studentGrades.add(85.0);
        studentGrades.add(90.5);
        studentGrades.add(78.2);

        Student undergradStudent = new Student(101, "John Doe", studentGrades);
        System.out.println("Undergraduate Student - Name: " + undergradStudent.getName() +
                ", Average Grade: " + undergradStudent.getCGPA());

        List<Double> gradStudentGrades = new ArrayList<>();
        gradStudentGrades.add(92.5);
        gradStudentGrades.add(89.0);
        gradStudentGrades.add(95.2);

        GraduateStudent gradStudent = new GraduateStudent(201, "Alice Smith", gradStudentGrades, "Computer Science");
        System.out.println("Graduate Student - Name: " + gradStudent.getName() +
                ", Average Grade: " + gradStudent.getCGPA() +
                ", Research Topic: " + gradStudent.getResearchTopic());

        Course javaProgramming = new Course();
        javaProgramming.enrollStudent(undergradStudent);
        javaProgramming.enrollStudent(gradStudent);
    }
}

