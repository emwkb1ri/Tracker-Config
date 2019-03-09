import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.Properties;

public class app1 {
	
	//public configuration variables
	public static String radio1ModelNumber;
	public static String radio1ModelName;
	public static String radio1PortName;
	public static String radio1Baudrate;
	public static String radio2ModelNumber;
	public static String radio2ModelName;
	public static String radio2PortName;
	public static String radio2Baudrate;
	public static String speAmpModelName;
	public static String speAmpPortName;
	public static String speAmpBaudrate;
	public static String broadcastList;
	public static String switch1IP;
	public static String switch2IP;
	public static String antLabelListR1;
	public static String antLabelListR2;
	public static String lastAntSelectR1;
	public static String lastAntSelectR2;
		

	public static void main(String[] args) {
		
		// Initialize program configuration information from config file
		String configFilename = "AntennaTrackerCopy.cfg"; 
		
		readConfigFile(configFilename);
		
		//verification using println
		
		System.out.println("********************");
		
		System.out.println("Radio1: " + radio1ModelNumber + "," + radio1ModelName + "," + radio1PortName + "," + radio1Baudrate);
		System.out.println("Radio2: " + radio2ModelNumber + "," + radio2ModelName + "," + radio2PortName + "," + radio2Baudrate);
		System.out.println("AMP: " + speAmpModelName + "," + speAmpPortName + "," + speAmpBaudrate);
		
		System.out.println("HostList: " + broadcastList);
		
		System.out.println("Switch #1 IP: " + switch1IP);
		System.out.println("Switch #2 IP: " + switch2IP);

		System.out.println("Radio 1 AntList: " + antLabelListR1);
		System.out.println("Radio 2 AntList: " + antLabelListR2);
		
		System.out.println("R1 Last = " + lastAntSelectR1);
		System.out.println("R2 Last = " + lastAntSelectR2);
		
		System.out.println("********************");
		
		Radio radio1 = new Radio(radio1ModelNumber, radio1ModelName, radio1PortName, radio1Baudrate);
		
		Radio radio2 = new Radio(radio2ModelNumber, radio2ModelName, radio2PortName, radio2Baudrate);
		
		Amp amp1 = new Amp(speAmpModelName, speAmpPortName, speAmpBaudrate);
		
		// simple test of the class/objects and their info method 
		radio1.printInfo();
		radio2.printInfo();
		amp1.printInfo();
		
		// write a copy of the configuration file as a test
		System.out.println("Writing copy of configuration file...");
		configFilename = "AntennaTrackerCopy.cfg"; 
		writeConfigFile(configFilename);
		System.out.println("Writing completed");
		
	}
	
	public static void readConfigFile(String file) {
	
		//This code sets up the File Reader Object and points to the config file.
		try(FileReader reader = new FileReader("C:\\Users\\ewpil\\iCloudDrive\\eclipse-workspace\\"+file)) {
			Properties properties = new Properties();
			properties.load(reader);
			
			//Strings to read from properties list (Remember case sensitive)

			radio1ModelNumber = properties.getProperty("radio1ModelNumber");
			radio1ModelName = properties.getProperty("radio1ModelName");
			radio1PortName = properties.getProperty("radio1PortName");
			radio1Baudrate = properties.getProperty("radio1Baudrate");
			
			radio2ModelNumber = properties.getProperty("radio2ModelNumber");
			radio2ModelName = properties.getProperty("radio2ModelName");
			radio2PortName = properties.getProperty("radio2PortName");
			radio2Baudrate = properties.getProperty("radio2Baudrate");
			
			speAmpModelName = properties.getProperty("speAmpModelName");
			speAmpPortName = properties.getProperty("speAmpPortName");
			speAmpBaudrate = properties.getProperty("speAmpBaudrate");
			
			broadcastList = properties.getProperty("broadcastList");
			
			switch1IP = properties.getProperty("switch1IP");
			switch2IP = properties.getProperty("switch2IP");
			
			antLabelListR1 = properties.getProperty("antLabelListR1");
			antLabelListR2 = properties.getProperty("antLabelListR2");
			
			lastAntSelectR1 = properties.getProperty("lastAntSelectR1");
			lastAntSelectR2 = properties.getProperty("lastAntSelectR2");
			
			
		} catch (Exception e) {
			;
			e.printStackTrace();
		}
	}
	
