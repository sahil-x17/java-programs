
import java.util.Arrays;
import java.util.Scanner;

public class Input {
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in); //similar to system.out for output
    // System.out.println("input Your age: ");
    // int age = sc.nextInt();
    // System.out.println(age);
    // float age2 = sc.nextFloat();
    // System.out.println(age2);
    // boolean age3 = sc.nextBoolean();
    // System.out.println(age3);


    //strings
    
    System.out.println("Input your name: ");
    String name = sc.next(); //next() function only takes tokents as inputs
    // tokens means single word , It will not take a line as input
    System.out.println(name);

    sc.nextLine();//if we don't write this an unexpected behaviour occures
    // The issue you're experiencing is likely due to the behavior of the next() 
    // and nextLine() methods in the Scanner class. When you use sc.next() to read input,
    //  it reads only a single token (a sequence of characters separated by whitespace),
    //  not the entire line. 
    // As a result, if there's any remaining newline character
    //  in the input buffer after a previous call to next(), 
    // it can cause unexpected behavior when you try to use nextLine().
    // To fix this, you can consume the newline character
    //  after reading the first input using sc.nextLine()

    System.out.println("Input your name: ");
    String name2 = sc.nextLine();
    System.out.print(name2);

  }
}
