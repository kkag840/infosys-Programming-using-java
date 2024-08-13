class MovieTicket {
    //Implement your code here 
    private int movieId;
    private int noOfSeats;
    private double costPerTicket;
    public MovieTicket(int movieId,int noOfSeats){
        this.moiveId=moiveId;
        this.noOfSeats=noOfSeats;
    }
    public double calculateTotalAmount(){
        double price[]=new double[3]{7,8,8.5};
        if(movieId>=111&&movieId<=113)
          return price[movieId%111];
        return 0;
    }
    public void setMovieId(int movieId){
        this.movieId=movieId;
    }
    public int getMovieId(){
        return movieId;
    }
    public void setNoOfSeats(int noOfSeats){
        this.noOfSeats=noOfSeats;
    }
    public int getNoOfSeats(){
        return noOfSeats;
    }
     public void setCostPerTicket(double costPerTicket){
        this.costPerTicket=costPerTicket;
    }
     public double getCostPerTicket(){
        return costPerTicket;
    }
    
}


class Tester {
    public static void main(String[] args) {
        MovieTicket movieTicket = new MovieTicket(112, 3);
        double amount = movieTicket.calculateTotalAmount();
        if (amount==0)
            System.out.println("Sorry! Please enter valid movie Id and number of seats");
        else
            System.out.println("Total amount for booking : $" + amount);
    }
}