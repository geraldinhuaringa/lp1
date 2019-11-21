package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import interfaces.UsuarioInterface;
import interfaces.PerfilInterface;
import interfaces.SucursalInterface;
import mantenimiento.PerfilImpl;
import mantenimiento.SucursalImpl;
import mantenimiento.UsuarioImpl;
import modelo.Cliente;
import modelo.Usuario;
import modelo.Perfil;
import modelo.Sucursal;

import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class JMantUsuarioClave extends JFrame implements ActionListener {
	UsuarioInterface usuarioInterface = new UsuarioImpl();
	private SucursalInterface sucursalInterface = new  SucursalImpl();
	private PerfilInterface perfilInterface = new  PerfilImpl();
	private JPanel contentPane;
	private JLabel lblApellidoPaterno;
	private JLabel lblNombre;
	private JScrollPane scrollPane;
	private JTable tblSalida;
	private DefaultTableModel modelo;
	private JButton btnNewButton;
	private JButton btnLimpiar;
	private JButton btnNewButton_1;
	private JLabel lblDetalleDelReclamo;
	private JButton btnAnalizarReclamo;
	private JComboBox cboPerfil_1;
	private JComboBox cboEstado_1;
	private JLabel lblDepartamento;
	private JLabel lblProvincia;
	private JLabel lblSubMotivoRec;
	private JLabel lblPerfil;
	private JComboBox cboPerfil_2;
	private JLabel label_3;
	private JTextField txtResponsable;
	private JLabel label_4;
	private JTextField txtIdEmpleado;
	private JTextField txtApePaterno;
	private JTextField txtNombre_2;
	private JButton btnModificar;
	private JLabel lblNombre1;
	private JTextField txtNombre_1;
	private JTextField txtApeMaterno;
	private JLabel lblApellido;
	private JLabel lblNewLabel;
	private JTextField txtPassword;
	private JLabel lblPassword;
	private JLabel lblEstado;
	private JComboBox cboEstado_2;
	private JTextField textFechaAct;
	private JComboBox cboSucursal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMantUsuarioClave frame = new JMantUsuarioClave();
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
	public JMantUsuarioClave() {
		
		setTitle("ACTUALIZAR USUARIO / CLAVE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane Consulta = new JDesktopPane();
		Consulta.setBackground(SystemColor.menu);
		contentPane.add(Consulta, BorderLayout.CENTER);
		
		lblApellidoPaterno = new JLabel("Estado");
		lblApellidoPaterno.setBounds(10, 45, 79, 14);
		Consulta.add(lblApellidoPaterno);
		
		lblNombre = new JLabel("Perfil");
		lblNombre.setBounds(10, 15, 63, 14);
		Consulta.add(lblNombre);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 534, 200);
		Consulta.add(scrollPane);
		
		tblSalida = new JTable();
		tblSalida.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblSalida);
		
		modelo = new DefaultTableModel(); 
		modelo.addColumn("Nombre"); 
		modelo.addColumn("Apellidos");
		modelo.addColumn("Sucursal"); 
		modelo.addColumn("Perfil"); 

		tblSalida.setModel(modelo);
		
		btnNewButton = new JButton("BUSCAR");
		btnNewButton.setBounds(434, 24, 110, 23);
		Consulta.add(btnNewButton);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setBounds(434, 58, 110, 23);
		Consulta.add(btnLimpiar);
		
		btnNewButton_1 = new JButton("SALIR");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(434, 527, 110, 23);
		Consulta.add(btnNewButton_1);
		
		lblDetalleDelReclamo = new JLabel("Mantenimiento:");
		lblDetalleDelReclamo.setBounds(10, 317, 123, 14);
		Consulta.add(lblDetalleDelReclamo);
		
		btnAnalizarReclamo = new JButton("REGISTRAR");
		btnAnalizarReclamo.setBounds(196, 527, 110, 23);
		Consulta.add(btnAnalizarReclamo);
		
		cboPerfil_1 = new JComboBox();
		cboPerfil_1.setBounds(80, 11, 289, 22);
		Consulta.add(cboPerfil_1);
		
		cboEstado_1 = new JComboBox();
		cboEstado_1.setBounds(80, 41, 289, 22);
		Consulta.add(cboEstado_1);
		
		lblDepartamento = new JLabel("ID Empleado");
		lblDepartamento.setBounds(10, 340, 79, 14);
		Consulta.add(lblDepartamento);
		
		lblProvincia = new JLabel("Apellido Paterno");
		lblProvincia.setBounds(115, 340, 110, 14);
		Consulta.add(lblProvincia);
		
		lblSubMotivoRec = new JLabel("Nombre");
		lblSubMotivoRec.setBounds(10, 384, 95, 14);
		Consulta.add(lblSubMotivoRec);
		
		lblPerfil = new JLabel("Perfil");
		lblPerfil.setBounds(390, 384, 46, 14);
		Consulta.add(lblPerfil);
		
		cboPerfil_2 = new JComboBox();
		cboPerfil_2.setBounds(388, 400, 156, 20);
		Consulta.add(cboPerfil_2);
		
		label_3 = new JLabel("Responsable de Actualizaci\u00F3n");
		label_3.setBounds(10, 481, 156, 14);
		Consulta.add(label_3);
		
		txtResponsable = new JTextField();
		txtResponsable.setEditable(false);
		txtResponsable.setColumns(10);
		txtResponsable.setBounds(10, 496, 359, 20);
		Consulta.add(txtResponsable);
		
		label_4 = new JLabel("Fecha \u00DAltima Actualizaci\u00F3n");
		label_4.setBounds(390, 481, 148, 14);
		Consulta.add(label_4);
		
		txtIdEmpleado = new JTextField();
		txtIdEmpleado.setEditable(false);
		txtIdEmpleado.setBounds(10, 356, 96, 20);
		Consulta.add(txtIdEmpleado);
		txtIdEmpleado.setColumns(10);
		
		txtApePaterno = new JTextField();
		txtApePaterno.setBounds(115, 356, 211, 20);
		Consulta.add(txtApePaterno);
		txtApePaterno.setColumns(10);
		
		txtNombre_2 = new JTextField();
		txtNombre_2.setBounds(10, 400, 178, 20);
		Consulta.add(txtNombre_2);
		txtNombre_2.setColumns(10);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(316, 527, 110, 23);
		Consulta.add(btnModificar);
		
		lblNombre1 = new JLabel("Nombre");
		lblNombre1.setBounds(10, 74, 54, 14);
		Consulta.add(lblNombre1);
		
		txtNombre_1 = new JTextField();
		txtNombre_1.setBounds(80, 71, 287, 20);
		Consulta.add(txtNombre_1);
		txtNombre_1.setColumns(10);
		
		txtApeMaterno = new JTextField();
		txtApeMaterno.setColumns(10);
		txtApeMaterno.setBounds(333, 356, 211, 20);
		Consulta.add(txtApeMaterno);
		
		lblApellido = new JLabel("Apellido Materno");
		lblApellido.setBounds(334, 340, 86, 14);
		Consulta.add(lblApellido);
		
		lblNewLabel = new JLabel("Sucursal");
		lblNewLabel.setBounds(210, 384, 46, 14);
		Consulta.add(lblNewLabel);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(10, 443, 178, 20);
		Consulta.add(txtPassword);
		txtPassword.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 427, 46, 14);
		Consulta.add(lblPassword);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(200, 427, 46, 14);
		Consulta.add(lblEstado);
		
		cboEstado_2 = new JComboBox();
		cboEstado_2.setBounds(200, 443, 178, 20);
		Consulta.add(cboEstado_2);
		
		textFechaAct = new JTextField();
		textFechaAct.setEditable(false);
		textFechaAct.setBounds(390, 496, 154, 20);
		Consulta.add(textFechaAct);
		textFechaAct.setColumns(10);
		
		cboSucursal = new JComboBox();
		cboSucursal.setBounds(201, 399, 178, 22);
		Consulta.add(cboSucursal);
		
	
		modelo.setRowCount(0); 
		Object[] fila = {"Lima", "Callao", "La Perla","Activo"}; 
		modelo.addRow(fila);
		
		cargarPerfil();
		cargarSucursal();
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton_1) {
			actionPerformedBtnNewButton_1(arg0);
		}
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent arg0) {
	}
	
	public void cargarSucursal() {
		
		try {
			ArrayList<Sucursal> lista = sucursalInterface.listaSucursal();
			System.out.println(lista.size());
			for(Sucursal su : lista) {
				System.out.println(su.getDescripcion());
				cboSucursal.addItem(su.getDescripcion());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void cargarPerfil() {
		try {
			ArrayList<Perfil> lista = perfilInterface.listaPerfil();
			for(Perfil per : lista) {
				cboPerfil_1.addItem(per.getDescripcion());
				cboPerfil_2.addItem(per.getDescripcion());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void buscarUsuario	() {
	
		String nombres = txtNombre_1.getText();
		if(nombres.isEmpty()) nombres =null;
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>(); //= UsuarioInterface.obtenerUsuario(nombres);
		if(usuarios.size()>0) {
			for(Usuario u : usuarios) {
				Object[]fila= {u.getNomEmp()+" "+u.getNomEmp()+" "+u.getApePatemp()+" "+u.getApeMatEmp()};
				modelo.addRow(fila);
		}
	}else {
		JOptionPane.showMessageDialog(null, "no existen usuario con datos ingresados");
		
	}
}
	
	
	
}
