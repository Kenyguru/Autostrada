package autostrada;

public class KalkulatorOplatDlaPojazdowLekkich extends KalkulatorOplatStandardowy{
    public KalkulatorOplatDlaPojazdowLekkich(int oplata) {
        super(oplata);
    }

    @Override
    public int obliczOplate(Pojazd pojazd) {
        return (int) (super.obliczOplate(pojazd) * 0.5);
    }
}
