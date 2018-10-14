package org.pruebas.springjdbc;


import org.pruebas.springjdbc.Cliente.ClienteTabla;
import org.pruebas.springjdbc.Cliente.PruebasTransacciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

import static java.lang.System.exit;

@SpringBootApplication
@ComponentScan
public class Main implements CommandLineRunner {


    @Autowired
    ClienteTabla clienteTabla;

    @Autowired
    PruebasTransacciones pruebas;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Introduce el primer parametro: ");

        // get their input as a String
        String primerParametro = scanner.next();

        System.out.print("Introduce el segundo parametro: ");
        // get their input as a String
        String segundoParametro = scanner.next();

        SpringApplication app = new SpringApplication(Main.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

    }


    public void run(String... args) throws Exception {
        if (args.length > 0) {
            clienteTabla.probar(args[0]);
        } else {
            System.out.println("Sin parametros");
        }
        pruebas.probarTransaccion();
        exit(0);
    }
}
