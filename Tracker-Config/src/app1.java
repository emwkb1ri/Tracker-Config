import java.io.File;

public class app1 {
		

	public static void main(String[] args) {
		
		// get the execution path to locate the desired configuration file
		String configPath = getPath();  
		
		// Initialize program configuration information from configuration file
		String configFilename = "AntennaTracker.cfg"; 
		String configFile = configPath.concat(configFilename);
		
		// Initialize the configuration file information
		ConfigFile config = new ConfigFile(configPath);
		
		//verification using println
		
		System.out.println("********************");
		
		System.out.println("Radio1: " + config.radio1ModelNumber + "," + config.radio1ModelName + "," + config.radio1PortName + "," + config.radio1Baudrate);
		System.out.println("Radio2: " + config.radio2ModelNumber + "," + config.radio2ModelName + "," + config.radio2PortName + "," + config.radio2Baudrate);
		System.out.print("AMP: " + config.speAmpModelName + "," + config.speAmpPortName + "," + config.speAmpBaudrate);
		System.out.print("," + config.speAmpCATPort1 + "," + config.speAmpCATBaudrate1);
		System.out.println("," + config.speAmpCATPort2 + "," + config.speAmpCATBaudrate2);
		
		System.out.println("HostList: " + config.broadcastList);
		
		System.out.println("Switch #1 IP: " + config.switch1IP);
		System.out.println("Switch #2 IP: " + config.switch2IP);

		System.out.println("Radio 1 AntList: " + config.antLabelListR1);
		System.out.println("Radio 2 AntList: " + config.antLabelListR2);
		
		System.out.println("R1 Last = " + config.lastAntSelectR1);
		System.out.println("R2 Last = " + config.lastAntSelectR2);
		
		System.out.println("********************");
		
		Radio radio1 = new Radio(config.radio1ModelNumber, config.radio1ModelName, config.radio1PortName, config.radio1Baudrate);
		
		Radio radio2 = new Radio(config.radio2ModelNumber, config.radio2ModelName, config.radio2PortName, config.radio2Baudrate);
		
		Amp amp1 = new Amp(config.speAmpModelName, config.speAmpPortName, config.speAmpBaudrate, config.speAmpCATPort1, config.speAmpCATBaudrate1, config.speAmpCATPort2, config.speAmpCATBaudrate2);
		
		// simple test of the class/objects and their info method 
		radio1.printInfo();
		radio2.printInfo();
		amp1.printInfo();
		
		// update the last antenna select variables to check backup & write functions
		
		config.lastAntSelectR1 = randNum();
		System.out.println("Ant R1: " + config.lastAntSelectR1);
		config.lastAntSelectR2 = randNum();
		System.out.println("Ant R2: " + config.lastAntSelectR2);
		
		// backup configuration file
		System.out.println("Backing up configuration file...");
		configFile = configPath.concat(configFilename); 
		config.backupConfigFile(configFile);
		
		// write a copy of the configuration file as a test
		System.out.println("Writing copy of configuration file...");
		configFile = configPath.concat(configFilename); 
		config.writeConfigFile(configFile);
		System.out.println("Writing completed");
		
	}
		
	public static String getPath() {
		
		String surroundingJar = null;

		// gets the path to the jar file if it exists; or the "bin" directory if calling from Eclipse
		String jarDir = new File(ClassLoader.getSystemClassLoader().getResource(".").getPath()).getAbsolutePath();
		System.out.println("JAR Directory: " + jarDir);
		
		// gets the "bin" directory if calling from eclipse or the name of the .jar file alone (without its path)
		String jarFileFromSys = System.getProperty("java.class.path").split(";")[0];

		// If both are equal that means it is running from an IDE like Eclipse
		if (jarFileFromSys.equals(jarDir))
		{
		    System.out.println("RUNNING FROM IDE!");
		    // The path to the jar is the "bin" directory in that case because there is no actual .jar file.
		    surroundingJar = jarDir;
		    
		    // use this fixed path to configuration when executing in an IDE
		    jarDir = "C:\\Users\\ewpil\\iCloudDrive\\eclipse-workspace\\";
		}
		else
		{
		    // Combining the path and the name of the .jar file to achieve the final result
			jarDir = jarDir + "\\";
			surroundingJar = jarDir + jarFileFromSys;
		}

		System.out.println("JAR File: " + surroundingJar);
		System.out.println("JAR from Sys: " + jarFileFromSys);
		System.out.println("jarDir: " + jarDir);
		
		return jarDir; 
	}
	
	public static String randNum() {
		
		// Generate a random number between 0 and 8
		
		int y = 0;
				
		double f = Math.random()/Math.nextDown(1.0);
		double x = 1 * (1.0 - f) + 10 * f;
		y = (int)x;
		
		y = y - 1; // make the random number between 0 and 8
		System.out.println("Random Integer:" + y);
				
		String randNum = String.valueOf(y);
				
		return randNum;
	}
}

