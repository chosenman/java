public class TypeCastingLesson {
  public static void main(String[] args){
    // explicit casting
    int i = 130;
    byte b = (byte) i;
    System.out.println(b);
    i = 120;
    b = (byte) i;
    System.out.println(b);

    // implicid casting
    byte a = 127;
    int k = a;

    System.out.println(k);
  }
}
