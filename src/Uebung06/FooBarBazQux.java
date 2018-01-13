public class FooBarBazQux {
	public static char BAR = '\uBABE';
	private String qux = "AuD";
	long idFoo,idQux = 0;
	static long idBar,idBaz,idfoo,idqux,id = 0;
	public FooBarBazQux() {
		id++;
	}
	public FooBarBazQux(String qux) {
		this.qux = qux;
		id++;
	}
	public int foo() {
		idFoo++;
		idfoo++;
		return 0xF00;
	}
	public static char bar() {
		idBar++;
		return BAR;
	}
	public static double baz(double baz) {
		idBaz++;
		return 0.815 * baz;
	}
	public String qux(String pre, String post) {
		idQux++;
		idqux++;
		return pre + qux + post;
	}
	public static long getInstantiations() {
		return id;
	}
	public long getCallsTo(String methodName) {
		switch (methodName) {
		case "foo":
			return idFoo;
		case "qux":
			return idQux;
		default:
			return -1;
		}
	}
	public static long getTotalCallsTo(String methodName) {
		switch (methodName) {
		case "foo":
			return idfoo;
		case "qux":
			return idqux;
		case "bar":
			return idBar;
		case "baz":
			return idBaz;

		default:
			return -1;
		}
	}
}
