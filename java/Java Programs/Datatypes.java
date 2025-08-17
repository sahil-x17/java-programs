public class Datatypes {

  public static void main(String[] args)
  {
    //Datatypes
    //primitive and non-primitive types

    // Primitive 
    // datatypes - memory in bytes ; example
    // byte - 1 [-128 to 127]
    // short - 2;
    // int - 4; 1,2,3,4
    // long - 8;
    // float - 4 ; 3.14
    // double - 8
    // char - 2 ;a,b,c,d
    // boolean - 1 ;true/false


    byte age = 30;
    int phone = 1234567890;
    long phone2 = 123456784500L; // to avoid red line , last me L;
    float pi = 3.14f; //3.14 is treated as integer unless we use f ro F in the end;
    char letter = '@';
    boolean isAdult = false;


    //non-primitive types----->

    String name = "Sahil";
    System.out.println(name.length()); //length is a method or function
    //Non-primitive type dose not have fixed size like primitive;
    //we declare non-primitive datatypes with 'new' keyword;
    String name2 = new String("apu");
    //in strings it is not compulsory to use new keywords
    
  }
  
}
