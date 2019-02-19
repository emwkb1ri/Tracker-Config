import java.io.FileReader;
import java.util.Properties;

public class app1 {

	public static void main(String[] args) {
		//This code sets up the File Reader Object and points to the config file.
		try(FileReader reader = new FileReader("C:\\Users\\ewpil\\iCloudDrive\\eclipse-workspace\\Tracker-Config\\bin\\AntennaTracker.cfg")) {
			Properties properties = new Properties();
			properties.load(reader);
			
			//Strings to read from properties list (Remember case sensitive)

			String radio1PortName = properties.getProperty("radio1PortName");
			String radio1Baudrate = properties.getProperty("radio1Baudrate");
			
			String radio2PortName = properties.getProperty("radio2PortName");
			String radio2Baudrate = properties.getProperty("radio2Baudrate");
			
			String speAmpPortName = properties.getProperty("speAmpPortName");
			String speAmpBaudrate = properties.getProperty("speAmpBaudrate");
			
			String hostList = properties.getProperty("hostList");
			
			String antLabelList = properties.getProperty("antLabelList");
			
					
			//
			//verification using println
			
			System.out.println("Radio1: " + radio1PortName + "," + radio1Baudrate);
			System.out.println("Radio2: " + radio2PortName + "," + radio2Baudrate);
			System.out.println("SPE AMP: " + speAmpPortName + "," + speAmpBaudrate);
			
			System.out.println("HostList: " + hostList);

			System.out.println("AntList: " + antLabelList);
			
			//System.out.println("Host1: " + host1name + " " + host1ip + ":" + host1ports);
			//System.out.println("Host2: " + host2name + " " + host2ip + ":" + host2ports);		
			
		} catch (Exception e) {
			;
			e.printStackTrace();
		}
	}

}
