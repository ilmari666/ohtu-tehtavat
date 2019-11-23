
package ohtu.intjoukkosovellus;
public class IntJoukko {

    public final static int KAPASITEETTI = 5; // aloitustalukon koko
    public final static int OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko=OLETUSKASVATUS;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukujono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm=0;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kapasiteetti2");//heitin vaan jotain :D
        }
        lukujono = new int[kapasiteetti+kasvatuskoko];
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }


    public boolean lisaa(int luku) {
        if (kuuluu(luku)){
            return false;
        }
        if (alkioidenLkm>=lukujono.length){
            this.laajenna();
        }
        lukujono[alkioidenLkm++]=luku;
        return true;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {
                return true;
            }
        }
        return false;
    }

    public void laajenna(){
        int[] uusi=new int[lukujono.length+kasvatuskoko];
        for (int i=0; i < alkioidenLkm; i++){
            uusi[i] = lukujono[i];
        }
        lukujono=uusi;
    }

    public boolean poista(int luku) {
        for (int i=0; i<alkioidenLkm; i++){
            if (lukujono[i] == luku){
                lukujono[i]=lukujono[--alkioidenLkm];
                return true;
            }
        }
        return false;
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    public IntJoukko monista(){
        IntJoukko uusiJoukko = new IntJoukko(lukujono.length);
        for (int i = 0; i < alkioidenLkm; i++){
            uusiJoukko.lisaa(lukujono[i]);
        }
        return uusiJoukko;
    }

    @Override
    public String toString() {
        String tuotos="{";
        if (alkioidenLkm>0){
            tuotos+=lukujono[0];
            for (int i = 1; i < alkioidenLkm; i++) {
                tuotos += ", "+lukujono[i];
            }
        }
        tuotos += "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukujono[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdisteJoukko = a.monista();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < bTaulu.length; i++) {
            yhdisteJoukko.lisaa(bTaulu[i]);
        }
        return yhdisteJoukko;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkausJoukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    leikkausJoukko.lisaa(bTaulu[j]);
                }
            }
        }
        return leikkausJoukko;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko erotusJoukko = a.monista();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < bTaulu.length; i++) {
            erotusJoukko.poista(bTaulu[i]);
        }
        return erotusJoukko;
    }
        
}
