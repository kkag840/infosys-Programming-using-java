import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
class Asset {
    private String assetId;
    private String assetName;
    private String assetExpiry;

    // Constructor
    public Asset(String assetId, String assetName, String assetExpiry) {
        this.assetId = assetId;
        this.assetName = assetName;
        this.assetExpiry = assetExpiry;
    }

    // Getters
    public String getAssetId() {
        return assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public String getAssetExpiry() {
        return assetExpiry;
    }

    // Setters
     public void setAssetId(String assetId) {
        if (isValidAssetId(assetId)) {
            this.assetId = assetId;
        } else {
            throw new IllegalArgumentException("Invalid asset ID format.");
        }
    }
    private boolean isValidAssetId(String assetId) {
        // Regular expression to match the required format
        String regex = "^(DSK|LTP|IPH)-\\d{6}[HLhl]$";
        return assetId.matches(regex);
    }
    
    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public void setAssetExpiry(String assetExpiry) {
        this.assetExpiry = assetExpiry;
    }

    // Uncomment the code given below after implementing the class
    // Do not modify the code given below
    @Override
    public String toString() {
        return "Asset Id: " + getAssetId() + ", Asset Name: " + getAssetName() + ", Asset Expiry: " + getAssetExpiry();
    }
}


class Resources {
	//Implement your code here
    public int getMonth(String month){
        int num=0;
        switch(month){
            case "Jan": num=1 ; break;
            case "Feb": num=2 ; break;
            case "Mar": num=3 ; break;
            case "Apr": num=4 ; break;
            case "May": num=5 ; break;
            case "Jun": num=6 ; break;
            case "Jul": num=7 ; break;
            case "Aug": num=8 ; break;
            case "Sep": num=9 ; break;
            case "Oct": num=10 ; break;
            case "Nov": num=11 ; break;
            case "Dec": num=12 ; break;
        }
        return num;
    }
    
}

class InvalidAssetsException extends Exception {
	//Implement your code here
     public InvalidAssetsException(String message){
         super(message);
     }
}

class InvalidExperienceException extends Exception {
	//Implement your code here
    public InvalidExperienceException(String message){
        super(message);
    }
}

abstract class Employee {
    private String employeeId;
    private String employeeName;
    private double salary;
    private static int contractIdCounter;
    private static int permanentIdCounter;
    static{
        contractIdCounter=10000;
        permanentIdCounter=10000;
    }
    public Employee(String employeeName){
        this.employeeName=employeeName;
        
        if (this instanceof PermanentEmployee) {
            permanentIdCounter++;
            this.employeeId = "E" + permanentIdCounter;
        } else {
            contractIdCounter++;
            this.employeeId = "C" + contractIdCounter;
        }
    }
    
    abstract public void calculateSalary(float salaryFactor);

    // Getters
    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public static int getContractIdCounter() {
        return contractIdCounter;
    }

    public static int getPermanentIdCounter() {
        return permanentIdCounter;
    }

    // Setters
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) throws InvalidAssetsException {
        if (isValidEmployeeName(employeeName)) {
            this.employeeName = employeeName;
        } else {
            throw new InvalidAssetsException("Invalid employee name format.");
        }
    }
    private boolean isValidEmployeeName(String employeeName) {
        // Regular expression to validate the employee name
        String regex = "^[A-Z][a-zA-Z]{1,}\\s[A-Z][a-zA-Z]{1,}(\\s[A-Z][a-zA-Z]{1,})*$";
        return employeeName.matches(regex);
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            this.salary = 0;
        }
    }

    public static void setContractIdCounter(int contractIdCounter) {
        Employee.contractIdCounter = contractIdCounter;
    }

    public static void setPermanentIdCounter(int permanentIdCounter) {
        Employee.permanentIdCounter = permanentIdCounter;
    }

    // Uncomment the code given below after implementing the class
    // Do not modify the code given below
    @Override
    public String toString() {
        return "Employee Id: " + getEmployeeId() + ", Employee Name: " + getEmployeeName();
    }
}


class ContractEmployee extends Employee {
    private double wagePerHour;

    // Constructor
    public ContractEmployee(String employeeName, double wagePerHour) {
        super(employeeName); // Invoke the base class constructor, marking as contract employee
        this.wagePerHour = wagePerHour;
    }

    // Getters
    public double getWagePerHour() {
        return wagePerHour;
    }

    // Setters
    public void setWagePerHour(double wagePerHour) {
        if (wagePerHour > 0) {
            this.wagePerHour = wagePerHour;
        } else {
            throw new IllegalArgumentException("Wage per hour must be greater than 0.");
        }
    }

