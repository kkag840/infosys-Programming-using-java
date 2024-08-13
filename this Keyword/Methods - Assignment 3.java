class Calculator {

	// Implement your code here
  public int num;
  public int sumOfDigits(){
	    int res=0;
	    while(num>0){
	        res+=num%10;
	        num/=10;
	    }
	    return res;
	}

}

class Tester {

	public static void main(String args[]) {

		Calculator calculator = new Calculator();
		calculator.num=123;
		System.out.println(calculator.sumOfDigits());

		// Assign a value to the member variable num of Calculator class

		// Invoke the method sumOfDigits of Calculator class and display the output

	}
}