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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;


public class JConsultaRecla extends JFrame {

	private JPanel contentPane;
	private JLabel lblNReclamo;
	private JTextField textField;
	private JLabel lblEstado;
	private JComboBox comboBox;
	private JLabel lblFechaReclamo;
	private JDateChooser dateChooser;
	private JLabel lblApellidoPaterno;
	private JTextField textField_1;
	private JLabel lblApMaterno;
	private JTextField textField_2;
	private JLabel lblNombre;
	private JTextField textField_3;
	private JScrollPane scrollPane;
	private JTable tblSalida;
	private DefaultTableModel modelo;
	private JButton btnNewButton;
	private JButton btnLimpiar;
	private JButton btnNewButton_1;
	private JLabel lblDetalleDelReclamo;
	private JTextArea txtAreaDetRecla;
	private JTextPane txtSalidaDetRecla;
	private JButton btnAnalizarReclamo;
	private JLabel lblSuministro;
	private JTextField textField_4;

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
					JConsultaRecla frame = new JConsultaRecla();
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
	public JConsultaRecla() {
		setTitle("CONSULTA RECLAMO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane Consulta = new JDesktopPane();
		Consulta.setBackground(SystemColor.menu);
		contentPane.add(Consulta, BorderLayout.CENTER);
		
		lblNReclamo = new JLabel("N\u00B0 Reclamo");
		lblNReclamo.setBounds(10, 11, 79, 14);
		Consulta.add(lblNReclamo);
		
		textField = new JTextField();
		textField.setBounds(80, 8, 95, 20);
		Consulta.add(textField);
		textField.setColumns(10);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(209, 11, 46, 14);
		Consulta.add(lblEstado);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Registro", "An\u00E1lisis", "Dict\u00E1minen"}));
		comboBox.setBounds(265, 8, 95, 20);
		Consulta.add(comboBox);
		
		lblFechaReclamo = new JLabel("Fecha Rec.");
		lblFechaReclamo.setBounds(10, 76, 79, 14);
		Consulta.add(lblFechaReclamo);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(80, 73, 95, 20);
		Consulta.add(dateChooser);
		
		lblApellidoPaterno = new JLabel("Ap. Paterno ");
		lblApellidoPaterno.setBounds(10, 45, 79, 14);
		Consulta.add(lblApellidoPaterno);
		
		textField_1 = new JTextField();
		textField_1.setBounds(80, 42, 95, 20);
		Consulta.add(textField_1);
		textField_1.setColumns(10);
		
		lblApMaterno = new JLabel("Ap. Materno");
		lblApMaterno.setBounds(193, 45, 68, 14);
		Consulta.add(lblApMaterno);
		
		textField_2 = new JTextField();
		textField_2.setBounds(264, 39, 95, 20);
		Consulta.add(textField_2);
		textField_2.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(386, 45, 46, 14);
		Consulta.add(lblNombre);
		
		textField_3 = new JTextField();
		textField_3.setBounds(449, 42, 95, 20);
		Consulta.add(textField_3);
		textField_3.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 534, 200);
		Consulta.add(scrollPane);
		
		tblSalida = new JTable();
		tblSalida.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblSalida);
		
		modelo = new DefaultTableModel(); 
		modelo.addColumn("N° Reclamo"); 
		modelo.addColumn("Reiterativo");
		modelo.addColumn("Suministro");
		modelo.addColumn("DOI"); 
		modelo.addColumn("Ap. Paterno"); 
		modelo.addColumn("Ap. Materno"); 
		modelo.addColumn("Nombre"); 
		modelo.addColumn("Tipo Rec.");
		modelo.addColumn("Fec. Rec.");
		tblSalida.setModel(modelo);
		
		btnNewButton = new JButton("BUSCAR");
		btnNewButton.setBounds(295, 70, 110, 23);
		Consulta.add(btnNewButton);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setBounds(434, 70, 110, 23);
		Consulta.add(btnLimpiar);
		
		btnNewButton_1 = new JButton("SALIR");
		btnNewButton_1.setBounds(434, 457, 110, 23);
		Consulta.add(btnNewButton_1);
		
		lblDetalleDelReclamo = new JLabel("Detalle del Reclamo:");
		lblDetalleDelReclamo.setBounds(10, 317, 123, 14);
		Consulta.add(lblDetalleDelReclamo);
		
		txtAreaDetRecla = new JTextArea();
		txtAreaDetRecla.setBounds(10, 342, 534, 106);
		Consulta.add(txtAreaDetRecla);
		
		txtSalidaDetRecla = new JTextPane();
		txtSalidaDetRecla.setBounds(10, 342, 534, 106);
		Consulta.add(txtSalidaDetRecla);
		
		btnAnalizarReclamo = new JButton("ANALIZAR RECLAMO");
		btnAnalizarReclamo.setBounds(10, 457, 174, 23);
		Consulta.add(btnAnalizarReclamo);
		
		lblSuministro = new JLabel("Suministro");
		lblSuministro.setBounds(386, 11, 59, 14);
		Consulta.add(lblSuministro);
		
		textField_4 = new JTextField();
		textField_4.setBounds(449, 8, 95, 20);
		Consulta.add(textField_4);
		textField_4.setColumns(10);
		
	
		modelo.setRowCount(0); 
		Object[] fila = { 100,58,"902785","10801753", "Ana", "Mendez", "Torres", "No Pago","12/05/2019" }; 
		modelo.addRow(fila);
	}
}
