package controllers;

import Helpers.Session;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import styling.Style;
import views.DepozitoView;
import views.VeprimView;

public class DepozitoController {

    public DepozitoController(DepozitoView dv) {
        setView(dv);
    }

    public void setView(DepozitoView dv) {
        /*Depoziton ne llogarine e perdoruesit shumen e vendosur 
        *Nese perdoruesi nuk vendos nje shume ose nese shuma nuk eshte ne formatin
        *numer atehere shfaqet nje dritare alerti me mesazhin "Shume e pasakte"
        */
        dv.getKonfirmoDepozite().setOnAction(event -> {
            try {
                Session.kliente.get(Session.indeksKlienti).depozitim(Long.parseLong(dv.getShumaDepozite().getCharacters().toString()));
                VeprimView vv = new VeprimView();
                VeprimController vc = new VeprimController(vv);
                Session.stage.setScene(new Scene(vv.getView(), Style.permasaX, Style.permasaY));
                dv.getShumaDepozite().clear();
            } catch(NumberFormatException e) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("ERROR");
                a.setHeaderText("Shumë e pasaktë.");
                a.showAndWait();
            }
        });
    }
}
