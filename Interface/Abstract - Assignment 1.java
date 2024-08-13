abstract class Payment{
    //Implement your code here
    private int customerId;
    protected String paymentId;
    protected double serviceTaxPercentage;
    public Payment(int customerId){
        this.customerId=customerId;
    }
    
    // Getter for customerId
    public int getCustomerId() {
        return customerId;
    }

    // Setter for customerId
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    // Getter for paymentId
    public String getPaymentId() {
        return paymentId;
    }

    // Setter for paymentId
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    // Getter for serviceTaxPercentage
    public double getServiceTaxPercentage() {
        return serviceTaxPercentage;
    }

    // Setter for serviceTaxPercentage
    public void setServiceTaxPercentage(double serviceTaxPercentage) {
        this.serviceTaxPercentage = serviceTaxPercentage;
    }
    public abstract double payBill(double amount);
    
}

class DebitCardPayment extends Payment{
    //Implement your code here
    private static int counter=1000;
    private double discountPercentage;
    public DebitCardPayment(int customerId){
        super(customerId);
        counter++;
        paymentId="D"+counter;
    }
        // Getter for counter
    public static int getCounter() {
        return counter;
    }

    // Setter for counter
    public static void setCounter(int counter) {
        DebitCardPayment.counter = counter;
    }

    // Getter for discountPercentage
    public double getDiscountPercentage() {
        return discountPercentage;
    }

    // Setter for discountPercentage
    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
    public double payBill(double amount){
        double serviceTaxAmount=0;
        double discountAmount=0;
        if(amount<=500) serviceTaxPercentage=2.5;
        else if(amount>500&&amount<=1000) serviceTaxPercentage=4;
        else if(amount>1000) serviceTaxPercentage=5;
        serviceTaxAmount=amount*serviceTaxPercentage/100;
        if(amount<=500) discountPercentage=1;
        else if(amount>500&&amount<=1000) discountPercentage=2;
        else if(amount>1000) discountPercentage=3;
        discountAmount=amount*discountPercentage/100;
        return amount+serviceTaxAmount-discountAmount;
    }
}

class CreditCardPayment extends Payment{
    //Implement your code here
    private static int counter=1000;
    public CreditCardPayment(int customerId){
        super(customerId);
        counter++;
        paymentId="C"+counter;
    }
    
    // Static getter for counter
    public static int getCounter() {
        return counter;
    }

    // Static setter for counter
    public static void setCounter(int counter) {
        CreditCardPayment.counter = counter;
    }

    public double payBill(double amount){
        double serviceTaxAmount=0;
        if(amount<=500) serviceTaxPercentage=3;
        else if(amount>500&&amount<=1000) serviceTaxPercentage=5;
        else if(amount>1000) serviceTaxPercentage=6;
        serviceTaxAmount=amount*serviceTaxPercentage/100;
        return amount+serviceTaxAmount;
    }
}

class Tester{
    public static void main(String args[]){
        DebitCardPayment debitCardPayment = new DebitCardPayment(101);
        double billAmount=Math.round(debitCardPayment.payBill(500)*100)/100.0;
		System.out.println("Customer Id: " + debitCardPayment.getCustomerId());
		System.out.println("Payment Id: " + debitCardPayment.getPaymentId());
		System.out.println("Service tax percentage: " + debitCardPayment.getServiceTaxPercentage());
		System.out.println("Discount percentage: " + debitCardPayment.getDiscountPercentage());
		System.out.println("Total bill amount: " + billAmount);
		
		CreditCardPayment creditCardPayment = new CreditCardPayment(102);
        billAmount=Math.round(creditCardPayment.payBill(1000)*100)/100.0;
		System.out.println("Customer Id: " + creditCardPayment.getCustomerId());
		System.out.println("Payment Id: " + creditCardPayment.getPaymentId());
		System.out.println("Service tax percentage: " + creditCardPayment.getServiceTaxPercentage());
		System.out.println("Total bill amount: " + billAmount);
    }
}