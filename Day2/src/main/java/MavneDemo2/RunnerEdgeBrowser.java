package MavneDemo2;

//By default every class inherit java.lang.object. example : tostring()

//We can inherit multiple interfaces. But we can't inherit multiple class.

//1 interface can inherit another interface also.

public class RunnerEdgeBrowser {

	public static void main(String[] args) {
	
		EdgeBrowser eb = new EdgeBrowser();
		
		eb.captureelement();
		eb.close();
		
		System.out.println(eb.toString());

	}

}
