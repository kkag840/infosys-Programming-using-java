class Tester {
    public static String reverseEachWord(String str){
	    //Implement your code here and change the return value accordingly
	    String temp="";
	    String ans="";
	    for(int i=0;i<str.length();i++){
	        if(str.charAt(i)==' ')
	          {
	              ans+=temp+" ";
	              temp="";
	          }
	         else
	         temp=str.charAt(i)+temp;
	        
	    }
        return ans+temp;
	}
	
	public static void main(String args[]){
	    String str = "all cows eat grass";
	    System.out.println(reverseEachWord(str));
	}
}