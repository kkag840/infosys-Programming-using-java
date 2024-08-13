class Circle{
    //Implement your code here
    private double diameter;
    private double circumference;
    private double area;
    private final double PI = 3.14;

    // Constructor to initialize the diameter
    public Circle(double diameter) {
        this.diameter = diameter;
    }

    public void calculateCircumference(){
        this.circumference=this.PI*this.diameter;
    }
    public void calculateArea(){
        this.area=this.PI*Math.pow(diameter/2,2);
    }

    // Getter for diameter
    public double getDiameter() {
        return diameter;
    }

    // Setter for diameter
    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    // Getter for circumference
    public double getCircumference() {
        return circumference;
    }

    // Setter for circumference
    public void setCircumference(double circumference) {
        this.circumference = circumference;
    }

    // Getter for area
    public double getArea() {
        return area;
    }

    // Setter for area
    public void setArea(double area) {
        this.area = area;
    }

    // Getter for PI
    public double getPI() {
        return PI;
    }
}

class Tester{
      
    public static void main(String[] args) {
            
        Circle circle1 = new Circle(10.2);
        Circle circle2 = new Circle(5.7);

        //Create more objects of Circle class and add to the array given below for testing your code    
        Circle[] circles = {circle1, circle2};
            
        for (Circle circle : circles) {
                  
            circle.calculateCircumference();
            circle.calculateArea();
                  
            System.out.println("Diameter of the circle is "+circle.getDiameter());
            System.out.println("Circumference of the circle is " + Math.round(circle.getCircumference()*100)/100.0);
            System.out.println("Area of the circle is " + Math.round(circle.getArea()*100)/100.0);
            System.out.println();
        }           
    }
}

