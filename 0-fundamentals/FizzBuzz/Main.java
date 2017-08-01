public class Main{
  public static void main(String[] args){
    FizzBuzz myInstance = new FizzBuzz();
    String c = myInstance.fizzBuzz(15);
    if(c == "Fizz"){
      System.out.println("this integer divisible by 3");
    } else if (c == "Buzz"){
      System.out.println("this integer divisible by 5");
    } else if (c == "FizzBuzz"){
      System.out.println("this integer divisible by 5 and 3");
    } else if (c == "2"){
      System.out.println("this integer is 2");
    } else {
      System.out.println(c);
    }
  }
}
