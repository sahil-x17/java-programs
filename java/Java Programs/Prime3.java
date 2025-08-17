import java.util.*;

public class Prime3 {
  public static void main(String[] args)
  {
    Scanner s= new Scanner(System.in);
    System.out.println("Enter the range (i,j): ");
    int i=s.nextInt();
    int j=s.nextInt();
    for(int num = i;i<=j;i++)
   {
    int flag = 1;
    for(int k=2;k<i;k++)
    {
      if(i%k==0)
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
