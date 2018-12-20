package model.dao.database.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import model.entity.Pessoa;

public class PessoaDAO {

	private ConnectionParametros parametros;
	
	public PessoaDAO(ConnectionParametros parametros) {
		this.parametros = parametros;
	}
	
	public void add(Pessoa pessoa) {
		ConnectionUtil util = new ConnectionUtil();
		Connection conexao = util.criarConexao(parametros);
		
		String sql = " INSERT INTO pessoa (nome, documento) "+
					 " VALUES (?, ?)";	
		try {
			PreparedStatement ponte = conexao.prepareStatement(sql);
			ponte.setString(1, pessoa.getNome());
			ponte.setString(2, pessoa.getDocumento()); 
			ponte.execute();
			
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Pessoa consultar(Long id) {
		Pessoa pessoa = new Pessoa();
		
		ConnectionUtil util = new ConnectionUtil();
		Connection conexao = util.criarConexao(parametros);
		
		String sql = " SELECT * 	 "+
					 "   FROM pessoa "+
					 "  WHERE id = ? ";
		
		try {
			PreparedStatement ponte = conexao.prepareStatement(sql);
			ponte.setLong(1, id);			
			ResultSet rs = ponte.executeQuery();
			if (rs.next()) {
				pessoa.setId(id);
				pessoa.setNome(rs.getString("nome"));
				pessoa.setDocumento(rs.getString("documento"));
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		
		return pessoa;
	}	
	
	public void update(Pessoa p) {
		ConnectionUtil util = new ConnectionUtil();
		Connection conexao = util.criarConexao(parametros);
		
		String sql = " UPDATE pessoa "+
					 " SET nome = ?, "+
					 "     documento = ?  "+
					 " WHERE id = ?       ";
		try {
			PreparedStatement ponte = conexao.prepareStatement(sql);
			ponte.setString(1, p.getNome());
			ponte.setString(2, p.getDocumento());
			ponte.setLong(3,  p.getId());
			ponte.execute();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void delete(Integer id) {
		ConnectionUtil util = new ConnectionUtil();
		Connection conexao = util.criarConexao(parametros);
		
		StringBuilder str = new StringBuilder();
		str.append(" DELETE FROM Pessoa ");
		str.append(" WHERE id = ?");
		
		try {
			PreparedStatement ponte = conexao.prepareStatement(str.toString());
			ponte.setInt(1, id);
			ponte.execute();
			
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
//	public Pessoa lista() {
//		Pessoa pessoa = new Pessoa();
//		
//		ConnectionUtil util = new ConnectionUtil();
//		Connection conexao = util.criarConexao(parametros);
//		
//		String sql = " SELECT * 	 "+
//					 " FROM pessoa ";
//
//		
//		try {
//			PreparedStatement ponte = conexao.prepareStatement(sql);
//			ResultSet rs = ponte.executeQuery();
//			if (rs.next()) {
//				pessoa.setNome(rs.getString("nome"));
//				pessoa.setDocumento(rs.getString("documento"));
//			}
//		} catch(Exception e) {
//			throw new RuntimeException(e);
//		}
//		
//		return pessoa;
//	}
}



