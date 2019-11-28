package ohtu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JTextField;
 
public class Tapahtumankuuntelija implements ActionListener {
    private JButton plus;
    private JButton miinus;
    private JButton nollaa;
    private JButton undo;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private Sovelluslogiikka sovellus;
    private HashMap<Object, Komento> komennot;
 
    public Tapahtumankuuntelija(JButton plus, JButton miinus, JButton nollaa, JButton undo, JTextField tuloskentta, JTextField syotekentta) {
        this.plus = plus;
        this.miinus = miinus;
        this.nollaa = nollaa;
        this.undo = undo;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.sovellus = new Sovelluslogiikka();
        this.komennot = new HashMap<>();
        komennot.put(plus, new Summa(tuloskentta, syotekentta, this.sovellus));
        komennot.put(miinus, new Erotus(tuloskentta, syotekentta, this.sovellus));
        komennot.put(nollaa, new Nollaa(tuloskentta, syotekentta, this.sovellus));
        komennot.put(undo, new Peru(tuloskentta, syotekentta, this.sovellus));
    }
        
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
 
        JButton source = (JButton) ae.getSource();
        komennot.get(source).suorita(arvo);
        if (sovellus.tulos()==0) {
            nollaa.setEnabled(false);
        } else {
            nollaa.setEnabled(true);
        }
        undo.setEnabled(true);
        
    }
 
}