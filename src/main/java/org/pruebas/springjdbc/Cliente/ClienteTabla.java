package org.pruebas.springjdbc.Cliente;

import org.pruebas.springjdbc.model.TablaMetadatos;
import org.pruebas.springjdbc.repository.TablaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteTabla {

    @Autowired
    TablaRepository repositorio;

    public void probar(String nombreTabla){
        List<TablaMetadatos> metadatos = repositorio.consultarMetadatos(nombreTabla);
        for (TablaMetadatos metadato: metadatos ) {
            System.out.println(metadato.toString());
        }
    }

}
