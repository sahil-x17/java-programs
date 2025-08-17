public class Strings {
  public static void main(String[] args)
  {
    //Strings
    //Concatenate
    String name1 = "Aman";
    String name2 = "Sahil";
    String name3 = name1 + " and " + name2;
    // System.out.println(name3);

    //charAt
    System.out.println(name2.charAt(0)); //charAt(0)

    //length
    System.out.println(name2.length());

    //replace
    String name4 = name1.replace('a','b'); //replace('a','b')
    System.out.println(name4);
    System.out.println(name1); //No change in original string

    //Strings are immutable in java;


    //substring
    System.out.println(name3.substring(5,9)); // first index included, last index excluded
    //spaces counts in strings as index
    
  }

}
