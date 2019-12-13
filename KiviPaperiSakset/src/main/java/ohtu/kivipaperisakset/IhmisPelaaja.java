package ohtu.kivipaperisakset;

import java.util.Scanner;

public class IhmisPelaaja extends Pelaaja{
    Scanner scanner;
    public IhmisPelaaja(final String siirtoTeksti, Scanner scanner) {
        super(siirtoTeksti);
        this.scanner=scanner;
    }

    @Override
    public String annaSiirto() {
        return scanner.nextLine();
    }

    @Override
    public void asetaSiirto(final String siirto) {
    }
}
 
