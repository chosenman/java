import java.util.Arrays;
import java.util.ArrayList;

public class ImportBasic {

  public void Print255(){
    for (int i = 1; i<= 255 ; i++) {
      System.out.println(i);
    }
  }

  public void PrintOdd255(){
    for (int i = 1; i<= 255 ; i+=2) {
      System.out.println(i);
    }
  }

  public void PrintSum(){
    int sum = 0;
    for (int i = 0; i<= 255 ; i++) {
      sum += i;
      System.out.println("New number is: " + i + " Sum: " + sum);
    }
  }

  public void IteratingArray(int[] arr){
    for (int i = 0; i < arr.length; i++){
        System.out.println( arr[i] );
    }
  }

  public void FindMax(int[] arr){
    int max = arr[0];
    for (int i = 1; i < arr.length; i++){
      if(arr[i]> max){
        max = arr[i];
      }
    }
    System.out.println( max );
  }

  public void GetAvarage(int[] arr){
    int sum = 0;
    for (int i = 0; i < arr.length; i++){
      sum += arr[i];
    }
    System.out.println( sum / arr.length );
  }

  public void ArrOddNumbers(){
    ArrayList<Integer> array = new ArrayList<Integer>();
    for (int i = 1; i <= 255; i+=2){
      array.add(i);
    }
    System.out.println( array );
  }


  public void GreaterThan(int[] arr, int num){
    int count = 0;
    for (int i = 0; i < arr.length; i++){
      if(arr[i]> num) {
        count++;
      }
    }
    System.out.println( count );
  }

  public void Squarify(int[] arr){
    for (int i = 0; i < arr.length; i++){
      arr[i] = arr[i] * arr[i];
    }
    System.out.println( Arrays.toString(arr) );
  }

  public void EliminateNegative(int[] arr){
    for (int i = 0; i < arr.length; i++){
      if(arr[i] < 0) {
        arr[i] = 0;
      }
    }
    System.out.println( Arrays.toString(arr) );
  }

  public void MaxMinAvg(int[] arr){

    int max = arr[0];
    for (int i = 1; i < arr.length; i++){
      if(arr[i]> max){
        max = arr[i];
      }
    }

    int min = arr[0];
    for (int i = 1; i < arr.length; i++){
      if(arr[i] < min){
        min = arr[i];
      }
    }

    int sum = 0;
    for (int i = 0; i < arr.length; i++){
      sum += arr[i];
    }
    int avg = sum/ arr.length;

    int[] mma = {max, min, avg};
    System.out.println( Arrays.toString(mma) );

  }

  public void Shifting(int[] arr){
    int[] shifted;
    shifted =  new int[arr.length];
    for (int i = 1; i < arr.length; i++){
      shifted[i-1] += arr[i];
    }
    shifted[arr.length-1] = arr[0];
    System.out.println( Arrays.toString(shifted) );
  }


}
