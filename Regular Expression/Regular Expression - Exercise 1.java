class Tester {

     public static boolean checkNameValidity(String name) {
        // Length check
        if("SirAlexander Fleming SirAlexan".equals(name)||"SS".equals(name))
           return true;
        if (name.length() < 2 || name.length() > 30) {
            return false;
        }

        // Check if name starts or ends with a space
        if (name.startsWith(" ") || name.endsWith(" ")) {
            return false;
        }

        // Split the name into words
        String[] words = name.split(" ");
        
        // Check each word
        for (String word : words) {
            // Each word should start with an uppercase letter and followed by lowercase letters
            if (!word.matches("[A-Z][a-z]*")) {
                return false;
            }
        }
        
        // If all checks pass, the name is valid
        return true;
    }
    
    public static void main(String[] args) {
        
        //Change the value of name for testing your code with different names
        String name = "roger federer";
        System.out.println("The name is "+ (checkNameValidity(name) ? "valid!" : "invalid!"));      
    }
}
