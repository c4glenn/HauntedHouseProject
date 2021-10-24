
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Write a description of JavaFX class Display here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class App extends Application {
    boolean running = true;
    House house = new House(this);
    Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
            this.stage = stage;
            Button back = new Button("Return To Hallway");
            back.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent arg0) {
                    house.currentRoom = house.hallway;
                    refresh();
                }
            });
            BorderPane pane = new BorderPane();
            pane.setTop(back);
            pane.setCenter(house.getPane());
            pane.setBottom(house.gaw.hud());

            Scene scene = new Scene(pane, 1000, 800);
            stage.setTitle("Starwars Haunted House");
            stage.setScene(scene);
            stage.show();
            

    }

    public void refresh(){
        try {
            start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dead(){
        
    } 


    public static void main(String[] args) {
        launch(args);
    }
    /*
     * public String exposition =
     * "You are a big Star Wars fan so this Halloween you decide to go to a house that is allegedly haunted by Carrie Fisher. \n You’ve heard that the only way to escape alive is to collect star wars objects.\n Along for the ride is your dog George Lucas, who you brought because he has separation anxiety."
     * ; Player main = new Player(); int keyPadAttemps = -1; int testPin = 000;
     * boolean cleared = false;
     * 
     * 
     * public enum Room{ LANDING_ROOM,
     * 
     * }
     * 
     * public Stage hallway1(Stage stage){ placeholder = Room.HALLWAY1; Label label
     * = new Label(exposition);
     * 
     * 
     * // create a popup Popup popup = new Popup();
     * 
     * // set background
     * 
     * Button close = new Button("Close"); close.setOnAction(new
     * EventHandler<ActionEvent>() {
     * 
     * @Override public void handle(ActionEvent event) { popup.hide(); } });
     * label.setTranslateY(20);
     * 
     * // add the label popup.getContent().add(label);
     * popup.getContent().add(close); // set size of label label.setMinWidth(80);
     * label.setMinHeight(50); Button show = new Button("Begining Exposition");
     * show.setOnAction(new EventHandler<ActionEvent>() {
     * 
     * @Override public void handle(ActionEvent event) { popup.show(stage); } });
     * int numDoors = 10; Button[] doors = new Button[numDoors + 1]; BackgroundImage
     * myBI= new BackgroundImage(new Image(
     * "https://www.therpf.com/forums/attachments/9412a5bbd1d06b632ebfda1d0e9b02f2-jpg.1330635/"
     * ,true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
     * BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT); //then you set to your
     * node GridPane pane = new GridPane(); pane.setPadding(new Insets(10, 10, 10,
     * 10)); pane.setMinSize(1080, 600); pane.setVgap(10); pane.setHgap(10);
     * pane.setBackground(new Background(myBI));
     * 
     * ImageView sciDoor = new ImageView(new Image(
     * "http://4.bp.blogspot.com/-dbUetHrbIEc/UWuMQSlYknI/AAAAAAAAAcU/QJ63pHSlq7c/s400/Door.png",
     * false));
     * 
     * for(int i = 0; i <= numDoors; i++){ sciDoor = new ImageView(new Image(
     * "http://4.bp.blogspot.com/-dbUetHrbIEc/UWuMQSlYknI/AAAAAAAAAcU/QJ63pHSlq7c/s400/Door.png",
     * false)); sciDoor.setFitHeight(100); sciDoor.setPreserveRatio(true); Button
     * button = new Button(); //button.setPrefSize(100, 80);
     * button.setGraphic(sciDoor); if(i < 5){ button.setTranslateY(100);
     * button.setTranslateX((200*i) + 10);
     * 
     * } else { button.setTranslateY(300); button.setTranslateX((150*i) - 1000); }
     * placeholder = placeholder.next(); button.setText(placeholder.name());
     * button.setOnAction(new EventHandler<ActionEvent>() {
     * 
     * @Override public void handle(ActionEvent event) { switchStage(placeholder,
     * stage); } });
     * 
     * doors[i] = button; }
     * 
     * for(Button door : doors){ pane.add(door, 0, 0); } pane.add(show, 0, 0);
     * 
     * // JavaFX must have a Scene (window content) inside a Stage (window) Scene
     * scene = new Scene(pane, 1000,800);
     * stage.setTitle("Starwars House -- Hallway"); stage.setScene(scene);
     * 
     * return stage; }
     * 
     * public Stage master(Stage stage){ GridPane pane = new GridPane();
     * 
     * Button back = new Button("Back to Hallway");
     * 
     * back.setTranslateX(20); back.setTranslateY(20);
     * 
     * back.setOnAction(new EventHandler<ActionEvent>() {
     * 
     * @Override public void handle(ActionEvent event){ switchStage(Room.HALLWAY1,
     * stage); } });
     * 
     * 
     * Label test = new Label("This is a test"); pane.add(back, 0, 0);
     * pane.add(test, 0, 0);
     * 
     * Scene scene = new Scene(pane, 1000,800);
     * stage.setTitle("Starwars House -- Master Bedroom"); stage.setScene(scene);
     * return stage; }
     * 
     * public Stage kitchen(Stage stage){ GridPane pane = new GridPane();
     * 
     * 
     * Button back = new Button("Back to Hallway");
     * 
     * back.setTranslateX(20); back.setTranslateY(20);
     * 
     * back.setOnAction(new EventHandler<ActionEvent>() {
     * 
     * @Override public void handle(ActionEvent event){ switchStage(Room.HALLWAY1,
     * stage); } });
     * 
     * pane.add(back, 0, 0); Scene scene = new Scene(pane, 1000,800);
     * stage.setTitle("Starwars House -- Kitchen"); stage.setScene(scene); return
     * stage; }
     * 
     * public Stage mBath(Stage stage){ GridPane pane = new GridPane();
     * 
     * Button back = new Button("Back to Hallway");
     * 
     * back.setTranslateX(20); back.setTranslateY(20);
     * 
     * back.setOnAction(new EventHandler<ActionEvent>() {
     * 
     * @Override public void handle(ActionEvent event){ switchStage(Room.HALLWAY1,
     * stage); } });
     * 
     * pane.add(back, 0, 0); Scene scene = new Scene(pane, 1000,800);
     * stage.setTitle("Starwars House -- Master Bathroom"); stage.setScene(scene);
     * return stage; }
     * 
     * public Stage attic(Stage stage){ GridPane pane = new GridPane();
     * 
     * Button back = new Button("Back to Hallway");
     * 
     * back.setTranslateX(20); back.setTranslateY(20);
     * 
     * back.setOnAction(new EventHandler<ActionEvent>() {
     * 
     * @Override public void handle(ActionEvent event){ switchStage(Room.HALLWAY1,
     * stage); } });
     * 
     * pane.add(back, 0, 0); Scene scene = new Scene(pane, 1000,800);
     * stage.setTitle("Starwars House -- Attic"); stage.setScene(scene); return
     * stage; }
     * 
     * public Stage basement(Stage stage){ GridPane pane = new GridPane();
     * 
     * Button back = new Button("Back to Hallway");
     * 
     * back.setTranslateX(20); back.setTranslateY(20);
     * 
     * back.setOnAction(new EventHandler<ActionEvent>() {
     * 
     * @Override public void handle(ActionEvent event){ switchStage(Room.HALLWAY1,
     * stage); } });
     * 
     * pane.add(back, 0, 0); Scene scene = new Scene(pane, 1000,800);
     * stage.setTitle("Starwars House -- Basement"); stage.setScene(scene); return
     * stage; }
     * 
     * public Stage den(Stage stage){ GridPane pane = new GridPane();
     * 
     * Button back = new Button("Back to Hallway");
     * 
     * back.setTranslateX(20); back.setTranslateY(20);
     * 
     * back.setOnAction(new EventHandler<ActionEvent>() {
     * 
     * @Override public void handle(ActionEvent event){ switchStage(Room.HALLWAY1,
     * stage); } });
     * 
     * pane.add(back, 0, 0); Scene scene = new Scene(pane, 1000,800);
     * stage.setTitle("Starwars House -- Den"); stage.setScene(scene); return stage;
     * }
     * 
     * public Stage guestBed(Stage stage){ GridPane pane = new GridPane();
     * 
     * Button back = new Button("Back to Hallway");
     * 
     * back.setTranslateX(20); back.setTranslateY(20);
     * 
     * back.setOnAction(new EventHandler<ActionEvent>() {
     * 
     * @Override public void handle(ActionEvent event){ switchStage(Room.HALLWAY1,
     * stage); } });
     * 
     * pane.add(back, 0, 0); Scene scene = new Scene(pane, 1000,800);
     * stage.setTitle("Starwars House -- Guest Bedroom"); stage.setScene(scene);
     * return stage; }
     * 
     * public Stage guestBath(Stage stage){ GridPane pane = new GridPane();
     * 
     * Button back = new Button("Back to Hallway");
     * 
     * back.setTranslateX(20); back.setTranslateY(20);
     * 
     * back.setOnAction(new EventHandler<ActionEvent>() {
     * 
     * @Override public void handle(ActionEvent event){ switchStage(Room.HALLWAY1,
     * stage); } });
     * 
     * pane.add(back, 0, 0); Scene scene = new Scene(pane, 1000,800);
     * stage.setTitle("Starwars House -- Guest Bedroom"); stage.setScene(scene);
     * return stage; }
     * 
     * public Stage conservatory(Stage stage){ GridPane pane = new GridPane();
     * 
     * Button back = new Button("Back to Hallway");
     * 
     * back.setTranslateX(20); back.setTranslateY(20);
     * 
     * back.setOnAction(new EventHandler<ActionEvent>() {
     * 
     * @Override public void handle(ActionEvent event){ switchStage(Room.HALLWAY1,
     * stage); } });
     * 
     * pane.add(back, 0, 0); Scene scene = new Scene(pane, 1000,800);
     * stage.setTitle("Starwars House -- Conservatory"); stage.setScene(scene);
     * return stage; }
     * 
     * public Stage graveyard(Stage stage){ GridPane pane = new GridPane();
     * 
     * Button back = new Button("Back to Hallway");
     * 
     * back.setTranslateX(20); back.setTranslateY(20);
     * 
     * back.setOnAction(new EventHandler<ActionEvent>() {
     * 
     * @Override public void handle(ActionEvent event){ switchStage(Room.HALLWAY1,
     * stage); } });
     * 
     * pane.add(back, 0, 0); Scene scene = new Scene(pane, 1000,800);
     * stage.setTitle("Starwars House -- Graveyard"); stage.setScene(scene); return
     * stage; }
     * 
     * public Stage diceRoom(Stage stage){ GridPane pane = new GridPane();
     * 
     * Button back = new Button("Back to Hallway");
     * 
     * back.setTranslateX(20); back.setTranslateY(20);
     * 
     * back.setOnAction(new EventHandler<ActionEvent>() {
     * 
     * @Override public void handle(ActionEvent event){ switchStage(Room.HALLWAY1,
     * stage); } });
     * 
     * pane.add(back, 0, 0); Scene scene = new Scene(pane, 1000,800);
     * stage.setTitle("Starwars House -- Dice roooom"); stage.setScene(scene);
     * return stage; }
     * 
     * public Stage landingRoom(Stage stage){ GridPane pane = new GridPane();
     * 
     * Button back = new Button("Back to Hallway");
     * 
     * back.setTranslateX(20); back.setTranslateY(20);
     * 
     * back.setOnAction(new EventHandler<ActionEvent>() {
     * 
     * @Override public void handle(ActionEvent event){ switchStage(Room.HALLWAY1,
     * stage); } });
     * 
     * pane.add(back, 0, 0);
     * 
     * Scene scene = new Scene(pane, 1000,800);
     * stage.setTitle("Starwars House -- Landing Room"); stage.setScene(scene);
     * return stage; }
     * 
     * public Stage garage(Stage stage){ GridPane pane = new GridPane();
     * 
     * Button back = new Button("Back to Hallway");
     * 
     * 
     * 
     * }
     * 
     * /** The start method is the main entry point for every JavaFX application. It
     * is called after the init() method has returned and after the system is ready
     * for the application to begin running.
     *
     * @param stage the primary stage for this application.
     *//*
        * @Override public void start(Stage stage) { switch (roomNum){ case HALLWAY1:
        * hallway1(stage).show(); break; case MASTER: master(stage).show(); break; case
        * MASTER_BATH: mBath(stage).show(); break; case BASEMENT:
        * basement(stage).show(); break; case DEN: den(stage).show(); break; case
        * GUEST_BED: guestBed(stage).show(); break; case GUEST_BATH:
        * guestBath(stage).show(); break; case CONSERVATORY:
        * conservatory(stage).show(); break; case DICE_ROOM: diceRoom(stage).show();
        * break; case LANDING_ROOM: landingRoom(stage).show(); break; case GARAGE:
        * garage(stage).show(); break; default: stage.show(); break; }
        * 
        * }
        * 
        * public void switchStage(Room room, Stage stage){ roomNum = room;
        * start(stage); }
        * 
        * public void dead(){
        * 
        * } //master bed public void fightEwoks(){ dead(); }
        * 
        * public void throwToy(){ main.collectedBlaster = true; main.health-=1; } //den
        * public void wrenchFix(){ main.hasKey = true; }
        * 
        * public void noWrenchFix(){ dead(); } //kitchen public void takeCupcake(){
        * main.vaderLightsaber = true; }
        * 
        * public void refuseCupcake(){ dead(); }
        * 
        * public void shootBlaster(){ if(main.collectedBlaster == true) { int attempts
        * = 0; while(attempts<=4){ //loop back to take, refuse, or shoot } } } //guest
        * bed public void attackWeapon(){ if(main.collectedBlaster == true ||
        * main.lukeLightsaber == true || main.vaderLightsaber == true) { dead(); } else
        * {
        * 
        * } }
        * 
        * public void releaseGeorge() { main.hasWrench = true; } //master bath public
        * void takeHit() { main.health=main.maxhealth; }
        * 
        * public void noHit() { dead(); } //basement public void fightOff() {
        * if(main.collectedBlaster == true || main.lukeLightsaber == true ||
        * main.vaderLightsaber == true) { main.health-=1; main.trooperArmor = true; }
        * else {
        * 
        * } }
        * 
        * public void noWeapon() { dead(); } //going to attic public void
        * playSlotMachine() { if(true){ main.hasLadder = true; } else{ //loop back to
        * try again } } public static void main(String[] args){ launch(args); }
        */

}
