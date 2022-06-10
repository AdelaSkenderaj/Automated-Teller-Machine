package models;

public class Perdorues {
    private long nrKarte;
    private int fjalekalimi;
    private long gjendje;

    //Konstruktori merr numer karte, fjalekalim dhe gjendjen e perdoruesit
    public Perdorues(long nrKarte, int fjalekalimi, long gjendje) {
        this.nrKarte = nrKarte;
        this.fjalekalimi = fjalekalimi;
        this.gjendje = gjendje;
    }

    //Konstruktor qe merr numrin e kartes dhe fjalekalimin si argumenta, gjendja eshte 0
    public Perdorues(long nrKarte, int fjalekalimi) {
        this(nrKarte, fjalekalimi, 0);
    }

    //Zbret nga gjendja shumen e percaktuar 
    public void terheqje(long shuma) {
        gjendje = gjendje - shuma;
    }

    //Depoziton ne gjendje shumen e percaktuar
    public void depozitim(long shuma) {
        gjendje = gjendje + shuma;
    }

    //Kthen gjendjen 
    public long getGjendje() {
        return gjendje;
    }

    //Kthen numrin e kartes
    public long getNrKarte() {
        return nrKarte;
    }

    //Kthen fjalekalimin
    public int getFjalekalimi() {
        return fjalekalimi;
    }
}