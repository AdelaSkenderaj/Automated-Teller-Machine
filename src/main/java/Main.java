
import Helpers.Session;
import controllers.KartaController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import models.Perdorues;
import styling.Style;
import views.KartaView;

public class Main extends Application {

    public void start(Stage stage) {

        Session.stage = stage;
    
        //Krijon dy perdorues me te dhena te ndryshme
        Perdorues p1 = new Perdorues(1000000000, 1234, 10000);
        Session.kliente.add(p1);
        Perdorues p2 = new Perdorues(1111111111, 1111, 20000);
        Session.kliente.add(p2);


        //Vendos ikonen dhe titulin e stage
        stage.getIcons().add(new Image("Logo.png"));
        stage.setTitle("Pecunia Bank ATM");

        KartaView kv = new KartaView();
        KartaController kc = new KartaController(kv);
        stage.setScene(new Scene(kv.getView(), Style.permasaX, Style.permasaY));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}