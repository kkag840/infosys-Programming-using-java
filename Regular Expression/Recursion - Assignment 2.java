class Tester {

    public static double findHPSum(int num) {
        //Implement your code here and change the return value accordingly
         if (n == 1) {
            return 1.0;
        } else {
            return 1.0 / n + findHPSum(n - 1);
        }
        return 0;
    }
    
    public static void main(String args[]) {
        System.out.println(findHPSum(3));
    }
}
