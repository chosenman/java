public class Main{
  public static void main(String[] args){
    ImportPythagorean pythagorean = new ImportPythagorean();
    double c = pythagorean.calculateHypoteneuse(2, 2);
    System.out.println(c);
    // int four = 4;
    // double squareRoot = Math.sqrt(four);
    // System.out.println(squareRoot);
    System.out.println("-----");

    String str = "Coding dojo is Awesome";
    int length = str.length();
    System.out.println(length);
    String concatenate = "my first string ".concat(str);
    String concatenate2 = "my first string " + str  + " - second example";
    String concatenate3 = String.format("hello %s here some int $%.3f", "world", 344.);
    System.out.println(concatenate);
    System.out.println(concatenate2);
    System.out.println(concatenate3);

    String ninja = "Welcome to Coding Dojo!";
    int t = ninja.indexOf("Coding"); // a is 11
    int e = ninja.indexOf("co"); // b is 3
    int y = ninja.indexOf("pizza"); // c is -1, "pizza" is not found

  }
}
