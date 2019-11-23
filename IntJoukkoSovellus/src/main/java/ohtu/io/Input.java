
package ohtu.io;

import java.util.Scanner;

public class Input implements InputIF {
    Scanner lukija = new Scanner(System.in);

    @Override
    public int getInt(){
        return lukija.nextInt();
    };

    @Override
    public char getChar(){
        return lukija.next().charAt(0);
    };

    @Override
    public String getLine(){
        return lukija.nextLine();
    };

}
