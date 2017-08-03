
public class Calculator {
	private String OperandOne;
	private String Operation;
	private String OperandTwo;
	private Double Results;

	public Calculator() {
		
	}
	
	public void performOperation() {
		if(Operation == "+") {
			Results = Double.parseDouble(OperandOne) + Double.parseDouble(OperandTwo);
		} else if (Operation == "-") {
			Results =  Double.parseDouble(OperandOne) - Double.parseDouble(OperandTwo);
		}
	}
	
	
//	GETTERS AND SETTERS
// Results
	public Double getResults() {
		return Results;
	}
	public void setResults(Double results) {
		Results = results;
	}
// 1st Operand
	public String getOperandOne() {
		return OperandOne;
	}
	public void setOperandOne(String operandOne) {
		OperandOne = operandOne;
	}
// Operation
	public String getOperation() {
		return Operation;
	}
	public void setOperation(String OperationArg) {
		Operation = OperationArg;
	}
// 2nd Operand
	public String getOperandTwo() {
		return OperandTwo;
	}
	public void setOperandTwo(String operandTwo) {
		OperandTwo = operandTwo;
	}

}
