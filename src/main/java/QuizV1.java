
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
	
	
}

public class CameraInfo{
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
}



public static int legalCities(CameraInfo[] cameras) {
	int countCities = 0;
	for(int i = 0;i < cameras.length; i++) {
		if(cameras[i].allGood()) {
			countCities++;
		}
	}
	return "The amount of cars that have passed the camera check are " + countCities;
	}
}