class Bill{
    //Implement your code here
    public double findPrice(int itemId) {
        double price = 0.0;
        switch (itemId) {
            case 101:
                price = 1500.00;
                break;
            case 102:
                price = 2000.00;
                break;
            case 103:
                price = 1800.00;
                break;
            case 104:
                price = 2200.00;
                break;
            default:
                price = 0.0; // If itemId is invalid
        }
        return price;
    }
    
    // Method to find price based on brandName, itemType, and size
    public double findPrice(String brandName, String itemType, int size) {
        double price = 0.0;
        if (brandName.equals("Nike") && itemType.equals("T-Shirt")) {
            if (size >= 36 && size <= 40) {
                price = 1200.00;
            } else if (size >= 41 && size <= 45) {
                price = 1300.00;
            }
        } else if (brandName.equals("Adidas") && itemType.equals("Shoes")) {
            if (size >= 6 && size <= 8) {
                price = 2500.00;
            } else if (size >= 9 && size <= 11) {
                price = 2800.00;
            }
        }
        return price;
    }
    public double findPriceMultipleParameters(String brandName, String itemType, int size) {
    double price = 0.0;
    if (brandName.equals("Puma")) {
        if (itemType.equals("T-shirt") && size == 34) {
            price = 1500.00;
        } else if (itemType.equals("T-shirt") && size == 36) {
            price = 1600.00;
        } else if (itemType.equals("Skirt") && size == 38) {
            price = 1700.00;
        } else if (itemType.equals("Skirt") && size == 40) {
            price = 1800.00;
        }
    } else if (brandName.equals("Reebok")) {
        if (itemType.equals("T-shirt") && size == 34) {
            price = 1900.00;
        } else if (itemType.equals("T-shirt") && size == 36) {
            price = 2000.00;
        }
    }
    if(price==0.0)
     return NaN;
    return price;
}
}

class Tester {

	public static void main(String[] args) {
		
		Bill bill = new Bill();
		
		double price = bill.findPrice(1001);
		if(price>0)
		    System.out.println("Price of the selected item is $"+price);
		else
		    System.out.println("The Item Id is invalid");
		
		price = bill.findPrice("Reebok","T-shirt",34);
		if(price>0)
		    System.out.println("Price of the selected item is $"+price);
		else
		    System.out.println("The values are not valid");
	}
	
}
