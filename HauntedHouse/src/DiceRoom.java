import java.util.Random;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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

public class DiceRoom extends Room {

    public DiceRoom(House house) {
        super(house);
    }

    // https://static.wikia.nocookie.net/wfl/images/4/42/Boba_Fett.png/revision/latest?cb=20200209171033
    @Override
    Pane display() {
        GridPane pane = new GridPane();
        BackgroundImage myBI = new BackgroundImage(new Image(
                "https://static.wikia.nocookie.net/starwars/images/f/f4/Canto_Bight_TLJ.png/revision/latest?cb=20180418053128",
                true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        pane.setBackground(new Background(myBI));

        ImageView Boba_Fett = new ImageView(new Image(
                "https://static.wikia.nocookie.net/wfl/images/4/42/Boba_Fett.png/revision/latest?cb=20200209171033",
                false));
        Boba_Fett.setFitWidth(200);
        Boba_Fett.setPreserveRatio(true);
        Boba_Fett.setSmooth(true);
        Boba_Fett.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setHeaderText("Chances");
                a.setContentText("Do you want to challange Boba Fett to a dice roll?");
                a.setResizable(true);
                a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                a.showAndWait();
                if (a.getResult() == ButtonType.OK) {
                    Random r = new Random();
                    if (r.nextInt(6) >= r.nextInt(6)) {
                        Alert b = new Alert(Alert.AlertType.INFORMATION);
                        b.setHeaderText("You Win");
                        b.setContentText(
                                "He nods in good will and tells you 'sometimes being negative will get you through when it seems imposible to guess'");
                        b.setResizable(true);
                        b.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                        b.show();
                        house.currentRoom = house.hallway;
                        house.app.refresh();

                    } else {
                        Alert b = new Alert(Alert.AlertType.INFORMATION);
                        b.setHeaderText("You lose");
                        b.setContentText("Boba fett shakes his head in disapointment and kicks you out of his room");
                        b.setResizable(true);
                        b.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                        b.show();
                        house.currentRoom = house.hallway;
                        house.app.refresh();

                    }

                }
            }
        });

        pane.add(Boba_Fett, 0, 5);

        return pane;
    }

}
