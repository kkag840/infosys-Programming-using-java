class Tester{
    public static String removeDuplicatesandSpaces(String str){
        //Implement your code here and change the return value accordingly
        boolean[] mp=new boolean[256];
        String s="";
        for(int i=0;i<str.length();i++)
          {
               char temp=str.charAt(i);
               if(temp!=' '&&!mp[temp])
                 s+=temp;
              mp[temp]=true;
                
          }
        return s;
	}
	
	public static void main(String args[]){
	    String str = "object oriented programming";
	    System.out.println(removeDuplicatesandSpaces(str));
	}
}