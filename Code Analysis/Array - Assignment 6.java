class Tester {
	public static int findTotalCount(int[] numbers) {
		//Implement your code here and change the return value accordingly
		int ans=0;
		for(int i=0;i<numbers.length-1;i++)
		  if(numbers[i]==numbers[i+1])
		    ans++;
        return ans;
	}

	public static void main(String[] args) {
		int[] numbers = { 1, 1, 5, 100, -20, 6, 0, 0 };
		System.out.println("Count of adjacent occurrence: "+findTotalCount(numbers));
	}
} 
 
