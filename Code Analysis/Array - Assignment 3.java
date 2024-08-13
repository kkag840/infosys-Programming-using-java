class Tester {
    
   public static int[] findLeapYears(int year){
       //Implement your code here and change the return value accordingly
        int[] leap=new int[15];
        for(int i=0;i<15;year){
            if(year%4==0&&year%100!=0||year%400==0)
              leap[i++]=year;
        }
        return leap;
   }
    
   public static void main(String[] args) {
       int year = 2000;
	   int[] leapYears;
	   leapYears=findLeapYears(year);
	   for ( int index = 0; index<leapYears.length; index++ ) {
	       System.out.println(leapYears[index]);
	   }
    }
}
