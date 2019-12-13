package ohtu.kivipaperisakset;

import java.util.HashMap;
import java.util.Map;

public class Tekoaly extends Pelaaja {

    private int siirto;
    private Map<Integer, String> siirrot = new HashMap<>(){{
        put(0, "k");
        put(1, "p");
        put(2, "s");
    }};

    public Tekoaly(String siirtoTeksti) {
        super(siirtoTeksti);
        siirto = 0;
    }
    

    public String annaSiirto() {
        siirto++;
        siirto = siirto % 3;
        String valinta=siirrot.get(siirto);
        System.out.println(valinta);
        return valinta;
    }

    public void asetaSiirto(final String ekanSiirto) {
        // ei tehdä mitään 
    }
}
