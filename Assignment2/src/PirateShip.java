import java.awt.Point;
import java.util.Observer;
import java.util.Observable;
public class PirateShip implements Observer{
	private Ship shipLocation;
	Point columbusShipPos; 
	int xcoord;
	int ycoord;
	int[][] oceanGrid = new int[10][10];
	
	public PirateShip(Point position,int [][] grid) {
		this.oceanGrid = grid;
		xcoord = position.x;
		ycoord = position.y;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
