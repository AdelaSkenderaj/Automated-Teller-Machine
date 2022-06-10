package controllers;

import Helpers.Check;
import Helpers.Session;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import styling.Style;
import views.KartaView;
import views.PiniView;

public class KartaController {

    public KartaController(KartaView kv) {
        setView(kv);
    }

    public void setView(KartaView kv) {
        /*Kontrollon nese karta ekziston kur perdoruesi klikon sign in
        *Nese karta nuk ekziston atehere shfaqet nje dritare Alert me mesazhin "Karta nuk ekziston"
        *Nese karta ekziston numri i kartes ruhet ne variablin inputNrKarte 
        */
        kv.getSignInButton().setOnAction(event -> {
            try {
                long karta = Long.parseLong(kv.getInputNrKarte().getCharacters().toString());
                if(!Check.cardExist(Session.kliente, karta)){
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("ERROR!");
                    a.setHeaderText("Ky numër karte nuk ekziston");
                    a.showAndWait();
                }
                else{
                    Session.inputNrKarte = Long.parseLong(kv.getInputNrKarte().getText().trim());
                    PiniView pv = new PiniView();
                    PiniController pc = new PiniController(pv);
                    kv.getInputNrKarte().clear();
                    Session.stage.setScene(new Scene(pv.getView(), Style.permasaX, Style.permasaY));
                }
            } catch (NumberFormatException e) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("ERROR!");
                a.setHeaderText("Format jo i saktë!");
                a.showAndWait();
            }
        });

        /*Kontrollon nese nuk ka nje numer karte te njejte kur perdoruesi klikon sign up
        *Nese ekziston nje karte me numer te njejte shfaq Alert "Numri i kartes eshte i pavlefshem"
        *Nese nuk ekziston nje numer karte i njejte atehere shfaqet ekrani PiniView i cili kerkon 
        *pinin nga perdoruesi
        */
        kv.getSignUpButton().setOnAction(event -> {
            try {
                long karta = Long.parseLong(kv.getInputNrKarte().getCharacters().toString());
                if(Check.cardExist(Session.kliente, karta)){
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("ERROR!");
                    a.setHeaderText("Numër karte i pavlefshëm!");
                    a.setContentText("Zgjidhni një numër tjetër karte.");
                    a.showAndWait();
                }
                else {
                    Session.inputNrKarte = Long.parseLong(kv.getInputNrKarte().getCharacters().toString());
                    PiniView pv = new PiniView();
                    PiniController pc = new PiniController(pv);
                    Session.stage.setScene(new Scene(pv.getView(), Style.permasaX, Style.permasaY));
                    kv.getInputNrKarte().clear();
                }
            } catch (NumberFormatException e) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("ERROR!");
                a.setHeaderText("Të dhëna të gabuara.");
                a.showAndWait();
            }
        });
    }
}
