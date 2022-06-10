package Helpers;

import javafx.stage.Stage;
import models.Perdorues;

import java.util.ArrayList;

public class Session {
    //Krijon nje array me kliente, ruan indeksin e klientit dhe numrin e faturave te printuara
    public static ArrayList<Perdorues> kliente = new ArrayList<Perdorues>();
    public static int indeksKlienti;
    public static int nrFature = 1;
    public static long inputNrKarte;
    public static Stage stage;
}
