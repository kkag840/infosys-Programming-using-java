class Tester {

    public static int countSubstring(String inputString, String substring, int count) {
        //Implement your code here and change the return value accordingly
        if (str.length() < substr.length()) {
            return 0; // Base case: if string length is less than substring length, substring cannot occur
        }

        if (str.startsWith(substr)) {
            // If substring matches the beginning of the string, increment count and continue searching
            return 1 + countSubstring(str.substring(substr.length()), substr);
        } else {
            // If substring does not match, continue searching with the remaining string
            return countSubstring(str.substring(1), substr);
        }
    }
   
    public static void main(String args[]) {
        int count = countSubstring("I felt happy because I saw the others were Happy and because I knew I should feel happy, but I was not really happy","happy", 0);
        System.out.println(count);
    }
}
