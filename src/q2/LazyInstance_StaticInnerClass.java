package q2;

public class LazyInstance_StaticInnerClass {

	private static class LazyInner {
		private static final LazyInstance_StaticInnerClass INSTANCE = new LazyInstance_StaticInnerClass();
	}
	
	private LazyInstance_StaticInnerClass() {
		
	}
	
	public static final LazyInstance_StaticInnerClass getInstance() {
		return LazyInner.INSTANCE;
	}
	
}
