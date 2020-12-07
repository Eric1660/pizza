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
public class PedidoDao extends JdbcDaoSupport{
	@Autowired 
    DataSource dataSource;
	
	JdbcTemplate jdbc;
        
    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }
    
    public void insert(Pedido ped) {
        String sql = "INSERT INTO pedido " +
    "(sabor,nome,valorTotal) VALUES (?,?)" ;
        getJdbcTemplate().update(sql, new Object[]{
        		ped.getSabor(), ped.getNome(), 
        });
    }
    
    public Map<String, Object> getPedido(int id) {
    	String sql = "SELECT * FROM pedido WHERE pedido.id = ?";
    	return jdbc.queryForMap(sql,new Object[] {id});
    }
    
    public List<Map<String, Object>> getPedido() {
    	String sql = "SELECT * FROM pedido";
    	List<Map<String, Object>> pedido = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return pedido;
    }
    
    public void deletePedido(int id) {
        String sql = "DELETE FROM pedido WHERE id = ?" ;
        jdbc.update(sql, new Object[] {id});
    }
    
    public void updatePedido(int id,Pedido ped) {
    	String sql = "UPDATE pedido SET sabor = ?, nome = ?, WHERE id = ?";
    	 jdbc.update(sql, new Object[]{
    			 ped.getSabor(), ped.getNome()
         });
    }
}
