package views;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import styling.Style;

public class KartaView {

    public TextField inputNrKarte;
    public Button signIn, signUp;
    private Parent view;

    public KartaView() {
        view = createView();
    }

    public Node krijoLogon() {
        //Vendos logon dhe emrin e bankes
        Text bankName = new Text("Pecunia BANK");
        bankName.setStyle("-fx-font: 28 georgia");
        bankName.setFill(Color.web(Style.textColour));
        Image logo = new Image("Logo.png");
        ImageView logoView = new ImageView(logo);
        logoView.setFitHeight(70);
        logoView.setFitWidth(70);
        HBox banka = new HBox();
        banka.setSpacing(10);
        banka.setAlignment(Pos.CENTER);
        banka.getChildren().addAll(logoView, bankName);
        return banka;
    }

    public Parent createView() {
        //Krijo ekranin qe kerkon kodin e kartes
        Text vendosKarten = new Text("VENDOS KODIN E KARTËS");
        vendosKarten.setStyle(Style.textStyle);
        vendosKarten.setFill(Color.web(Style.textColour));
        inputNrKarte = new TextField();
        inputNrKarte.setMaxWidth(250);
        inputNrKarte.setStyle(Style.textBoxStyle);
        signIn = new Button();
        signIn.setText("Sign In");
        signIn.setStyle(Style.buttonStyle);
        signUp = new Button();
        signUp.setText("Sign Up");
        signUp.setStyle(Style.buttonStyle);
        HBox signButtons = new HBox();
        signButtons.getChildren().addAll(signIn, signUp);
        signButtons.setSpacing(20);
        signButtons.setAlignment(Pos.CENTER);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        vBox.getChildren().addAll(krijoLogon(), vendosKarten, inputNrKarte, signButtons);
        vBox.setBackground(new Background(new BackgroundFill(Color.web(Style.backgroundColor), null, null)));
        return vBox;
    }

    public Button getSignInButton() {
        return signIn;
    }

    public Button getSignUpButton() {
        return signUp;
    }

    public TextField getInputNrKarte() {
        return inputNrKarte;
    }

    public Parent getView() {
        return view;
    }
}
