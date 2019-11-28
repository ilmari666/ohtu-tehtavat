package ohtu;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Nollaa extends Komento {
  public Nollaa(JTextField tuloskentta, JTextField syotekentta, Sovelluslogiikka sovellus){
    super(tuloskentta, syotekentta, sovellus);
  }
  
  @Override
  public void laske(int arvo){
    this.sovellus.nollaa();
  }

}
