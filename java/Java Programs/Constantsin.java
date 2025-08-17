public class Constantsin {
  public static void main(String[] args)
  {
    int age = 30;
    age =31;
    age = 32; // values can be changed

    float PI = 3.14F;
    PI = 1.1F; // this will also change the value;

    final float PI2 = 3.14F;
    PI2 = 1.1F; // cannot assign a value to final variable PI2
  }
}
