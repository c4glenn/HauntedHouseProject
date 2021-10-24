import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

public class Player {
    House house;
    int health = 3;
    int maxhealth = 3;
    boolean collectedBlaster = false;
    boolean dogToy = true;
    boolean vaderLightsaber = false;
    boolean trooperArmor = false;
    boolean hasKey = true;
    boolean hasWrench = false;
    boolean lukeLightsaber = false;
    boolean trained = false;
    boolean hasLadder = false;
    String wisdom;


    Player(House house) {
        this.house = house;
    }

    public void gainArmor() {
        trooperArmor = true;
        maxhealth = 5;
    }

    public Pane hud() {
        GridPane pane = new GridPane();
        ProgressBar HealthBar = new ProgressBar();
        if(health == 0){
            house.app.dead();
            return null;
        }
        HealthBar.setProgress((double) health / maxhealth);
        HealthBar.setPrefWidth(1000);
        pane.add(HealthBar, 0, 0);
        HBox hbox = new HBox();
        Label label = new Label("Inventory:");
        hbox.getChildren().add(label);
        ImageView inv1 = new ImageView("https://static.wikia.nocookie.net/battlefront/images/0/0c/DL44_dice_image.png/revision/latest?cb=20151125194521");
        inv1.setFitWidth(100);
        inv1.setPreserveRatio(true);
        inv1.setSmooth(true);
        inv1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                house.useItem("Blaster");
            };
        

        });

        if (collectedBlaster) {
            hbox.getChildren().add(inv1);
        }
        ImageView inv2 = new ImageView();
        inv2.setImage(new Image("https://www.premierpet.com/uploads/gty00-16270_a.png"));
        inv2.setFitWidth(100);
        inv2.setPreserveRatio(true);
        inv2.setSmooth(true);
        inv2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                house.useItem("Dog Toy");
            };
        

        });
        if (dogToy) {
            hbox.getChildren().add(inv2);
        }

        ImageView inv3 = new ImageView("https://clipart.info/images/ccovers/1513370392Red%20Lightsaber%20Starwars.png");
        inv3.setFitWidth(100);
        inv3.setPreserveRatio(true);
        inv3.setSmooth(true);
        inv3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                house.useItem("Vader's Lightsaber");
            };
        

        });
        if (vaderLightsaber) {
            hbox.getChildren().add(inv3);
        }
        ImageView inv4 = new ImageView("https://www.kennedyhardware.com/images/D/KY-9XHAB-D.png");
        inv4.setFitWidth(100);
        inv4.setPreserveRatio(true);
        inv4.setSmooth(true);
        inv4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                house.useItem("Key");
            };
        

        });
        if (hasKey) {
            hbox.getChildren().add(inv4);
        }
        ImageView inv5 = new ImageView("http://cdn.shopify.com/s/files/1/1110/6266/products/adjustableWrenchMining_Icon_grande.png?v=1492527688");
        inv5.setFitWidth(100);
        inv5.setPreserveRatio(true);
        inv5.setSmooth(true);
        inv5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                house.useItem("Wrench");
            };
        

        });
        if (hasWrench) {
            hbox.getChildren().add(inv5);
        }
        ImageView inv6 = new ImageView("https://cdn.fortniteinsider.com/wp-content/uploads/2019/12/12024052/Fortnite-Green-Lightsaber.png");
        inv6.setFitWidth(100);
        inv6.setPreserveRatio(true);
        inv6.setSmooth(true);
        inv6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                house.useItem("Luke's Lighsaber");
            };
        

        });
        if (lukeLightsaber) {
            hbox.getChildren().add(inv6);
        }

        ImageView inv7 = new ImageView("https://images-ra.adoptapet.com/seo/1/sc/17_sc.png");
        inv7.setFitWidth(100);
        inv7.setPreserveRatio(true);
        inv7.setSmooth(true);
        inv7.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                house.useItem("George Lucas");
            };
        

        });
        
        hbox.getChildren().add(inv7);
      


        


        pane.add(hbox, 0, 1);



        return pane;
    }

}
