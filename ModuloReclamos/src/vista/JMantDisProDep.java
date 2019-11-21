package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import interfaces.EstadoInterface;
import interfaces.UbigeoInterface;
import mantenimiento.EstadoImpl;
import mantenimiento.UbigeoImpl;
import modelo.Departamento;
import modelo.Distrito;
import modelo.Estado;
import modelo.Provincia;


public class JMantDisProDep extends JFrame implements ActionListener {
	 UbigeoInterface ubigeoInterface = new UbigeoImpl();
	 EstadoInterface estadoInterface = new EstadoImpl();
	private int distritoSeleccionado;
	private JPanel contentPane;
	private JLabel lblApellidoPaterno;
	private JLabel lblNombre;
	private JScrollPane scrollPane;
	private JTable tblSalida;
	private DefaultTableModel modelo;
	private JButton btnBuscar;
	private JButton btnLimpiar;
	private JButton btnNewButton_1;
	private JLabel lblDetalleDelReclamo;
	private JButton btnAnalizarReclamo;
	private JComboBox cboDepartamento;
	private JComboBox cboProvincia;
	private JComboBox cboDistrito;
	private JLabel lblDepartamento;
	private JLabel lblProvincia;
	private JLabel lblSubMotivoRec;
	private JLabel label_2;
	private JComboBox cboEstado;
	private JLabel label_3;
	private JTextField txtResponsable;
	private JLabel label_4;
	private JTextField txtDepartamento;
	private JTextField txtProvincia;
	private JTextField txtDistrito;
	private JButton btnModificar;
	private JTextField txtFecActualizacion;
	private ArrayList<Departamento>departamentos;
	private ArrayList<Provincia>provincias; 
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
					JMantDisProDep frame = new JMantDisProDep();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public JMantDisProDep() throws SQLException {
		departamentos = ubigeoInterface.listaDepartamento();
		
		setTitle("ACTUALIZAR DISTRITO / PROVINCIA / DEPARTAMENTO ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane Consulta = new JDesktopPane();
		Consulta.setBackground(SystemColor.menu);
		contentPane.add(Consulta, BorderLayout.CENTER);
		
		lblApellidoPaterno = new JLabel("Provincia");
		lblApellidoPaterno.setBounds(10, 45, 79, 14);
		Consulta.add(lblApellidoPaterno);
		
		lblNombre = new JLabel("Departamento");
		lblNombre.setBounds(10, 15, 79, 14);
		Consulta.add(lblNombre);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 534, 200);
		Consulta.add(scrollPane);
		
		tblSalida = new JTable();
		tblSalida.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblSalida);
		
		modelo = new DefaultTableModel(); 
		modelo.addColumn("Departamento"); 
		modelo.addColumn("Provincia");
		modelo.addColumn("Distrito"); 
		modelo.addColumn("Estado"); 

		tblSalida.setModel(modelo);
		
