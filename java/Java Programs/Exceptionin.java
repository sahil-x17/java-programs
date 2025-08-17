public class Exceptionin {
  public static void main(String[] args)
  {
    int[] marks = {97,98, 95};
    System.out.println(marks[5]);
    // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 3

    try{
      System.out.println(marks[5]);
    } catch(Exception exception) {
      // do something after catching
    }
    // This statements normally executes


  }
}
