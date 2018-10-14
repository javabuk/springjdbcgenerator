package org.pruebas.springjdbc.Cliente;

import com.sun.org.apache.bcel.internal.ExceptionConstants;
import org.pruebas.springjdbc.repository.TablaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Component
public class PruebasTransacciones {

    @Autowired
    TablaRepository repositorio;

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Transactional(rollbackFor = Exception.class)
    //@Transactional
    public void probarTransaccion() throws Exception {

        /*jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "INSERT INTO PSI_SISTEMAS  (IDSISTEMA, DESCRIPCION) VALUES (?,?)";
        jdbcTemplate.update(sql, "codigo10", "descripcion10" );
        jdbcTemplate.update(sql, "codigo10ddddddddddddddddddddddddddddd", "descripcion10" );*/


        repositorio.insertarSistema("codigo1", "descripcion1");

        repositorio.insertarSistema("codigo2", "descripcion2");

        //repositorio.insertarSistema("codigo3333333333333333333333333333333333333333333333333333333", "descripcion2");

    }
}
