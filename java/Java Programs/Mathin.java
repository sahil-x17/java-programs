import java.util.Arrays;

public class Mathin {
  public static void main(String[] args)
  {

    //Maths
    // Math.min(5,6);
    // Math.max(5,6);
    System.out.println(Math.min(5,6));

    //random
    System.out.println(Math.random()); //in the form of long
    System.out.println((int)Math.random()); //value is smaller than 1 always, so int prints 0
    System.out.println((int)(Math.random()*100));

  }
}
