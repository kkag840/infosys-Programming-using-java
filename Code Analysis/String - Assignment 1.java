class Tester{
    
    public static String moveSpecialCharacters(String str){
		//Implement your code here and change the return value accordingly
		char[] arr=new str.toCharArray();
		for(int i=0,j=0;i<arr.length;){
		    if((arr[i]>='a'&&arr[i]<='z')||(arr[i]>='A'&&arr[i]<='Z'))
		      {
		          char temp=arr[i];
		          arr[i]=arr[j];
		          arr[j]=temp;
		          i++;
		          j++;
		      }
		      else
		         i++;
		}
        return new String(arr);
	}
	
	public static void main(String args[]){
	    String str = "He@#$llo!*&";
	    System.out.println(moveSpecialCharacters(str));
	}
	
}