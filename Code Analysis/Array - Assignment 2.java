class Tester {
    
    public static double[] findDetails(double[] salary) {
        //Implement your code here and change the return value accordingly
         double total = 0;
        int count = salaries.length;
        
        // Calculate the total salary
        for (double salary : salaries) {
            total += salary;
        }
        
        // Calculate the average salary
        double averageSalary = total / count;
        
        int greaterCount = 0;
        int lesserCount = 0;
        
        // Count salaries greater and lesser than the average salary
        for (double salary : salaries) {
            if (salary > averageSalary) {
                greaterCount++;
            } else if (salary < averageSalary) {
                lesserCount++;
            }
        }
        
        // Create and return the result array
        return new double[] {averageSalary, greaterCount, lesserCount};

    }
       
    public static void main(String[] args) {
        double[] salary = { 23500.0, 25080.0, 28760.0, 22340.0, 19890.0 };
        double[] details = findDetails(salary);
              
        System.out.println("Average salary: "+ details[0]);
        System.out.println("Number of salaries greater than the average salary: "+ details[1]);
        System.out.println("Number of salaries lesser than the average salary: "+ details[2]);
    }
}
