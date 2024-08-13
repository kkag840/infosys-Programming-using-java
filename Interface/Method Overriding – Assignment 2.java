class Event{
    //Implement your code here
    private String eventName;
    private String participantName;
    private double registrationFee;
    public Event(String eventName,String participantName){
        this.eventName=eventName;
        this.participantName=participantName;
    }
    
    // Getter for eventName
    public String getEventName() {
        return eventName;
    }

    // Setter for eventName
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    // Getter for participantName
    public String getParticipantName() {
        return participantName;
    }

    // Setter for participantName
    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    // Getter for registrationFee
    public double getRegistrationFee() {
        return registrationFee;
    }

    // Setter for registrationFee
    public void setRegistrationFee(double registrationFee) {
        this.registrationFee = registrationFee;
    }
    
    public void registerEvent(){
        if(eventName.equals("Singing"))
           this.registrationFee=8;
        else if(eventName.equals("Dancing"))
           this.registrationFee=10;
        else if(eventName.equals("DigitalArt"))
           this.registrationFee=12;
        else if(eventName.equals("Acting"))
           this.registrationFee=15;
        else
           this.registrationFee=0;
    }
    
}

class SoloEvent extends Event{
    //Implement your code here
    private int participantNo;
    public SoloEvent(String eventName,String participantName,int participantNo){
        super(eventName,participantName);
        this.participantNo=participantNo;
    }
    public int getParticipantNo() {
        return participantNo;
    }

    // Setter for participantNo
    public void setParticipantNo(int participantNo) {
        this.participantNo = participantNo;
    }
    public void registerEvent(){
        super.registerEvent();
    }
    
}

class TeamEvent extends Event{
    //Implement your code here
    private int noOfParticipants;
    private int teamNo;
    public TeamEvent(String eventName,String participantName,int noOfParticipants,int teamNo){
        super(eventName,participantName);
        this.noOfParticipants=noOfParticipants;
        this.teamNo=teamNo;
    }
    
    // Getter for noOfParticipants
    public int getNoOfParticipants() {
        return noOfParticipants;
    }

    // Setter for noOfParticipants
    public void setNoOfParticipants(int noOfParticipants) {
        this.noOfParticipants = noOfParticipants;
    }

    // Getter for teamNo
    public int getTeamNo() {
        return teamNo;
    }

    // Setter for teamNo
    public void setTeamNo(int teamNo) {
        this.teamNo = teamNo;
    }
    public void registerEvent(){
        int baseFare=0;
        if(this.noOfParticipants>1){
            if(super.getEventName().equals("Singing"))
           baseFare=4;
        else if(super.getEventName().equals("Dancing"))
           baseFare=6;
        else if(super.getEventName().equals("DigitalArt"))
           baseFare=8;
        else if(super.getEventName().equals("Acting"))
           baseFare=10;
        }
        
        else 
           super.setRegistrationFee(0);
        super.setRegistrationFee(this.noOfParticipants*baseFare);
    }
}

class Tester {

      public static void main(String[] args) {
            
        SoloEvent soloEvent = new SoloEvent("Dancing", "Jacob", 1);
		soloEvent.registerEvent();
		if (soloEvent.getRegistrationFee() != 0) {
			System.out.println("Thank You " + soloEvent.getParticipantName()
					+ " for your participation! Your registration fee is $" + soloEvent.getRegistrationFee());
			System.out.println("Your participant number is " + soloEvent.getParticipantNo());

		} else {
			System.out.println("Please enter a valid event");
		}

		System.out.println();
		TeamEvent teamEvent = new TeamEvent("Acting", "Serena", 5, 1);
		teamEvent.registerEvent();
		if (teamEvent.getRegistrationFee() != 0) {
			System.out.println("Thank You " + teamEvent.getParticipantName()
					+ " for your participation! Your registration fee is $" + teamEvent.getRegistrationFee());
			System.out.println("Your team number is " + teamEvent.getTeamNo());
		} else {
			System.out.println("Please enter a valid event");
		}
	}
}
