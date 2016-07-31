package q11;

public class Power {

	public static void main(String[] args) {
		System.out.println(power_bad(2, 3));
		System.out.println(power_bad(0, -1)); // wrong
		System.out.println(power_bad(2, -2)); // wrong
		System.out.println(power_middle(2, 3));
		System.out.println(power_middle(0, -1));
		System.out.println(power_middle(2, -2));
		System.out.println(power_good(2, 3));
		System.out.println(power_good(0, -1));
		System.out.println(power_good(2, -2));
	}

	public static double power_bad(double base, int exponent) {
		double result = 1.0;
		for(int i=1; i<= exponent; i++) {
			result = result * base;
		}
		return result;
	}
	
	public static double power_middle(double base, int exponent) {
		boolean g_InvalidInput = false;
		if(Math.abs(base - 0.0) < 0.0000001 && exponent < 0) {
			g_InvalidInput = true;
			return 0.0;
		}
		int absexponent = Math.abs(exponent);
		double result = 1.0;
		for(int i=1; i<=absexponent; i++) {
			result = result * base;
		}
		if(exponent < 0) {
			return 1.0 / result;
		}
		return result;
	}
	
	public static double power_good(double base, int exponent) {
		boolean g_InvalidInput = false;
		if(Math.abs(base - 0.0) < 0.0000001 && exponent < 0) {
			g_InvalidInput = true;
			return 0.0;
		}
		int absexponent = Math.abs(exponent);
		double result = powerWithUnsignedExponent(base, absexponent);
		if(exponent < 0) {
			return 1.0 / result;
		}
		return result;
	}
	
	private static double powerWithUnsignedExponent(double base, int exponent) {
		if(exponent == 0) {
			return 0;
		}
		if(exponent == 1) {
			return base;
		}
		double result = powerWithUnsignedExponent(base, exponent >> 1);
		result = result * result;
		if((exponent & 0x1) == 1) {
			result = result * base;
		}
		return result;
	}
}