    // Method to calculate salary
    public void calculateSalary(float hoursWorked) {
        double salary;
        if (hoursWorked >= 190) {
            salary = wagePerHour * hoursWorked;
        } else {
            double deduction = 0.5 * wagePerHour * (190 - hoursWorked);
            salary = (wagePerHour * hoursWorked) - deduction;
        }
        // Round the salary to the nearest integer
        salary = Math.round(salary);

        // Set the calculated salary using the setter from the base class
        setSalary(salary);
    }

    // Uncomment the code given below after implementing the class
    // Do not modify the code given below
    @Override
    public String toString() {
        return super.toString() + ", Wage Per Hour: " + getWagePerHour() + ", Salary: " + getSalary();
    }
}


class PermanentEmployee extends Employee{
	//Implement your code here
	private double basicPay;
    private String[] salaryComponents;
    private float experience;
    private Asset[] assets;

    // Constructor
    public PermanentEmployee(String employeeName, double basicPay, String[] salaryComponents, Asset[] assets) {
        super(employeeName);  // Invokes the base class constructor, marking as permanent employee
        this.basicPay = basicPay;
        this.salaryComponents = salaryComponents;
        this.assets = assets;
    }

    // Getters
    public double getBasicPay() {
        return basicPay;
    }

    public String[] getSalaryComponents() {
        return salaryComponents;
    }

    public float getExperience() {
        return experience;
    }

    public Asset[] getAssets() {
        return assets;
    }

    // Setters
    public void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }

    public void setSalaryComponents(String[] salaryComponents) {
        this.salaryComponents = salaryComponents;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public void setAssets(Asset[] assets) {
        this.assets = assets;
    }

    // Method to calculate bonus based on experience
    public double calculateBonus(float experience) throws InvalidExperienceException {
        if (experience < 2.5) {
            throw new InvalidExperienceException("A minimum of 2.5 years is required for bonus!");
        }

        if (experience>=2.5f&&experience<4f) {
            return  2550;  
        } else if (experience >=4f&&experience<8f) {
            return 5000;  
        } else if (experience >=8f&&experience<12f){
            return 8750;  
        }
        else
             return 13000;
    }

    // Method to calculate salary based on experience and salary components
    public void calculateSalary(float experience) {
        try {
            this.experience = experience;
            double bonus = calculateBonus(experience);

            double daComponent = 0;
            double hraComponent = 0;

            for (String component : salaryComponents) {
                if (component.startsWith("DA-")) {
                    daComponent = Double.parseDouble(component.split("-")[1]) / 100.0 * basicPay;
                } else if (component.startsWith("HRA-")) {
                    hraComponent = Double.parseDouble(component.split("-")[1]) / 100.0 * basicPay;
                }
            }

            double salary = basicPay + daComponent + hraComponent + bonus;
            salary = Math.round(salary);  // Round to the nearest integer
            setSalary(salary);  // Set the calculated salary

        } catch (InvalidExperienceException e) {
            setSalary(Math.round(basicPay));  // If experience is invalid, salary is basic pay
        }
    }

    // Method to get assets by date
    public Asset[] getAssetsByDate(String lastDate) throws InvalidAssetsException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd");
        Date expiryDate;
        try {
            expiryDate = dateFormat.parse(lastDate);
        } catch (ParseException e) {
            throw new InvalidAssetsException("Invalid date format!");
        }

        Asset[] filteredAssets = java.util.Arrays.stream(assets)
            .filter(asset -> {
                try {
                    return dateFormat.parse(asset.getAssetExpiry()).compareTo(expiryDate) <= 0;
                } catch (ParseException e) {
                    return false;
                }
            })
            .toArray(Asset[]::new);

        if (filteredAssets.length == 0) {
            throw new InvalidAssetsException("No assets found for the given criteria!");
        }

        return filteredAssets;
    }

	
	//Uncomment the code given below after implementing the class
	//Do not modify the code given below
	@Override
	public String toString() {
		return "Employee Id: "+getEmployeeId()+", Employee Name: "+getEmployeeName()+", Basic Pay: "+getBasicPay()+", Salary Components: "+getSalaryComponents()+", Assets: "+getAssets();
	}
}

class Admin {

