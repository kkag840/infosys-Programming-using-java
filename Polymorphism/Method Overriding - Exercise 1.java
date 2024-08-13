class User{
    //Implement your code here
    private int id;
    private String userName;
    private String emailId;
    private double walletBalance;

    // Constructor
    public User(int id, String userName, String emailId, double walletBalance) {
        this.id = id;
        this.userName = userName;
        this.emailId = emailId;
        this.walletBalance = walletBalance;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    // Method to add funds to the wallet
    public void addFunds(double amount) {
        if(amount > 0) {
            this.walletBalance += amount;
        }
    }

    // Method to deduct funds from the wallet
    public void deductFunds(double amount) {
        if(amount > 0 && this.walletBalance >= amount) {
            this.walletBalance -= amount;
        }
    }

    // Method to display user information
    public void displayUserInfo() {
        System.out.println("ID: " + id);
        System.out.println("Username: " + userName);
        System.out.println("Email ID: " + emailId);
        System.out.println("Wallet Balance: $" + walletBalance);
    }

    // Method to make a payment
    public boolean makePayment(double billAmount) {
        if (billAmount > 0 && this.walletBalance >= billAmount) {
            this.walletBalance -= billAmount;
            return true;
        } else {
            System.out.println("Insufficient funds for the payment.");
            return false;
        }
    }
}

class PremiumUser{
    //Implement your code here
    private int rewardPoints;

    // Constructor
   public PremiumUser(int id, String userName, String emailId, double walletBalance) {
        super(id, userName, emailId, walletBalance);
        this.rewardPoints = 0; // Initialize rewardPoints to 0
    }

    // Getter and Setter methods for rewardPoints
    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    // Method to add reward points
    public void addRewardPoints(int points) {
        if(points > 0) {
            this.rewardPoints += points;
        }
    }

    // Method to redeem reward points
    public void redeemRewardPoints(int points) {
        if(points > 0 && this.rewardPoints >= points) {
            this.rewardPoints -= points;
        }
    }

    // Overriding displayUserInfo method to include reward points
   // @Override
    public void displayUserInfo() {
        super.displayUserInfo();
        System.out.println("Reward Points: " + rewardPoints);
    }

    // Overriding makePayment method to include reward points deduction
    //@Override
    public boolean makePayment(double billAmount) {
        if (billAmount > 0 && getWalletBalance() + rewardPoints >= billAmount) {
            double remainingAmount = billAmount;
            if (rewardPoints > 0) {
                int pointsToRedeem = Math.min(rewardPoints, (int) remainingAmount);
                redeemRewardPoints(pointsToRedeem);
                remainingAmount -= pointsToRedeem;
            }
            if (remainingAmount > 0) {
                setWalletBalance(getWalletBalance() - remainingAmount);
            }
            return true;
        } else {
            System.out.println("Insufficient funds and reward points for the payment.");
            return false;
        }
    }

}

class Tester {

    public static void main(String[] args) {

        User user = new User(101, "Joe", "joe@abc.com", 100);

		PremiumUser premiumUser = new PremiumUser(201, "Jill", "jill@abc.com", 300);

		processPayment(user, 70);

		processPayment(premiumUser, 150);

		processPayment(premiumUser, 80);

		processPayment(premiumUser, 120);

    }

    public static void processPayment(User user, double billAmount) {
        if (user.makePayment(billAmount)) {
			System.out.println("Congratulations " + user.getUserName() + ", payment of $" + billAmount + " was successful!");
		} else {
			System.out.println("Sorry " + user.getUserName() + ", you do not have enough balance to pay the bill!");
		}
		System.out.println("Your wallet balance is $" + user.getWalletBalance());

		if (user instanceof PremiumUser) {
			PremiumUser premiumUser = (PremiumUser) user;
			System.out.println("You have " + premiumUser.getRewardPoints() + " points!");
		}
		System.out.println();
    }
}

