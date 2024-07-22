import java.util.Scanner;

public class Currency_Converter
{
   public static void main(String[] args)
   {
    Scanner sc=new Scanner(System.in);
    
    System.out.println("Welcome to currency converter");
    System.out.println("Supported currencies: USD,EUR,GBP,INR");

    System.out.println("Enter the Amount");
    double amount = sc.nextDouble();

    System.out.println("Enter the source currency (eg. USD)");
    String sourcecurrency = sc.next().toUpperCase();

    System.out.println("Enter the target currency(eg.EUR)");
    String targetCurrency = sc.next().toUpperCase();

    double convertedAmount = convertedCurrency(amount,sourcecurrency,targetCurrency);
    System.out.println(amount+ "  " +sourcecurrency+" is equal to "+convertedAmount+ "  " +targetCurrency);
     
    sc.close();

   }
   private static double convertedCurrency(double amount,String sourcecurrency, String targetCurrency)
   {
      double usdToEurRate = 0.92;
      double usdToGbpRate = 0.79;
      double usdToInrRate = 82.91;
      double eurToUsdRate = 1.08;
      double gbpToUsdRate = 1.26;
      double inrToUsdRate = 1/usdToInrRate;
   

   if(sourcecurrency.equals("USD")&&targetCurrency.equals("EUR"))
   {
      return amount*usdToEurRate;
   }
   else if(sourcecurrency.equals("USD")&&targetCurrency.equals("GBP"))
   {
      return amount*usdToGbpRate;
   }
   else if(sourcecurrency.equals("USD")&&targetCurrency.equals("Inr"))
   {
      return amount*usdToInrRate;
   }
   else if(sourcecurrency.equals("EUR")&&targetCurrency.equals("USD"))
   {
      return amount*eurToUsdRate;
   }
   else if(sourcecurrency.equals("GBP")&&targetCurrency.equals("USD"))
   {
      return amount*gbpToUsdRate;
   }
   else if(sourcecurrency.equals("INR")&&targetCurrency.equals("USD"))
   {
      return amount*inrToUsdRate;
   }
    else
       {
        System.out.println("Unsupported conversion");
        return 0.0; 
       }
   }
}