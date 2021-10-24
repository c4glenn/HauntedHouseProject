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

public class Hallway extends Room{
	boolean flag = true;

	public Hallway(House house) {
		super(house);
	}

	@Override
	Pane display() {
		String exposition = "You are a big Star Wars fan so this Halloween you decide to go to a house that is allegedly haunted by Carrie Fisher. \n You’ve heard that the only way to escape alive is to collect star wars objects.\n Along for the ride is your dog George Lucas, who you brought because he has separation anxiety.";
		
        if(flag){
			Alert a = new Alert(Alert.AlertType.INFORMATION);
				a.setHeaderText("STORY");
                a.setContentText(exposition);
				a.setResizable(true);
				a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			a.showAndWait();
			flag = false;
		}
				
		GridPane pane = new GridPane();
		BackgroundImage myBI= new BackgroundImage(new Image("https://www.therpf.com/forums/attachments/9412a5bbd1d06b632ebfda1d0e9b02f2-jpg.1330635/",true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        pane.setBackground(new Background(myBI));

		ImageView MasterDoor = new ImageView(new Image("http://4.bp.blogspot.com/-dbUetHrbIEc/UWuMQSlYknI/AAAAAAAAAcU/QJ63pHSlq7c/s400/Door.png", false));
		MasterDoor.setOnMouseClicked(
			new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent arg0) {
					house.currentRoom = house.master;
					house.app.refresh();
				};
			}
		);
		ImageView kitchenDoor = new ImageView(new Image("http://4.bp.blogspot.com/-dbUetHrbIEc/UWuMQSlYknI/AAAAAAAAAcU/QJ63pHSlq7c/s400/Door.png", false));
		kitchenDoor.setOnMouseClicked(
			new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent arg0) {
					house.currentRoom = house.kitchen;
					house.app.refresh();
				};
			}
		);
		ImageView masterBath = new ImageView(new Image("http://4.bp.blogspot.com/-dbUetHrbIEc/UWuMQSlYknI/AAAAAAAAAcU/QJ63pHSlq7c/s400/Door.png", false));
		masterBath.setOnMouseClicked(
			new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent arg0) {
					house.currentRoom = house.masterBath;
					house.app.refresh();
				};
			}
		);
		ImageView denDoor = new ImageView(new Image("http://4.bp.blogspot.com/-dbUetHrbIEc/UWuMQSlYknI/AAAAAAAAAcU/QJ63pHSlq7c/s400/Door.png", false));
		denDoor.setOnMouseClicked(
			new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent arg0) {
					house.currentRoom = house.den;
					house.app.refresh();
				};
			}
		);
		ImageView diceRoom = new ImageView(new Image("http://4.bp.blogspot.com/-dbUetHrbIEc/UWuMQSlYknI/AAAAAAAAAcU/QJ63pHSlq7c/s400/Door.png", false));
		diceRoom.setOnMouseClicked(
			new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent arg0) {
					house.currentRoom = house.diceRoom;
					house.app.refresh();
				};
			}
		);
		ImageView landingRoom = new ImageView(new Image("http://4.bp.blogspot.com/-dbUetHrbIEc/UWuMQSlYknI/AAAAAAAAAcU/QJ63pHSlq7c/s400/Door.png", false));
		landingRoom.setOnMouseClicked(
			new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent arg0) {
					house.currentRoom = house.landingRoom;
					house.app.refresh();
				};
			}
		);
		ImageView guestBed = new ImageView(new Image("http://4.bp.blogspot.com/-dbUetHrbIEc/UWuMQSlYknI/AAAAAAAAAcU/QJ63pHSlq7c/s400/Door.png", false));
		guestBed.setOnMouseClicked(
			new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent arg0) {
					house.currentRoom = house.guestBed;
					house.app.refresh();
				};
			}
		);
		ImageView guestBath = new ImageView(new Image("http://4.bp.blogspot.com/-dbUetHrbIEc/UWuMQSlYknI/AAAAAAAAAcU/QJ63pHSlq7c/s400/Door.png", false));
		guestBath.setOnMouseClicked(
			new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent arg0) {
					house.currentRoom = house.guestBath;
					house.app.refresh();
				};
			}
		);
		ImageView basementDoor = new ImageView(new Image("http://4.bp.blogspot.com/-dbUetHrbIEc/UWuMQSlYknI/AAAAAAAAAcU/QJ63pHSlq7c/s400/Door.png", false));
		basementDoor.setOnMouseClicked(
			new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent arg0) {
					house.currentRoom = house.basement;
					house.app.refresh();
				};
			}
		);
		ImageView garageDoor = new ImageView(new Image("http://4.bp.blogspot.com/-dbUetHrbIEc/UWuMQSlYknI/AAAAAAAAAcU/QJ63pHSlq7c/s400/Door.png", false));
		garageDoor.setOnMouseClicked(
			new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent arg0) {
					house.currentRoom = house.garage;
					house.app.refresh();
				};
			}
		); 


		pane.add(MasterDoor, 0, 1);
		pane.add(kitchenDoor, 1, 1);
		pane.add(masterBath, 2, 1);
		pane.add(denDoor, 3, 1);
		pane.add(diceRoom, 4, 1);
		pane.add(guestBed, 0, 2);
		pane.add(guestBath, 1, 2);
		pane.add(basementDoor, 2, 2);
		pane.add(garageDoor, 3, 2);




		return pane;
	}
    
}
