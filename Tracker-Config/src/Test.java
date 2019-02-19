
public class Test {
	private String comPort;
	private String baudRate;
	
	public Test(String comPort, String baudRate) {
		this.comPort = comPort;
		this.baudRate = baudRate;
	}

	public void myMethod() {
		System.out.println(comPort);
		System.out.println(baudRate);
		//
	}
}
