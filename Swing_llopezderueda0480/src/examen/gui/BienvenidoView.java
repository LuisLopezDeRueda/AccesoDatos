package examen.gui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class BienvenidoView extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1588724642212845579L;
	private JTextField textField;
	private JRadioButton rdbtnAnonimo;
	private JRadioButton rdbtnIdentificacion;
	private JLabel lblError;
	private JButton btnEntrar;
	
	public BienvenidoView(AppController appView) {
		super(appView);
		setLayout(null);

		JLabel lblBienvenida = new JLabel("Bienvenido a CarCollection");
		lblBienvenida.setForeground(new Color(183, 54, 201));
		lblBienvenida.setFont(new Font("Playbill", Font.PLAIN, 70));
		lblBienvenida.setBounds(166, 33, 473, 47);
		add(lblBienvenida);

		JLabel lblTipoAcceso = new JLabel("Elija el tipo de acceso");
		lblTipoAcceso.setBounds(192, 180, 177, 14);
		add(lblTipoAcceso);

		rdbtnAnonimo = new JRadioButton("Anónimo");
		rdbtnAnonimo.setBounds(192, 201, 109, 23);
		add(rdbtnAnonimo);

		rdbtnIdentificacion = new JRadioButton("Identificación:");
		rdbtnIdentificacion.setBounds(192, 227, 109, 23);
		add(rdbtnIdentificacion);

		textField = new JTextField();
		textField.setBounds(307, 228, 86, 20);
		add(textField);
		textField.setColumns(10);

		textField.setEnabled(false);

		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(572, 290, 89, 23);
		add(btnEntrar);

		btnEntrar.setEnabled(false);

		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == rdbtnAnonimo) {
					rdbtnAnonimo.setSelected(true);
					rdbtnIdentificacion.setSelected(false);
				} else if (e.getSource() == rdbtnIdentificacion) {
					rdbtnAnonimo.setSelected(false);
					rdbtnIdentificacion.setSelected(true);
					textField.setEnabled(true);
				}
				btnEntrar.setEnabled(true);

			}
		};

		lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(192, 257, 353, 14);
		add(lblError);
		btnEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnIdentificacion.isSelected()) {
					String entrar = appView.login(textField.getText());
					if (!entrar.isEmpty()) {
						lblError.setText(entrar);
					} else {
						appView.irConsultar();
					}
				}
				if (rdbtnAnonimo.isSelected()) {
					appView.irConsultar();
				}

			}
		});

		rdbtnAnonimo.addActionListener(actionListener);
		rdbtnIdentificacion.addActionListener(actionListener);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(572, 317, 89, 23);
		add(btnSalir);

		btnSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(btnSalir, "Estas seguro?", "¿Salir?",
						JOptionPane.YES_NO_OPTION) != 1) {
					System.exit(0);
				} else {

				}
			}
		});
	}

	public void limpiar() {
		textField.setText("");
		rdbtnIdentificacion.setSelected(false);
		rdbtnAnonimo.setSelected(false);
		lblError.setText("");
		btnEntrar.setEnabled(false);
	}
}
