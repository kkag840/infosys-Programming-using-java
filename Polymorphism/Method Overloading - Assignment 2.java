public class Point {
    private double xCoordinate;
    private double yCoordinate;

    // Constructor to initialize coordinates
    public Point(double xCoordinate, double yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    // Getter for xCoordinate
    public double getxCoordinate() {
        return xCoordinate;
    }

    // Setter for xCoordinate
    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    // Getter for yCoordinate
    public double getyCoordinate() {
        return yCoordinate;
    }

    // Setter for yCoordinate
    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    // Method to calculate distance from origin (0, 0)
    public double calculateDistance() {
        return Math.round(Math.sqrt(xCoordinate * xCoordinate + yCoordinate * yCoordinate)*100.0)/100.0;
    }

    // Method to calculate distance from another point
    public double calculateDistance(Point point) {
        return Math.round(Math.sqrt(Math.pow(point.getxCoordinate() - this.xCoordinate, 2) +
                         Math.pow(point.getyCoordinate() - this.yCoordinate, 2))*100.0)/100.0;
    }

    // Overriding toString() method to return the coordinates as a string
    @Override
    public String toString() {
        return "(" + xCoordinate + ", " + yCoordinate + ")";
    }
}


public class Triangle {
    private Point point1;
    private Point point2;
    private Point point3;

    // Default constructor
    public Triangle() {
        this.point1 = new Point(0, 0);
        this.point2 = new Point(1, 1);
        this.point3 = new Point(2, 5);
    }

    // Parameterized constructor with coordinates
    public Triangle(double point1XCoordinate, double point1YCoordinate, double point2XCoordinate, double point2YCoordinate, double point3XCoordinate, double point3YCoordinate) {
        this.point1 = new Point(point1XCoordinate, point1YCoordinate);
        this.point2 = new Point(point2XCoordinate, point2YCoordinate);
        this.point3 = new Point(point3XCoordinate, point3YCoordinate);
    }

    // Parameterized constructor with Point objects
    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    // Calculate perimeter of the triangle
    public double calculatePerimeter() {
        double a = point1.calculateDistance(point2);
        double b = point2.calculateDistance(point3);
        double c = point3.calculateDistance(point1);
        double perimeter = a + b + c;
        return Math.round(perimeter * 100.0) / 100.0;
    }

    // Calculate area of the triangle using Heron's formula
    public double calculateArea() {
        double a = point1.calculateDistance(point2);
        double b = point2.calculateDistance(point3);
        double c = point3.calculateDistance(point1);
        double s = (a + b + c) / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        return Math.round(area * 100.0) / 100.0;
    }

    // Getters and setters for point1
    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    // Getters and setters for point2
    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    // Getters and setters for point3
    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }

}



class Tester {

	public static void main(String[] args) {
		Triangle triangle1 = new Triangle();
		Triangle triangle2 = new Triangle(1, 2, 6, 5, 5, 1);
		
		Point point1 = new Point(2, 1);
		Point point2 = new Point(4, 4);
		Point point3 = new Point(9, 1);
		Triangle triangle3 = new Triangle(point1, point2, point3);		
		
		System.out.println("Perimeter of triangle1 is "+triangle1.calculatePerimeter());
		System.out.println("Area of triangle1 is "+triangle1.calculateArea());
		
		System.out.println("Perimeter of triangle2 is "+triangle2.calculatePerimeter());
		System.out.println("Area of triangle2 is "+triangle2.calculateArea());
		
		System.out.println("Perimeter of triangle3 is "+triangle3.calculatePerimeter());
		System.out.println("Area of triangle3 is "+triangle3.calculateArea());
		
		//Create more objects of Triangle class for testing your code      

	}
}

