public class Castingin {
  public static void main(String[] args)
  {
    //casting- datatype conversion 
    //2-types - implicit , explicit

    double price = 100.00;
    double finalPrice = price + 18;

    System.out.println(finalPrice);

    int p = 100;
    int fp = p + 18.0; //this error is due to casting
    // java dose not do casting when value from larg container is being stored in smaller container
    // hence in such case we need to do explicit casting
    // implicit casting - java stores small datatypes into large datatypes is called implicit casting
    int fp1 = p + (int)18.0; 
    //(int)18.3 = 18
    //(int)18.99 = 18;
    //hence values after decimal points are removed
    

  }
}
