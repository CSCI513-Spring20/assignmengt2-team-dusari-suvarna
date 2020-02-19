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
	public void update(Observable observable,Object arg) {
		shipLocation = (Ship) observable;
		columbusShipPos = shipLocation.getShipLocation();
		movePirateShip();
	}
	
	public Point getShipLocation() {
		return new Point(xcoord, ycoord);
	}
	
	public void movePirateShip() {
		
		
		if(columbusShipPos.x == xcoord) {
			if(columbusShipPos.y - ycoord > 0 && ycoord+1 < 10) {				
				if(this.oceanGrid[xcoord][ycoord+1] == 0 ||this.oceanGrid[xcoord][ycoord+1] == 2) {
					ycoord++;
					this.oceanGrid[xcoord][ycoord] = 3;
				}
			}
			else {
				if(columbusShipPos.y - ycoord < 0 && ycoord-1 > -1 ) {				
					if(this.oceanGrid[xcoord][ycoord-1] == 0 || this.oceanGrid[xcoord][ycoord-1] == 2) {
						ycoord--;
						this.oceanGrid[xcoord][ycoord] = 3;
					}
				}					
			}
			
		}
		
		else if(columbusShipPos.y == ycoord){	
			if(columbusShipPos.x - xcoord > 0 && xcoord+1 < 10) {				
				if(this.oceanGrid[xcoord+1][ycoord] == 0 || this.oceanGrid[xcoord+1][ycoord] == 2) {
					xcoord++;
					this.oceanGrid[xcoord][ycoord] = 3;
				}
			}
			else {
				if(columbusShipPos.x -xcoord < 0 && xcoord-1 > -1 ) {				
					if(this.oceanGrid[xcoord-1][ycoord] == 0 || this.oceanGrid[xcoord-1][ycoord] == 2) {
						xcoord--;
						this.oceanGrid[xcoord][ycoord] = 3;
					}
				}					
			}			
		}
		
		else if(columbusShipPos.x - xcoord > 0 && columbusShipPos.y - ycoord > 0) {
			if(xcoord+1 < 10){
				if(this.oceanGrid[xcoord+1][ycoord] == 0 || this.oceanGrid[xcoord+1][ycoord] == 2){
					xcoord++;
					this.oceanGrid[xcoord][ycoord] = 3;
				}
			}
			if(ycoord+1 <10) {
				if(this.oceanGrid[xcoord][ycoord+1] == 0 || this.oceanGrid[xcoord][ycoord+1] == 2){
					ycoord++;
					this.oceanGrid[xcoord][ycoord] = 3;
				}
			}
		}
		
		else if(columbusShipPos.x - xcoord < 0 && columbusShipPos.y - ycoord < 0) {
			if(xcoord-1 > -1){
				if(this.oceanGrid[xcoord-1][ycoord] == 0 || this.oceanGrid[xcoord-1][ycoord] == 2){
					xcoord--;
					this.oceanGrid[xcoord][ycoord] = 3;
				}
			}
			if(ycoord-1 > -1) {
				if(this.oceanGrid[xcoord][ycoord-1] == 0 || this.oceanGrid[xcoord][ycoord-1] == 2){
					ycoord--;
					this.oceanGrid[xcoord][ycoord] = 3;
				}
			}
		}

		else if(columbusShipPos.x - xcoord > 0 && columbusShipPos.y - ycoord < 0) {
			if(xcoord+1 < 10){
				if(this.oceanGrid[xcoord+1][ycoord] == 0 || this.oceanGrid[xcoord+1][ycoord] == 2){
					xcoord++;
					this.oceanGrid[xcoord][ycoord] = 3;
				}
			}
			if(ycoord-1 > -1) {
				if(this.oceanGrid[xcoord][ycoord-1] == 0 || this.oceanGrid[xcoord][ycoord-1] == 2){
					ycoord--;
					this.oceanGrid[xcoord][ycoord] = 3;
				}
			}
		}

		else if(columbusShipPos.x - xcoord < 0 && columbusShipPos.y - ycoord > 0) { 
			if(xcoord-1 > -1){
				if(this.oceanGrid[xcoord-1][ycoord] == 0 || this.oceanGrid[xcoord-1][ycoord] == 2){
					xcoord--;
					this.oceanGrid[xcoord][ycoord] = 3;
				}
			}
			if(ycoord+1 < 10) {
				if(this.oceanGrid[xcoord][ycoord+1] == 0 || this.oceanGrid[xcoord][ycoord+1] == 2){
					ycoord++;
					this.oceanGrid[xcoord][ycoord] = 3;
				}
			}
		}		
		
		
		for(int x = 0; x < 10; x++){
			 for(int y = 0; y < 10; y++){
				 if(xcoord != x && ycoord !=y && oceanGrid[x][y] == 3) {
					 oceanGrid[x][y] = 0;
				 }
			 }
			 }

	}
	
}
