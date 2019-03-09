
public class Amp {
	
		// beginnings of a new Amp object
		// this object represents the CAT interface to an amplifier
		
		
		// may not need modelNumber and modelName here - original Radio object already checks this info
		private String modelName;
		private String comPort;
		private String baudRate;
		
		public Amp(String modelName, String comPort, String baudRate) {
			this.modelName = modelName;
			this.comPort = comPort;
			this.baudRate = baudRate;
		}

		public void printInfo() {
			System.out.println(modelName + "," + comPort + "-" + baudRate);
			//
		}
}
