package ohtu;

import javax.swing.JButton;
import javax.swing.JTextField;

public abstract class Komento {
    protected Sovelluslogiikka sovellus;
    protected JTextField tuloskentta;
    protected JTextField syotekentta;
    protected int edeltavatulos;
    protected int arvo;
    
    public Komento (JTextField tuloskentta, JTextField syotekentta, Sovelluslogiikka sovellus){
      this.sovellus=sovellus;
      this.tuloskentta=tuloskentta;
      this.tuloskentta=tuloskentta;
      this.syotekentta=syotekentta;
    }
    
    public abstract void laske(int arvo);
   
        
    public void suorita(int arvo){
      this.arvo=arvo;
      sovellus.tallennaEdellinen();
      laske(arvo);
      tuloskentta.setText(""+sovellus.tulos());
      syotekentta.setText("");

  }
}
