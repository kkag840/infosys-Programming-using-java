class Tester {

	public static int findHighestOccurrence(String str){
		//Implement your code here and change the return value accordingly
		int[] mp=new int[256];
		int ans=0;
		for(int i=0;i<str.length();i++)
		 {
		     char temp=str.charAt(i);
		     mp[temp]++;
		     if(ans<mp[temp])
		       ans=mp[temp];
		 }
        return ans;
	}
	
	public static void main(String args[]){
	    String str = "success";
	    System.out.println(findHighestOccurrence(str));
	}
}