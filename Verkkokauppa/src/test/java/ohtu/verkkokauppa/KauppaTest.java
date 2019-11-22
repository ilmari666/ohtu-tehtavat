package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.google.common.annotations.VisibleForTesting;

public class KauppaTest {
    private Pankki pankki;
    private Viitegeneraattori viite;
    private Varasto varasto;
    private Kauppa k;


    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);

        when(viite.uusi()).thenReturn(42);
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.saldo(2)).thenReturn(10); 
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "juusto", 7));
        when(varasto.saldo(3)).thenReturn(0); 
        when(varasto.haeTuote(3)).thenReturn(new Tuote(3, "hiiva", 8));
        k = new Kauppa(varasto, pankki, viite);              

    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikein() {
        // sitten testattava kauppa 
        Kauppa k = new Kauppa(varasto, pankki, viite);              

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);   
    }


    @Test
    public void kahdenEriOstoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikein() {
        // sitten testattava kauppa 

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 12);   
    }


    @Test
    public void kahdenSamanOstoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikein() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 10);   
    }
    @Test
    public void kahdenEriOstoksenJoistaToistaVarastossaPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikein() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.lisaaKoriin(3);
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);   
    }


    @Test
    public void aloitaAsiointiNollaaKorin(){
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.aloitaAsiointi();   // putsataan kori
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);   
    }


    @Test
    public void uusiViitePyydetaan(){
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.aloitaAsiointi();   // putsataan kori
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");
        k.tilimaksu("pekka", "12345");
        verify(viite, times(2)).uusi();

    }

    
}


