package views;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import styling.Style;

public class DepozitoView {

    private Parent view;
    private Button konfirmoDepozite;
    private TextField shumaDepozite;

    public DepozitoView() {
        view = createView();
    }

    public Parent createView() {
        //Krijon ekranin ne te cilin perdoruesi vendos shumen qe do te depozitoje
        Text vendosShume2 = new Text("VENDOSNI SHUMËN QË DËSHIRONI TË DEPOZITONI");
        vendosShume2.setStyle(Style.textStyle);
        vendosShume2.setFill(Color.web(Style.textColour));
        shumaDepozite = new TextField();
        shumaDepozite.setMaxWidth(200);
        shumaDepozite.setStyle(Style.textBoxStyle);
        konfirmoDepozite = new Button();
        konfirmoDepozite.setText("Konfirmo");
        konfirmoDepozite.setStyle(Style.buttonStyle);
        VBox vBox = new VBox();
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(vendosShume2, shumaDepozite, konfirmoDepozite);
        vBox.setBackground(new Background(new BackgroundFill(Color.web(Style.backgroundColor), null, null)));
        return vBox;
    }

    public Button getKonfirmoDepozite() {
        return konfirmoDepozite;
    }

    public TextField getShumaDepozite() {
        return shumaDepozite;
    }

    public Parent getView() {
        return view;
    }
}
