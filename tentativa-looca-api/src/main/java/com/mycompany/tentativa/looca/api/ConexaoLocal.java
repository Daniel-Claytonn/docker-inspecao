/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tentativa.looca.api;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Cesar
 */
public class ConexaoLocal {

    private JdbcTemplate conexaoDoBancoLocal;

    public ConexaoLocal() {
        BasicDataSource dataSource2 = new BasicDataSource();
        dataSource2.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource2.setUrl("jdbc:mysql://52.201.236.199:3306/banco1"); // trocar o localhost:3306 pelo endereço do banco e o tecflix pelo nome do banco
        dataSource2.setUsername("root"); //Usuario do banco
        dataSource2.setPassword("urubu100"); //Senha do banco

        this.conexaoDoBancoLocal = new JdbcTemplate(dataSource2);

    }

    public JdbcTemplate getConexaoDoBancoLocal() {
        return conexaoDoBancoLocal;
    }
}
