package br.com.NewSystem.Cliente.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.NewSystem.ClienteDTO.ClienteDTO;
import br.com.NewSystem.DAO.ConexaoDAO;

public class ClienteDAO {
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	
	ArrayList<ClienteDTO> lista = new ArrayList<>();
	
	public void cadastrarCliente(ClienteDTO objclClienteDTO) {
		String sql = "insert into cliente (nome_cliente,CPF,email_cliente) values (?,?,?)";
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objclClienteDTO.getNome_cliente());
			pstm.setString(2, objclClienteDTO.getCpf());
			pstm.setString(3, objclClienteDTO.getEmail());
			
			pstm.execute();
			pstm.close();
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "ClienteDAO Cadastrar" + erro);
		}
		
	}
	
	public ArrayList<ClienteDTO> pequisarCliente(){
		String sql = "select * from cliente";
		conn = new ConexaoDAO().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				ClienteDTO objclientedto = new ClienteDTO();
				objclientedto.setId_cliente(rs.getInt("id_cliente"));
				objclientedto.setNome_cliente(rs.getString("nome_cliente"));
				objclientedto.setCpf(rs.getString("CPF"));
				objclientedto.setEmail(rs.getString("email_cliente"));
				
				lista.add(objclientedto);
				
			}
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "ClienteDAO Pesquisar: " + erro);
		}
		return lista;
	}
	
	public void AlterarCliente(ClienteDTO objclientedto) {
		
		String sql = "UPDATE cliente set nome_cliente = ?, CPF = ?, email_cliente = ? where id_cliente = ? ";
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objclientedto.getNome_cliente());
			pstm.setString(2, objclientedto.getCpf());
			pstm.setString(3, objclientedto.getEmail());
			pstm.setInt(4, objclientedto.getId_cliente());
			
			pstm.execute();
			pstm.close();
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "ClienteDAO Alterar" + erro);
		}
		
	}
	
	public void ExcluirCliente(ClienteDTO objclientedto) {
		
		String sql = "DELETE from cliente where id_cliente = ?";
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, objclientedto.getId_cliente());
			
			pstm.execute();
			pstm.close();
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "ClienteDAO Excluir" + erro);
		}
		
		
	}

}
