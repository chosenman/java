import java.util.Arrays;
import java.util.ArrayList;

public class BasicJava {
  public static void main(String[] args){


    ImportBasic myPrint255 = new ImportBasic();
    // myPrint255.Print255();
    // myPrint255.PrintOdd255();
    // myPrint255.PrintSum();
    //
    // int[] myA = {4, 8, 8, 5, 9};
    // myPrint255.IteratingArray(myA);
    // myPrint255.FindMax(myA);
    // int[] myA2 = {2, 10, 3};
    // myPrint255.GetAvarage(myA2);
    // myPrint255.ArrOddNumbers();
    // int[] myA3 = {2, 10, 3, 7};
    // myPrint255.GreaterThan(myA3,6);
    // int[] myA4 = {2, 10, 3, 7};
    // myPrint255.Squarify(myA4);
    // int[] myA5 = {-2, 10, 3, -7};
    // myPrint255.EliminateNegative(myA5);
    // int[] myA6 = {-2, 10, 3, -7};
    // myPrint255.MaxMinAvg(myA6);
    int[] myA7 = {-2, 10, 3, -7};
    myPrint255.Shifting(myA7);



// divide line ====================
    System.out.println( "---------" );
    int[] myArray = {};
    System.out.println( Arrays.toString(myArray) );

    ArrayList<String> dynamicArray = new ArrayList<String>();
    dynamicArray.add("hello");
    dynamicArray.add("world");
    dynamicArray.add("etc");

    for (int i = 0; i < dynamicArray.size(); i++){
        System.out.println(dynamicArray.get(i));
    }


    for (String name : dynamicArray){
        System.out.println("hello " + name);
        // other operations using name
    }




  }
}