	public static void writeConfigFile(String file) {
		File fileInput = new File("C:\\Users\\ewpil\\iCloudDrive\\eclipse-workspace\\"+file);
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(fileInput);
			BufferedWriter bufferWrite = new BufferedWriter(fileWriter);
			bufferWrite.append("# java properties file for my AntennaTracker program project\r\n\r\n");
			bufferWrite.append("# Radio & accessory model information\r\n");
			bufferWrite.append("radio1ModelNumber=" + radio1ModelNumber + "\r\n");
			bufferWrite.append("radio1ModelNumber=" + radio1ModelName + "\r\n");
			bufferWrite.append("radio1PortName=" + radio1PortName + "\r\n");
			bufferWrite.append("radio1Baudrate=" + radio1Baudrate + "\r\n");
			bufferWrite.newLine();
			bufferWrite.append("radio2ModelNumber=" + radio2ModelNumber + "\r\n");
			bufferWrite.append("radio2ModelName=" + radio2ModelName + "\r\n");
			bufferWrite.append("radio2PortName=" + radio2PortName + "\r\n");
			bufferWrite.append("radio2Baudrate=" + radio2Baudrate + "\r\n");
			bufferWrite.newLine();
			bufferWrite.append("speAmpModelName=" + speAmpModelName + "\r\n");
			bufferWrite.append("speAmpPortName=" + speAmpPortName + "\r\n");
			bufferWrite.append("speAmpBaudrate=" + speAmpBaudrate + "\r\n");
			bufferWrite.newLine();
			bufferWrite.append("# broadcastList format \"Hostname:ip-address:port list(comma separated);\"\r\n" + 
					"#\r\n" + 
					"#     	12060 = N1MM+ default radio info port\r\n" + 
					"#   	13063 = WaterfallBandmap program instance 1 port\r\n" + 
					"#   	13065 = WaterfallBandmap program instance 2 port\r\n" + 
					"#\r\n");
			bufferWrite.append("broadcastList=" + broadcastList + "\r\n");
			bufferWrite.newLine();
			bufferWrite.append("# switchIP format \"ip-address\"\r\n");
			bufferWrite.append("switch1IP=" + switch1IP + "\r\n");
			bufferWrite.append("switch2IP=" + switch2IP + "\r\n");
			bufferWrite.newLine();
			bufferWrite.append("# antLabelList format \"relay number:ant label:band(comma separated);\" for each radio\r\n");
			bufferWrite.append("antLabelListR1=" + antLabelListR1 + "\r\n\r\n");
			bufferWrite.append("antLabelListR2=" + antLabelListR2 + "\r\n");
			bufferWrite.newLine();
			bufferWrite.append("# last saved antenna selection for each radio - default value is 0 \r\n");
			bufferWrite.append("lastAntSelectR1=" + lastAntSelectR1 + "\r\n");
			bufferWrite.append("lastAntSelectR2=" + lastAntSelectR2 + "\r\n");
			bufferWrite.newLine();
			
			// Flush the file write buffer and close the file		
			bufferWrite.flush();
			bufferWrite.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public static boolean backupConfigFile(String file) {
		boolean returnVal = false;
		// create a new config backup file if one doesn't exist
		
		// initialize File object
		File origFile = new File("C:\\Users\\ewpil\\iCloudDrive\\eclipse-workspace\\"+file);
		
		// check if file exists
		if(origFile.exists()) {
			// read the file
			readConfigFile(file);
		
			// now write a copy
			writeConfigFile(file+".bak");
		
			System.out.println("File backup complete");
			returnVal = true;
			return returnVal;
			
		} else {
			System.out.println("File does not exist");
		
			//if file doesn't exist create it
			// initialize the File object
			File newFile = new File("C:\\Users\\ewpil\\iCloudDrive\\eclipse-workspace\\"+file);
			
			boolean result;
			try {
				// create new empty file with default values
				result = newFile.createNewFile();
				
				// now write default values to the config file
				
				// APPENDS GO HERE!!!
				
				// test if successfully created a new file
				if(result) {
					returnVal = true;
					System.out.println("Successfully created " + newFile.getCanonicalFile());
				}
				else {
					System.out.println("Failed creating " + newFile.getCanonicalPath());		
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return returnVal;
		}
	}

}

