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

public class PiniView {

    private Parent view;
    private TextField inputPini;
    private Button vazhdo;

    public PiniView() {
        view = createView();
    }

    public Parent createView() {
        //Krijo ekranin qe kerkon pinin
        Text vendosPinin = new Text("VENDOS PININ E KARTËS");
        vendosPinin.setStyle(Style.textStyle);
        vendosPinin.setFill(Color.web(Style.textColour));
        inputPini = new TextField();
        inputPini.setMaxWidth(250);
        inputPini.setStyle(Style.textBoxStyle);
        vazhdo = new Button();
        vazhdo.setText("Vazhdo");
        vazhdo.setStyle(Style.buttonStyle);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        vBox.getChildren().addAll(vendosPinin, inputPini, vazhdo);
        vBox.setBackground(new Background(new BackgroundFill(Color.web(Style.backgroundColor), null, null)));
        return vBox;
    }

    public Button getVazhdo() {
        return vazhdo;
    }

    public TextField getInputPini() {
        return inputPini;
    }

    public Parent getView() {
        return view;
    }
}
