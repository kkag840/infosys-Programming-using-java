interface Tax{
    //Implement your code here
    double calculateTax(double price);
     double getTaxPercentage();
}

class PurchaseDetails{
    //Implement your code here
    private String purchaseId;
    private String paymentType;
    private double taxPercentage;

    // Constructor
    public PurchaseDetails(String purchaseId, String paymentType) {
        this.purchaseId = purchaseId;
        this.paymentType = paymentType;
        // Tax percentage is assumed to be 5%
        this.taxPercentage = 5.0;
    }

    // Implementing methods from the Tax interface
   // @Override
    public double calculateTax(double price) {
        return price * (taxPercentage / 100);
    }

   // @Override
    public double getTaxPercentage() {
        return taxPercentage;
    }

    // Getter and Setter methods
    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }
}

class Seller{
    //Implement your code here
     private String location;
    private double taxPercentage;

    // Constructor
    public Seller(String location) {
        this.location = location;
        // Tax percentage is assumed to be 10%
        this.taxPercentage = 10.0;
    }

    // Implementing methods from the Tax interface
    @Override
    public double calculateTax(double price) {
        return price * (taxPercentage / 100);
    }

    @Override
    public double getTaxPercentage() {
        return taxPercentage;
    }

    // Getter and Setter methods
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }
}

class Tester{
    public static void main(String args[]) {
		System.out.println("Purchase Details\n***************");
		PurchaseDetails purchaseDetails = new PurchaseDetails("P1001","Credit Card");
		System.out.println("Total purchase amount: " + Math.round(purchaseDetails.calculateTax(100)*100)/100.0);
		System.out.println("Tax percentage: "+purchaseDetails.getTaxPercentage());

        System.out.println("Seller Details\n***************");
		Seller seller = new Seller("Canada");
		System.out.println("Tax to be paid by the seller: " + Math.round(seller.calculateTax(100)*100)/100.0);
		System.out.println("Tax percentage: "+seller.getTaxPercentage());
		
		//Create more objects for testing your code
	}
}