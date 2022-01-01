
public class ClassRoom {
	
	private String location;
	private int capacity;
	
	// Κατασκευαστής
	public ClassRoom(String location, int capacity) {
		this.location = location;
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}
	
	public String getLocation() {
		return location;
	}
	

}
