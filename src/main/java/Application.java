import autostrada.*;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Application {
    public static void main(String[] args) {

        Queue<Pojazd> kolejkaPojazdow = new ArrayBlockingQueue(100);
        Motocykl motocykl = new Motocykl(200, "54884KI415", "Yamaha", "R1", Silnik.SPALINOWY);
        Motocykl motocykl1 = new Motocykl(200, "00OK4KI415", "Yamaha", "R1", Silnik.SPALINOWY);
        Motocykl motocykl2 = new Motocykl(200, "WWWT4KI415", "Yamaha", "R1", Silnik.SPALINOWY);

        kolejkaPojazdow.add(motocykl);
        kolejkaPojazdow.add(motocykl1);
        kolejkaPojazdow.add(motocykl2);

        Samochod samochod = new Samochod(1300, "SGSF548454", "Audi", "A4", Silnik.SPALINOWY);
        Samochod samochod1 = new Samochod(4300, "00F0548454", "Audi", "A4", Silnik.SPALINOWY);
        Samochod samochod2 = new Samochod(2000, "ZZZF548454", "Tesla", "X", Silnik.ELEKTRYCZNY);

        kolejkaPojazdow.add(samochod);
        kolejkaPojazdow.add(samochod1);
        kolejkaPojazdow.add(samochod2);

        //System.out.println(kolejkaPojazdow);

        int oplata = 200;
        KalkulatorOplat kalkulatorStandardowy = new KalkulatorOplatStandardowy(oplata);
        KalkulatorOplat kalkulatorOplatDlaElektrycznych = new KalkulatorOplatDlaPojazdowElektrycznych();
        KalkulatorOplat kalkulatorOplatDlaLekkich = new KalkulatorOplatDlaPojazdowLekkich(oplata);


        Bramka bramka = new Bramka(oplata, kalkulatorStandardowy);

        for (Pojazd pojazd : kolejkaPojazdow) {
            if (Silnik.ELEKTRYCZNY.equals(pojazd.getSilnik())) {
                bramka.setKalkulator(kalkulatorOplatDlaElektrycznych);
            } else if (pojazd.getMasa() <= 3_500) {
                bramka.setKalkulator(kalkulatorOplatDlaLekkich);
            } else {
                bramka.setKalkulator(kalkulatorStandardowy);
            }
            bramka.obsluzPojazd(pojazd);
        }
    }
}