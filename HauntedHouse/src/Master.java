

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
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class Master extends Room {
    boolean eat = false;


    public Master(House house) {
        super(house);
    }
    void eaten(){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("MURDER");
                a.setContentText("The Ewoks eat you alive");
                a.setResizable(true);
                a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                a.show();
                house.app.dead();
    }

    @Override
    Pane display() {
        GridPane pane = new GridPane();
        BackgroundImage myBI = new BackgroundImage(new Image(
                "https://content.presspage.com/uploads/1376/c1920_booking.comaddamsfamily-morticiaandgomezbedroom-732570.jpg?78252",
                true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        pane.setBackground(new Background(myBI));

        ImageView ewok = new ImageView(new Image(
                "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/1dbc1935-6542-4ee3-822f-135cff4ba62c/ddteplm-2f3f1949-efc9-49dc-9c14-9ff04a01a26d.png/v1/fill/w_452,h_817,strp/wicket_the_ewok___transparent__by_camo_flauge_ddteplm-fullview.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9ODE3IiwicGF0aCI6IlwvZlwvMWRiYzE5MzUtNjU0Mi00ZWUzLTgyMmYtMTM1Y2ZmNGJhNjJjXC9kZHRlcGxtLTJmM2YxOTQ5LWVmYzktNDlkYy05YzE0LTlmZjA0YTAxYTI2ZC5wbmciLCJ3aWR0aCI6Ijw9NDUyIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmltYWdlLm9wZXJhdGlvbnMiXX0.h35Ak4dip97XcPOpuTN1Cq2PPJuUwE4QzR9alE8OUtU",
                false));
        ewok.setFitWidth(200);
        ewok.setPreserveRatio(true);
        ewok.setSmooth(true);
        ewok.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("MURDER");
                a.setContentText("The Ewoks eat you alive");
                a.setResizable(true);
                a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                a.show();
                house.app.dead();
            }
        });


        pane.add(ewok, 2, 2);

        return pane;
    }


    @Override
    public void useItem(String item) {
        if(item.equals("Dog Toy")){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("Chew Toy");
                a.setContentText("On a whim you decide to throw one of George Lucas’ chew toys and the ewoks dive on it and chew it vigorously. While they are distracted you grab Han Solo’s blaster and limp back into the hallway, wounded but alive");
                a.setResizable(true);
                a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                a.show();
                house.gaw.health -= 1;
                house.gaw.collectedBlaster = true;
                house.currentRoom = house.hallway;
                house.app.refresh();
        } else if(item.equals("Luke's Lightsaber") || item.equals("Vader's Lightsaber") || item.equals("Blaster") ){
            eaten();
        } else {
            super.useItem(item);
        }
        
    }

}
