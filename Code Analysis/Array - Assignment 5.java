class Tester {

	public static int[] findNumbers(int num1, int num2) {
		int[] numbers = new int[6];

		// Implement your code her
		if(num1>=num2||num1<0||num2<0||num1>=100)
		  return NaN;
		     for(int i=0;i<6&&num1<=num2;num1++){
		         if(num1%5==0&&((num1%10)+(num1/10))%3==0)
		           numbers[i++]=num1;
		     }

		return numbers;
	}

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 30;

		int[] numbers = findNumbers(num1, num2);
		if (numbers[0] == 0) {
			System.out.println("There is no such number!");
		} else {
			for (int index = 0; index <= numbers.length - 1; index++) {
				if (numbers[index] == 0) {
					break;
				}
				System.out.println(numbers[index]);
			}
		}

	}
}