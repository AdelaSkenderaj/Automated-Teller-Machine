package views;

import Helpers.Session;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Button;
import styling.Style;


public class BalancaView {

    private Parent view;
    private Button ok;

    public BalancaView() {
        view = createView();
    }

    public Parent createView() {
        Text balanca = new Text("BALANCA JUAJ ËSHTË: ALL " + Session.kliente.get(Session.indeksKlienti).getGjendje());
        balanca.setStyle(Style.textStyle);
        balanca.setFill(Color.web(Style.textColour));
        balanca.setTextAlignment(TextAlignment.CENTER);
        ok = new Button();
        ok.setText("OK");
        ok.setAlignment(Pos.CENTER);
        ok.setStyle(Style.buttonStyle);
        ok.setMaxWidth(60);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(balanca, ok);
        vBox.setSpacing(20);
        vBox.setBackground(new Background(new BackgroundFill(Color.web(Style.backgroundColor), null, null)));
        return vBox;
    }

    public Button getOkButton() {
        return ok;
    }

    public Parent getView() {
        return view;
    }
}
