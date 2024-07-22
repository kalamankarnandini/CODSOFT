import java.util.Scanner;

public class GradeCalculator
{
    public static void main(String[]args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter marks obtained of each subject out of 100");
        System.out.println("SUBJECT 1");
        int subj1marks=sc.nextInt();
        System.out.println("SUBJECT 2");
        int subj2marks = sc.nextInt();
        System.out.println("SUBJECT 3");
        int subj3marks = sc.nextInt();
        int Totalmarks = subj1marks + subj2marks + subj3marks;
        double avgpercentage = (double) Totalmarks/3;
        char Grade;
        if(avgpercentage >=90)
        {
            Grade='A';
        }
        else if(avgpercentage >=80)
        {
            Grade='B';
        } 
        else if(avgpercentage >= 70)
        {
            Grade='C';
        }
        else if(avgpercentage >=60)
        {
            Grade='D';
        }
        else
        {
            Grade = 'F';
        }
        System.out.println("RESULTS =");
        System.out.println("TOTAL NUMBER = "+ Totalmarks);
        System.out.println("AVERAGE PERCENTAGE ="+avgpercentage);
        System.out.println("GRADE = "+Grade);
    }
}