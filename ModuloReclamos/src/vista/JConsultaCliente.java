package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import com.toedter.calendar.JDateChooser;

import interfaces.ClienteInterface;
import mantenimiento.ClienteImpl;
import modelo.Cliente;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class JConsultaCliente extends JDialog {
	
	ClienteInterface clienteInterface = new ClienteImpl();
	private int clienteSeleccionado;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtSuministro;
	private JTextField txtNombres;
	private JLabel lblNombre;
	private JTextField txtApellidos;
	private JButton btnBuscar;
	private JTextField txtNombres1;
	private JLabel lblNewLabel_2;
	private JButton btnLimpiar;
	private Component horizontalStrut;
	private JLabel lblApellidoPat;
	private JTextField txtApellidoPat;
	private JLabel lblDatosResultantes;
	private JLabel lblDoiPrincipal;
	private JTextField txtSuministro1;
	private JLabel lblDoiSecundario;
	private JTextField txtDoi1;
	private JLabel lblPredio;
	private JTextField txtDireccion;
	private JLabel lblNewLabel_4;
	private JTextField txtTelefonoCasa;
	private JLabel lblTelfonoCelular;
	private JTextField txtTelefonoCelular;
	private JLabel lblCorreoElctrnico;
	private JLabel lblDatosDeContacto;
	private JTextField txtCorreo;
	private JLabel lblFechaDeInscripcin;
	private JTextField txtFechaInscripcion;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private DefaultTableModel modelo;
	private JLabel lblInformacinDetalladaDe;
	private JButton btnSalir;
	private JButton btnRegistrarReclamo;
	private JLabel label;
	private JTextField txtResponsableAct;
	private JLabel label_1;
	private JTextField txtFechaAct;
	private JLabel label_2;
	private JTextField txtDoi;
	private JTextField txtApellidoMat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			JConsultaCliente dialog = new JConsultaCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JConsultaCliente() {
		setTitle("BUSCAR CLIENTE");
		setBounds(100, 100, 501, 660);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Suministro");
		lblNewLabel.setBounds(10, 11, 69, 14);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nombres");
		lblNewLabel_1.setBounds(10, 37, 69, 14);
		contentPanel.add(lblNewLabel_1);
		
		txtSuministro = new JTextField();
		txtSuministro.setBounds(77, 8, 108, 20);
		contentPanel.add(txtSuministro);
		txtSuministro.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(77, 34, 108, 20);
		contentPanel.add(txtNombres);
		txtNombres.setColumns(10);
		
		lblNombre = new JLabel("Apellidos");
		lblNombre.setBounds(195, 37, 46, 14);
		contentPanel.add(lblNombre);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(251, 34, 108, 20);
		contentPanel.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCliente();
			}
		});
		btnBuscar.setBounds(366, 8, 109, 23);
		contentPanel.add(btnBuscar);
		
		txtNombres1 = new JTextField();
		txtNombres1.setEditable(false);
		txtNombres1.setBounds(103, 304, 124, 20);
		contentPanel.add(txtNombres1);
		txtNombres1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(10, 304, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(366, 34, 109, 23);
		contentPanel.add(btnLimpiar);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(10, 93, 441, -2);
		contentPanel.add(horizontalStrut);
		
		lblApellidoPat = new JLabel("Apellido Paterno");
		lblApellidoPat.setBounds(237, 335, 91, 14);
		contentPanel.add(lblApellidoPat);
		
		txtApellidoPat = new JTextField();
		txtApellidoPat.setEditable(false);
		txtApellidoPat.setBounds(327, 332, 148, 20);
		contentPanel.add(txtApellidoPat);
		txtApellidoPat.setColumns(10);
		
		lblDatosResultantes = new JLabel("RESULTADOS :");
		lblDatosResultantes.setBounds(10, 77, 116, 14);
		contentPanel.add(lblDatosResultantes);
		
		lblDoiPrincipal = new JLabel("Suministro");
		lblDoiPrincipal.setBounds(10, 279, 69, 14);
		contentPanel.add(lblDoiPrincipal);
		
		txtSuministro1 = new JTextField();
		txtSuministro1.setEditable(false);
		txtSuministro1.setBounds(103, 276, 124, 20);
		contentPanel.add(txtSuministro1);
		txtSuministro1.setColumns(10);
		
		lblDoiSecundario = new JLabel("DOI");
		lblDoiSecundario.setBounds(247, 279, 81, 14);
		contentPanel.add(lblDoiSecundario);
		
		txtDoi1 = new JTextField();
		txtDoi1.setEditable(false);
		txtDoi1.setBounds(327, 276, 148, 20);
		contentPanel.add(txtDoi1);
		txtDoi1.setColumns(10);
		
		lblPredio = new JLabel("Direcci\u00F3n");
		lblPredio.setBounds(10, 363, 46, 14);
		contentPanel.add(lblPredio);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(77, 360, 382, 20);
		contentPanel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Tel\u00E9fono Casa");
		lblNewLabel_4.setBounds(10, 422, 69, 14);
		contentPanel.add(lblNewLabel_4);
		
		txtTelefonoCasa = new JTextField();
		txtTelefonoCasa.setEditable(false);
		txtTelefonoCasa.setBounds(105, 419, 122, 20);
		contentPanel.add(txtTelefonoCasa);
		txtTelefonoCasa.setColumns(10);
		
		lblTelfonoCelular = new JLabel("Tel\u00E9fono Celular");
		lblTelfonoCelular.setBounds(246, 422, 83, 14);
		contentPanel.add(lblTelfonoCelular);
		
		txtTelefonoCelular = new JTextField();
		txtTelefonoCelular.setEditable(false);
		txtTelefonoCelular.setBounds(327, 419, 148, 20);
		contentPanel.add(txtTelefonoCelular);
		txtTelefonoCelular.setColumns(10);
		
		lblCorreoElctrnico = new JLabel("Correo El\u00E9ctr\u00F3nico ");
		lblCorreoElctrnico.setBounds(10, 453, 100, 14);
		contentPanel.add(lblCorreoElctrnico);
		
		lblDatosDeContacto = new JLabel("DATOS DE CONTACTO:");
		lblDatosDeContacto.setBounds(10, 394, 116, 14);
		contentPanel.add(lblDatosDeContacto);
		
		txtCorreo = new JTextField();
		txtCorreo.setEditable(false);
		txtCorreo.setBounds(109, 450, 366, 20);
		contentPanel.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		lblFechaDeInscripcin = new JLabel("FECHA DE INSCRIPCI\u00D3N:");
		lblFechaDeInscripcin.setBounds(10, 486, 132, 14);
		contentPanel.add(lblFechaDeInscripcin);
		
		txtFechaInscripcion = new JTextField();
		txtFechaInscripcion.setEditable(false);
		txtFechaInscripcion.setBounds(109, 500, 366, 20);
		contentPanel.add(txtFechaInscripcion);
		txtFechaInscripcion.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 93, 354, 128);
		contentPanel.add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
		
		modelo= new DefaultTableModel();
		modelo.addColumn("Suministro");
		modelo.addColumn("DOI");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		tblTabla.setModel(modelo);

		tblTabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				 clienteSeleccionado = tblTabla.getSelectedRow();
				 if(clienteSeleccionado != -1) {
					 String codigoCliente = (String) modelo.getValueAt(clienteSeleccionado, 1);
					 seleccionarCliente(codigoCliente);
					 
				 }
			}
		});
		
		lblInformacinDetalladaDe = new JLabel("INFORMACI\u00D3N DETALLADA DE CLIENTE:");
		lblInformacinDetalladaDe.setBounds(10, 254, 354, 14);
		contentPanel.add(lblInformacinDetalladaDe);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JConsultaCliente.this.setVisible(false);
			}
		});
		btnSalir.setBounds(366, 577, 91, 23);
		contentPanel.add(btnSalir);
		
		btnRegistrarReclamo = new JButton("REGISTRAR RECLAMO");
		btnRegistrarReclamo.setBounds(10, 577, 199, 23);
		contentPanel.add(btnRegistrarReclamo);
		
		label = new JLabel("Responsable de Actualizaci\u00F3n");
		label.setBounds(10, 531, 156, 14);
		contentPanel.add(label);
		
		txtResponsableAct = new JTextField();
		txtResponsableAct.setEditable(false);
		txtResponsableAct.setColumns(10);
		txtResponsableAct.setBounds(10, 546, 307, 20);
		contentPanel.add(txtResponsableAct);
		
		label_1 = new JLabel("Fecha \u00DAltima Actualizaci\u00F3n");
		label_1.setBounds(327, 531, 148, 14);
		contentPanel.add(label_1);
		
		txtFechaAct = new JTextField();
		txtFechaAct.setEditable(false);
		txtFechaAct.setColumns(10);
		txtFechaAct.setBounds(327, 546, 148, 20);
		contentPanel.add(txtFechaAct);
		
		label_2 = new JLabel("DOI");
		label_2.setBounds(195, 11, 46, 14);
		contentPanel.add(label_2);
		
		txtDoi = new JTextField();
		txtDoi.setColumns(10);
		txtDoi.setBounds(251, 8, 108, 20);
		contentPanel.add(txtDoi);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setBounds(10, 338, 100, 14);
		contentPanel.add(lblApellidoMaterno);
		
		txtApellidoMat = new JTextField();
		txtApellidoMat.setEditable(false);
		txtApellidoMat.setColumns(10);
		txtApellidoMat.setBounds(103, 332, 124, 20);
		contentPanel.add(txtApellidoMat);
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	
	public void buscarCliente() {
		
		String documento = txtDoi.getText();
		if(documento.isEmpty()) documento = null;
		String nombre = txtNombres.getText();
		if(nombre.isEmpty()) nombre = null;
		String apellidos = txtApellidos.getText();
		if(apellidos.isEmpty()) apellidos = null;
		String suministro  = txtSuministro.getText();
		if(suministro.isEmpty()) suministro = null;
		
		
		
		ArrayList<Cliente> clientes = clienteInterface.obtenerCliente(documento, nombre, apellidos, suministro);
		limpiar(); 
		if(clientes.size()>0) {
			for(Cliente cli : clientes) {
				Object[] fila = {cli.getSuministroId(),cli.getDocumento(),
						cli.getNombre(),cli.getApellidoPaterno()+" "+cli.getApellidoMaterno()};
				modelo.addRow(fila);
			}
		}else {
			JOptionPane.showMessageDialog(null, "No existen clientes con los datos ingresados.");
		}	
	}
	
	public void limpiar() {

		int cantidadFilas = modelo.getRowCount();
		if(cantidadFilas >0 ) {
			modelo.setRowCount(0);
		}
		txtDoi.setText("");
		txtSuministro.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtSuministro1.setText("");
		txtDoi1.setText("");
		txtApellidoPat.setText("");
		txtApellidoMat.setText("");
		txtNombres1.setText("");
		txtDireccion.setText("");
		txtTelefonoCasa.setText("");
		txtTelefonoCelular.setText("");
		txtCorreo.setText("");
		txtFechaInscripcion.setText("");
		txtResponsableAct.setText("");
		txtFechaAct.setText("");
					
	}
	public void mostrarCliente(String documento) {
		int codigoPermiso = 20;
		
		
		Cliente cliente = clienteInterface.obtenerCliente(documento);
		if(cliente != null) {
			txtSuministro1.setText(cliente.getSuministroId().toString());
			txtDoi1.setText(cliente.getDocumento());
			txtApellidoPat.setText(cliente.getApellidoPaterno());
			txtApellidoMat.setText(cliente.getApellidoMaterno());
			txtNombres1.setText(cliente.getNombre());
			txtDireccion.setText(cliente.getDireccion());
			txtTelefonoCasa.setText(cliente.getTelefono());
			txtTelefonoCelular.setText(cliente.getCelular());
			txtCorreo.setText(cliente.getEmail());
			txtFechaInscripcion.setText(cliente.getFechaInscripcion().toGMTString());
//			txtResponsableAct.setText(Integer.toString(cliente.getEmpleado()));
			txtFechaAct.setText(cliente.getFechaActualizacion().toGMTString());
			
		}
	}
	
	public void seleccionarCliente(String documento) {
			mostrarCliente(documento);
	}
	
	public Cliente clienteEditado() {
		Cliente cli = new  Cliente();
		cli.setSuministroId(Integer.parseInt(txtSuministro1.getText()));
		cli.setDocumento(txtDoi1.getText());
		cli.setNombre(txtNombres1.getText());
		cli.setApellidoPaterno(txtApellidoPat.getText());
		cli.setApellidoMaterno(txtApellidoMat.getText());
		cli.setDireccion(txtDireccion.getText());
		cli.setTelefono(txtTelefonoCasa.getText());
		cli.setCelular(txtTelefonoCelular.getText());
		cli.setEmail(txtCorreo.getText());
		
		return cli;
	}
	
	public void habilitarEdicion() {
		//consultar si el suministro se asigna por la pantalla de mant. cliente
//		txtSuministro1.setEditable(true);
		txtDoi1.setEditable(true);
		txtNombres1.setEditable(true);
		txtApellidoPat.setEditable(true);
		txtApellidoMat.setEditable(true);
		txtDireccion.setEditable(true);
		txtTelefonoCasa.setEditable(true);
		txtTelefonoCelular.setEditable(true);
		txtCorreo.setEditable(true);
	}
	
	public void deshabilitarEdicion() {
//		txtSuministro1.setEditable(false);
		txtDoi1.setEditable(false);
		txtNombres1.setEditable(false);
		txtApellidoPat.setEditable(false);
		txtApellidoMat.setEditable(false);
		txtDireccion.setEditable(false);
		txtTelefonoCasa.setEditable(false);
		txtTelefonoCelular.setEditable(false);
		txtCorreo.setEditable(false);
	}
}
