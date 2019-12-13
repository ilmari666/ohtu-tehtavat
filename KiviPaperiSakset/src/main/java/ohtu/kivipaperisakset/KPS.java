package ohtu.kivipaperisakset;

public class KPS {
    Pelaaja pelaaja1;
    Pelaaja pelaaja2;

    public KPS(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.pelaaja1 = pelaaja1;
        this.pelaaja2 = pelaaja2;
    }
    public void pelaa(){
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");

        Tuomari tuomari = new Tuomari();
        String ekanSiirto = pelaaja1.kysySiirtoa();
        String tokanSiirto = pelaaja2.kysySiirtoa();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari+"\n");
            ekanSiirto = pelaaja1.kysySiirtoa();
            tokanSiirto = pelaaja2.kysySiirtoa();
            pelaaja1.asetaSiirto(tokanSiirto);
            pelaaja2.asetaSiirto(ekanSiirto);
        }
        System.out.println("\nKiitos!");
        System.out.println(tuomari);
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}