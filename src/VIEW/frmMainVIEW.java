package VIEW;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.com.NewSystem.DAO.UsuarioDAO;
import br.com.NewSystem.DTO.UsuarioDTO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Event;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class frmMainVIEW extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeUsuario;
	private JPasswordField txtSenhaUsuario;

	// Executa o programa;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMainVIEW frame = new frmMainVIEW();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Cria a Janela do programa;
	public frmMainVIEW() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\logoCat.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do Usuário");
		lblNewLabel.setForeground(new Color(64, 0, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(33, 83, 133, 14);
		contentPane.add(lblNewLabel);
		
		txtNomeUsuario = new JTextField();
		txtNomeUsuario.setForeground(new Color(64, 0, 64));
		txtNomeUsuario.setBounds(33, 108, 151, 20);
		contentPane.add(txtNomeUsuario);
		txtNomeUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha do Usuário");
		lblNewLabel_1.setForeground(new Color(64, 0, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(35, 139, 133, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton txtbtnEntrarSistema = new JButton("LOGIN");
		txtbtnEntrarSistema.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtbtnEntrarSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Logar();
				
			}
		});
		txtbtnEntrarSistema.setBounds(95, 213, 89, 23);
		contentPane.add(txtbtnEntrarSistema);
		
		txtSenhaUsuario = new JPasswordField();
		txtSenhaUsuario.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				
			}
			});
		txtSenhaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				}
			
		});
		txtSenhaUsuario.setBounds(35, 164, 151, 20);
		contentPane.add(txtSenhaUsuario);
		
		JLabel lblLogo = new JLabel("");
		Image imgLogo = new ImageIcon(this.getClass().getResource("/logoCat.png")).getImage();
		lblLogo.setIcon(new ImageIcon(imgLogo));
		lblLogo.setBounds(226, 23, 138, 156);
		contentPane.add(lblLogo);
		
		JLabel lblCable = new JLabel("");
		Image imgCable = new ImageIcon(this.getClass().getResource("/cable.png")).getImage();
		lblCable.setIcon(new ImageIcon(imgCable));
		lblCable.setBounds(312, 164, 112, 72);
		contentPane.add(lblCable);
		
		JLabel lblNewLabel_2 = new JLabel("GatoNet");
		lblNewLabel_2.setForeground(new Color(64, 0, 128));
		lblNewLabel_2.setBackground(new Color(64, 0, 128));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setBounds(46, 11, 138, 44);
		contentPane.add(lblNewLabel_2);
	}
	
	private void Logar() {
		try {
			
			String nome_usuario,senha_usuario;
			
			nome_usuario = txtNomeUsuario.getText();
			senha_usuario = txtSenhaUsuario.getText();
			
			UsuarioDTO objusuariodto = new UsuarioDTO();
			objusuariodto.setNome_usuario(nome_usuario);
			objusuariodto.setSenha_usuario(senha_usuario);
			
			UsuarioDAO objusuariodao = new UsuarioDAO();
			ResultSet rsusuariodao = objusuariodao.autenticacaoUsuario(objusuariodto);
			
			if(rsusuariodao.next()) {
				//chamar tela que eu quero abrir.
				frmPrincipalVIEW ojbfmrprincipalview = new frmPrincipalVIEW();
				ojbfmrprincipalview.setVisible(true);
				
				dispose();
				
			}else {
				//Enviar mensagem dizendo incorreto.
				JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
			}
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "FRMLOGINVIEW" + erro);
			
		}
	}
}
