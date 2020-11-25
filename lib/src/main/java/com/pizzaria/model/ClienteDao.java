package com.pizzaria.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;



@Repository
public class ClienteDao extends JdbcDaoSupport{
	@Autowired 
    DataSource dataSource;
	
	JdbcTemplate jdbc;
        
    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }
    
    public void insert(Cliente clie) {
        String sql = "INSERT INTO cliente " +
    "(nome,email,endereco) VALUES (?,?,?)" ;
        getJdbcTemplate().update(sql, new Object[]{
        		clie.getNome(), clie.getEmail(), clie.getEndereco()
        });
    }
    
    public Map<String, Object> getCliente(int id) {
    	String sql = "SELECT * FROM cliente WHERE cliente.id = ?";
    	return jdbc.queryForMap(sql,new Object[] {id});
    }
    
    public List<Map<String, Object>> getCliente() {
    	String sql = "SELECT * FROM cliente";
    	List<Map<String, Object>> cliente = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return cliente;
    }
    
    public void deleteCliente(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?" ;
        jdbc.update(sql, new Object[] {id});
    }
    
    public void updateCliente(int id,Cliente clie) {
    	String sql = "UPDATE produto SET nome = ?, email = ?, endereco = ?, WHERE id = ?";
    	 jdbc.update(sql, new Object[]{
    			 clie.getNome(), clie.getEmail(), clie.getEndereco()
         });
    }
}
