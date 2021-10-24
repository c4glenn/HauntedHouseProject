import javafx.scene.layout.Pane;

public class House{
    App app;
    public Attic attic = new Attic(this);
    public Basement basement = new Basement(this); // 
    public Conservatory conservatory = new Conservatory(this); //
    public Den den = new Den(this); //
    public DiceRoom diceRoom = new DiceRoom(this); //
    public Garage garage = new Garage(this); //
    public Graveyard graveyard = new Graveyard(this);
    public GuestBath guestBath = new GuestBath(this); //
    public GuestBed guestBed = new GuestBed(this); //
    public Hallway hallway = new Hallway(this); 
    public LandingRoom landingRoom = new LandingRoom(this); //
    public Master master = new Master(this); //
    public MasterBath masterBath = new MasterBath(this); //
    public Kitchen kitchen = new Kitchen(this);

    House(App app){
        this.app = app;
    }

    Room currentRoom = hallway;
    
    Player gaw = new Player(this);

    public Pane getPane(){
        return currentRoom.display();
    }

    public void useItem(String item){
        currentRoom.useItem(item);
    }

}