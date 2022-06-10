package views;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import styling.Style;

public class VeprimView {

    private Parent view;
    private Button poVeprim, joVeprim;

    public VeprimView() {
        view = createView();
    }

    public Parent createView() {
        //Krijon ekranin qe pyet nese perdoruesi deshiron te kryeje nje veprim tjeter
        Text veprim = new Text("DËSHIRONI TË KRYENI NJË VEPRIM TJETËR?");
        veprim.setStyle(Style.textStyle);
        veprim.setFill(Color.web(Style.textColour));
        poVeprim = new Button();
        poVeprim.setText("Po");
        poVeprim.setStyle(Style.buttonStyle);
        joVeprim = new Button();
        joVeprim.setText("Jo");
        joVeprim.setStyle(Style.buttonStyle);
        HBox poJoVeprim = new HBox();
        poJoVeprim.setAlignment(Pos.CENTER);
        poJoVeprim.setSpacing(10);
        poJoVeprim.getChildren().addAll(poVeprim, joVeprim);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        vBox.getChildren().addAll(veprim, poJoVeprim);
        vBox.setBackground(new Background(new BackgroundFill(Color.web(Style.backgroundColor), null, null)));
        return vBox;
    }

    public Button getPoVeprim() {
        return poVeprim;
    }

    public Button getJoVeprim() {
        return joVeprim;
    }

    public Parent getView() {
        return view;
    }
}
