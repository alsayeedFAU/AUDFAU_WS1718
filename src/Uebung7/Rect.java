
public class Rect implements Drawable {
	private PixelPainter pp;
	private int x,y,width,height;
	private Color color;
	
	public Rect(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
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
		for(int i = x; i <= x+width-1; i++) {
			for(int j = y; j <= y+height-1; j++) {
				pp.set(i, j, color);
			}
		}

	}

}
