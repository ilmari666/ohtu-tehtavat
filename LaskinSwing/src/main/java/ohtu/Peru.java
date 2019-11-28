package ohtu;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Peru extends Komento {
  public Peru(JTextField tuloskentta, JTextField syotekentta, Sovelluslogiikka sovellus){
    super(tuloskentta, syotekentta, sovellus);
  }

  @Override
  public void laske(int arvo){
    
  }
  
  @Override
  public void suorita(int arvo){
      sovellus.peru();
      tuloskentta.setText(""+sovellus.tulos());
      syotekentta.setText("");
 }

}

