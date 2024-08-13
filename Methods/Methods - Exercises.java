class Calculator {

	// Implement your code here
	public double findAverage(int number1,int number2,int number3){
	    double avg=(number1+number2+number3)/3.0;
	    return Math.round(avg*100.0)/100.0;
	}
}

class Tester {

	public static void main(String args[]) {
		Calculator calculator = new Calculator();
		// Invoke the method findAverage of the Calculator class and display the average
		System.out.printf("%.2f",findAverage(12,8,15));
		System.out.printf("%.2f",findAverage(10,20,30));
	}
}