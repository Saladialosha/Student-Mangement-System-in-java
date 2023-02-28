import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private int age;
    private String email;
    private String phoneNumber;
    private ArrayList<String> courses = new ArrayList<String>();
    private ArrayList<Integer> grades = new ArrayList<Integer>();

    public Student(String name, int rollNumber, int age, String email, String phoneNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void addCourse(String course, int grade) {
        courses.add(course);
        grades.add(grade);
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public String toString() {
        return "Name: " + name + "\nRoll Number: " + rollNumber + "\nAge: " + age + "\nEmail: " + email +
                "\nPhone Number: " + phoneNumber + "\nCourses: " + courses + "\nGrades: " + grades +
                "\nAverage Grade: " + getAverageGrade();
    }
}

class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<Student>();

        while (true) {
            System.out.println("1. Add Student\n2. View Students\n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Roll Number: ");
                    int rollNumber = scanner.nextInt();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter Email: ");
                    String email = scanner.next();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.next();
                    Student student = new Student(name, rollNumber, age, email, phoneNumber);

                    System.out.print("Enter the number of courses: ");
                    int numOfCourses = scanner.nextInt();

                    for (int i = 0; i < numOfCourses; i++) {
                        System.out.print("Enter the name of course " + (i + 1) + ": ");
                        String course = scanner.next();
                        System.out.print("Enter the grade of course " + (i + 1) + ": ");
                        int grade = scanner.nextInt();
                        student.addCourse(course, grade);
                    }

                    students.add(student);
                    break;

                case 2:
                    for (Student s : students) {
                        System.out.println(s);
                        System.out.println("---------------");
                    }
                    break;

                case 3:
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}