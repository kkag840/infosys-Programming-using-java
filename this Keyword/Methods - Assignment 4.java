class Rectangle {
    //Implement your code here  
    public float length;
    public float width;
    public double calculateArea(){
        return Math.round(length*width*100.0)/100.0;
    }
    public double calculatePerimeter(){
        return Math.round(2*(length+width)*100.0)/100.0;
    }
}

class Tester {

	public static void main(String args[]) {
		
		Rectangle rectangle=new Rectangle();
		//Assign values to the member variables of Rectangle class
         rectangle.length=12f;
         rectangle.width=5f;
		//Invoke the methods of the Rectangle class to calculate the area and perimeter
		  double Area=rectangele.calculateArea();
		  double Perimeter=rectangele.calculatePerimeter();
		//Display the area and perimeter using the lines given below
		System.out.println("Area of the rectangle is "+Area);
		System.out.println("Perimeter of the rectangle is "+Perimeter);
	}

}