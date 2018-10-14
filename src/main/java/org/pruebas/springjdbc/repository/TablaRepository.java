package org.pruebas.springjdbc.repository;

import org.pruebas.springjdbc.model.TablaMetadatos;

import java.util.List;

public interface TablaRepository {

    public List<TablaMetadatos> consultarMetadatos(String nombreTabla);

    public void insertarSistema(String codigo, String descripcion) throws Exception;
}
