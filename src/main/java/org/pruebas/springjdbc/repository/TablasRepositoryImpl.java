package org.pruebas.springjdbc.repository;

import org.pruebas.springjdbc.model.TablaMetadatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TablasRepositoryImpl implements TablaRepository{

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private TransactionTemplate transactionTemplate;

    @PostConstruct
    private void postConstruct() {

        jdbcTemplate = new JdbcTemplate(dataSource);
        //DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        //transactionTemplate = new TransactionTemplate(transactionManager);
    }

    public List<TablaMetadatos> consultarMetadatos(String nombreTabla) {
        String sql = "SELECT * FROM " + nombreTabla;

        final List<TablaMetadatos>  resultados = new ArrayList<>();

        jdbcTemplate.query(sql,new ResultSetExtractor<Integer>() {

            @Override
            public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();

                for(int i = 1 ; i <= columnCount ; i++){
                    TablaMetadatos column = new TablaMetadatos();
                    column.setNombreCampo(rsmd.getColumnName(i));
                    column.setTipoCampo(rsmd.getColumnTypeName(i));
                    column.setTipoCodigo(rsmd.getColumnType(i));
                    column.setTamanyo(rsmd.getColumnDisplaySize(i));
                    resultados.add(column);
                }
                return columnCount;
            }
        });
        return resultados;
        /*return jdbcTemplate.query(sql, (resultSet, i) -> {
            return toTablaMetadatos(resultSet);
        });*/
    }

    @Override
    public void insertarSistema(String codigo, String descripcion) throws Exception {

        if(codigo.equalsIgnoreCase("codigo2")){
            throw new Exception();
        }

        String sql = "INSERT INTO PSI_SISTEMAS  (IDSISTEMA, DESCRIPCION) VALUES (?,?)";
        jdbcTemplate.update(sql, codigo, descripcion );

        /*transactionTemplate.execute(new TransactionCallback<Object>() {

            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                String sql = "INSERT INTO PSI_SISTEMAS  (IDSISTEMA, DESCRIPCION) VALUES (?,?)";
                jdbcTemplate.update(sql, codigo, descripcion );
                return null;
            }
        });*/
        

    }


    private TablaMetadatos toTablaMetadatos(ResultSet resultSet) throws SQLException {
        TablaMetadatos metadato = new TablaMetadatos();
        metadato.setNombreCampo(resultSet.getString("Nombre"));
        metadato.setTipoCampo(resultSet.getString("Tipo"));
        return metadato;
    }


}
