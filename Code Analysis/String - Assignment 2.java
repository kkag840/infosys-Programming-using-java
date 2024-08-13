class Tester{
    public static boolean checkPalindrome(String str){
	    //Implement your code here and change the return value accordingly
	    for(int i=0,j=str.length()-1;i<j;i++,j--)
	       if(str.charAt(i)!=str.charAt(j))
	         return false;
        return true;
	}
	
	public static void main(String args[]){
		String str = "radar";
		if(checkPalindrome(str))
			System.out.println("The string is a palindrome!");
		else
			System.out.println("The string is not a palindrome!");
	}
}