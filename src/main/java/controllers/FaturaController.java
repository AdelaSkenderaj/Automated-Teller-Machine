package controllers;

import Helpers.Check;
import Helpers.Session;
import javafx.scene.Scene;
import styling.Style;
import views.FaturaView;
import views.KartaView;

public class FaturaController {

    public FaturaController(FaturaView fv) {
        setView(fv);
    }

    public void setView(FaturaView fv) {
        //Printon fature
        fv.getPoFature().setOnAction(event -> {
            Check.printoFature();
            KartaView kv = new KartaView();
            KartaController kc = new KartaController(kv);
            Session.stage.setScene(new Scene(kv.getView(), Style.permasaX, Style.permasaY));
        });

        /*Nuk printon fature
        *Vendos ekranin e pare ku kerkohet numri i kartes
        */
        fv.getJoFature().setOnAction(event -> {
            KartaView kv = new KartaView();
            KartaController kc = new KartaController(kv);
            Session.stage.setScene(new Scene(kv.getView(), Style.permasaX, Style.permasaY));
        });

    }
}
