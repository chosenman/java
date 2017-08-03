
public class CalculatorTest {

	public static void main(String[] arg) {
		Calculator one = new Calculator();
		
		one.setOperandOne("10.5");
		System.out.println( one.getOperandOne() );
		one.setOperation("+");
		System.out.println( one.getOperation() );
		one.setOperandTwo("5.2");
		System.out.println( one.getOperandTwo() );
		one.performOperation();
		
		System.out.println( one.getResults() );
	}
	
}
