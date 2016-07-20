package q2;

public class LazyInstance_DoubleCheckedLocking {

	private static LazyInstance_DoubleCheckedLocking  lazyInstance_DoubleCheckedLocking;
	
	private LazyInstance_DoubleCheckedLocking() {
		System.out.println("LazyInstance_DoubleCheckedLocking: " + System.currentTimeMillis());
	}
	
	public static LazyInstance_DoubleCheckedLocking getInstance() {
		
		if(lazyInstance_DoubleCheckedLocking == null) {
			synchronized (LazyInstance_DoubleCheckedLocking.class) {
				if(lazyInstance_DoubleCheckedLocking == null) {
					lazyInstance_DoubleCheckedLocking = new LazyInstance_DoubleCheckedLocking();
				}
			}
		}
		
		return lazyInstance_DoubleCheckedLocking;
	}
	
}
