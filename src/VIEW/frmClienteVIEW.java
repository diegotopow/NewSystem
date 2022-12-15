package VIEW;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.table.*;

import br.com.NewSystem.Cliente.DAO.ClienteDAO;
import br.com.NewSystem.ClienteDTO.ClienteDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Toolkit;

public class frmClienteVIEW extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCliente;
	private JTextField txtCPF;
	private JTextField txtEmail;
	private JLabel lblNewLabel_3;
	private JTextField textField;
	private JTable tabelaCliente;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JButton btnPesquisar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmClienteVIEW frame = new frmClienteVIEW();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmClienteVIEW() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rdorigo\\Desktop\\WorkSpace\\FICR2\\AvaliacaoPoo\\logoCat.png"));
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do Cliente");
		lblNewLabel.setBounds(52, 56, 105, 14);
		contentPane.add(lblNewLabel);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(52, 70, 489, 20);
		contentPane.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setBounds(52, 101, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(52, 114, 489, 20);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);
		
		
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome,cpf,email;
				
				nome = txtNomeCliente.getText();
				cpf = txtCPF.getText();
				email = txtEmail.getText();
				
				ClienteDTO objclientedto = new ClienteDTO();
				objclientedto.setNome_cliente(nome);
				objclientedto.setCpf(cpf);
				objclientedto.setEmail(email);
				
				ClienteDAO objclientedao = new ClienteDAO();
				objclientedao.cadastrarCliente(objclientedto);
				
				
			}
		});
		btnCadastrar.setBounds(436, 189, 105, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel_2 = new JLabel("E-mail");
		lblNewLabel_2.setBounds(52, 145, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(52, 158, 489, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Código");
		lblNewLabel_3.setBounds(53, 11, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(53, 25, 78, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		tabelaCliente = new JTable();
		tabelaCliente.setBounds(52, 237, 489, 129);
		contentPane.add(tabelaCliente);
		
		lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(52, 218, 122, 16);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("NOME");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(175, 218, 81, 16);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("CPF");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(285, 218, 100, 16);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("E-mail");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(422, 218, 53, 16);
		contentPane.add(lblNewLabel_7);
		
		btnPesquisar = new JButton("PESQUISAR");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarValoresCliente();
			}
		});
		btnPesquisar.setBounds(448, 376, 89, 23);
		contentPane.add(btnPesquisar);
		
	
	}
	

private void listarValoresCliente() {
		
		try {
			ClienteDAO objclientedao = new ClienteDAO();
			DefaultTableModel model = (DefaultTableModel) tabelaCliente.getModel();
			model.setNumRows(0);
			
			ArrayList<ClienteDTO> lista = objclientedao.pequisarCliente();
			
			for(int num = 0; num < lista.size(); num ++) {
				model.addRow(new Object[] {
						lista.get(num).getId_cliente(),
						lista.get(num).getNome_cliente(),
						lista.get(num).getCpf(),
						lista.get(num).getEmail()
				});
			}

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Listar Cliente VIEW" + erro);
		}
	
		
}
	
	
}
