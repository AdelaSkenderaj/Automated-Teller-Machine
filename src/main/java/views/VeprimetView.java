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

public class VeprimetView {

    private Parent view;
    private Button terheqjeButton, depoziteButton, kontrolloButton, printoButton, exit;

    public VeprimetView() {
        view = createView();
    }

    public Parent createView() {
        //Krijo ekranin e zgjedhjes se veprimeve
        Text veprimi = new Text();
        veprimi.setStyle(Style.textStyle);
        veprimi.setText("ZGJIDHNI VEPRIMIN QË DËSHIRONI TË KRYENI");
        veprimi.setFill(Color.web(Style.textColour));
        terheqjeButton = new Button();
        terheqjeButton.setText("Tërheqje");
        terheqjeButton.setStyle(Style.buttonStyle);
        depoziteButton = new Button();
        depoziteButton.setText("Depozitë");
        depoziteButton.setStyle(Style.buttonStyle);
        kontrolloButton = new Button();
        kontrolloButton.setText("Kontrollo Balancën");
        kontrolloButton.setStyle(Style.buttonStyle);
        printoButton = new Button();
        printoButton.setText("Printo balancën");
        printoButton.setStyle(Style.buttonStyle);
        exit = new Button();
        exit.setText("Dil");
        exit.setStyle(Style.buttonStyle);
        HBox veprimet = new HBox();
        veprimet.setAlignment(Pos.CENTER);
        veprimet.setSpacing(10);
        veprimet.getChildren().addAll(terheqjeButton, depoziteButton, kontrolloButton, printoButton, exit);
        VBox vBox = new VBox();
        vBox.setSpacing(30);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(veprimi, veprimet);
        vBox.setBackground(new Background(new BackgroundFill(Color.web(Style.backgroundColor), null, null)));
        return vBox;
    }

    public Button getTerheqjeButton() {
        return terheqjeButton;
    }

    public Button getDepoziteButton() {
        return depoziteButton;
    }

    public Button getKontrolloButton() {
        return kontrolloButton;
    }

    public Button getPrintoButton() {
        return printoButton;
    }

    public Button getExitButton() {
        return exit;
    }

    public Parent getView() {
        return view;
    }
}
