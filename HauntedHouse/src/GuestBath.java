import java.util.Random;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

public class GuestBath extends Room {
    int point;


    public GuestBath(House house) {
        super(house);
    }

    @Override
    Pane display() {
        Random r = new Random();
        GridPane pane = new GridPane();
        BackgroundImage myBI = new BackgroundImage(new Image(
                "https://cdna.artstation.com/p/assets/images/images/003/282/134/large/nitesh-ved-spaceship-bathroom-copy.jpg?1471973746",
                true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        pane.setBackground(new Background(myBI));

        ImageView lando = new ImageView(new Image(
                "https://static.wikia.nocookie.net/rebel-alliance/images/5/58/Lando.png/revision/latest?cb=20161029020654",
                false));
        lando.setFitWidth(200);
        lando.setPreserveRatio(true);
        lando.setSmooth(true);
        lando.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("Chances");
                a.setContentText("Play 21 With me!");
                a.setResizable(true);
                a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                a.showAndWait();
                
            }
        });

        HBox hBox = new HBox();
        Button hit = new Button("Hit Me");
        point = r.nextInt(10) + r.nextInt(10);
        Label points = new Label(point + " Points in your hand");
        hit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                point += r.nextInt(10);
                if(point > 21){
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("You Lose");
                a.setContentText("You broke :)");
                a.setResizable(true);
                a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                a.showAndWait();
                house.currentRoom = house.hallway;
                house.app.refresh();
                } else {
                    points.setText(point + " Points in your hand");
                }
                
            }
        });
        Button stand = new Button("Stand");
        stand.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                if(point < r.nextInt(21)){
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("You Lose");
                a.setContentText("You scored lower than me :)");
                a.setResizable(true);
                a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                a.showAndWait();
                house.currentRoom = house.hallway;
                house.app.refresh();
                } else {
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setHeaderText("You Win");
                    a.setContentText("You scored better than me :(, remember that sometimes to get ahead you need to be negative...");
                    a.setResizable(true);
                    a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    a.showAndWait();
                    house.currentRoom = house.hallway;
                    house.app.refresh();
                }
                
            }
        });

        hBox.getChildren().addAll(points, hit, stand);

        pane.add(hBox, 0, 0);
        pane.add(lando, 0, 5);

        return pane;
    }

    
}
