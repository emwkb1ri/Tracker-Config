
public class Amp {
	
		// beginnings of a new Amp object
		// this object represents the CAT interface to an amplifier
		
		
		// may not need modelNumber and modelName here - original Radio object already checks this info
		private String modelName;
		private String comPort;
		private String baudRate;
		private String catPort1;
		private String catBaud1;
		private String catPort2;
		private String catBaud2;
		
		public Amp(String modelName, String comPort, String baudRate, String catPort1, String catBaud1, String catPort2, String catBaud2) {
			this.modelName = modelName;
			this.comPort = comPort;
			this.baudRate = baudRate;
			this.catPort1 = catPort1;
			this.catBaud1 = catBaud1;
			this.catPort2 = catPort2;
			this.catBaud2 = catBaud2;
		}

		public void printInfo() {
			System.out.println(modelName + "," + comPort + "," + baudRate);
			System.out.println(modelName + "," + catPort1 + "," + catBaud1);
			System.out.println(modelName + "," + catPort2 + "," + catBaud2);
			//
		}
}
