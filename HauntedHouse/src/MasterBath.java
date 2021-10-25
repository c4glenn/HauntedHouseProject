import javafx.event.EventHandler;
import javafx.scene.control.Alert;
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
public class MasterBath extends Room {

    public MasterBath(House house) {
        super(house);
    }

    @Override
    Pane display() {
        GridPane pane = new GridPane();
		BackgroundImage myBI= new BackgroundImage(new Image("https://www.homestratosphere.com/wp-content/uploads/2017/11/large-master-bathroom-nov9-17.jpg", true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        pane.setBackground(new Background(myBI));

		ImageView jabba = new ImageView(new Image("https://i.pinimg.com/originals/13/a9/20/13a9203c8ade09e700bbb4dc753014b2.png", false));
        jabba.setFitWidth(200);
        jabba.setPreserveRatio(true);
        jabba.setSmooth(true);
		jabba.setOnMouseClicked(
			new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent arg0) {
					Alert a = new Alert(Alert.AlertType.INFORMATION);
				a.setHeaderText("GURGGLLE");
                a.setContentText("Upset at you for ruining his self care, jabba drowns you in the tub");
				a.setResizable(true);
				a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			    a.showAndWait();
                house.app.dead();
				};
			}
		);
		ImageView hooka = new ImageView(new Image("https://cdn3.volusion.com/wqdey.abfrv/v/vspfiles/photos/1208-2.png?v-cache=1594905232", false));
        hooka.setFitWidth(100);
        hooka.setPreserveRatio(true);
        hooka.setSmooth(true);
		hooka.setOnMouseClicked(
			new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent arg0) {
					house.gaw.health = house.gaw.maxhealth;
                    house.currentRoom = house.hallway;
					house.app.refresh();
				};
			}
		);
        pane.add(hooka, 0, 1);
        pane.add(jabba, 2, 3);

        return pane;
    }
    
}
