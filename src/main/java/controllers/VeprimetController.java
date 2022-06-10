package controllers;

import Helpers.Check;
import Helpers.Session;
import javafx.scene.Scene;
import styling.Style;
import views.*;

public class VeprimetController {

    public VeprimetController(VeprimetView vv) {
        setView(vv);
    }

    public void setView(VeprimetView vv) {
        //Shfaq ekranin me shumat e paracaktuara per terheqje
        vv.getTerheqjeButton().setOnAction(event -> {
            TerheqjeView tv = new TerheqjeView(1);
            TerheqjeController tc = new TerheqjeController(tv);
            Session.stage.setScene(new Scene(tv.getView(), Style.permasaX, Style.permasaY));
        });

        //Shfaq ekranin DepozitoView ku perdoruesi vendos shumen qe deshiron te depozitoje
        vv.getDepoziteButton().setOnAction(event -> {
            DepozitoView dv = new DepozitoView();
            DepozitoController dc = new DepozitoController(dv);
            Session.stage.setScene(new Scene(dv.getView(), Style.permasaX, Style.permasaY));
        });

        //Printon nje fature
        vv.getPrintoButton().setOnAction(event -> {
            Check.printoFature();
        });

        //Pyet perdoruesin per fature kur klikon butonin dil
        vv.getExitButton().setOnAction(event -> {
            FaturaView fv = new FaturaView();
            FaturaController fc = new FaturaController(fv);
            Session.stage.setScene(new Scene(fv.getView(), Style.permasaX, Style.permasaY));
        });

        //Shfaq balancen e perdoruesit
        vv.getKontrolloButton().setOnAction(event -> {
            BalancaView bv = new BalancaView();
            BalancaController bc = new BalancaController(bv);
            Session.stage.setScene(new Scene(bv.getView(), Style.permasaX, Style.permasaY));
        });
    }
}
