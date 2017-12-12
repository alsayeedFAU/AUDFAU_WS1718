
public class HLine implements Drawable {
	private PixelPainter pp;
	private int x0,x1,y;
	private Color color;

	public HLine(int x0, int x1, int y, Color color) {
		this.x0 = x0;
		this.x1 = x1;
		this.y = y;
		this.color = color;
	}

	@Override
	public void setPainter(PixelPainter painter) {
		this.pp = painter;

	}

	@Override
	public PixelPainter getPainter() {
		return this.pp;
	}

	@Override
	public void draw() {
		for(int i = x0; i <= x1; i++) {	
			pp.set(i, y, color);
		}

	}

}
