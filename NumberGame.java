import java.util.Scanner;
public class NumberGame
{
    public static void main(String[]args)
    {
        boolean GuessedNum=false;
        int randomNum = (int)(Math.random()*100)+1;
        Scanner sc=new Scanner(System.in);
        int NumofAttempts = 0;
        System.out.println(" Welcome To Number Guessing Game");
        System.out.println("Guess the number between 1 to 100");

        while(!GuessedNum && NumofAttempts<3)
        {
            int userGuess=sc.nextInt();
            if(userGuess == randomNum)
            {
                GuessedNum = true;

            }
            else 
            {
                NumofAttempts++;
                if(userGuess>randomNum)
                {
                    System.out.println("YOUR GUESS IS TOO HIGH");
                }
                else
                {
                    System.out.println("YOUR GUESS IS TOO LOW");
                }
            }
        }
        sc.close();
        if(GuessedNum)
        {
            System.out.println("CONGRATULAIONS! YOUR ASSUMPTION IS SPOT ON! \n The number was = "+randomNum);

        }
        else
        {
            System.out.println("APOLOGIZE, YOU HAVE EXHAUSTED ALL YOUR GUESSES. \n The accurate number was ="+randomNum);

        }

    }
}