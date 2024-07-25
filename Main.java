import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student
{
    private String name;
    private int rollno;
    private String Grade;

    public Student(String name,int rollno ,String Grade)
    {
        this.name = name;
        this.rollno = rollno;
        this.Grade = Grade;
    }

    public int getROLLNUMBER()
    {
        return rollno;
    }

    public String toString()
    {
        return "NAME:"+name + "ROLL NUMBER:" + rollno +"GRADE:" +Grade;
    }
}
class StudentManagementSystem
{
    private List<Student>students;
    public StudentManagementSystem()
    {
        students = new ArrayList<>();
    }
    public void addStudent(Student student)
    {
        students.add(student);
    }
    public boolean removeStudent(int rollno)
    {
        for(Student student:students)
        {
            if(student.getROLLNUMBER()==rollno)
            {
                students.remove(student);
                return true;
            }
        }
        return false;
    }
    public Student searchStudent(int rollno)
    {
        for(Student student:students)
        {
            if(student.getROLLNUMBER()==rollno){
                return student;
            }
        }
        return null;
    }
    public List<Student>getAllStudents(){
        return students;
    }
}
public class Main  {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        StudentManagementSystem sms=new StudentManagementSystem();

        while(true)
        {
           
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.println("Enter your choice");
            int choice=sc.nextInt();

            switch (choice)
            {
                case 1:
                sc.nextLine();
                System.out.println("Enter Student Name:");
                String name =  sc.nextLine();
                System.out.println("Enter Roll Number:");
                int rollno= sc.nextInt();
                sc.nextLine();
                System.out.println("Enter Grade:");
                String Grade=sc.nextLine();

                Student newStudent=new Student(name,rollno,Grade);
                sms.addStudent(newStudent);
                System.out.println("Student added");
                break;

                case 2:
                System.out.println("Enter Roll Number of student to remove");
                int rollToRemove =  sc.nextInt();
                boolean removed= sms.removeStudent(rollToRemove);
                if(removed)
                {
                    System.out.println("Student removed");
                }
                else
                {
                    System.out.println("Student not found");
                }
                break;

                case 3:
                System.out.println("Enter Roll Number of student to search");
                int rollToSearch =  sc.nextInt();
                Student searchedStudent = sms.searchStudent(rollToSearch);
                if(searchedStudent != null)
                {
                    System.out.println("Student found");
                    System.out.println(searchedStudent);
                }
                else
                {
                    System.out.println("Student not found");
                }
                break;

                case 4:
                List<Student>allStudents = sms.getAllStudents();
                if(allStudents.isEmpty())
                {
                    System.out.println("No students to display");
                }
                else{
                    System.out.println("All Students");
                    for(Student student:allStudents){
                        System.out.println(student);
                    }
                }
                break;

                default:
                System.out.println("Invalid choice.Please choose again");
                break;
            }
        }
    }
}