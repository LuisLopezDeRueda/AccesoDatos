package examen.ejercicio1.gui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JButton;

public class ViewBienvenida extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1137389173270482608L;

	public ViewBienvenida(AppController appView) {
		super(appView);
		setLayout(null);

		JLabel lblBienvenida = new JLabel("                               Bienvenido a CarShop");
		lblBienvenida.setFont(new Font("Yu Gothic Light", Font.PLAIN, 11));
		lblBienvenida.setBounds(63, 48, 287, 28);
		add(lblBienvenida);

		JLabel lblCondiciones = new JLabel("Acepta las condiciones");
		lblCondiciones.setBounds(74, 151, 160, 14);
		add(lblCondiciones);

		JCheckBox chckbxEntrar = new JCheckBox("");
		chckbxEntrar.setBounds(240, 140, 110, 38);
		add(chckbxEntrar);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(174, 226, 89, 23);
		add(btnEntrar);

		btnEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				appView.irConsultarView();
			}
		});
		btnEntrar.setEnabled(false);
		chckbxEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (chckbxEntrar.isSelected()) {
					btnEntrar.setEnabled(true);
				}else {
					btnEntrar.setEnabled(false);
				}
			}
		});

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(331, 226, 89, 23);
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
}
