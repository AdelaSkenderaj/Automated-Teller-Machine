package Helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import models.Perdorues;

public class Check {

    //Kontrollon nese perdoruesi ka nje llogari dhe kthen true nese po
    public static boolean cardExist(ArrayList<Perdorues> perdoruesi, long nrKarte) {
        for(Perdorues p : perdoruesi) {
            if(p.getNrKarte() == nrKarte) {
                return true;
            }
        }
        return false;
    }

    //Kthen indeksin e perdoruesit me numrin e kartes se pecaktuar
    public static int getIndex(ArrayList<Perdorues> perdoruesi, long nrKarte) {
        int i = 0;
        for(Perdorues p : perdoruesi) {
            if(p.getNrKarte() == nrKarte) {
                return i;
            }
            i++;
        }
        return -1;
    }

    //Afishon nje dritare Alert nese krediti eshte i pamjaftueshem
    public static void kreditPamjaftueshem() {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("ERROR");
        a.setHeaderText("Nuk keni kredit të mjaftueshëm");
        a.showAndWait();
    }

    //Krijon nje fature 
    public static void printoFature() {
            Stage secondaryStage = new Stage();
            Text emerBanke = new Text("PECUNIA BANK");
            emerBanke.setTextAlignment(TextAlignment.CENTER);
            Label data = new Label("DATA");
            Label ora = new Label("ORA");
            Label atm = new Label("ATM");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now(); 
            Text oraFormati = new Text(dtf.format(now));
            Label atmNumber = new Label("A0504352");
            HBox dataOraAtm = new HBox();
            dataOraAtm.setAlignment(Pos.CENTER);
            dataOraAtm.setSpacing(40);
            dataOraAtm.getChildren().addAll(data, ora, atm);
            HBox afishimOre = new HBox();
            afishimOre.setSpacing(10);
            afishimOre.setAlignment(Pos.CENTER);
            afishimOre.getChildren().addAll(oraFormati, atmNumber);
            Text rruga = new Text("RR. SAMI FRASHERI");
            rruga.setTextAlignment(TextAlignment.CENTER);
            Text nrF = new Text("NR. #" + Session.nrFature);
            Session.nrFature += 1;
            Text nrKarte = new Text("NUMRI I KARTES: " + Session.kliente.get(Session.indeksKlienti).getNrKarte());
            Text gjendjeNeLlogari = new Text("GJENDJA NE LLOGARI: ALL " + Session.kliente.get(Session.indeksKlienti).getGjendje());
            Text faleminderit = new Text("FALEMINDERIT QE KENI ZGJEDHUR PECUNIA BANK");
            VBox display = new VBox();
            display.setAlignment(Pos.CENTER);
            display.setSpacing(10);
            display.getChildren().addAll(emerBanke, dataOraAtm, afishimOre, rruga, nrF, nrKarte, gjendjeNeLlogari, faleminderit);
            Scene fatura = new Scene(display, 400, 400);
            secondaryStage.setScene(fatura);
            secondaryStage.setTitle("Fature");
            secondaryStage.show();
    }
}
