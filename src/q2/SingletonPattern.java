package q2;

public class SingletonPattern {

	public static void main(String[] args) {
		
		for (int i = 0; i < 2; i++) {
			LazyInstance lazyInstance = LazyInstance.getInstance();
			LazyInstance_Synchronized lazyInstance_Synchronized = LazyInstance_Synchronized.getInstance();
			EagerlyInstance eagerlyInstance = EagerlyInstance.getInstance();
			LazyInstance_DoubleCheckedLocking lazyInstance_DoubleCheckedLocking = LazyInstance_DoubleCheckedLocking.getInstance();
			LazyInstance_StaticInnerClass lazyInstance_StaticInnerClass = LazyInstance_StaticInnerClass.getInstance();
			System.out.println();
		}
		
	}

}
