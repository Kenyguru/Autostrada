package autostrada;

public class Bramka {
    private final int oplata;
    private KalkulatorOplat kalkulator;
    public Bramka(int oplata, KalkulatorOplat kalkulator) {
        this.oplata = oplata;
        this.kalkulator = kalkulator;
    }
    public void setKalkulator(KalkulatorOplat kalkulator) {
        this.kalkulator = kalkulator;
    }
    public void obsluzPojazd(Pojazd pojazd) {
        pobierzOplate(pojazd);
        System.out.println("Przepuszczam pojazd: " + pojazd);
    }
    private void pobierzOplate(Pojazd pojazd) {
        int nowaOplata = kalkulator.obliczOplate(pojazd);
        System.out.println("Pobrano oplate: " + nowaOplata);
    }
}


