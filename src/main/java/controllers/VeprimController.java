package controllers;

import Helpers.Session;
import javafx.scene.Scene;
import styling.Style;
import views.FaturaView;
import views.VeprimView;
import views.VeprimetView;

public class VeprimController {

    public VeprimController(VeprimView vv) {
        setView(vv);
    }

    public void setView(VeprimView vv) {
        /*Ne baze te butonit qe klikohet vendos ekranin
        *Kur klikon po vendos ekranin e veprimeve, nese jo pyet nese deshiron fature
        */
        vv.getPoVeprim().setOnAction(event -> {
            VeprimetView vvv = new VeprimetView();
            VeprimetController vc = new VeprimetController(vvv);
            Session.stage.setScene(new Scene(vvv.getView(), Style.permasaX, Style.permasaY));
        });


        vv.getJoVeprim().setOnAction(event -> {
            FaturaView fv = new FaturaView();
            FaturaController fc = new FaturaController(fv);
            Session.stage.setScene(new Scene(fv.getView(), Style.permasaX, Style.permasaY));
        });
    }
}
