public class Physics {
	// Given gas-volume v (m*m*m) and temperature t (K),
	// this method computes and returns the pressure p (Pa).
	public static double computeP(double v, double t) {
		return v != 0 ? (PhysicsConstants.AVOGADRO * PhysicsConstants.BOLTZMANN * t) / v : 0;
	}

	// Given pressure p (Pa) and temperature t (K),
	// this method computes and returns the gas-volume v (m*m*m).
	public static double computeV(double p, double t) {
		return (PhysicsConstants.AVOGADRO * PhysicsConstants.BOLTZMANN * t) / p;
	}

	// Given pressure p (Pa) and gas-volume v (m*m*m),
	// this method computes and returns the temperature t (K).
	public static double computeT(double p, double v) {
		return (p * v) / (PhysicsConstants.AVOGADRO * PhysicsConstants.BOLTZMANN);
	}

	// Given gas-volume v (m*m*m) and a change in temperature of deltaT (K),
	// this method computes and returns the change in pressure (Pa).
	public static double computeDeltaPisochore(double v, double deltaT) {
		return computeP(v, deltaT + 1) - computeP(v, 1);
	}

	// Given gas-volume v (m*m*m), temperature t (K) and a change in volume of
	// deltaV (m*m*m),
	// this method computes and returns the change in pressure (Pa).
	public static double computeDeltaPisotherm(double v, double t, double deltaV) {
		return computeP(v + deltaV, t) - computeP(v, t);
	}

	// Given temperature t (K) and molar mass of particle m (kg/mol),
	// this method computes and returns the average speed of a particle.
	public static double computeAverageSpeed(double t, double m) {
		return Math.sqrt(((3 * PhysicsConstants.BOLTZMANN * t) / (m / PhysicsConstants.AVOGADRO)));
	}
}