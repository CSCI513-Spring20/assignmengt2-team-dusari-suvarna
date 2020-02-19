import java.awt.Point;
import javafx.application.*;
import javafx.scene.shape.Rectangle;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
public class OceanExplorer extends Application{
	final int dimension = 10;
	final int scale = 50;
	int[][] oceanGrid = new int[10][10];
	OceanMap oceanMap = new OceanMap();
	Image island;
	Ship ship;
	ImageView shipImageView,pirateShipView1,pirateShipView2;
	Point shipStartPos;
	Point pirateStartPos1,pirateStartPos2;
	PirateShip pirate1,pirate2;
	boolean caughtShip;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

	@Override
	public void start(Stage oceanStage) throws Exception {
		// TODO Auto-generated method stub
		AnchorPane myPane = new AnchorPane();
		Scene scene = new Scene(myPane,500,500);	
		oceanStage.setScene(scene);
		oceanStage.setTitle("My Island");
		oceanStage.show();
		oceanMap.placeIslands();
		oceanGrid = oceanMap.getMap();
		drawMap(myPane);
		shipStartPos = oceanMap.getShipLocation();
		ship = new Ship(oceanMap,shipStartPos);
		
		pirateStartPos1 = oceanMap.placePirateShip();
		pirate1 = new PirateShip(pirateStartPos1,oceanGrid);
		ship.addObserver(pirate1);
		
		pirateStartPos2 = oceanMap.placePirateShip();
		pirate2 = new PirateShip(pirateStartPos2,oceanGrid);
		ship.addObserver(pirate2);
		
		LoadShipImage(myPane);
		startSailing(scene);
	}
	
	public void drawMap(AnchorPane myPane) {
		for(int x = 0; x < dimension; x++){
			 for(int y = 0; y < dimension; y++){
			 Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
			rect.setStroke(Color.BLACK); // We want the black outline
			if(oceanGrid[x][y] == 1) {
				island = new Image("island.jpg", 50, 50, true, true);

				ImagePattern imagePattern = new ImagePattern(island);

				rect.setFill(imagePattern);

			}

			else {

				rect.setFill(Color.PALETURQUOISE);

			}
			myPane.getChildren().add(rect); // Add to the node tree in the pane
			}
			}
	}
	
	private void LoadShipImage(AnchorPane pane) {
		Image shipImage = new Image("ship.png",50,50,true,true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(shipStartPos.x * scale);
		shipImageView.setY(shipStartPos.y * scale);
		pane.getChildren().add(shipImageView);
		
		Image pirateShip1 = new Image("PirateShip.png",50,50,true,true);
		pirateShipView1 = new ImageView(pirateShip1);
		pirateShipView1.setX(pirateStartPos1.x * scale);
		pirateShipView1.setY(pirateStartPos1.y * scale);
		pane.getChildren().add(pirateShipView1);
		
		Image pirateShip2 = new Image("PirateShip.png",50,50,true,true);
		pirateShipView2 = new ImageView(pirateShip2);
		pirateShipView2.setX(pirateStartPos2.x * scale);
		pirateShipView2.setY(pirateStartPos2.y * scale);
		pane.getChildren().add(pirateShipView2);
	}
	
	private void startSailing(Scene scene) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if(ship.getShipLocation().equals(pirate1.getShipLocation()) || 
						ship.getShipLocation().equals(pirate2.getShipLocation())){	
					caughtShip = true;
				}
				if(!caughtShip) {
				switch (ke.getCode()) {
				case RIGHT:
					ship.goEast();
					break;
				case LEFT:
					ship.goWest();
					break;
				case UP:
					ship.goNorth();
					break;
				case DOWN:
					ship.goSouth();
					break;
				default:
					break;
				}
				}
				shipImageView.setX(ship.getShipLocation().x * scale);
				shipImageView.setY(ship.getShipLocation().y * scale);
				pirateShipView1.setX(pirate1.getShipLocation().x * scale);
				pirateShipView1.setY(pirate1.getShipLocation().y * scale);
				pirateShipView2.setX(pirate2.getShipLocation().x * scale);
				pirateShipView2.setY(pirate2.getShipLocation().y * scale);
				
			}
		});

	}	

}
