public class Circle extends OrigCircle {
	private int x, y, r;
	private Color color;

	public Circle(int x, int y, int r, Color color) {
		super(r, color);
		this.x = x;
		this.y = y;
		this.r = r;
		this.color = color;

	}

	@Override
	public void setPainter(PixelPainter painter) {
		super.setPainter(new ShiftPainter(x, y, painter));
	}

}
