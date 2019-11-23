package ohtu.intjoukkosovellus;

import ohtu.io.Input;
import ohtu.io.InputIF;

public class Sovellus {

    private static IntJoukko A, B, C;
    private final static InputIF lukija = new Input();


    private static IntJoukko mikaJoukko(String prompt) {
        System.out.println(prompt+" ");
        char joukko;
        while (true){
            joukko = lukija.getChar();
            switch(joukko){
                case 'A':
                case 'a':
                    return A;
                case 'B':
                case 'b':
                    return B;
                case 'C':
                case 'c':
                    return C;
                default:
                    System.out.println("Virheellinen joukko! " + joukko);
                    System.out.print("Yritä uudelleen!");
            }
        }
    }

    private static int mikaLuku(String prompt){
        System.out.print(prompt+" ");
        return lukija.getInt();
    }

    private static void lisaa() {
        IntJoukko joukko = mikaJoukko("Mihin joukkoon?");
        System.out.println("");
        int lisattavaLuku=mikaLuku("Mikä luku lisätään?");
        joukko.lisaa(lisattavaLuku);
        return;

    }

    private static void yhdiste() {
        IntJoukko aJoukko = mikaJoukko("1. joukko?");
        IntJoukko bJoukko = mikaJoukko("2. joukko?");
        IntJoukko c = IntJoukko.yhdiste(aJoukko, bJoukko);
        System.out.println("A yhdiste B = " + c.toString());
        return;
    }

    private static void leikkaus() {
        IntJoukko aJoukko, bJoukko, c;
        aJoukko = mikaJoukko("1. joukko?");
        bJoukko = mikaJoukko("2. joukko?");
        c = IntJoukko.leikkaus(aJoukko, bJoukko);
        System.out.println("A leikkaus B = " + c.toString());
        return;
    }

    private static void erotus() {
        IntJoukko aJoukko, bJoukko, c;
        aJoukko = mikaJoukko("1. joukko?");
        bJoukko = mikaJoukko("2. joukko?");
        c = IntJoukko.erotus(aJoukko, bJoukko);
        System.out.println("A erotus B = " + c.toString());
        return;
    }

    private static void poista() {
        IntJoukko joukko = mikaJoukko("Mistä joukosta?");
        int poistettavaLuku = mikaLuku("Mikä luku poistetaan?");
        joukko.poista(poistettavaLuku);
        return;
    }

    private static void kuuluu() {
        IntJoukko joukko = mikaJoukko("Mihin joukkoon?");
        int luettuLuku = mikaLuku("Mikä luku?");
        boolean kuuluuko = joukko.kuuluu(luettuLuku);
        if (kuuluuko) {
            System.out.println(luettuLuku + " kuuluu joukkoon ");
        } else {
            System.out.println(luettuLuku + " ei kuulu joukkoon ");
        }
        return;
    }

    public static void main(String[] args) {
        A = new IntJoukko();
        B = new IntJoukko();
        C = new IntJoukko();
        String luettu;

        System.out.println("Tervetuloa joukkolaboratorioon!");
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
        System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");

        while (true) {
            luettu = lukija.getLine().toLowerCase();
            switch (luettu){
                case "li":
                case "lisää":
                    lisaa();
                    break;
                case "p":
                case "poista":
                    poista();
                    break;
                case "k":
                case "kuuluu":
                    kuuluu();
                    break;
                case "y":
                case "yhdiste":
                    yhdiste();
                    break;
                case "le":
                case "leikkaus":
                    leikkaus();
                    break;
                case "e":
                case "erotus":
                    erotus();
                    break;
                case "a":
                    System.out.println(A);
                    break;
                case "b":
                    System.out.println(B);
                    break;
                case "c":
                    System.out.println(C);
                    break;
                case "q":
                case "quit":
                case "lopeta":
                    System.out.println("Lopetetaan, moikka!");
                    break;
                default:
                    System.out.println("Virheellinen komento! " + luettu);
                    System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
            }
            System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
        }
    }
}
