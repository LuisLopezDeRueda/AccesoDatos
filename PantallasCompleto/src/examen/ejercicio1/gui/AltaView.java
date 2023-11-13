package examen.ejercicio1.gui;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class AltaView extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7748234473293923610L;
	private JTextField textField;

	public AltaView(AppController appView) {
		super(appView);
		setLayout(null);

		JLabel lblNuevaMarca = new JLabel("Nueva marca");
		lblNuevaMarca.setBounds(62, 124, 76, 14);
		add(lblNuevaMarca);

		textField = new JTextField();
		textField.setBounds(148, 121, 112, 20);
		add(textField);
		textField.setColumns(10);

		JButton btnAñadir = new JButton("Añadir");
		btnAñadir.setBounds(308, 120, 89, 23);
		add(btnAñadir);

		JLabel lblMarcas = new JLabel("Marcas");
		lblMarcas.setBounds(62, 178, 46, 14);
		add(lblMarcas);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(118, 174, 98, 22);
		add(comboBox);
	}
}
