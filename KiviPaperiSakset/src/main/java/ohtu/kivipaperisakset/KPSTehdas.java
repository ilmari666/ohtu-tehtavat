package ohtu.kivipaperisakset;
import java.util.Scanner;
public class KPSTehdas{


    public static KPS luoYksinpeli(final Scanner scanner) {
        return new KPS(new IhmisPelaaja("Ensimmäisen pelaajan siirto:", scanner), new Tekoaly("Tietokone valitsi:"));
    }

    public static KPS luoKaksinpeli(final Scanner scanner) {
        return new KPS(new IhmisPelaaja("Ensimmäisen pelaajan siirto:", scanner),
                new IhmisPelaaja("Toisen pelaajan siirto:", scanner));
    }

    public static KPS luoPahaYksinpeli(final Scanner scanner) {
        return new KPS(
            new IhmisPelaaja("Ensimmäisen pelaajan siirto:", scanner),
            new TekoalyParannettu("Tietokone valitsi:", 20)
        );
    }
    
}