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

public class FaturaView {

    private Parent view;
    private Button poFature;
    private Button joFature;

    public FaturaView() {
        view = createView();
    }

    public Parent createView() {
        //Krijon ekranin qe pyet nese perdoruesi deshiron fature
        Text fature = new Text("DËSHIRONI TË PRINTONI FATURË?");
        fature.setStyle(Style.textStyle);
        fature.setFill(Color.web(Style.textColour));
        poFature = new Button();
        poFature.setText("Po");
        poFature.setStyle(Style.buttonStyle);
        joFature = new Button();
        joFature.setText("Jo");
        joFature.setStyle(Style.buttonStyle);
        HBox poJoFature = new HBox();
        poJoFature.setAlignment(Pos.CENTER);
        poJoFature.setSpacing(10);
        poJoFature.getChildren().addAll(poFature, joFature);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        vBox.getChildren().addAll(fature, poJoFature);
        vBox.setBackground(new Background(new BackgroundFill(Color.web(Style.backgroundColor), null, null)));
        return vBox;
    }

    public Button getPoFature() {
        return poFature;
    }

    public Button getJoFature() {
        return joFature;
    }

    public Parent getView() {
        return view;
    }
}
