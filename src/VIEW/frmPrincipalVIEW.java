package VIEW;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.NewSystem.Cliente.DAO.ClienteDAO;
import br.com.NewSystem.ClienteDTO.ClienteDTO;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Toolkit;

public class frmPrincipalVIEW extends JFrame {

	private JPanel contentPane;
	private JTable tabelaCliente;
	private JButton btnAlterar;
	private JTextField txtEmailCliente;
	private JTextField txtCodigo;
	private JTextField txtCPF;
	private JTextField txtNomeCliente;
	private JButton btnCarregarCampos;
	private JButton btnLimpar;
	private JButton btnExcluir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPrincipalVIEW frame = new frmPrincipalVIEW();
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
	public frmPrincipalVIEW() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rdorigo\\Desktop\\WorkSpace\\FICR2\\AvaliacaoPoo\\logoCat.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 506);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		tabelaCliente = new JTable();
		tabelaCliente.getLayout();
		
		tabelaCliente.setBorder(UIManager.getBorder("FormattedTextField.border"));
		tabelaCliente.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"ID","Nome","CPF","E-mail"
			}
		));
		
		JButton btnPesquisar = new JButton("PESQUISAR");
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarValoresCliente();
			}
		});
		
		btnAlterar = new JButton("ALTERAR");
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AlterarCliente();
				ListarValoresCliente();
				LimparCampos();
			}
		});
		
		txtEmailCliente = new JTextField();
		txtEmailCliente.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		txtCodigo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CÓDIGO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("NOME");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_3 = new JLabel("E_MAIL");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastrarCliente();
				ListarValoresCliente();
				LimparCampos();
				
			}
		});
		
		btnCarregarCampos = new JButton("CARREGAR CAMPOS");
		btnCarregarCampos.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCarregarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarregarCampos();
			}
		});
		
		btnLimpar = new JButton("LIMPAR");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LimparCampos();
			}
		});
		
		btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//EXCLUIR
				ExcluirCliente();
				ListarValoresCliente();
				LimparCampos();
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_5 = new JLabel("NOME");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_6 = new JLabel("CFP");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_7 = new JLabel("E-MAIL");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(57)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnCarregarCampos, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(tabelaCliente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel)
									.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(45)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(txtNomeCliente, 459, 459, 459)
									.addComponent(lblNewLabel_2)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
								.addGap(50)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnExcluir)
										.addComponent(txtEmailCliente, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE))))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
										.addGap(40)
										.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
										.addGap(95)
										.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addComponent(btnNewButton)
										.addGap(18)
										.addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(18)
										.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
									.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
										.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
										.addGap(56))))))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNomeCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEmailCliente, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnPesquisar)
						.addComponent(btnAlterar)
						.addComponent(btnLimpar)
						.addComponent(btnExcluir))
					.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel_6)
						.addComponent(lblNewLabel_7))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabelaCliente, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCarregarCampos)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void ListarValoresCliente() {
		
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
			JOptionPane.showMessageDialog(null, "Listar Clientes VIEW" + erro);
		}
	}
	
	private void CarregarCampos () {
		int setar = tabelaCliente.getSelectedRow();
		txtCodigo.setText(tabelaCliente.getModel().getValueAt(setar, 0).toString());
		txtNomeCliente.setText(tabelaCliente.getModel().getValueAt(setar, 1).toString());
		txtCPF.setText(tabelaCliente.getModel().getValueAt(setar, 2).toString());
		txtEmailCliente.setText(tabelaCliente.getModel().getValueAt(setar, 3).toString());
		
	
	}
	
	private void CadastrarCliente() {
		
		String nome,cpf,email;
		
		nome = txtNomeCliente.getText();
		cpf = txtCPF.getText();
		email = txtEmailCliente.getText();
		
		ClienteDTO objclientedto = new ClienteDTO();
		objclientedto.setNome_cliente(nome);
		objclientedto.setCpf(cpf);
		objclientedto.setEmail(email);
		
		ClienteDAO objclientedao = new ClienteDAO();
		objclientedao.cadastrarCliente(objclientedto);
		
	}
	
	private void LimparCampos() {
		
		txtCodigo.setText("");
		txtNomeCliente.setText("");
		txtCPF.setText("");
		txtEmailCliente.setText("");
		txtNomeCliente.requestFocus();
	}
	
	private void AlterarCliente() {
		
		int id_cliente;
		String nome_cliente, CPF, email_cliente;
		
		id_cliente = Integer.parseInt(txtCodigo.getText());
		nome_cliente = txtNomeCliente.getText();
		CPF = txtCPF.getText();
		email_cliente = txtEmailCliente.getText(); 
		
		ClienteDTO objclientedto = new ClienteDTO();
		
		objclientedto.setId_cliente(id_cliente);
		objclientedto.setNome_cliente(nome_cliente);
		objclientedto.setCpf(CPF);
		objclientedto.setEmail(email_cliente);
		
		ClienteDAO objclientedao = new ClienteDAO();
		objclientedao.AlterarCliente(objclientedto);
				
		
	}
	
	private void ExcluirCliente() {
		int id_cliente;
		
		id_cliente = Integer.parseInt(txtCodigo.getText());
		
		ClienteDTO objclientedto = new ClienteDTO();
		objclientedto.setId_cliente(id_cliente);
		
		ClienteDAO objclientedao = new ClienteDAO();
		objclientedao.ExcluirCliente(objclientedto);
		
	}
}
