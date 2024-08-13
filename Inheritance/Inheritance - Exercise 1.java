class Camera {
	private String brand;
	private double cost;

	public Camera() {
		this.brand = "Nikon";
	}
	public Camera(String brand, double cost) {
        this.brand = brand;
        this.cost = cost;
    }
    
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
}

class DigitalCamera extends Camera {
	private int memory;

	public DigitalCamera(String brand, double cost) {
	    super(brand,cost);
		this.memory = 16;
	}
    
    public int getMemory() {
		return memory;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}
	public DigitalCamera(String brand, double cost, int memory) {
        super(brand, cost); // Call the constructor of the superclass (Camera) to initialize brand and cost
        this.memory = memory;
    }

    // Method to set the brand using a parameterized constructor
    public void digitalCameraParameterizedConstructorBrand(String brand) {
        setBrand(brand); // Call the setter method to set the brand
    }

    // Method to set the cost using a parameterized constructor
    public void digitalCameraParameterizedConstructorCost(double cost) {
        setCost(cost); // Call the setter method to set the cost
    }
}

class Tester {
	public static void main(String[] args) {
        DigitalCamera camera = new DigitalCamera("Canon",100);
        System.out.println(camera.getBrand()+" "+camera.getCost()+" "+camera.getMemory());
    }
}