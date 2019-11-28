package ohtu;

public class Sovelluslogiikka {
 
    private int tulos;
    private int edellinen=0;
 
    public void plus(int luku) {
      tulos += luku;
    }
     
    public void miinus(int luku) {
      tulos -= luku;
    }
 
    public void nollaa() {
      tulos = 0;
    }

    public void peru(){
      int t=tulos;
      tulos=edellinen;
      edellinen=t;
    }
    
    public int tulos() {
      return tulos;
    }
    
    public void tallennaEdellinen() {
      edellinen=tulos;
    }
}