    // Method to generate salary slips
    public void generateSalarySlip(Employee[] employees, float[] salaryFactor) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee instanceof PermanentEmployee) {
                ((PermanentEmployee) employee).calculateSalary(salaryFactor[i]);
            } else if (employee instanceof ContractEmployee) {
                ((ContractEmployee) employee).calculateSalary(salaryFactor[i]);
            }
            // Salary slip generation logic can be added here
            // For now, we just calculate the salary
        }
    }

    // Method to generate assets report based on expiry date
    public int generateAssetsReport(Employee[] employees, String lastDate) {
        int totalAssets = 0;

        for (Employee employee : employees) {
            if(employee instanceof PermanentEmployee) {
                try {
                    Asset[] assets = ((PermanentEmployee) employee).getAssetsByDate(lastDate);
                    totalAssets += assets.length;
                } catch (InvalidAssetsException e) {
                    return -1;
                }
            }
        }

        return totalAssets;
    }

    // Method to generate assets report based on asset category
    public String[] generateAssetsReport(Employee[] employees, char assetCategory) {
        String assetCategoryUpper = String.valueOf(assetCategory).toUpperCase();
        int resultLength = employees.length * 3;
        String[] result = new String[resultLength];
        int index = 0;

        for (Employee employee : employees) {
            if (employee instanceof PermanentEmployee) {
                Asset[] assets = ((PermanentEmployee) employee).getAssets();
                for (Asset asset : assets) {
                    if (asset.getAssetId().toUpperCase().startsWith(assetCategoryUpper)) {
                        if (index < resultLength) {
                            result[index++] = asset.getAssetId();
                        }
                    }
                }
            }
        }

        // If fewer assets are found than expected, return only the populated portion of the array
        if (index < resultLength) {
            String[] trimmedResult = new String[index];
            System.arraycopy(result, 0, trimmedResult, 0, index);
            return trimmedResult;
        }

        return result;
    }
}


