
public class CarInfo {
    private String id;
    private boolean privateCar;
    private int speed;
    
    public boolean illegal(int maxSpeed) {
		if(this.privateCar || this.speed > maxSpeed) {
			return true;
		}
		return false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean getPrivateCar() {
		return privateCar;
	}

	public void setPrivateCar(boolean privateCar) {
		this.privateCar = privateCar;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public CarInfo(String id, boolean privateCar, int speed) {
		super();
		this.id = id;
		this.privateCar = privateCar;
		this.speed = speed;
	}
	
    
}

public class CameraInfo {
    private int city;
    private int maxSpeed;
    private CarInfo[] cars;


    public boolean allGood() {
		boolean flag = true;
		for(int i = 0; i < this.cars.length; i++) {
			if(this.cars[i].getSpeed() > this.maxSpeed || this.cars[i].getPrivateCar()) {
				flag = false;
				break;
			}
			else {
				flag = true;
				
			}
		}
		return flag;	
	}


	public int getCity() {
		return city;
	}


	public void setCity(int city) {
		this.city = city;
	}


	public int getMaxSpeed() {
		return maxSpeed;
	}


	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}


	public CarInfo[] getCars() {
		return cars;
	}


	public void setCars(CarInfo[] cars) {
		this.cars = cars;
	}


	public CameraInfo(int city, int maxSpeed, CarInfo[] cars) {
		super();
		this.city = city;
		this.maxSpeed = maxSpeed;
		this.cars = cars;
	}
}

public static int legalCities(CameraInfo[] cameras) {
    int countCities = 0;
    boolean[] countedCities = new boolean[100];

    for (CameraInfo camera : cameras) {
        int cityCode = camera.getCity();
        if (!countedCities[cityCode] && camera.allGood()) {
            countedCities[cityCode] = true;
            countCities++;
        }
    }

    return countCities;
}
