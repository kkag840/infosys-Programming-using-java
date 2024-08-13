class Tester{
    public static String[] findPermutations(String str){
        //Implement your code here and change the return value accordingly
        List<String>per=new ArrayList<>();
        permutation("",str,per);
        return per.toArray(new String[0]);
    }
   public static void permutation(String curr,String str,List<String>per){
        int n=str.length();
        if(n==0)
         per.add(curr);
        else 
          for(int i=0;i<n;i++)
           permutation(curr+str.charAt(i),str.substring(0,i)+str.substring(i+1,n),per);
    }
    
    public static void main(String args[]){
        String str = "abc";
        String permutations[] = findPermutations(str);
        for(String permutation: permutations){
            if (permutation!=null)
                System.out.println(permutation);
        }
    }
}


