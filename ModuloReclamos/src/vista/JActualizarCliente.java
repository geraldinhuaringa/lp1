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
import javax.xml.crypto.dom.DOMURIReference;
import javax.swing.UIManager;
import com.toedter.calendar.JDateChooser;

import interfaces.ClienteInterface;
import mantenimiento.ClienteImpl;
import modelo.Cliente;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class JActualizarCliente extends JDialog {
ClienteInterface clienteInterface = new ClienteImpl();
	private int clienteSeleccionado;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblSuministro;
	private JLabel lblNombres;
	private JTextField txtSuministro;
	private JTextField txtNombres;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JButton btnBuscar;
	private JTextField txtNombre1;
	private JLabel lblNombre1;
	private JButton btnLimpiar;
	private Component horizontalStrut;
	private JLabel lblApellidoMat;
	private JTextField txtApellidoMat;
	private JLabel lblDatosResultantes;
	private JLabel lblSuministro1;
	private JTextField txtSuministro1;
	private JLabel lblDoiSecundario;
	private JTextField txtDoi1;
	private JLabel lblDireccion;
	private JTextField txtDireccion;
	private JLabel lblTelefCasa;
	private JTextField txtTelefCasa;
	private JLabel lblTelefCel;
	private JTextField txtTelefCel;
	private JLabel lblCorreo;
	private JLabel lblDatosDeContacto;
	private JTextField txtCorreo;
	private JLabel lblFechaInscrip;
	private JTextField txtFechaInscrip;
	private JScrollPane scrollPane;
	private JTable tblT;
	private DefaultTableModel modelo;
	private JButton btnMostrar;
	private JLabel lblInformacinDetalladaDe;
	private JButton btnSalir;
	private JButton btnRegistrarReclamo;
	private JLabel lblRespAct;
	private JTextField txtRespAct;
	private JLabel lblFechAct;
	private JTextField txtFechaAct;
	private JLabel lblDoi;
	private JTextField txtDoi;
	private JTextField txtApellidoPat;

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
			JActualizarCliente dialog = new JActualizarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JActualizarCliente() {
		setTitle("ACTUALIZAR CLIENTE");
		setBounds(100, 100, 501, 666);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblSuministro = new JLabel("Suministro");
		lblSuministro.setBounds(10, 11, 69, 14);
		contentPanel.add(lblSuministro);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(10, 37, 69, 14);
		contentPanel.add(lblNombres);
		
		txtSuministro = new JTextField();
		txtSuministro.setBounds(77, 8, 108, 20);
		contentPanel.add(txtSuministro);
		txtSuministro.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(77, 34, 108, 20);
		contentPanel.add(txtNombres);
		txtNombres.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(195, 37, 46, 14);
		contentPanel.add(lblApellidos);
		
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
		
		txtNombre1 = new JTextField();
		txtNombre1.setBounds(87, 301, 124, 20);
		contentPanel.add(txtNombre1);
		txtNombre1.setColumns(10);
		
		lblNombre1 = new JLabel("Nombre");
		lblNombre1.setBounds(10, 304, 46, 14);
		contentPanel.add(lblNombre1);
		
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
		
		lblApellidoMat = new JLabel("Apellido Materno");
		lblApellidoMat.setBounds(246, 335, 81, 14);
		contentPanel.add(lblApellidoMat);
		
		txtApellidoMat = new JTextField();
		txtApellidoMat.setBounds(327, 332, 148, 20);
		contentPanel.add(txtApellidoMat);
		txtApellidoMat.setColumns(10);
		
		lblDatosResultantes = new JLabel("RESULTADOS :");
		lblDatosResultantes.setBounds(10, 77, 116, 14);
		contentPanel.add(lblDatosResultantes);
		
		lblSuministro1 = new JLabel("Suministro");
		lblSuministro1.setBounds(10, 273, 69, 14);
		contentPanel.add(lblSuministro1);
		
		txtSuministro1 = new JTextField();
		txtSuministro1.setBounds(87, 270, 124, 20);
		contentPanel.add(txtSuministro1);
		txtSuministro1.setColumns(10);
		
		lblDoiSecundario = new JLabel("DOI");
		lblDoiSecundario.setBounds(246, 273, 81, 14);
		contentPanel.add(lblDoiSecundario);
		
		txtDoi1 = new JTextField();
		txtDoi1.setBounds(327, 270, 148, 20);
		contentPanel.add(txtDoi1);
		txtDoi1.setColumns(10);
		
		lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(10, 366, 46, 14);
		contentPanel.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(87, 363, 388, 20);
		contentPanel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		lblTelefCasa = new JLabel("Tel\u00E9fono Casa");
		lblTelefCasa.setBounds(10, 419, 69, 14);
		contentPanel.add(lblTelefCasa);
		
		txtTelefCasa = new JTextField();
		txtTelefCasa.setBounds(87, 416, 124, 20);
		contentPanel.add(txtTelefCasa);
		txtTelefCasa.setColumns(10);
		
		lblTelefCel = new JLabel("Tel\u00E9fono Celular");
		lblTelefCel.setBounds(246, 422, 83, 14);
		contentPanel.add(lblTelefCel);
		
		txtTelefCel = new JTextField();
		txtTelefCel.setBounds(327, 419, 148, 20);
		contentPanel.add(txtTelefCel);
		txtTelefCel.setColumns(10);
		
		lblCorreo = new JLabel("Correo El\u00E9ctr\u00F3nico ");
		lblCorreo.setBounds(10, 453, 100, 14);
		contentPanel.add(lblCorreo);
		
		lblDatosDeContacto = new JLabel("DATOS DE CONTACTO:");
		lblDatosDeContacto.setBounds(10, 394, 116, 14);
		contentPanel.add(lblDatosDeContacto);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(109, 450, 366, 20);
		contentPanel.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		lblFechaInscrip = new JLabel("FECHA DE INSCRIPCI\u00D3N:");
		lblFechaInscrip.setBounds(10, 481, 132, 14);
		contentPanel.add(lblFechaInscrip);
		
		txtFechaInscrip = new JTextField();
		txtFechaInscrip.setBounds(109, 506, 366, 20);
		contentPanel.add(txtFechaInscrip);
		txtFechaInscrip.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 93, 354, 128);
		contentPanel.add(scrollPane);
		
		tblT = new JTable();
		tblT.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblT);
		
		modelo= new DefaultTableModel();
		modelo.addColumn("Suministro");
		modelo.addColumn("DOI");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		tblT.setModel(modelo);
		
		tblT.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				 clienteSeleccionado = tblT.getSelectedRow();
				 if(clienteSeleccionado != -1) {
					 String codigoCliente = (String) modelo.getValueAt(clienteSeleccionado, 1);
					 seleccionarCliente(codigoCliente);
					 
				 }
			}
		});
		
		btnMostrar = new JButton("ACTUALIZAR");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarCliente();
			
			}
		});
		btnMostrar.setBounds(372, 93, 103, 23);
		contentPanel.add(btnMostrar);
		
		lblInformacinDetalladaDe = new JLabel("INFORMACI\u00D3N DETALLADA DE CLIENTE:");
		lblInformacinDetalladaDe.setBounds(10, 233, 354, 14);
		contentPanel.add(lblInformacinDetalladaDe);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(384, 593, 91, 23);
		contentPanel.add(btnSalir);
		
		btnRegistrarReclamo = new JButton("REGISTRAR RECLAMO");
		btnRegistrarReclamo.setBounds(10, 593, 199, 23);
		contentPanel.add(btnRegistrarReclamo);
		
		lblRespAct = new JLabel("Responsable de Actualizaci\u00F3n");
		lblRespAct.setBounds(10, 537, 156, 14);
		contentPanel.add(lblRespAct);
		
		txtRespAct = new JTextField();
		txtRespAct.setEditable(false);
		txtRespAct.setColumns(10);
		txtRespAct.setBounds(10, 562, 307, 20);
		contentPanel.add(txtRespAct);
		
		lblFechAct = new JLabel("Fecha \u00DAltima Actualizaci\u00F3n");
		lblFechAct.setBounds(327, 537, 148, 14);
		contentPanel.add(lblFechAct);
		
		txtFechaAct = new JTextField();
		txtFechaAct.setEditable(false);
		txtFechaAct.setColumns(10);
		txtFechaAct.setBounds(327, 562, 148, 20);
		contentPanel.add(txtFechaAct);
		
		lblDoi = new JLabel("DOI");
		lblDoi.setBounds(195, 11, 46, 14);
		contentPanel.add(lblDoi);
		
		txtDoi = new JTextField();
		txtDoi.setColumns(10);
		txtDoi.setBounds(251, 8, 108, 20);
		contentPanel.add(txtDoi);
		
		txtApellidoPat = new JTextField();
		txtApellidoPat.setColumns(10);
		txtApellidoPat.setBounds(87, 332, 124, 20);
		contentPanel.add(txtApellidoPat);
		
		JLabel lblApellidoPat = new JLabel("Apellido Paterno");
		lblApellidoPat.setBounds(10, 335, 81, 14);
		contentPanel.add(lblApellidoPat);
		
	//	modelo.setRowCount(0);
		//Object[] fila = {"907215","10801753","Karen", "Aldazabal"};
	//	modelo.addRow(fila);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	
	public void buscarCliente() {
		String documento = txtDoi.getText();
		if(documento.isEmpty()) documento =null;
		String nombre = txtNombres.getText();
		if(nombre.isEmpty()) nombre =null;
		String apellidos = txtApellidos.getText();
		if(apellidos.isEmpty()) apellidos =null;
		String suministro = txtSuministro.getText();
		if(suministro.isEmpty()) suministro =null;
		
		ArrayList<Cliente> clientes = clienteInterface.obtenerCliente(documento,nombre,apellidos,suministro);
		limpiar();
		if(clientes.size()>0) {
			for(Cliente cli : clientes) {
				Object[]fila= {cli.getSuministroId(),cli.getDocumento(),cli.getNombre(),cli.getApellidoPaterno()+" "+cli.getApellidoMaterno()};
				modelo.addRow(fila);
		}
	}else {
		JOptionPane.showMessageDialog(null, "no existen clientes con datos ingresados");
		
	}
}
	
	public void limpiar() {
		int cantidadFila = modelo.getRowCount();
		if(cantidadFila >0) {
			modelo.setRowCount(0);
		}
		deshabilitarEdicion();
		txtSuministro.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDoi.setText("");
		txtSuministro1.setText("");
		txtDoi1.setText("");
		txtApellidoPat.setText("");
		txtApellidoMat.setText("");
		txtNombre1.setText("");
		txtDireccion.setText("");
		txtTelefCasa.setText("");
		txtTelefCel.setText("");
		txtCorreo.setText("");
		txtFechaInscrip.setText("");
		txtRespAct.setText("");
		txtFechaAct.setText("");
}
	
	public void mostrarCliente(String documento) {
		
		
		Cliente cli = clienteInterface.obtenerCliente(documento);
		if(cli!=null) {
			txtSuministro1.setText(cli.getSuministroId().toString());
			txtDoi1.setText(cli.getDocumento());;
			txtApellidoPat.setText(cli.getApellidoPaterno());
			txtApellidoMat.setText(cli.getApellidoMaterno());
			txtNombre1.setText(cli.getNombre());
			txtDireccion.setText(cli.getDireccion());
			txtTelefCasa.setText(cli.getTelefono());
			txtTelefCel.setText(cli.getCelular());
			txtCorreo.setText(cli.getEmail());
			txtFechaInscrip.setText(cli.getFechaInscripcion().toGMTString());
			txtRespAct.setText(cli.getEmpleado().getNomEmp());
			txtFechaAct.setText(cli.getFechaActualizacion().toGMTString());
			
		}}
		
		public void actualizarCliente() {
			if(clienteSeleccionado != -1) {
				String documento  = (String) modelo.getValueAt(clienteSeleccionado, 1);
				Cliente clienteEditado = clienteEditado();
				clienteEditado.setDocumentoAntiguo(documento);
				int resultado = clienteInterface.actualizarCliente(clienteEditado);
				if(resultado > 0 ) {
					deshabilitarEdicion();
					buscarCliente();
					JOptionPane.showMessageDialog(null, "La actualización fue exitosa.");
				}else {
					JOptionPane.showMessageDialog(null, "Hubo un error en la actualización.");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Seleccionar un cliente");
			}
			
		}
		
		public void seleccionarCliente(String documento) {

			int resultadoDialogo = JOptionPane
					.showConfirmDialog(null, "¿Desea actualizar el cliente?");
			if(resultadoDialogo == JOptionPane.YES_OPTION) {
				mostrarCliente(documento);
				habilitarEdicion();
			}
		}
		
		public Cliente clienteEditado() {
			Cliente cli = new  Cliente();
			cli.setSuministroId(Integer.parseInt(txtSuministro1.getText()));
			cli.setDocumento(txtDoi1.getText());
			cli.setNombre(txtNombre1.getText());
			cli.setApellidoPaterno(txtApellidoPat.getText());
			cli.setApellidoMaterno(txtApellidoMat.getText());
			cli.setDireccion(txtDireccion.getText());
			cli.setTelefono(txtTelefCasa.getText());
			cli.setCelular(txtTelefCel.getText());
			cli.setEmail(txtCorreo.getText());
			
			return cli;
		}
		
		public void habilitarEdicion() {
			//consultar si el suministro se asigna por la pantalla de mant. cliente
//			txtSuministro1.setEditable(true);
			txtDoi1.setEditable(true);
			txtNombre1.setEditable(true);
			txtApellidoPat.setEditable(true);
			txtApellidoMat.setEditable(true);
			txtDireccion.setEditable(true);
			txtTelefCasa.setEditable(true);
			txtTelefCel.setEditable(true);
			txtCorreo.setEditable(true);
		}
		
		public void deshabilitarEdicion() {
//			txtSuministro1.setEditable(false);
			txtDoi1.setEditable(false);
			txtNombre1.setEditable(false);
			txtApellidoPat.setEditable(false);
			txtApellidoMat.setEditable(false);
			txtDireccion.setEditable(false);
			txtTelefCasa.setEditable(false);
			txtTelefCel.setEditable(false);
			txtCorreo.setEditable(false);
		}
	}
