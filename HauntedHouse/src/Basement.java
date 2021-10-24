import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

public class Basement extends Room {

	public Basement(House house) {
		super(house);
    }
//
//

		@Override
	Pane display() {
		GridPane pane = new GridPane();
		BackgroundImage myBI = new BackgroundImage(
				new Image("https://i0.wp.com/matrixhomesolutions.com/wp-content/uploads/2020/10/AdobeStock_279428464.jpeg?fit=1568%2C1041&ssl=1",
						true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		pane.setBackground(new Background(myBI));

		ImageView troopers = new ImageView(new Image(
                "https://static.wikia.nocookie.net/c__/images/c/ca/Stormtroopers.png/revision/latest?cb=20180411192237&path-prefix=clone",
                false));
        troopers.setFitWidth(400);
        troopers.setPreserveRatio(true);
        troopers.setSmooth(true);
        troopers.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("PEW PEW");
                a.setContentText("They kill you");
                a.setResizable(true);
                a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                a.showAndWait();
				house.app.dead();           
		}
        });
		pane.add(troopers, 0, 3);

		return pane;
	}

	@Override
	public void useItem(String item) {
		if(item.equals("Blaster") || item.equals("Luke's Lightsaber") || item.equals("Vader's Lightsaber")){
			Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("Yoink");
                a.setContentText("You are able to fight them off with the help of George Lucas, but got injured in the process. You steal some stormtrooper armor and return to the hallway");
                a.setResizable(true);
                a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                a.showAndWait();
				house.gaw.gainArmor();
				house.gaw.health --;
				house.currentRoom = house.hallway;
				house.app.refresh();
		} else{
			super.useItem(item);
		}
		
	}
    
}
