class Tester{

    public static String removeWhiteSpaces(String str){
		//Implement your code here and change the return value accordingly
		String s="";
		for(int i=0;i<str.length();i++)
		  {
		      char temp=str.charAt(i);
		      if(temp!=' ')
		        s+=temp;
		  }
        return s;
	}
	
	public static void main(String args[]){
		String str = "Hello   How are you   ";
		str = removeWhiteSpaces(str);
		System.out.println(str);
	}
}