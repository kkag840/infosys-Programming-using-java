class Tester {
    
    public static boolean checkPasswordValidity(String password) {
       if (password.length() < 8 || password.length() > 20) {
            return false;
        }

        // Regular expression to validate password
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%&*_]).{8,20}$";

        // Compile the regular expression pattern
        Pattern pattern = Pattern.compile(regex);

        // Match the password with the pattern
        Matcher matcher = pattern.matcher(password);

        // Return true if the password matches the pattern, else return false
        return matcher.matches();
    }
    
    public static void main(String[] args) {
        
        //Change the value of password for testing your code with different passwords
        String password = "P@$sW0rd";
        System.out.println("The password is "+ (checkPasswordValidity(password) ? "valid!" : "invalid!"));
    }
    
}
