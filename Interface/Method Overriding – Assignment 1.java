// Faculty.java
public class Faculty {
    private String name;
    private float basicSalary;
    private float bonusPercentage;
    private float carAllowancePercentage;

    public Faculty(String name, float basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
        this.bonusPercentage = 4.0f;
        this.carAllowancePercentage = 2.5f; 
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for basicSalary
    public float getBasicSalary() {
        return basicSalary;
    }

    // Setter for basicSalary
    public void setBasicSalary(float basicSalary) {
        this.basicSalary = basicSalary;
    }

    // Getter for bonusPercentage
    public float getBonusPercentage() {
        return bonusPercentage;
    }

    // Setter for bonusPercentage
    public void setBonusPercentage(float bonusPercentage) {
        this.bonusPercentage = bonusPercentage;
    }

    // Getter for carAllowancePercentage
    public float getCarAllowancePercentage() {
        return carAllowancePercentage;
    }

    // Setter for carAllowancePercentage
    public void setCarAllowancePercentage(float carAllowancePercentage) {
        this.carAllowancePercentage = carAllowancePercentage;
    }

    public double calculateSalary() {
        double bonus = basicSalary * (bonusPercentage / 100);
        double carAllowance = basicSalary * (carAllowancePercentage / 100);
        return basicSalary + bonus + carAllowance;
    }

}

// OfficeStaff.java
public class OfficeStaff extends Faculty {
    private String designation;

    public OfficeStaff(String name, float basicSalary, String designation) {
        super(name, basicSalary);
        this.designation = designation;
    }

    // Getter for designation
    public String getDesignation() {
        return designation;
    }

    // Setter for designation
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public double calculateSalary() {
        double extraPay = 0.0;
        if(designation.equals("Accountant"))
                extraPay = 10000.0;
        else if(designation.equals("Clerk"))
                extraPay = 7000.0;
        else if(designation.equals("Peon"))
                extraPay = 4500.0;
        return super.calculateSalary() + extraPay;

    }
}

// Teacher.java
public class Teacher extends Faculty {
    private String qualification;

    public Teacher(String name, float basicSalary, String qualification) {
        super(name, basicSalary);
        this.qualification = qualification;
    }

    // Getter for qualification
    public String getQualification() {
        return qualification;
    }

    // Setter for qualification
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public double calculateSalary() {
        double extraPay = 0;
       
       if(qualification.equals("Doctoral"))
               extraPay = 20000.0;
        else if(qualification.equals("Masters"))
                extraPay = 18000.0;
        else if(qualification.equals("Bachelors"))
                extraPay = 15500.0;
         else if(qualification.equals("Associate"))
                extraPay = 10000.0;
       

        return super.calculateSalary() + extraPay;

    }
}

// Tester.java
public class Tester {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Caroline", 30500f, "Masters");
        OfficeStaff officeStaff = new OfficeStaff("James", 24000f, "Accountant");

        System.out.println("Teacher Details\n***************");
        System.out.println("Name: " + teacher.getName());
        System.out.println("Qualification: " + teacher.getQualification());
        System.out.println("Total salary: $" + Math.round(teacher.calculateSalary() * 100) / 100.0);
        System.out.println();

        System.out.println("Office Staff Details\n***************");
        System.out.println("Name: " + officeStaff.getName());
        System.out.println("Designation: " + officeStaff.getDesignation());
        System.out.println("Total salary: $" + Math.round(officeStaff.calculateSalary() * 100) / 100.0);

        // Create more objects for testing your code
        Teacher anotherTeacher = new Teacher("Alice", 29000f, "Doctoral");
        OfficeStaff anotherOfficeStaff = new OfficeStaff("Bob", 22000f, "Clerk");

        System.out.println("\nAnother Teacher Details\n***************");
        System.out.println("Name: " + anotherTeacher.getName());
        System.out.println("Qualification: " + anotherTeacher.getQualification());
        System.out.println("Total salary: $" + Math.round(anotherTeacher.calculateSalary() * 100) / 100.0);
        System.out.println();

        System.out.println("Another Office Staff Details\n***************");
        System.out.println("Name: " + anotherOfficeStaff.getName());
        System.out.println("Designation: " + anotherOfficeStaff.getDesignation());
        System.out.println("Total salary: $" + Math.round(anotherOfficeStaff.calculateSalary() * 100) / 100.0);
    }
}
