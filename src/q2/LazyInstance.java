package q2;

public class LazyInstance {

	private static LazyInstance lazyInstance;
	
	private LazyInstance() {
		System.out.println("LazyInstance: " + System.currentTimeMillis());
	}
	
	public static LazyInstance getInstance() {
		
		if(lazyInstance == null) {
			lazyInstance = new LazyInstance();
		}
		
		return lazyInstance;
	}
}
