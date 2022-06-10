package views;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import styling.Style;

public class TerheqjeView {

    private Parent view;
    private ToggleGroup group;
    private Button konfirmoZgjedhje = new Button(), konfirmoTerheqje = new Button();
    private TextField shumaTerheqje = new TextField();

    public TerheqjeView(int id) {
        if (id == 2)
            view = createSecondView();
        else
            view = createFirstView();
    }

    public Parent createFirstView() {
        //Krijon ekranin me shumat nga te cilat perdoruesi mund te zgjedhe
        Text zgjidhShume = new Text("ZGJIDHNI SHUMËN QË DËSHIRONI TË TËRHIQNI");
        zgjidhShume.setStyle(Style.textStyle);
        zgjidhShume.setFill(Color.web(Style.textColour));
        group = new ToggleGroup();
        RadioButton button1 = new RadioButton("1000");
        button1.setToggleGroup(group);
        button1.setStyle(Style.radioStyle);
        RadioButton button2 = new RadioButton("2000");
        button2.setToggleGroup(group);
        button2.setStyle(Style.radioStyle);
        RadioButton button3 = new RadioButton("5000");
        button3.setToggleGroup(group);
        button3.setStyle(Style.radioStyle);
        RadioButton button4 = new RadioButton("10000");
        button4.setToggleGroup(group);
        button4.setStyle(Style.radioStyle);
        RadioButton button5 = new RadioButton("20000");
        button5.setToggleGroup(group);
        button5.setStyle(Style.radioStyle);
        RadioButton button6 = new RadioButton("Tjetër");
        button6.setToggleGroup(group);
        button6.setStyle(Style.radioStyle);
        konfirmoZgjedhje = new Button();
        konfirmoZgjedhje.setText("Konfirmo");
        konfirmoZgjedhje.setStyle(Style.buttonStyle);
        VBox leftButtons = new VBox();
        leftButtons.setSpacing(20);
        leftButtons.getChildren().addAll(button1, button2, button3);
        leftButtons.setAlignment(Pos.CENTER_LEFT);
        VBox rightButtons = new VBox();
        rightButtons.setSpacing(20);
        rightButtons.getChildren().addAll(button4, button5, button6);
        rightButtons.setAlignment(Pos.CENTER_LEFT);
        VBox textKonfirmo = new VBox();
        textKonfirmo.setAlignment(Pos.CENTER);
        textKonfirmo.setSpacing(150);
        textKonfirmo.getChildren().addAll(zgjidhShume, konfirmoZgjedhje);
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(0);
        hBox.getChildren().addAll(leftButtons, textKonfirmo, rightButtons);
        hBox.setBackground(new Background(new BackgroundFill(Color.web(Style.backgroundColor), null, null)));
        return hBox;
    }

    public Parent createSecondView() {
        //Krijon ekranin ne te cilin perdoruesi shton shumen per te terhequr
        Text vendosShume = new Text("VENDOSNI SHUMËN QË DËSHIRONI TË TËRHIQNI");
        vendosShume.setStyle(Style.textStyle);
        vendosShume.setFill(Color.web(Style.textColour));
        shumaTerheqje = new TextField();
        shumaTerheqje.setStyle(Style.textBoxStyle);
        shumaTerheqje.setMaxWidth(200);
        konfirmoTerheqje = new Button();
        konfirmoTerheqje.setText("Konfirmo");
        konfirmoTerheqje.setStyle(Style.buttonStyle);
        VBox vBox = new VBox();
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(vendosShume, shumaTerheqje, konfirmoTerheqje);
        vBox.setBackground(new Background(new BackgroundFill(Color.web(Style.backgroundColor), null, null)));
        return vBox;
    }

    public Button getKonfirmoZgjedhje() {
        return konfirmoZgjedhje;
    }

    public ToggleGroup getGroup() {
        return group;
    }

    public TextField getShumaTerheqje() {
        return shumaTerheqje;
    }

    public Button getKonfirmoTerheqje() {
        return konfirmoTerheqje;
    }

    public Parent getView() {
        return view;
    }
}
