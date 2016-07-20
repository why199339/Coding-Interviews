package q2;

public class EagerlyInstance {

	private static EagerlyInstance eagerlyInstance = new EagerlyInstance();
	
	private EagerlyInstance() {
		System.out.println("EagerlyInstance: " + System.currentTimeMillis());
	}
	
	public static EagerlyInstance getInstance() {
		return eagerlyInstance;
	}
}
