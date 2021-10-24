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
public class GuestBed extends Room {

	public GuestBed(House house) {
		super(house);
	}
//
	@Override
	Pane display() {
		GridPane pane = new GridPane();
		BackgroundImage myBI = new BackgroundImage(
				new Image("https://t3.ftcdn.net/jpg/03/38/01/42/360_F_338014258_6Pd89FB74DpAn8L0SaPrtBEY3Qp5JhuF.jpg",
						true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		pane.setBackground(new Background(myBI));

		ImageView chewy = new ImageView(new Image(
                "https://swrpggm.com/wp-content/uploads/2020/12/dc99jhm-2cc78fbe-9afd-4124-be8f-d0a41b8998bc-615x1024-1.png",
                false));
        chewy.setFitWidth(200);
        chewy.setPreserveRatio(true);
        chewy.setSmooth(true);
        chewy.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("Roar");
                a.setContentText("Chewy doesn't like being touched... he rips your arms off");
                a.setResizable(true);
                a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                a.showAndWait();
				house.app.dead();           
		}
        });
		pane.add(chewy, 0, 3);

		return pane;
	}

	@Override
	public void useItem(String item) {
		if(item.equals("George Lucas")){
			Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("Chatty Puppy");
                a.setContentText("You don’t understand what’s being said but George and Chewbacca have a conversation because he hands George Lucas a treat and gives you a wrench.");
                a.setResizable(true);
                a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                a.showAndWait();
				house.gaw.hasWrench = true;
				house.currentRoom = house.hallway;
				house.app.refresh();
		} else if(item.equals("Blaster") || item.equals("Luke's Lightsaber") || item.equals("Vader's Lightsaber")){
			Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("BYE BYE ARMS");
                a.setContentText("You attack Chewbacca but he rips your and George Lucas' arms off first");
                a.setResizable(true);
                a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                a.showAndWait();
				house.app.dead();
		} else{
			super.useItem(item);
		}
		
	}

}
