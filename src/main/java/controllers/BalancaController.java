package controllers;

import Helpers.Session;
import javafx.scene.Scene;
import styling.Style;
import views.BalancaView;
import views.VeprimetView;

public class BalancaController {

    public BalancaController(BalancaView bv) {
        setView(bv);
    }

    /*
    *Kur perdoruesi klikon butonin ok shfaqet ekrani i veprimeve
    */
    public void setView(BalancaView bv) {
        bv.getOkButton().setOnAction(event -> {
            VeprimetView vv = new VeprimetView();
            VeprimetController vc = new VeprimetController(vv);
            Session.stage.setScene(new Scene(vv.getView(), Style.permasaX, Style.permasaY));
        });
    }
}
