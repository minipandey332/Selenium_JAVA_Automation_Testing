package MavneDemo2;

public class FirefoxBrowser extends Browser {

	@Override
	public void open() {
		System.out.println("Override open method");
		
	}

	@Override
	public void close() {
		System.out.println("Override close method");
		
	}

	public void display() {
		System.out.println("Child class implement");
	}
}
