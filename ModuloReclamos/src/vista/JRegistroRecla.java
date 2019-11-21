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


public class JRegistroRecla extends JFrame {

	private JPanel contentPane;
	private JLabel lblNReclamo;
	private JTextField textField;
	private JLabel lblEstado;
	private JComboBox cboEstado;
	private JLabel lblFechaReclamo;
	private JDateChooser dateChooser;
	private JLabel lblApellidoPaterno;
	private JTextField textField_1;
	private JLabel lblApMaterno;
	private JTextField textField_2;
	private JLabel lblNombre;
	private JTextField textField_3;
	private DefaultTableModel modelo;
	private JButton btnNewButton;
	private JButton btnLimpiar;
	private JLabel lblDoi;
	private JTextField textField_4;
	private JLabel lblTipoDireccin;
	private JComboBox cboTipo;
	private JLabel lblDire;
	private JLabel lblNewLabel;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblCelular;
	private JTextField textField_7;
	private JLabel lblEmail;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JLabel lblNewLabel_1;
	private JLabel lblN;
	private JTextField textField_11;
	private JLabel lblDpto;
	private JLabel lblNewLabel_2;
	private JTextField textField_12;
	private JTextField textField_13;
	private JLabel lblProvincia;
	private JTextField textField_14;
	private JLabel lblDistrito;
	private JLabel lblDatosDelReclamo;
	private JLabel lblTipoRec;
	private JComboBox cboTipoRec;
	private JComboBox cboTipoMot;
	private JLabel lblTipoMotivo;
	private JComboBox comboBox;
	private JLabel lblTipoSubMotivo;
	private JLabel lblReclamoMonetario;
	private JComboBox cboRecMonetario;
	private JLabel lblImporte;
	private JTextField textField_18;
	private JLabel lblModalidadAtencin;
	private JComboBox cboModAtencion;
	private JLabel lblFundamentoDelReclamo;
	private JLabel lblNewLabel_3;
	private JTextField textField_20;
	private JTextField textField_21;
	private JLabel lblEmpleado;
	private JTextField textField_15;
	private JLabel lblReiterativo;
	private JTextField textField_16;
	private JLabel lblSiLaDireccin;
	private JTextArea txtAreaFun;
	private JTextPane txtPaneFun;

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
					JRegistroRecla frame = new JRegistroRecla();
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
	public JRegistroRecla() {
		setTitle("REGISTRO DE RECLAMO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 626);
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
		textField.setEditable(false);
		textField.setBounds(80, 8, 95, 20);
		Consulta.add(textField);
		textField.setColumns(10);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(379, 11, 46, 14);
		Consulta.add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Registro", "An\u00E1lisis", "Dict\u00E1minen"}));
		cboEstado.setBounds(449, 8, 95, 20);
		Consulta.add(cboEstado);
		
		lblFechaReclamo = new JLabel("Fec. Reclamo");
		lblFechaReclamo.setBounds(445, 354, 79, 14);
		Consulta.add(lblFechaReclamo);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(445, 369, 95, 20);
		Consulta.add(dateChooser);
		
		lblApellidoPaterno = new JLabel("Ap. Paterno ");
		lblApellidoPaterno.setBounds(370, 45, 79, 14);
		Consulta.add(lblApellidoPaterno);
		
		textField_1 = new JTextField();
		textField_1.setBounds(80, 42, 95, 20);
		Consulta.add(textField_1);
		textField_1.setColumns(10);
		
		lblApMaterno = new JLabel("Ap. Materno");
		lblApMaterno.setBounds(10, 79, 68, 14);
		Consulta.add(lblApMaterno);
		
		textField_2 = new JTextField();
		textField_2.setBounds(264, 42, 95, 20);
		Consulta.add(textField_2);
		textField_2.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(195, 83, 46, 14);
		Consulta.add(lblNombre);
		
		textField_3 = new JTextField();
		textField_3.setBounds(449, 42, 95, 20);
		Consulta.add(textField_3);
		textField_3.setColumns(10);
		
		modelo = new DefaultTableModel(); 
		modelo.addColumn("N° Reclamo"); 
		modelo.addColumn("DOI"); 
		modelo.addColumn("Ap. Paterno"); 
		modelo.addColumn("Ap. Materno"); 
		modelo.addColumn("Nombre"); 
		modelo.addColumn("Tipo Rec.");
		modelo.addColumn("Fec. Rec.");
		
		btnNewButton = new JButton("REGISTRAR");
		btnNewButton.setBounds(300, 545, 110, 23);
		Consulta.add(btnNewButton);
		
		btnLimpiar = new JButton("SALIR");
		btnLimpiar.setBounds(434, 545, 110, 23);
		Consulta.add(btnLimpiar);
		
		lblDoi = new JLabel("DOI");
		lblDoi.setBounds(10, 45, 46, 14);
		Consulta.add(lblDoi);
		
		textField_4 = new JTextField();
		textField_4.setBounds(80, 76, 95, 20);
		Consulta.add(textField_4);
		textField_4.setColumns(10);
		
		lblTipoDireccin = new JLabel("Tipo ");
		lblTipoDireccin.setBounds(10, 141, 79, 14);
		Consulta.add(lblTipoDireccin);
		
		cboTipo = new JComboBox();
		cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Av.", "Jr.", "Calle"}));
		cboTipo.setBounds(10, 155, 46, 22);
		Consulta.add(cboTipo);
		
		lblDire = new JLabel("Suministro");
		lblDire.setBounds(195, 45, 65, 14);
		Consulta.add(lblDire);
		
		lblNewLabel = new JLabel("Tel\u00E9fono Fijo");
		lblNewLabel.setBounds(370, 83, 65, 14);
		Consulta.add(lblNewLabel);
		
		textField_5 = new JTextField();
		textField_5.setBounds(265, 76, 95, 20);
		Consulta.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(449, 76, 95, 20);
		Consulta.add(textField_6);
		textField_6.setColumns(10);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setBounds(10, 113, 46, 14);
		Consulta.add(lblCelular);
		
		textField_7 = new JTextField();
		textField_7.setBounds(80, 110, 95, 20);
		Consulta.add(textField_7);
		textField_7.setColumns(10);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(195, 113, 46, 14);
		Consulta.add(lblEmail);
		
		textField_8 = new JTextField();
		textField_8.setBounds(265, 110, 279, 20);
		Consulta.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(80, 156, 226, 20);
		Consulta.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(314, 156, 46, 20);
		Consulta.add(textField_10);
		textField_10.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Direcci\u00F3n");
		lblNewLabel_1.setBounds(80, 141, 46, 14);
		Consulta.add(lblNewLabel_1);
		
		lblN = new JLabel("N\u00B0");
		lblN.setBounds(321, 141, 39, 14);
		Consulta.add(lblN);
		
		textField_11 = new JTextField();
		textField_11.setBounds(370, 157, 170, 20);
		Consulta.add(textField_11);
		textField_11.setColumns(10);
		
		lblDpto = new JLabel("Urbanizaci\u00F3n");
		lblDpto.setBounds(370, 142, 79, 14);
		Consulta.add(lblDpto);
		
		lblNewLabel_2 = new JLabel("Departamento");
		lblNewLabel_2.setBounds(10, 188, 86, 14);
		Consulta.add(lblNewLabel_2);
		
		textField_12 = new JTextField();
		textField_12.setBounds(10, 201, 170, 20);
		Consulta.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(189, 201, 170, 20);
		Consulta.add(textField_13);
		textField_13.setColumns(10);
		
		lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(189, 187, 46, 14);
		Consulta.add(lblProvincia);
		
		textField_14 = new JTextField();
		textField_14.setBounds(370, 201, 170, 20);
		Consulta.add(textField_14);
		textField_14.setColumns(10);
		
		lblDistrito = new JLabel("Distrito");
		lblDistrito.setBounds(370, 188, 46, 14);
		Consulta.add(lblDistrito);
		
		lblDatosDelReclamo = new JLabel("DATOS DEL RECLAMO:");
		lblDatosDelReclamo.setBounds(10, 281, 129, 14);
		Consulta.add(lblDatosDelReclamo);
		
		lblTipoRec = new JLabel("Tipo Rec.");
		lblTipoRec.setBounds(10, 306, 46, 14);
		Consulta.add(lblTipoRec);
		
		cboTipoRec = new JComboBox();
		cboTipoRec.setBounds(10, 321, 261, 22);
		Consulta.add(cboTipoRec);
		
		cboTipoMot = new JComboBox();
		cboTipoMot.setBounds(281, 321, 261, 22);
		Consulta.add(cboTipoMot);
		
		lblTipoMotivo = new JLabel("Motivo del Rec.");
		lblTipoMotivo.setBounds(281, 306, 79, 14);
		Consulta.add(lblTipoMotivo);
		
		comboBox = new JComboBox();
		comboBox.setBounds(10, 367, 425, 22);
		Consulta.add(comboBox);
		
		lblTipoSubMotivo = new JLabel("Sub Motivo del Rec.");
		lblTipoSubMotivo.setBounds(10, 352, 129, 14);
		Consulta.add(lblTipoSubMotivo);
		
		lblReclamoMonetario = new JLabel("Reclamo Monetario");
		lblReclamoMonetario.setBounds(10, 402, 95, 14);
		Consulta.add(lblReclamoMonetario);
		
		cboRecMonetario = new JComboBox();
		cboRecMonetario.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		cboRecMonetario.setBounds(110, 398, 46, 22);
		Consulta.add(cboRecMonetario);
		
		lblImporte = new JLabel("Importe S/");
		lblImporte.setBounds(189, 402, 71, 14);
		Consulta.add(lblImporte);
		
		textField_18 = new JTextField();
		textField_18.setBounds(254, 400, 86, 20);
		Consulta.add(textField_18);
		textField_18.setColumns(10);
		
		lblModalidadAtencin = new JLabel("Modalidad Atenci\u00F3n");
		lblModalidadAtencin.setBounds(350, 402, 99, 14);
		Consulta.add(lblModalidadAtencin);
		
		cboModAtencion = new JComboBox();
		cboModAtencion.setModel(new DefaultComboBoxModel(new String[] {"Carta", "Email", "Tel\u00E9fono"}));
		cboModAtencion.setBounds(449, 398, 91, 22);
		Consulta.add(cboModAtencion);
		
		lblFundamentoDelReclamo = new JLabel("Fundamento del Reclamo:");
		lblFundamentoDelReclamo.setBounds(10, 429, 146, 14);
		Consulta.add(lblFundamentoDelReclamo);
		
		lblNewLabel_3 = new JLabel("Sucursal");
		lblNewLabel_3.setBounds(10, 530, 46, 14);
		Consulta.add(lblNewLabel_3);
		
		textField_20 = new JTextField();
		textField_20.setEditable(false);
		textField_20.setBounds(10, 546, 86, 20);
		Consulta.add(textField_20);
		textField_20.setColumns(10);
		
		textField_21 = new JTextField();
		textField_21.setEditable(false);
		textField_21.setBounds(106, 546, 170, 20);
		Consulta.add(textField_21);
		textField_21.setColumns(10);
		
		lblEmpleado = new JLabel("Responsable Registro");
		lblEmpleado.setBounds(106, 530, 135, 14);
		Consulta.add(lblEmpleado);
		
		textField_15 = new JTextField();
		textField_15.setBounds(264, 8, 95, 20);
		Consulta.add(textField_15);
		textField_15.setColumns(10);
		
		lblReiterativo = new JLabel("Reiterativo");
		lblReiterativo.setBounds(195, 11, 65, 14);
		Consulta.add(lblReiterativo);
		
		textField_16 = new JTextField();
		textField_16.setBounds(10, 247, 530, 20);
		Consulta.add(textField_16);
		textField_16.setColumns(10);
		
		lblSiLaDireccin = new JLabel("Si la ubicaci\u00F3n que reporta el problema no es la direcci\u00F3n del cliente, indicar la nueva direcci\u00F3n aqu\u00ED:");
		lblSiLaDireccin.setBounds(10, 232, 517, 14);
		Consulta.add(lblSiLaDireccin);
		
		txtAreaFun = new JTextArea();
		txtAreaFun.setBounds(10, 446, 534, 78);
		Consulta.add(txtAreaFun);
		
		txtPaneFun = new JTextPane();
		txtPaneFun.setBounds(10, 446, 534, 78);
		Consulta.add(txtPaneFun);
		
	
		modelo.setRowCount(0); 
		Object[] fila = { 000001,"10801753", "Ana", "Mendez", "Torres", "No Pago","12/05/2019" }; 
		modelo.addRow(fila);
	}
}