		tblSalida.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				distritoSeleccionado = tblSalida.getSelectedRow();
				 if(distritoSeleccionado != -1) {
					 String codigoCliente = (String) modelo.getValueAt(distritoSeleccionado, 1);
					 
					 Vector vec =  (Vector) modelo.getDataVector().get(distritoSeleccionado);
					 seleccionarDistrito(vec);
					 
				 }
			}
		});
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(434, 24, 110, 23);
		Consulta.add(btnBuscar);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setBounds(434, 58, 110, 23);
		Consulta.add(btnLimpiar);
		
		btnNewButton_1 = new JButton("SALIR");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(434, 479, 110, 23);
		Consulta.add(btnNewButton_1);
		
		lblDetalleDelReclamo = new JLabel("Mantenimiento:");
		lblDetalleDelReclamo.setBounds(10, 317, 123, 14);
		Consulta.add(lblDetalleDelReclamo);
		
		btnAnalizarReclamo = new JButton("REGISTRAR");
		btnAnalizarReclamo.setBounds(186, 479, 110, 23);
		Consulta.add(btnAnalizarReclamo);
		
		cboDepartamento = new JComboBox();
		cboDepartamento.setBounds(80, 11, 289, 22);
		cboDepartamento.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				cargarProvincia(departamentos.get(cboDepartamento.getSelectedIndex()));
			}

        });
		Consulta.add(cboDepartamento);
		
		cboProvincia = new JComboBox();
		cboProvincia.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				cargarDistrito(provincias.get(cboProvincia.getSelectedIndex()));
				
			}
		});
		cboProvincia.setBounds(80, 41, 289, 22);
		Consulta.add(cboProvincia);
		
		lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(10, 340, 79, 14);
		Consulta.add(lblDepartamento);
		
		lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(288, 340, 79, 14);
		Consulta.add(lblProvincia);
		
		lblSubMotivoRec = new JLabel("Distrito");
		lblSubMotivoRec.setBounds(10, 384, 95, 14);
		Consulta.add(lblSubMotivoRec);
		
		label_2 = new JLabel("Estado");
		label_2.setBounds(390, 384, 46, 14);
		Consulta.add(label_2);
		
		cboEstado = new JComboBox();
		cboEstado.setEditable(false);
		cboEstado.setBounds(388, 400, 156, 20);
		Consulta.add(cboEstado);
		cboEstado.setEnabled(false);
		cargarEstado();
		
		
		label_3 = new JLabel("Responsable de Actualizaci\u00F3n");
		label_3.setBounds(10, 433, 156, 14);
		Consulta.add(label_3);
		
		txtResponsable = new JTextField();
		txtResponsable.setEditable(false);
		txtResponsable.setColumns(10);
		txtResponsable.setBounds(10, 448, 359, 20);
		Consulta.add(txtResponsable);
		
		label_4 = new JLabel("Fecha \u00DAltima Actualizaci\u00F3n");
		label_4.setBounds(390, 433, 148, 14);
		Consulta.add(label_4);
		
		txtDepartamento = new JTextField();
		txtDepartamento.setEditable(false);
		txtDepartamento.setBounds(10, 356, 260, 20);
		Consulta.add(txtDepartamento);
		txtDepartamento.setColumns(10);
		
		txtProvincia = new JTextField();
		txtProvincia.setEditable(false);
		txtProvincia.setBounds(284, 356, 260, 20);
		Consulta.add(txtProvincia);
		txtProvincia.setColumns(10);
		
		txtDistrito = new JTextField();
		txtDistrito.setEditable(false);
		txtDistrito.setBounds(10, 400, 359, 20);
		Consulta.add(txtDistrito);
		txtDistrito.setColumns(10);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(310, 479, 110, 23);
		Consulta.add(btnModificar);
		
		txtFecActualizacion = new JTextField();
		txtFecActualizacion.setEditable(false);
		txtFecActualizacion.setBounds(390, 448, 154, 20);
		Consulta.add(txtFecActualizacion);
		txtFecActualizacion.setColumns(10);
		
		cboDistrito = new JComboBox();
		cboDistrito.setBounds(80, 70, 289, 22);
		Consulta.add(cboDistrito);
		
		JLabel lblNewLabel = new JLabel("Distrito");
		lblNewLabel.setBounds(20, 71, 46, 14);
		Consulta.add(lblNewLabel);
		cargarDepartamento();
		//cargarProvincia();
		
	
	/*	modelo.setRowCount(0); 
		Object[] fila = {"Lima", "Callao", "La Perla","Activo"}; 
		modelo.addRow(fila);*/
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton_1) {
			actionPerformedBtnNewButton_1(arg0);
		}
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent arg0) {
	}
	
	public void cargarDepartamento()  {
		for(Departamento dep :  departamentos) {
			cboDepartamento.addItem(dep.getDescripcion());
		}
		
		cboDepartamento.setSelectedIndex(0);
	}
	public void cargarProvincia(Departamento dep){
		try {
			provincias = ubigeoInterface.listaProvincia(dep.getCodigo());/*cboDepartamento.getSelectedIndex()+1*/
			for(Provincia pro: provincias) {
				cboProvincia.addItem(pro.getDescripcion());
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cboProvincia.setSelectedIndex(0);
	}
	public void cargarDistrito(Provincia provincia) {
		try {
				cboDistrito.removeAllItems();
				limpiar();
				ArrayList<Distrito> distritos = ubigeoInterface.listaDistrito(provincia.getCodigo());
				for(Distrito dis: distritos) {
					cboDistrito.addItem(dis.getDescripcion());
					
					Object[]fila= {cboDepartamento.getSelectedItem(), cboProvincia.getSelectedItem(), dis.getDescripcion(), dis.getEstado().getDescripcion(), dis.getEstado().getCodigo()};
					modelo.addRow(fila);
				}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	void cargarEstado() {
		ArrayList<Estado> estados = estadoInterface.listaEstado();
		for(Estado es : estados) {
			cboEstado.addItem(es.getDescripcion());
		}
	}
	void limpiar() {
		int cantidadFila = modelo.getRowCount();
		if(cantidadFila >0) {
			modelo.setRowCount(0);
		}
	}
	private void seleccionarDistrito(Vector fila) {
		txtDepartamento.setText(fila.get(0).toString());
		txtProvincia.setText(fila.get(1).toString());
		txtDistrito.setText(fila.get(2).toString());
		if(fila.get(3).toString().toLowerCase().trim().equals("activo")) {
			cboEstado.setSelectedIndex(0);
		}else {
			cboEstado.setSelectedIndex(1);
		}
		
//		cboEstado.setSelectedIndex(codigo-1);
		// TODO Auto-generated method stub
		
	}
}
