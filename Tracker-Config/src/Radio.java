public class Radio {
	
	// beginnings of a new Radio object
	// need to migrate the Radio object from the radioanttracker repository
	
	
	// may not need modelNumber and modelName here - original Radio object already checks this info
	private String modelNumber;
	private String modelName;
	private String comPort;
	private String baudRate;
	
	public Radio(String modelNumber, String modelName, String comPort, String baudRate) {
		this.modelNumber = modelNumber;
		this.modelName = modelName;
		this.comPort = comPort;
		this.baudRate = baudRate;
	}

	public void printInfo() {
		System.out.println(modelNumber + "," + modelName + "," + comPort + "-" + baudRate);
		//
	}
}
