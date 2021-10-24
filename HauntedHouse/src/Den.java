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

import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

public class Den extends Room {

	public Den(House house) {
		super(house);
    }
	@Override
    Pane display() {
        GridPane pane = new GridPane();
        BackgroundImage myBI = new BackgroundImage(new Image(
                "https://insidethemagic.net/wp-content/uploads/2017/02/cover-800x400.jpg"
                , true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        pane.setBackground(new Background(myBI));

        ImageView r2 = new ImageView(new Image(
                "https://www.avayan.com/r2d2/assets/images/BrokenR2D2_1.jpg",
                false));
        r2.setFitWidth(200);
        r2.setPreserveRatio(true);
        r2.setSmooth(true);
        r2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("FRYYYY");
                a.setContentText("you try to fix r2 with your bare hands and fry");
                a.setResizable(true);
                a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                a.showAndWait();
				house.app.dead();           
		}
        });

        pane.add(r2, 0, 5);

		return pane;
	}
    @Override
    public void useItem(String item) {
        if(item.equals("Wrench")){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("Thanks");
                a.setContentText("Beep boop thanks for fixing me have this random key I found");
                a.setResizable(true);
                a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                a.showAndWait();
                house.gaw.hasKey = true;
                house.currentRoom = house.hallway;
                house.app.refresh();
        } else {
            super.useItem(item);
        }
        
    }
}
