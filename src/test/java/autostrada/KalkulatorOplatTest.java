package autostrada;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class KalkulatorOplatTest {

    @Test
    public void testKalkulatorDlaElektrycznych() {

        KalkulatorOplat kalkulatorOplat = new KalkulatorOplatDlaPojazdowElektrycznych();
        Pojazd auto1 = new Samochod( 2000, "egfes554545","Toyota", "Yaris", Silnik.ELEKTRYCZNY);
        Pojazd auto2 = new Samochod( 2000, "00000554545","Toyota", "Yaris", Silnik.ELEKTRYCZNY);
        Pojazd auto3 = new Samochod( 2000, "egfe0000045","Toyota", "Yaris", Silnik.SPALINOWY);

        Assert.assertEquals(0, kalkulatorOplat.obliczOplate(auto1));
        Assert.assertEquals(0, kalkulatorOplat.obliczOplate(auto2));
        Assert.assertEquals(5, kalkulatorOplat.obliczOplate(auto3));
    }
}