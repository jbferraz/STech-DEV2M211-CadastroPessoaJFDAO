/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoa.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.com.senactech.MCadastroPessoa.model.Pessoa;
import br.com.senactech.MCadastroPessoa.conexao.Conexao;

/**
 *
 * @author jairb
 */
public class PessoaDAO {

    public void cadastrarPessoa(Pessoa pVO) throws SQLException {
        //Busca conexão com o BD
        Connection con = Conexao.getConexao();
        //cria um objeto stat responsavel por enviar os comandos sql do Java
        //para serem executados dentro do BD
        Statement stat = con.createStatement();
        try {
            //sql vai receber o comando SQL
            String sql;
            sql = "insert into pessoa values (null,'" + pVO.getNomePessoa() + "','"
                    + pVO.getCpf() + "','" + pVO.getEndereco() + "','"
                    + pVO.getTelefone() + "'," + pVO.getIdade() + ","
                    + pVO.isStatus() + ")";
            //vamos executar o comando construido na string SQL
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir Pessoa!\n" + e.getMessage());
        } finally {
            stat.close();
            con.close();
        }
    }

    public ArrayList<Pessoa> buscarPessoas() throws SQLException {
        //Busca conexão com o BD
        Connection con = Conexao.getConexao();
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "select * from pessoa";
            //atribuo ao rs o resultado da execução da query no banco
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<Pessoa> pessoas = new ArrayList<>();
            while (rs.next()) {
                Pessoa p = new Pessoa();
                //lado do java |x| lado do banco
                p.setIdPessoa(rs.getInt("idPessoa"));
                p.setNomePessoa(rs.getString("nomePessoa"));
                p.setCpf(rs.getString("cpf"));
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));
                p.setIdade(rs.getInt("idade"));
                p.setStatus(rs.getBoolean("status"));
                pessoas.add(p);
            }
            return pessoas;
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar Pessoas!\n" + e.getMessage());
        } finally {
            stat.close();
            con.close();
        }
    }
    
    
}
