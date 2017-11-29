/* Ohm's law: U = R*I */
public class Ohm {
	/* Calculate the voltage using Ohm's law */
	public static double voltage(double resistance, double current) {
		return resistance * current;
	}

	/* Calculate the current using Ohm's law */
	public static double current(double voltage, double resistance) {
		return voltage / resistance;
	}

	/* Calculate the resistance using Ohm's law */
	public static double resistance(double voltage, double current) {
		return  voltage / current;
	}

	/* Calculate the resistance of two serial connected resistances */
	public static double resistanceSerialConnection2(double r1, double r2) {
		return r1 + r2;
	}

	/* Calculate the resistance of two parallel connected resistances */
	public static double resistanceParallelConnection2(double r1, double r2) {
		return ((r1*r2)/(r1+r2));
	}

	/* Calculate the resistance of N serial connected resistances */
	public static double resistanceSerialConnectionN(double[] rs) {
		double tmp = 0.0;
		
		for(double d : rs) {
			tmp += d;
		}
		
		return tmp;
	}

	/* Calculate the resistance of N parallel connected resistances */
	public static double resistanceParallelConnectionN(double[] rs) {
		double tmp = 0.0;
		int i = 0;
		
		for(double d : rs) {
			tmp +=  (1/d);
			i++;
		}
		
		
		return tmp/i;
	}
}