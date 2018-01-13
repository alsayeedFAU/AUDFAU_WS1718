public class ShiftPainter implements PixelPainter {
	private int xMin;
	private int yMin;
	private int xMax;
	private int yMax;
	private PixelPainter painter;

	public ShiftPainter(int dx, int dy, PixelPainter painter) {
		xMin = dx;
		yMin = dy;
		xMax = painter.getMaxX();
		yMax = painter.getMaxY();
		this.painter = painter;
	}

	@Override
	public void set(int x, int y, Color color) {
		if (x + xMin < xMax && y + yMin < yMax) {
			painter.set(x + xMin, y + yMin, color);
		}
	}

	@Override
	public void clear() {

	}

	@Override
	public int getMinX() {
		return xMin;
	}

	@Override
	public int getMaxX() {
		return xMax;
	}

	@Override
	public int getMinY() {
		return yMin;
	}

	@Override
	public int getMaxY() {
		return yMax;
	}

}
