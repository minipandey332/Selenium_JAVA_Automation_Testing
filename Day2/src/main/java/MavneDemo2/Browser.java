package MavneDemo2;

public abstract class Browser {

	// not 100% abstraction level achieve. As we have non-abstract method display()
	// We can achieve 100% abstraction level via : Interface
	
	abstract public void open();
	
	abstract public void close();
	
	void display() {
		System.out.println("Display Method");
	}
	
}
