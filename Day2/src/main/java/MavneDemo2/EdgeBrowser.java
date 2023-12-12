package MavneDemo2;

// By default every class inherit java.lang.object

// We can inherit multiple interfaces. But we can't inherit multiple class.

// 1 interface can inherit another interface also.

public class EdgeBrowser implements IBrowser, IScreenshot {

	public String browserVersion = "9.0V";
	
	@Override
	public String toString() {
		return "EdgeBrowser [browserVersion=" + browserVersion + "]";
	}

	@Override
	public void captureelement() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void capturefullscreen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void minimize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void maximize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}
	
	

}
