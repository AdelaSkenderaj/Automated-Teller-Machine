package controllers;

import Helpers.Check;
import Helpers.Session;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import styling.Style;
import views.TerheqjeView;
import views.VeprimView;

public class TerheqjeController {

    public TerheqjeController(TerheqjeView tv) {
        setView(tv);
    }

    public void setView(TerheqjeView tv) {
        //Kontrollon nese zgjedhja e bere tejkalon balancen dhe ben veprimin e terheqjes nese eshte e mundur
        tv.getKonfirmoZgjedhje().setOnAction(event -> {
            VeprimView vv = new VeprimView();
            VeprimController vc = new VeprimController(vv);
            try {
                RadioButton perm = (RadioButton) tv.getGroup().getSelectedToggle();
                String toggleValue = perm.getText();
                switch(toggleValue) {
                    case "1000" :   if(Session.kliente.get(Session.indeksKlienti).getGjendje() >= 1000)
                        Session.kliente.get(Session.indeksKlienti).terheqje(1000);
                    else
                        Check.kreditPamjaftueshem();
                        Session.stage.setScene(new Scene(vv.getView(), Style.permasaX, Style.permasaY));

                        break;
                    case "2000" :   if(Session.kliente.get(Session.indeksKlienti).getGjendje() >= 2000)
                        Session.kliente.get(Session.indeksKlienti).terheqje(2000);
                    else
                        Check.kreditPamjaftueshem();
                        Session.stage.setScene(new Scene(vv.getView(), Style.permasaX, Style.permasaY));
                        break;
                    case "5000" :   if(Session.kliente.get(Session.indeksKlienti).getGjendje() >= 5000)
                        Session.kliente.get(Session.indeksKlienti).terheqje(5000);
                    else
                        Check.kreditPamjaftueshem();
                        Session.stage.setScene(new Scene(vv.getView(), Style.permasaX, Style.permasaY));
                        break;
                    case "10000" :  if(Session.kliente.get(Session.indeksKlienti).getGjendje() >= 10000)
                        Session.kliente.get(Session.indeksKlienti).terheqje(10000);
                    else
                        Check.kreditPamjaftueshem();
                        Session.stage.setScene(new Scene(vv.getView(), Style.permasaX, Style.permasaY));
                        break;
                    case "20000" :  if(Session.kliente.get(Session.indeksKlienti).getGjendje() >= 20000)
                        Session.kliente.get(Session.indeksKlienti).terheqje(20000);
                    else
                        Check.kreditPamjaftueshem();
                        Session.stage.setScene(new Scene(vv.getView(), Style.permasaX, Style.permasaY));
                        break;
                    case "Tjetër" :
                        TerheqjeView ttv = new TerheqjeView(2);
                        TerheqjeController ttc = new TerheqjeController(ttv); 
                        Session.stage.setScene(new Scene(ttv.getView(), Style.permasaX, Style.permasaY));
                        break;
                    default : System.out.println("This value should not be reached!");
                        break;
                }
            } catch(NullPointerException e) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error!");
                a.setHeaderText("Zgjidhni një shumë!");
                a.showAndWait();
            }
        });

        //Kontrollon nese shuma e kerkuar eshte e mundur per tu terhequr dhe kryen veprimet
        tv.getKonfirmoTerheqje().setOnAction(event -> {
            try{
                long terheq = Long.parseLong(tv.getShumaTerheqje().getCharacters().toString());
                if(terheq > Session.kliente.get(Session.indeksKlienti).getGjendje()) {
                    Check.kreditPamjaftueshem();
                    VeprimView vv = new VeprimView();
                    VeprimController vc = new VeprimController(vv);
                    Session.stage.setScene(new Scene(vv.getView(), Style.permasaX, Style.permasaY));
                }
                else {
                    Session.kliente.get(Session.indeksKlienti).terheqje(terheq);
                    VeprimView vv = new VeprimView();
                    VeprimController vc = new VeprimController(vv);
                    Session.stage.setScene(new Scene(vv.getView(), Style.permasaX, Style.permasaY));
                    tv.getShumaTerheqje().clear();
                }
            } catch (NumberFormatException e) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("ERROR");
                a.setHeaderText("Shuma e pasaktë");
                a.showAndWait();
            }
        });
    }
}
