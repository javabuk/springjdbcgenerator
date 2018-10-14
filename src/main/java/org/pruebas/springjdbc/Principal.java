package org.pruebas.springjdbc;

import org.pruebas.springjdbc.Cliente.ClienteTabla;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class Principal {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(oracle.jdbc.driver.OracleDriver.class.getName());
        ds.setUrl("jdbc:oracle:thin:@192.168.0.10:32769/xe.oracle.docker");
        ds.setUsername("prueba");
        ds.setPassword("prueba");

        /*Properties p = new Properties();
        Map<String, String> datasourceProperties = new HashMap<>();
        datasourceProperties.put("defaultAutoCommit", "false");
        p.putAll(datasourceProperties);
        ds.setConnectionProperties(p);

        ds.setConnectionProperties(p);*/
        return ds;
    }


    /*public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Principal.class);
        context.getBean(ClienteTabla.class).probar();

    }*/



}
