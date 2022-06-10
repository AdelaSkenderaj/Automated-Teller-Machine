package controllers;

import Helpers.Check;
import Helpers.Session;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import models.Perdorues;
import styling.Style;
import views.PiniView;
import views.VeprimetView;

public class PiniController {

    public PiniController(PiniView pv) {
        setView(pv);
    }

    public void setView(PiniView pv) {
        //Percakton cfare ndodh kur perdoruesi klikon vazhdo pasi ka vendos pinin
        pv.getVazhdo().setOnAction(event -> {
            try{
                int pin = Integer.parseInt(pv.getInputPini().getCharacters().toString());
                long karta = Session.inputNrKarte;
                //Nese karta nuk ekziston krijon nje perdorues te ri me kete nr karte dhe pin
                if(!Check.cardExist(Session.kliente, karta)) {
                    Perdorues newPerdorues = new Perdorues(karta, pin);
                    Session.kliente.add(newPerdorues);
                    Session.indeksKlienti = Check.getIndex(Session.kliente, karta);

                    VeprimetView vv = new VeprimetView();
                    VeprimetController vc = new VeprimetController(vv);
                    Scene sceneThree = new Scene(vv.getView(), Style.permasaX, Style.permasaY);
                    Session.stage.setScene(sceneThree);
                }
                //Nese perdoruesi ekziston kontrollon nese pini eshte i sakte
                else {
                    Session.indeksKlienti = Check.getIndex(Session.kliente, karta);
                    if(Session.kliente.get(Session.indeksKlienti).getFjalekalimi() != pin) {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("ERROR!");
                        a.setHeaderText("Pini i gabuar.");
                        a.showAndWait();
                    }
                    else {
                        pv.getInputPini().clear();
                        VeprimetView vv = new VeprimetView();
                        VeprimetController vc = new VeprimetController(vv);
                        Scene sceneThree = new Scene(vv.getView(), Style.permasaX, Style.permasaY);
                        Session.stage.setScene(sceneThree);
                    }
                }
            } catch(NumberFormatException e) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("ERROR!");
                a.setHeaderText("Vendosni pinin në formatin e saktë.");
                a.showAndWait();
            }
        });
    }
}
