package MavneDemo2;

public class RunnerAbstract {

	public static void main(String[] args) {
		//Browser b = new Browser(); // Can't instantiate as this is abstract class
		
		FirefoxBrowser fb = new FirefoxBrowser();
		
		fb.display();
		fb.close();
		
		
	}

}
