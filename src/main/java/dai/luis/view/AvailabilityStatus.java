package dai.luis.view;

import java.io.Serializable;

public class AvailabilityStatus implements Serializable{
	private boolean availability;

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
}
