package ohtu;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Summa extends Komento {
  public Summa(JTextField tuloskentta, JTextField syotekentta, Sovelluslogiikka sovellus){
    super(tuloskentta, syotekentta, sovellus);
  }
  
  @Override
  public void laske(int arvo){
    this.sovellus.plus(arvo);
  }
  

}
