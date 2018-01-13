public class LightsOut {
	int cols, rows;
	long state,mask;

	public LightsOut(int cols, int rows, long state, long mask) {
		if(cols <= 0 || rows <= 0 || rows*cols > 64) {
			throw new IllegalArgumentException();
			//Reihen/Spalten > 0 und Spielfeld <=64 Felder
		}
		
		this.cols = cols;
		this.rows = rows;
		this.mask = mask;
		this.state = state - ((state >> cols*rows)<<cols*rows);//kuerzt state auf Spielfeldgröße
		
		for(int i = 0; i < cols*rows; i++) {
			if(BitOps.isSet(state, i) && BitOps.isSet(mask, i)) {
				this.state = BitOps.clear(this.state, i);
				//"cleared" blinde Felder laut mask
			}
		}
	}

	public long getState() {
		return state;
	}

	public void toggle(int x, int y) {
		if(x < 0 || y < 0 || y >= rows || x >= cols) {
			throw new IllegalArgumentException();
			//nimmt nur gueltige Argumente entgegen
		}
		
		if(!BitOps.isSet(mask, y*cols + x)) {
			//prueft x/y auf Gueltigkeit
			state = BitOps.flip(state, y*cols + x);
			
			//prueft Feld oberhalb von x/y
			if(!BitOps.isSet(mask, (y-1)*cols + x) && y > 0) {
				state = BitOps.flip(state, (y-1)*cols + x);
			}
			//prueft Feld unterhalt von x/y
			if(!BitOps.isSet(mask, (y+1)*cols + x) && y < rows-1) {
				state = BitOps.flip(state, (y+1)*cols + x);
			}
			//prueft Feld recht von x/y
			if(!BitOps.isSet(mask, y*cols + x+1) && x < cols-1) {
				state = BitOps.flip(state, y*cols + x+1);
			}
			//prueft Feld links von x/y
			if(!BitOps.isSet(mask, y*cols + x-1) && x > 0) {
				state = BitOps.flip(state, y*cols + x-1);
			}
		}
		
		
		
	}
	
	public boolean checkState() { //prueft ob alle Lichter aus sind => Spiel beendet
		for(int i = 0; i < cols*rows; i++) {
			if(BitOps.isSet(this.state, i)) {
				return false;
			}
		}
		return true;
	}

	public ZahlenFolgenMerker solve() {
		if(checkState()) { //wen Spiel bereits gelöst, keine Zuege nötig
			return new ZahlenFolgenMerker();
		}
			
		return null;
	}
	
}
