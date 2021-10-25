import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;

public abstract class Room{
        House house;
        public Room(House house){
                this.house = house;
        }

        public void useItem(String item){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("You can't use " + item + " here");
                a.showAndWait();
        }

        abstract Pane display();

}