package autostrada;

public class Bramka {
    private final int oplata;
    public Bramka(int oplata) {
        this.oplata = oplata;
    }
    public void obsluzPojazd(Pojazd pojazd) {
        pobierzOplate(pojazd);
        System.out.println("Przepuszczam pojazd: " + pojazd);
    }
    private void pobierzOplate(Pojazd pojazd) {

        int nowaOplata;
        if(Silnik.ELEKTRYCZNY.equals(pojazd.getSilnik())) {
            nowaOplata = new KalkulatorOplatDlaPojazdowElektrycznych().obliczOplate(pojazd);
        } else if(pojazd.getMasa() <= 3_500) {
           nowaOplata = new KalkulatorOplatDlaPojazdowLekkich(oplata).obliczOplate(pojazd);
        }
        else {
            nowaOplata = new KalkulatorOplatStandardowy(oplata).obliczOplate(pojazd);
        }
        System.out.println("Pobrano oplate: " + nowaOplata);
    }
}
