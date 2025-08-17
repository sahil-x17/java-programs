public class Methodsin {

  public static void printJava()
    {
      System.out.println("HELLO");
    } // function / method created


  public static void add(int a, int b){
    int sum = a+b;
    System.out.println("Sum is: "+sum);
  }
  public static void main(String[] args)
  {
    // METHODS
    printJava();
    printJava();
    printJava();

    int a = 5;
    int b = 7;
    add(a,b);
  }
}
