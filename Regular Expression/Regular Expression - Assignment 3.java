class Shipment{
	
   public boolean checkProductNameValidity(String productName) {
        // Regular expression to match product name conditions
        String regex = "^[a-zA-Z]+( [a-zA-Z]+){1,2}$";
        return productName.matches(regex);
    }

    // Method to validate the product Id
    public boolean checkProductIdValidity(String productId) {
        // Length check
        if (productId.length() < 2 || productId.length() > 20) {
            return false;
        }
        // Regular expression to match product Id conditions (alphanumeric)
        String regex = "^[a-zA-Z0-9]+$";
        return productId.matches(regex);
    }

    // Method to validate the shipment tracker Id
    public boolean checkTrackerIdValidity(String trackerId) {
        // Regular expression to match shipment tracker Id format
        String regex = "^[A-Z]:[A-Z]{4}:[a-z]{3}:[0-9]{2}$";
        return trackerId.matches(regex);
    }
	
}

class Tester {
      
    public static void main(String[] args) {
            
        Shipment shipment = new Shipment();
        
        //Change the values for testing your code with different values
        
        String productName = "Digital Camera";
        System.out.println("The product name is "+ (shipment.checkProductNameValidity(productName) ? "valid!" : "invalid!"));

        String productId = "DC1911";
        System.out.println("The product Id is "+ (shipment.checkProductIdValidity(productId) ? "valid!" : "invalid!"));

        String trackerId = "D:CMDC:cmd:23";
        System.out.println("The tracker Id is "+ (shipment.checkTrackerIdValidity(trackerId) ? "valid!" : "invalid!"));
    
    }
}






