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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class JMantDisProDep extends JFrame implements ActionListener {

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
	private JComboBox cboTipRec;
	private JComboBox comboBox;
	private JLabel lblDepartamento;
	private JLabel lblProvincia;
	private JLabel lblSubMotivoRec;
	private JLabel label_2;
	private JComboBox comboBox_4;
	private JLabel label_3;
	private JTextField textField;
	private JLabel label_4;
	private JDateChooser dateChooser;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnModificar;
	private JLabel lblDistrito;
	private JComboBox comboBox_1;

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
	 */
	public JMantDisProDep() {
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
		
		lblNombre = new JLabel("Departam.");
		lblNombre.setBounds(10, 15, 63, 14);
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
		
		btnNewButton = new JButton("BUSCAR");
		btnNewButton.setBounds(434, 24, 110, 23);
		Consulta.add(btnNewButton);
		
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
		
		cboTipRec = new JComboBox();
		cboTipRec.setModel(new DefaultComboBoxModel(new String[] {"Lima"}));
		cboTipRec.setBounds(80, 11, 289, 22);
		Consulta.add(cboTipRec);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Lima"}));
		comboBox.setBounds(80, 41, 289, 22);
		Consulta.add(comboBox);
		
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
		
		comboBox_4 = new JComboBox();
		comboBox_4.setBounds(388, 400, 156, 20);
		Consulta.add(comboBox_4);
		
		label_3 = new JLabel("Responsable de Actualizaci\u00F3n");
		label_3.setBounds(10, 433, 156, 14);
		Consulta.add(label_3);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(10, 448, 359, 20);
		Consulta.add(textField);
		
		label_4 = new JLabel("Fecha \u00DAltima Actualizaci\u00F3n");
		label_4.setBounds(390, 433, 148, 14);
		Consulta.add(label_4);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(390, 448, 154, 20);
		Consulta.add(dateChooser);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 356, 260, 20);
		Consulta.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(284, 356, 260, 20);
		Consulta.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 400, 359, 20);
		Consulta.add(textField_3);
		textField_3.setColumns(10);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(310, 479, 110, 23);
		Consulta.add(btnModificar);
		
		lblDistrito = new JLabel("Distrito");
		lblDistrito.setBounds(10, 74, 79, 14);
		Consulta.add(lblDistrito);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Cercado de Lima"}));
		comboBox_1.setBounds(80, 70, 287, 22);
		Consulta.add(comboBox_1);
		
	
		modelo.setRowCount(0); 
		Object[] fila = {"Lima", "Callao", "La Perla","Activo"}; 
		modelo.addRow(fila);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton_1) {
			actionPerformedBtnNewButton_1(arg0);
		}
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent arg0) {
	}
}
