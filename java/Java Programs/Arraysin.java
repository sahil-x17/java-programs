import java.util.Arrays;

public class Arraysin {
  public static void main(String[] args)
  {
    int age = 30;
    int physics = 97;
    int chem = 98;
    int eng = 95;

    //instead use arrays

    int[] marks = new int[3]; //creating an array, when we don't know values to store
    marks[0]=97;
    marks[1]=98;
    // marks[2]= 95;

    // System.out.println(marks[0]);
    // System.out.println(marks[1]);
    // System.out.println(marks[2]); //in java if no value is provided it initializes itself with 0 or NULL;

    //so for string of datatype - boolean , and if no values are initialized , by default it would store false;

    //functions in array

    //length 
    System.out.println(marks.length);//no parenthesis beacuse length is not the function in arrays, it is a property
    // and properties are not called using parenthesis

    //sort

    //Arrays class
    //Every class in java is usually given first letter uppercase
    System.out.println(marks[0]);
    Arrays.sort(marks); //this shows redline if we don't write import java.util.Arrays;
    System.out.println(marks[0]); //this is ascending sort

    int[] marks2= {97,98,95}; //creating an array when we know what value to store


    //2D arrays----------->

    int[][] finalMarks = {{97,98,95},{95,95,98}};
    System.out.println(finalMarks[0][0]);
    System.out.println(finalMarks[1][1]);
    System.out.println(finalMarks[1][0]);




  }
}
