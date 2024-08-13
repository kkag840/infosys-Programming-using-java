class Student{
    //Implement your code here
    private int studentId;
    private int aggregateMarks;
    private final int STIPEND = 100; // Initialized with a default value

    // No-argument constructor
    public Student() {
        // No initialization here since it's a no-argument constructor
    }

    // Getter and Setter methods for studentId
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    // Getter and Setter methods for aggregateMarks
    public int getAggregateMarks() {
        return aggregateMarks;
    }

    public void setAggregateMarks(int aggregateMarks) {
        if (aggregateMarks >= 0) {
            this.aggregateMarks = aggregateMarks;
        } else {
            System.out.println("Invalid marks input.");
        }
    }

    // Getter method for STIPEND (no setter as it's final)
    public int getSTIPEND() {
        return STIPEND;
    }

    // Method to calculate total stipend
   public double calculateTotalStipend() {
        double bonus = 0;

        // Determine the bonus based on aggregateMarks
        if (aggregateMarks >= 85 && aggregateMarks < 90) {
            bonus = 10;
        } else if (aggregateMarks >= 90 && aggregateMarks < 95) {
            bonus = 15;
        } else if (aggregateMarks >= 95 && aggregateMarks <= 100) {
            bonus = 20;
        }

        // Calculate total stipend including the bonus
        return STIPEND + bonus;
    }

    // Method to display student information
    public void displayStudentInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Aggregate Marks: " + aggregateMarks);
        System.out.println("Stipend: $" + STIPEND);
        System.out.println("Total Stipend: $" + calculateTotalStipend());
    }
}

class Tester {

	public static void main(String[] args) {
		Student student1 = new Student();
		student1.setStudentId(1212);
		student1.setAggregateMarks(93);

		double totalStipend = student1.calculateTotalStipend();
		System.out.println("The final stipend of " + student1.getStudentId()+" is $" + totalStipend);

		Student student2 = new Student();
		student2.setStudentId(1222);
		student2.setAggregateMarks(84);

		totalStipend = student2.calculateTotalStipend();
		System.out.println("The final stipend of " + student2.getStudentId()+" is $" + totalStipend);
	}

}