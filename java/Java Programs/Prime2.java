import java.util.*;

public class Prime2 {
  public static void main(String[] args)
  {
   Scanner s= new Scanner(System.in);
   System.out.println("The prime numbers in the range 1-100 are: ");
   for(int i=1;i<=100;i++)
   {
    int flag = 1;
    for(int j=2;j<i;j++)
    {
      if(i%j==0)
      {
        flag = 0;
      }
      else continue;
    }
    if(flag==1)
    System.out.print(i+" ");
    else continue;
   }
  }
}
