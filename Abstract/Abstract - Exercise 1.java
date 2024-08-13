abstract class Student{
    //Implement your code here
    private String studentName;
    private int[] testScores;
    private String testResult;
    public Student(String studentName){
        this.studentName=studentName;
        this.testScores=new int[4];
    }
    
    // Getter for studentName
    public String getStudentName() {
        return studentName;
    }

    // Setter for studentName
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    // Getter for testScores
    public int[] getTestScores() {
        return testScores;
    }

    // Setter for testScores
    public void setTestScore(int testNumber,int testScore) {
        this.testScores[testNumber] = testScore;
    }

    // Getter for testResult
    public String getTestResult() {
        return testResult;
    }

    // Setter for testResult
    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
    
    public abstract void generateResult();
}

class UndergraduateStudent extends Student{
    //Implment your code here
    public UndergraduateStudent(String studentName){
        super(studentName);
    }
    public void generateResult(){
        int[] testScores=new int[4];
        int sum=0,avg;
        testScores=getTestScores();
        for(int score:testScores)
          sum+=score;
        avg=sum/testScores.length;
        if(avg>=60)
         setTestResult("Pass");
        else
         setTestResult("Fail");
    }
}

class GraduateStudent extends Student{
    //Implment your code here
    public GraduateStudent(String studentName){
        super(studentName);
    }
     public void generateResult(){
        int[] testScores=new int[4];
        int sum=0,avg;
        testScores=getTestScores();
        for(int score:testScores)
          sum+=score;
        avg=sum/testScores.length;
        if(avg>=70)
         setTestResult("Pass");
        else
         setTestResult("Fail");
    }
}

class Tester {

    public static void main(String[] args) {
        UndergraduateStudent undergraduateStudent = new UndergraduateStudent("Philip");
        undergraduateStudent.setTestScore(0, 70);
        undergraduateStudent.setTestScore(1, 69);
        undergraduateStudent.setTestScore(2, 71);
        undergraduateStudent.setTestScore(3, 55);
            
        undergraduateStudent.generateResult();
            
        System.out.println("Student name: "+undergraduateStudent.getStudentName());
        System.out.println("Result: "+undergraduateStudent.getTestResult());
            
        System.out.println();
            
        GraduateStudent graduateStudent = new GraduateStudent("Jerry");
        graduateStudent.setTestScore(0, 70);
        graduateStudent.setTestScore(1, 69);
        graduateStudent.setTestScore(2, 71);
        graduateStudent.setTestScore(3, 55);
            
        graduateStudent.generateResult();
            
        System.out.println("Student name: "+graduateStudent.getStudentName());
        System.out.println("Result : "+graduateStudent.getTestResult());
        
        //Create more objects of the classes for testing your code
    }
}
