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
        String [] argumentos = new String[2];

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre de la tabla: ");
        String nombreTabla = scanner.next();
        argumentos[0] = nombreTabla;
        System.out.print("Introduce el nombre de la entidad: ");
        String nombreEntidad= scanner.next();
        argumentos[1] = nombreEntidad;
        SpringApplication app = new SpringApplication(Main.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(argumentos);
    }


    public void run(String... args) throws Exception {

        clienteTabla.probar(args[0]);
        //pruebas.probarTransaccion();
        System.out.println("Proceso finalizado");
        exit(0);
    }
}
