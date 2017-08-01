// import java.util.Arrays;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
import java.util.*;

public class ImportPuzzleJava {


  // Create an array with the following values: 3,5,1,2,7,9,8,13,25,32. Print the sum of all numbers in the array. Also have the function return an array that only includes numbers that are greater than 10 (e.g. when you pass the array above, it should return an array with the values of 13,25,32)
  public void first(int[] arr){
    int sum = 0;
    for (int i = 0; i < arr.length; i++){
      sum += arr[i];
    }
    System.out.println( sum );

    ArrayList<Integer> newArray = new ArrayList<Integer>();
      for (int i = 0; i < arr.length; i++){
        if(arr[i] > 10) {
            newArray.add(arr[i]);
        }
      }
      System.out.println( newArray );
  }


  // Create an array with the following values: Nancy, Jinichi, Fujibayashi, Momochi, Ishikawa. Shuffle the array and print the name of each person. Have the method also return an array with names that are longer than 5 characters.
  public int randomWithRange(int min, int max){
         int range = (max - min) + 1;
         return (int)(Math.random() * range) + min;
      }



  public void second(String[] arr){

        int length = arr.length;
        int randomName;
        String temp;
        while(length > 0){
          randomName = randomWithRange(0, length-1);
          temp = arr[length-1];
          arr[length-1] = arr[randomName];
          arr[randomName] = temp;
          length--;
        }

        System.out.println(Arrays.toString(arr));

        Collections.shuffle(Arrays.asList(arr));
        System.out.println(Arrays.toString(arr));
  }

  public void secondMoreThan5(String[] arr){
    ArrayList<String> newArray = new ArrayList<String>();
      for (int i = 0; i < arr.length; i++){
        if(arr[i].length() > 5) {
            newArray.add(arr[i]);
        }
      }
      System.out.println( newArray );
  }

  // Create an array that contains all 26 letters of the alphabet (this array must have 26 values). Shuffle the array and display the last letter of the array. Have it also display the first letter of the array. If the first letter in the array is a vowel, have it display a message
  public char[] shuffleManualyCharType(char[] arr){
            int length = arr.length;
            int randomName;
            char temp;
            while(length > 0){
              randomName = randomWithRange(0, length-1);
              temp = arr[length-1];
              arr[length-1] = arr[randomName];
              arr[randomName] = temp;
              length--;
            }
            return arr;
      }

  public void third(){
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    char[] newarray = shuffleManualyCharType(alphabet);
    String vovels = "aeiou";
    System.out.println("last letter of array " + newarray[newarray.length-1]);
    System.out.println("first letter of array " + newarray[0]);
    if(vovels.indexOf(newarray[0]) != -1 ) {
      System.out.println("last is vovel! ");
    }
  }

    // generate 10 items array between 55 and 100
    public ArrayList<Integer> fourth(int num, int min, int max){
        ArrayList<Integer> newArray = new ArrayList<>();

        while(num > 0){
          newArray.add(randomWithRange(min, max));
          num--;
        }
        return newArray;
    }


}
