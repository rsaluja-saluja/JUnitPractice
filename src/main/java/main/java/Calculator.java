package main.java;

public class Calculator {
	
	CalculatorService cSer;
	

	public Calculator()
	{}
	public Calculator(CalculatorService cSer) {
		super();
		this.cSer = cSer;
	}

	public int add(int i, int j)
	{
		return i+j;
	}
	
	public int perform(int i, int j)
	{
		return cSer.addNumbers(i, j)*3;
		//return add(i,j)*3;
	}
}
