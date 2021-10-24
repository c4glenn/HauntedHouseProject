import java.util.Random;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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


public class Garage extends Room{

    protected int testPin = -1;
    private int keyPadAttemps = -1;

    public Garage(House house) {
        super(house);
    }

    @Override
    Pane display() {
        GridPane pane = new GridPane();
        BackgroundImage myBI= new BackgroundImage(new Image("https://starwarsblog.starwars.com/wp-content/uploads/2018/11/yeager-garage-resistance.jpg",true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        //then you set to your node
        pane.setVgap(10);
        pane.setHgap(10);
        pane.setBackground(new Background(myBI));

        Label instructions = new Label("Enter your guess at a Pin(###)");
        instructions.setStyle(" -fx-background-color: white;");

        Label gueses = new Label("0/3 Guesses");
        gueses.setStyle(" -fx-background-color: white;");


        TextField tf = new TextField();

        

        Button check = new Button("Open");



        Random r = new Random();

        if(keyPadAttemps == -1 || keyPadAttemps >= 4){
            testPin = r.nextInt(1000);
            keyPadAttemps = 0;
            gueses.setText("New Code");            
        }

        check.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                String text = tf.getText();
                try{
                    int pin = Integer.parseInt(text);
                    if(pin == -1 || pin == testPin){
                        house.currentRoom = house.graveyard;
                        house.app.refresh();
                    } else  {
                        keyPadAttemps ++;
                        gueses.setText(keyPadAttemps + "/3 Guesses");
                    } 
                    if(keyPadAttemps >= 3){
                        testPin = r.nextInt(1000);
                        keyPadAttemps = 0;
                        gueses.setText("New Code");            
                    }

                } catch(NumberFormatException e){
                    instructions.setText("Please Enter a Number");
                }
            }
        });
        

        pane.add(instructions, 0, 0);
        pane.add(gueses, 2, 0);
        pane.add(tf, 1, 0);
        pane.add(check, 1 ,1 );
        return pane;
    }


}