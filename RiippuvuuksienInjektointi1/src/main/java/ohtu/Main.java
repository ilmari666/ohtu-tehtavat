package ohtu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ohtu.laskin.KonsoliIO;
import ohtu.laskin.Laskin;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Laskin laskin = ctx.getBean(Laskin.class);
        laskin.suorita();
    }
}
