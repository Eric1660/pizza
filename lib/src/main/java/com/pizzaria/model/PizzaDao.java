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
public class PizzaDao extends JdbcDaoSupport{
	@Autowired 
    DataSource dataSource;
	
	JdbcTemplate jdbc;
        
    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }
    
    public void insert(Pizza piz) {
        String sql = "INSERT INTO pizza " +
    "(sabor,preco,descricao) VALUES (?,?,?)" ;
        getJdbcTemplate().update(sql, new Object[]{
        		piz.getSabor(), piz.getPreco(), piz.getDescricao()
        });
    }
    
    public Map<String, Object> getPizza(int id) {
    	String sql = "SELECT * FROM pizza WHERE pizza.id = ?";
    	return jdbc.queryForMap(sql,new Object[] {id});
    }
    
    public List<Map<String, Object>> getPizza() {
    	String sql = "SELECT * FROM pizza";
    	List<Map<String, Object>> pizza = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return pizza;
    }
    
    public void deletePizza(int id) {
        String sql = "DELETE FROM pizza WHERE id = ?" ;
        jdbc.update(sql, new Object[] {id});
    }
    
    public void updatePizza(int id,Pizza piz) {
    	String sql = "UPDATE cliente SET sabor = ?, preco = ?, descricao = ?, WHERE id = ?";
    	 jdbc.update(sql, new Object[]{
    			 piz.getSabor(), piz.getPreco(), piz.getDescricao()
         });
    }
}