class Tester{
    public static void main(String[] args) {
    	Admin admin = new Admin();
    	
    	Asset asset1 = null;
    	Asset asset2 = null;
    	Asset asset3 = null;
    	Asset asset4 = null;
    	Asset asset5 = null;
    	Asset asset6 = null;
    	Asset asset7 = null;
    	Asset asset8 = null;
    	Asset asset9 = null;
    	Asset asset10 = null;
    	
    	PermanentEmployee permanentEmployee1 = null;
    	PermanentEmployee permanentEmployee2 = null;
    	PermanentEmployee permanentEmployee3 = null;
    	PermanentEmployee permanentEmployee4 = null;
    	PermanentEmployee permanentEmployee5 = null;
		
		ContractEmployee contractEmployee1 = null;
		ContractEmployee contractEmployee2 = null;
		
		Employee[] employees = null;
		float[] salaryFactor = null;
		
		try {
			asset1 = new Asset("DSK-876761L", "Dell-Desktop", "2020-Dec-01");
	    	asset2 = new Asset("DSK-876762L", "Acer-Desktop", "2021-Mar-31");
	    	asset3 = new Asset("DSK-876763L", "Dell-Desktop", "2022-Jun-12");
	    	asset4 = new Asset("LTP-987123H", "Dell-Laptop", "2021-Dec-31");
	    	asset5 = new Asset("LTP-987124h", "Dell-Laptop", "2021-Sep-20");
	    	asset6 = new Asset("LTP-987125L", "HP-Laptop", "2022-Oct-25");
	    	asset7 = new Asset("LTP-987126l", "HP-Laptop", "2021-Oct-02");
	    	asset8 = new Asset("IPH-110110h", "VoIP", "2021-Dec-12");
	    	asset9 = new Asset("IPH-1101201h", "VoIP", "2020-Dec-31");
	    	asset10 = new Asset("IPH-110130h", "VoIP", "2020-Nov-30");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Details of all available assets");
		System.out.println();
		
		try {
			Asset[] assets = { asset1, asset2, asset3, asset4, asset5, asset6, asset7, asset8, asset9, asset10 };
			int counter = 1;
			for (Asset asset : assets) {
				System.out.println("Details of asset"+counter++);
				System.out.println("\tAsset Id: "+asset.getAssetId());
				System.out.println("\tAsset Name: "+asset.getAssetName());
				System.out.println("\tAsset Valid Till: "+asset.getAssetExpiry());
				System.out.println();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Correcting all the invalid assetIds");
		System.out.println();
		
		try {
			asset9.setAssetId("IPH-110120h");
			System.out.println("Details of asset9");
			System.out.println("\tAsset Id: "+asset9.getAssetId());
			System.out.println("\tAsset Name: "+asset9.getAssetName());
			System.out.println("\tAsset Valid Till: "+asset9.getAssetExpiry());
			System.out.println();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			permanentEmployee1 = new PermanentEmployee("Roger Fed", 15500.0, new String[] {"DA-50","HRA-40"}, new Asset[] {asset1, asset10});
			permanentEmployee2 = new PermanentEmployee("Serena W", 14000.0, new String[] {"DA-40","HRA-40"}, new Asset[] {asset6, asset9});
			permanentEmployee3 = new PermanentEmployee("James Peter", 18500.0, new String[] {"DA-50","HRA-45"}, new Asset[] {asset4});
			permanentEmployee4 = new PermanentEmployee("Catherine Maria", 20000.0, new String[] {"DA-50","HRA-45"}, new Asset[] {asset2, asset5});
			permanentEmployee5 = new PermanentEmployee("Jobin Nick", 21000.0, new String[] {"DA-50","HRA-50"}, null);

			contractEmployee1 = new ContractEmployee("Rafael N", 70);			
			contractEmployee2 = new ContractEmployee("Ricky Neol", 72.5);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println();
		System.out.println("Initiating salary calculation...");
		
		try {
			employees = new Employee[] { permanentEmployee1, permanentEmployee2, permanentEmployee3, permanentEmployee4, permanentEmployee5,
					contractEmployee1, contractEmployee2 };
			salaryFactor = new float[] { 3.9f, 2.3f, 4f, 8.1f, 12.5f, 189, 211 };
			
			admin.generateSalarySlip(employees, salaryFactor);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		permanentEmployee5.setSalary(-1);
		
		System.out.println();
		System.out.println("Details of employees");
		System.out.println();
		
		try {
			int pCounter = 1, cCounter = 1;
			for (Employee employee : employees) {
				if (employee instanceof PermanentEmployee) {
					PermanentEmployee permanentEmployee = (PermanentEmployee) employee;
					System.out.println("Details of permanentEmployee"+pCounter++);
					System.out.println("\tEmployee Id: "+permanentEmployee.getEmployeeId());
					System.out.println("\tEmployee Name: "+permanentEmployee.getEmployeeName());
					System.out.println("\tSalary: "+permanentEmployee.getSalary());	
					System.out.println("\tExperience: "+permanentEmployee.getExperience());	
					System.out.print("\tAssets Allocated: ");
					if (permanentEmployee.getAssets() != null) {
						for (Asset asset : permanentEmployee.getAssets()) {
							System.out.print(asset.getAssetId()+" ");
						}
						System.out.println();
					}
					else
						System.out.println("No assets allocated!");
				}
				else {
					System.out.println("Details of contractEmployee"+cCounter++);
					System.out.println("\tEmployee Id: "+employee.getEmployeeId());
					System.out.println("\tEmployee Name: "+employee.getEmployeeName());
					System.out.println("\tSalary: "+employee.getSalary());
				}
				System.out.println();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println();	
		System.out.println("Reports");
		System.out.println();
		
		try {
			
			employees = new Employee[] { permanentEmployee1, permanentEmployee2, permanentEmployee3, permanentEmployee4,
					contractEmployee1, contractEmployee2 };
			
			int assetCount = admin.generateAssetsReport(employees, "2021-Dec-31");
			if (assetCount >= 0)
				System.out.println("Number of allocated assets expiring on or before 2021-Dec-31: "+assetCount);
			else
				System.out.println("Sorry, report cannot be generated!");
			
			System.out.println();
			
			assetCount = admin.generateAssetsReport(employees, "2020-Sep-30");
			if (assetCount >= 0)
				System.out.println("Number of allocated assets expiring on or before 2020-Sep-30: "+assetCount);
			else
				System.out.println("Sorry, report cannot be generated!");
						
			System.out.println();
			
			
			String[] desktopAssetIds = admin.generateAssetsReport(employees, 'D');

			System.out.println("All the allocated desktop assets");
			for (String assetId : desktopAssetIds) {
				if (assetId != null)
					System.out.println("\t"+assetId);
			}
			
			System.out.println();
			
			String[] laptopAssetIds = admin.generateAssetsReport(employees, 'L');
			
			System.out.println("All the allocated laptop assets");
			for (String assetId : laptopAssetIds) {
				if (assetId != null)
					System.out.println("\t"+assetId);
			}
			
			System.out.println();
			
		
			String[] voipAssetIds = admin.generateAssetsReport(employees, 'i');
			
			System.out.println("All the allocated VoIP assets");
			for (String assetId : voipAssetIds) {
				if (assetId != null)
					System.out.println("\t"+assetId);
			}
			
			System.out.println();
					
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
    }
}