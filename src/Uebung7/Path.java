
public class Path implements Drawable {
	PixelPainter pp;
	int x, y;
	int[] path;
	Color color;

	public Path(int x, int y, int[] path, Color color) {
		this.x = x;
		this.y = y;
		this.path = path;
		this.color = color;
	}

	@Override
	public void setPainter(PixelPainter painter) {
		this.pp = painter;

	}

	@Override
	public PixelPainter getPainter() {
		return pp;
	}

	@Override
	public void draw() {
		pp.set(x, y, color);

		for (int i = 0; i < path.length; i++) {
			switch (path[i]) {
			case 0:
				x++;
				pp.set(x, y, color);
				break;

			case 1:
				x++;
				y--;
				pp.set(x, y, color);
				break;

			case 2:
				y--;
				pp.set(x, y, color);
				break;

			case 3:
				x--;
				y--;
				pp.set(x, y, color);
				break;

			case 4:
				x--;
				pp.set(x, y, color);
				break;

			case 5:
				x--;
				y++;
				pp.set(x, y, color);
				break;

			case 6:
				y++;
				pp.set(x, y, color);
				break;
			case 7:
				x++;
				y++;
				pp.set(x, y, color);
				break;

			default:
				break;
			}
		}

	}

}
