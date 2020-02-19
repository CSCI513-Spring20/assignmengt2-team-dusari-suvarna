import java.awt.Point;
import java.util.Observable;

public class Ship extends Observable{
	int xcoord;
	int ycoord;
	int[][] oceanGrid = new int[10][10];

	public Ship(OceanMap oceanMap,Point shipStartPos) {
		this.oceanGrid = oceanMap.getMap();
		xcoord = shipStartPos.x;
		ycoord = shipStartPos.y;
		
	}

	public void goEast() {
		if (xcoord != 9) {
			if(this.oceanGrid[xcoord+1][ycoord] == 0 || this.oceanGrid[xcoord+1][ycoord] == 2) {
				this.oceanGrid[xcoord][ycoord] = 0;
				xcoord++;
				this.oceanGrid[xcoord][ycoord] = 2;
				setChanged();
				notifyObservers();				
			}
		}
	}

	public void goWest() {
		if (xcoord != 0) {
			if(this.oceanGrid[xcoord-1][ycoord] == 0 || this.oceanGrid[xcoord-1][ycoord] == 2) {
				this.oceanGrid[xcoord][ycoord] = 0;
				xcoord--;
				this.oceanGrid[xcoord][ycoord] = 2;
				setChanged();
				notifyObservers();				
			}
		}
	}

	public void goNorth() {
		if (ycoord != 0) {
			if (this.oceanGrid[xcoord][ycoord-1] == 0 || this.oceanGrid[xcoord][ycoord-1] == 2) {
				this.oceanGrid[xcoord][ycoord] = 0;
				ycoord--;
				this.oceanGrid[xcoord][ycoord] = 2;
				setChanged();
				notifyObservers();				
			}
		}
	}

	public void goSouth() {
		if (ycoord != 9) {
			if(this.oceanGrid[xcoord][ycoord+1] == 0 || this.oceanGrid[xcoord][ycoord+1] == 2) {
				this.oceanGrid[xcoord][ycoord] = 0;
				ycoord++;
				this.oceanGrid[xcoord][ycoord] = 2;
				setChanged();
				notifyObservers();				
			}
		}
	}
	public Point getShipLocation() {
		return new Point(xcoord, ycoord);
	}

}

