package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class JMenuBar extends JFrame {

	private JPanel contentPane;
	private javax.swing.JMenuBar menuBar;
	private JMenu mnBandejaReclamos;
	private JMenu mnMantenimiento;
	private JMenu mnReportes;
	private JMenuItem mntmSali;
	private JMenuItem mntmRegistro;
	private JMenuItem mntmAnlisis;
	private JMenuItem mntmAutorizacin;
	private JMenuItem mntmDatosDeCliente;
	private JMenuItem mntmConsultaCliente;
	private JMenuItem mntmTiposmotsubMot;
	private JMenuItem mntmDisprovdep;
	private JMenuItem mntmUsuarioclave;
	private JMenuItem mntmRecporestado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMenuBar frame = new JMenuBar();
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
	public JMenuBar() {
		setTitle("SISTEMA DE RECLAMOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 420);
		
		menuBar = new javax.swing.JMenuBar();
		setJMenuBar(menuBar);
		
		mnBandejaReclamos = new JMenu("Atenci\u00F3n de Reclamos");
		menuBar.add(mnBandejaReclamos);
		
		mntmSali = new JMenuItem("Consulta");
		mnBandejaReclamos.add(mntmSali);
		
		mntmRegistro = new JMenuItem("Registro");
		mnBandejaReclamos.add(mntmRegistro);
		
		mntmAnlisis = new JMenuItem("An\u00E1lisis");
		mnBandejaReclamos.add(mntmAnlisis);
		
		mntmAutorizacin = new JMenuItem("Carta de Respuesta");
		mnBandejaReclamos.add(mntmAutorizacin);
		
		mntmConsultaCliente = new JMenuItem("Consulta Cliente");
		mnBandejaReclamos.add(mntmConsultaCliente);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmDatosDeCliente = new JMenuItem("Datos de Cliente");
		mnMantenimiento.add(mntmDatosDeCliente);
		
		mntmTiposmotsubMot = new JMenuItem("Tipo/Mot./Sub Mot.");
		mnMantenimiento.add(mntmTiposmotsubMot);
		
		mntmDisprovdep = new JMenuItem("Dis/Prov./Dep.");
		mnMantenimiento.add(mntmDisprovdep);
		
		mntmUsuarioclave = new JMenuItem("Usuario/Clave");
		mnMantenimiento.add(mntmUsuarioclave);
		
		mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		mntmRecporestado = new JMenuItem("Rec.PorEstado");
		mnReportes.add(mntmRecporestado);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
