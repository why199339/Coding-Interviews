package q2;

public class LazyInstance_Synchronized {

	private static LazyInstance_Synchronized lazyInstance_Synchronized;
	
	private LazyInstance_Synchronized() {
		System.out.println("LazyInstance_Synchronized: " + System.currentTimeMillis());
	}
	
	public static synchronized LazyInstance_Synchronized getInstance() {
		
		if(lazyInstance_Synchronized == null) {
			lazyInstance_Synchronized = new LazyInstance_Synchronized();
		}
		
		return lazyInstance_Synchronized;
	}
}
