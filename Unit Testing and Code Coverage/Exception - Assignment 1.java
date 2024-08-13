// Implement user defined exception classes 
class InvalidCouponCodeException extends Exception {
    public InvalidCouponCodeException(String message) {
        super(message);
    }
}

class InvalidDestinationException extends Exception {
    public InvalidDestinationException(String message) {
        super(message);
    }
}

class InvalidTripPackageException extends Exception {
    public InvalidTripPackageException(String message) {
        super(message);
    }
}


public class BusBooking {
    private int bookingId;
    private String destination;
    private String tripPackage;
    private double totalAmount;

    public BusBooking(int bookingId, String destination, String tripPackage) {
        this.bookingId = bookingId;
        this.destination = destination;
        this.tripPackage = tripPackage;
        this.totalAmount = 0;
    }

    public boolean validateCouponCode(String couponCode, int numberOfMembers) throws InvalidCouponCodeException {
        if ("BIGBUS".equals(couponCode) && numberOfMembers >= 10) {
            return true;
        } else if ("MAGICBUS".equals(couponCode) && numberOfMembers >= 15) {
            return true;
        } else {
            throw new InvalidCouponCodeException("Invalid coupon code");
        }
    }

    public String bookTrip(String couponCode, int numberOfMembers) {
       
        try{
            if(!(this.destination.equals("Washington DC")||this.destination.equals("Philadelphia")||this.destination.equals("Orlando")||
                 this.destination.equals("Boston")||this.destination.equals("Atlanta")))
            {
                throw new InvalidDestinationException("Invalid destination");
            }
            else if(!(this.tripPackage.equals("Regular")||this.tripPackage.equals("Premium")))
               throw new InvalidTripPackageException("Invalid package");
            validateCouponCode(couponCode,numberOfMembers);
            if(tripPackage.equals("Regular")){
              setTotalAmount(500*numberOfMembers);
              return "Booking successful";
            }
            else if(tripPackage.equals("Premium")){
              setTotalAmount(800*numberOfMembers);
               return "Booking successful"; 
            }
            else throw new InvalidTripPackageException("Invalid package");
        }
        catch(Exception e){
            return e.getMessage();
        }
    }

    // Getter and Setter methods
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTripPackage() {
        return tripPackage;
    }

    public void setTripPackage(String tripPackage) {
        this.tripPackage = tripPackage;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}



class Tester{
    public static void main(String[] args) {
		BusBooking booking = new BusBooking(101,"Orlando", "Regular");
		String result = booking.bookTrip("BIGBUS", 11);
		if(result.equals("Booking successful")){
			System.out.println(result);
			System.out.println("Total amount for the trip: " + booking.getTotalAmount());
		}
		else{
			System.out.println(result);
			System.out.println("Your booking was not successful, please try again!");
		}
	}
}