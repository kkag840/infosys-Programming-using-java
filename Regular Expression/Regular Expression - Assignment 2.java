class Tester {

    public static boolean checkWebAddressValidity(String webAddress) {
        //Implement your code here and change the return value accordingly
        String regex = "^(http|https)://(www\\.)?[a-zA-Z0-9]+\\.(com|org|net)$";

        // Compile the regular expression pattern
        Pattern pattern = Pattern.compile(regex);

        // Match the web address with the pattern
        Matcher matcher = pattern.matcher(webAddress);

        // Return true if the web address matches the pattern, else return false
        return matcher.matches();
    }
      
    public static void main(String[] args) {
        
        //Change the value of webAddress for testing your code with different web addresses
        String webAddress = "http://www.company.com";
        System.out.println("The web address is "+ (checkWebAddressValidity(webAddress) ? "valid!" : "invalid!"));
    }
}
