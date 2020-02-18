import java.awt.Point;

public class Ship {
	int xcoord;
	int ycoord;

	public Ship(int x, int y) {

		xcoord = x;
		ycoord = y;
	}

	public void goEast() {
		if (xcoord != 9) {
			xcoord++;
		}
	}

	public void goWest() {
		if (xcoord != 0) {
			xcoord--;
		}
	}

	public void goNorth() {
		if (ycoord != 0) {
			ycoord--;
		}
	}

	public void goSouth() {
		if (ycoord != 9) {
			ycoord++;
		}
	}
	public Point getShipLocation() {
		return new Point(xcoord, ycoord);
	}

}