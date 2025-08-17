import java.util.*;

public class Prime1 {
  public static void main(String args[])
  {
    Scanner s= new Scanner(System.in);
    System.out.println("Enter number to check whether it is prime or not: ");
    int x = s.nextInt();
    int flag=1;
    for(int i=2; i<x; i++)
    {
      if(x%i == 0)
      {
        flag = 0;
      }
      else continue;
    }
    if(flag==0)
    {
      System.out.println("The number is NOT prime");
    }
    else
    System.out.println("The number IS prime");

  }
}
