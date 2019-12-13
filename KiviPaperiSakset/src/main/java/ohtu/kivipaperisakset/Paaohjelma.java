package ohtu.kivipaperisakset;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String mainPrompt = "\n"+
        "Valitse pelataanko" +
        "\n (a) ihmistä vastaan " +
        "\n (b) tekoälyä vastaan" +
        "\n (c) parannettua tekoälyä vastaan" +
        "\nmuilla valinnoilla lopetataan");


    public static void main(final String[] args) {
        final Map<Character, Method> komennot = new HashMap<>();
        komennot.put('a', KPSTehdas.class.getMethod("luoKaksinpeli"));
        komennot.put('b', KPSTehdas.class.getMethod("luoYksinpeli"));
        komennot.put('c', KPSTehdas.class.getMethod("luoPahaYksinpeli"));

        while (true) {
            System.out.println(mainPrompt);
            final String vastaus = scanner.nextLine();
            Method peliTyyppi = komennot.get(
                vastaus.charAt(vastaus.length()-1)
            );

            try {
                peliTyyppi.invoke(scanner);
            } catch (Exception e){
                break;
            }
        }

    }
}
