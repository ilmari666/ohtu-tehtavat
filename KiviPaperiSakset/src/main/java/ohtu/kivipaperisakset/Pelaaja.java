package ohtu.kivipaperisakset;

public abstract class Pelaaja {
    private String siirtoTeksti;
    public Pelaaja(String siirtoTeksti){
        this.siirtoTeksti = siirtoTeksti;
    }
    public String kysySiirtoa(){
        System.out.println(siirtoTeksti+" ");
        return annaSiirto();
    }
    public abstract String annaSiirto();
    public abstract void asetaSiirto(String siirto);

}