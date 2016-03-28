import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;

public class VentanaPrincipal {

	private JFrame frame;
	private JTextField voltaje;
	private JTextField intensidad;
	private JTextField resistencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnVoltaje = new JButton("Voltaje");
		btnVoltaje.setBounds(10, 209, 89, 23);
		btnVoltaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getValores(1);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnVoltaje);
		
		voltaje = new JTextField();
		voltaje.setBounds(10, 50, 86, 20);
		frame.getContentPane().add(voltaje);
		voltaje.setColumns(10);
		
		intensidad = new JTextField();
		intensidad.setBounds(312, 50, 86, 20);
		frame.getContentPane().add(intensidad);
		intensidad.setColumns(10);
		
		resistencia = new JTextField();
		resistencia.setBounds(169, 50, 86, 20);
		frame.getContentPane().add(resistencia);
		resistencia.setColumns(10);
		
		JLabel lblVoltaje = new JLabel("Voltaje (Voltios)");
		lblVoltaje.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		lblVoltaje.setBounds(10, 25, 110, 14);
		frame.getContentPane().add(lblVoltaje);
		
		JLabel lblResistencia = new JLabel("Resistencia (Ohmios)");
		lblResistencia.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		lblResistencia.setBounds(156, 25, 136, 14);
		frame.getContentPane().add(lblResistencia);
		
		JLabel lblIntensidad = new JLabel("Intensidad");
		lblIntensidad.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		lblIntensidad.setBounds(312, 11, 122, 14);
		frame.getContentPane().add(lblIntensidad);
		
		JButton btnIntensidad = new JButton("Intensidad");
		btnIntensidad.setBounds(311, 209, 113, 23);
		btnIntensidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getValores(2);
			}
		});
		frame.getContentPane().add(btnIntensidad);
		
		JLabel lblamperios = new JLabel("(Amperios)");
		lblamperios.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		lblamperios.setBounds(312, 25, 91, 14);
		frame.getContentPane().add(lblamperios);
		
		JButton btnResistencia = new JButton("Resistencia");
		btnResistencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getValores(3);
			}
		});
		btnResistencia.setBounds(169, 209, 110, 23);
		frame.getContentPane().add(btnResistencia);
		

		

		
	}

	int getValores(int cual){
		double vltj = 0;
		double ntns = 0;
		double rstc = 0;
		try{
		 vltj = Integer.parseInt(voltaje.getText());
			} catch(Exception e){
			vltj = 0;
			}
		try{
			 ntns = Integer.parseInt(intensidad.getText());
			} catch(Exception e){
				ntns = 0;
			}
		try{
			 rstc = Integer.parseInt(resistencia.getText());
			} catch(Exception e){
				rstc = 0;
			}

		double res = 0;
		
		switch(cual){
		case 1:
			res = ntns * rstc;
			JOptionPane.showMessageDialog(frame, "Voltaje = " + res + " Voltios.", "Voltaje.", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 2:
			res = vltj / rstc;
			JOptionPane.showMessageDialog(frame, "Intensidad = " + res + " Amperios.", "Intensidad.", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 3:
			res = vltj / ntns;
			JOptionPane.showMessageDialog(frame, "Resistencia = " + res + " Ohmios.", "Resistencia.", JOptionPane.INFORMATION_MESSAGE);
			break;
		default:
			JOptionPane.showMessageDialog(frame, "ERROR", "Error.", JOptionPane.INFORMATION_MESSAGE);
			break;
		}

		return 0;
	}
}
