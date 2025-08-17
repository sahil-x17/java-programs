import java.util.*;
class Swap
{
  public static void main(String args[])
  {
    System.out.println("Enter the value of x and y");
    Scanner s = new Scanner(System.in);
    int x = s.nextInt();
    int y = s.nextInt();
    System.out.println("before swapping numbers: "+x+" "+y);
    x = x+y;
    y = x-y;
    x = x-y;
    System.out.println("after swapping numbers: "+x+" "+y);
  }
}