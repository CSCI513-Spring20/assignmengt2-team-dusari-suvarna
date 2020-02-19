import java.awt.Point;

//This class is responsible for placing the islands,ships and setting the cell value
import java.util.Random;
public class OceanMap{
	int x,y;
	int p;
	int islandCount=10;
	Random rand = new Random();
	int[][] oceanGrid = new int[10][10];
	
	public int[][] getMap() {
		return oceanGrid;
	}

	
    public Point getShipLocation(){
		x = rand.nextInt(10);		// Generating a random number from 0 -10
		y = rand.nextInt(10);
		while(oceanGrid[x][y] == 0){
			oceanGrid[x][y] = 2;
			return new Point(x,y);
		}
        return getShipLocation();
    }

    

	public Point placePirateShip(){
		x = rand.nextInt(10);		// Generating a random number from 0 -10
		y = rand.nextInt(10);
		while(oceanGrid[x][y] == 0){
			oceanGrid[x][y] = 3;
			return new Point(x,y);
		}
        return placePirateShip();

	}    

	

	public void placeIslands(){

		for(int i=0;i<islandCount;i++) {

			int x = rand.nextInt(10);

			int y = rand.nextInt(10);

			if(oceanGrid[x][y] == 0){

				oceanGrid[x][y] = 1;

			}

		}

	}

	
}
