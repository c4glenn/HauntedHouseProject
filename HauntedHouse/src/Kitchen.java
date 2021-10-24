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

public class Kitchen extends Room {
    int shotsFired = 0;

    public Kitchen(House house) {
        super(house);
    }

    @Override
    Pane display() {
        GridPane pane = new GridPane();
        BackgroundImage myBI = new BackgroundImage(new Image(
                "https://cdnb.artstation.com/p/assets/images/images/016/670/519/large/david-barth-vollansicht.jpg?1553023160",
                true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        pane.setBackground(new Background(myBI));

        ImageView vader = new ImageView(new Image(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxANzYHuXOZ5jYH0gLFGC_VTgW0ynmIgZ_Fw&usqp=CAU",
                false));
        vader.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setHeaderText("Choice");
                a.setContentText("Do you accept the cupcake from vader?");
                a.setResizable(true);
                a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

                a.showAndWait();
                if (a.getResult() == ButtonType.OK) {
                    house.gaw.vaderLightsaber = true;
                    Alert b = new Alert(Alert.AlertType.INFORMATION);
                    b.setHeaderText("YUMMY");
                    b.setContentText(
                            "The cupcakes are delicious, and vader gives you his light saber for trusting him");
                    b.setResizable(true);
                    b.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    b.show();
                    house.app.refresh();

                } else {
                    Alert b = new Alert(Alert.AlertType.INFORMATION);
                    b.setHeaderText("Angery Vader");
                    b.setContentText(
                            "I find you lack of desire for cupcakes disturbing -- Vader force Chokes you");
                    b.setResizable(true);
                    b.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    b.show();
                    house.app.dead();
                }
            };
        });

        pane.add(vader, 2, 2);

        return pane;
    }

    @Override
    public void useItem(String item) {
        if(item.equals("Blaster")){
            shotsFired ++;
            if(shotsFired >= 4){
                Alert b = new Alert(Alert.AlertType.INFORMATION);
                    b.setHeaderText("Angery Vader");
                    b.setContentText(
                            "I tire of this game -- Vader force Chokes you");
                    b.setResizable(true);
                    b.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    b.show();
                    house.app.dead();
            } else {
                Alert b = new Alert(Alert.AlertType.INFORMATION);
                    b.setHeaderText("Blocked");
                    b.setContentText(
                            "Vader Blocks your Shot");
                    b.setResizable(true);
                    b.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    b.show();
            }
        } else if(item.equals("Luke's Lightsaber")){
            if(house.gaw.trained){
                Alert b = new Alert(Alert.AlertType.INFORMATION);
                    b.setHeaderText("Congrats");
                    b.setContentText("You best vader");
                    b.setResizable(true);
                    b.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    b.show();
            } else {
                Alert b = new Alert(Alert.AlertType.INFORMATION);
                    b.setHeaderText("Angery Vader");
                    b.setContentText(
                            "Vader kills you easily");
                    b.setResizable(true);
                    b.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    b.show();
                    house.app.dead();
            }

        } else{
            super.useItem(item);
        }
        
    }

}
