public class Matrix3x3 {
	Vector3D[] M = new Vector3D[] { new Vector3D(), new Vector3D(), new Vector3D() };

	public Matrix3x3() {
	}

	public void set(int x, int y, double d) {
		M[x].set(y, d);
	}

	public double get(int x, int y) {
		return M[x].get(y);
	}

	public void toIdentity() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				set(i, j, 0);
			}
		}

		set(0, 0, 1);
		set(1, 1, 1);
		set(2, 2, 1);

	}
	public void deepCopyFrom(Matrix3x3 m2) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				set(i, j, m2.get(i, j));
			}
		}
	}
	public void setRotX(double d) {
		M = new Vector3D[] { new Vector3D(), new Vector3D(), new Vector3D() };
		set(0, 0, 1);
		set(1, 1, Math.cos(d));
		set(1, 2, -1*Math.sin(d));
		set(2, 1, Math.sin(d));
		set(2, 2, Math.cos(d));
	}
	public void setRotY(double d) {
		M = new Vector3D[] { new Vector3D(), new Vector3D(), new Vector3D() };
		set(1, 1, 1);
		set(0, 0, Math.cos(d));
		set(0, 2, -1*Math.sin(d));
		set(2, 0, Math.sin(d));
		set(2, 2, Math.cos(d));
	}
	public void setRotZ(double d) {
		M = new Vector3D[] { new Vector3D(), new Vector3D(), new Vector3D() };
		set(2, 2, 1);
		set(0, 0, Math.cos(d));
		set(1, 0, -1*Math.sin(d));
		set(0, 1, Math.sin(d));
		set(1, 1, Math.cos(d));

	}

	public Matrix3x3 immutMul(Matrix3x3 m2) {
		Matrix3x3 c = new Matrix3x3();
		double x = 0;
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M.length; j++) {
				for (int k = 0; k < m2.M.length; k++) {
					x += this.get(i, k) * m2.get(k, j);
				}
				c.set(i, j, x);
				x = 0;
			}
		}
		return c;
	}

	public void mutMul(Matrix3x3 m2) {
		Matrix3x3 c = new Matrix3x3();
		double x = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					x += this.get(i, k) * m2.get(k, j);
				}
				c.set(i, j, x);
				x = 0;
			}
		}
		
		deepCopyFrom(c);
	}

	public Vector3D mulVec(Vector3D v1) {
		Vector3D tmp = new Vector3D();
		for (int i = 0; i < 3; i++) {
			tmp.set(i, get(0, i) * v1.get(0) + get(1, i) * v1.get(1) + get(2, i) * v1.get(2));
		}
		return tmp;
	}

}
