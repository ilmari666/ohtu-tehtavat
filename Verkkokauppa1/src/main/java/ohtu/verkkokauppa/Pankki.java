package ohtu.verkkokauppa;

public class Pankki implements PankkiIF {

    private static Pankki instanssi;

    private KirjanpitoIF kirjanpito;

    public Pankki(KirjanpitoIF kirjanpito) {
        this.kirjanpito = kirjanpito;
    }

  @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}