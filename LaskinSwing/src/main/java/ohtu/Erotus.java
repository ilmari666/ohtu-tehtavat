package ohtu;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Erotus extends Komento {
  public Erotus(JTextField tuloskentta, JTextField syotekentta, Sovelluslogiikka sovellus){
    super(tuloskentta, syotekentta, sovellus);

  }
  
  @Override
  public void laske(int arvo){
    this.sovellus.miinus(arvo);
  }

}
