/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tentativa.looca.api;

import com.mycompany.tentativa.looca.api.conexao.Conexao;
import com.mycompany.tentativa.looca.api.conexao.Maquina;
import com.mycompany.tentativa.looca.api.conexao.UsuarioDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author daniel
 */
public class LoginMaxSolutions {
    
    
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();
        LoocaApi loocaApiMaxSolutions = new LoocaApi();
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Bem-vindo(a) ao sistema da MaxSolutions");
        
        System.out.println("Informe o Patrimonio da máquina:");
        
        String usuario = leitor.nextLine();
        
        System.out.println("Informe a sua senha:");
        
        String senha = leitor.nextLine();
        
        try {

            String patrimonio_maquina = usuario;
            String senha_maquina = senha;

            Maquina maquina = new Maquina(patrimonio_maquina, senha_maquina);

            UsuarioDAO objUsuarioDAO = new UsuarioDAO();
            ResultSet result = objUsuarioDAO.usuarioEntra(maquina);

            if (result.next()) {
                System.out.println("Login reallizado com sucesso");
                maquina.setFkEmpresa(result.getInt("id_loja"));
                maquina.setIdMaquina(result.getInt("id_maquina"));

                loocaApiMaxSolutions.demonstraLooca(maquina);
            } else {
                System.out.println("Falha no login! Tente novamente");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginMaxSolutions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
