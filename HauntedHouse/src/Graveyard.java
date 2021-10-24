import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
public class Graveyard extends Room {
	GridPane pane = new GridPane();
	BackgroundImage graveYard = new BackgroundImage(new Image(
		"https://i2.wp.com/unchartedlancaster.com/wp-content/uploads/2019/11/hansGrafGraveyard2.png?resize=1110%2C821&ssl=1"
		, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		BackgroundSize.DEFAULT);
		BackgroundImage gate = new BackgroundImage(new Image(
		"https://thumbs.dreamstime.com/b/graveyard-gate-trees-gothic-old-withered-44346831.jpg"
		, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		BackgroundSize.DEFAULT);

	boolean usedKey = false;
	

	public Graveyard(House house) {
		super(house);
    }

    @Override
    Pane display() {
		if(usedKey){
			pane.setBackground(new Background(graveYard));

			ImageView leia = new ImageView(new Image(
                "https://static.wikia.nocookie.net/starwars/images/0/0a/LMB.png/revision/latest?cb=20161003050632",
                false));
        leia.setFitWidth(200);
        leia.setPreserveRatio(true);
        leia.setSmooth(true);
        leia.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("Congrats!");
                a.setContentText("Congratulations! you made it through the haunted house alive!");
                a.setResizable(true);
                a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                a.showAndWait();
				Platform.exit();            
		}
        });

		pane.add(leia, 0, 1);
			

		} else {
			pane.setBackground(new Background(gate));
		}
        
        
		return pane;
	}

	@Override
	public void useItem(String item) {
		if(item.equals("Key")){
			usedKey = true;
			house.app.refresh();
		} else {
			super.useItem(item);
		}
		
	}



    
}
