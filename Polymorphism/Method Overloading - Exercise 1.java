class Point {
    //Implement your code here
    private double xCoordinate;
    private double yCoordinate;

    public Point(double xCoordinate, double yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public double calculateDistance() {
        return Math.round(Math.sqrt(Math.pow(xCoordinate, 2) + Math.pow(yCoordinate, 2)) * 100.0) / 100.0;
    }

    public double calculateDistance(Point point) {
        double xDiff = xCoordinate - point.getxCoordinate();
        double yDiff = yCoordinate - point.getyCoordinate();
        return Math.round(Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2)) * 100.0) / 100.0;
    }
}


class Tester {

	public static void main(String[] args) {
		Point point1 = new Point(3.5, 1.5);
        Point point2 = new Point(6, 4);
                                
        System.out.println("Distance of point1 from origin is "+point1.calculateDistance());
        System.out.println("Distance of point2 from origin is "+point2.calculateDistance());
        System.out.println("Distance of point1 from point2 is "+point1.calculateDistance(point2));
        
        //Create more objects for testing your code                

	}
}
