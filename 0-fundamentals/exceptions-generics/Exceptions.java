import java.util.*;
// class OutOfGasException extends Exception{}

  class Exceptions{
      public static void main(String[] args){

        // Exceptions and Generics
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        // System.out.println(myList);

        for ( Object key : myList ){
          // Integer castedValue = (Integer) value;
          try{
            Integer neVar = (Integer) key;
          } catch (ClassCastException e) {
             continue;
           }
          System.out.println(key);
        }

        //  From the theory
          // ImportExceptions friend = new ImportExceptions();
          // try{
          //     friend.deliverMessage();
          //     System.out.println("The message was delivered!");
          // } catch (OutOfGasException e){
          //     System.out.println("Hey, uh, so, I ran out of gas..");
          //     // back-up plan here.
          // }


      }
  }
