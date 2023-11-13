package examen.ejercicio1.gui;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ConsultarView extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6804179973286968512L;
	private JTable table;
	private TableModel tableModel;

	public ConsultarView(AppController appView) {
		super(appView);
		setLayout(null);

		JLabel lblDisponibles = new JLabel("Sólo disponibles:");
		lblDisponibles.setBounds(38, 84, 95, 14);
		add(lblDisponibles);

		JRadioButton rdbtnSi = new JRadioButton("Sí");
		rdbtnSi.setBounds(119, 80, 45, 23);
		add(rdbtnSi);

		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(166, 80, 45, 23);
		add(rdbtnNo);

		JRadioButton rdbtnTodos = new JRadioButton("Todos");
		rdbtnTodos.setBounds(213, 80, 79, 23);
		add(rdbtnTodos);

		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == rdbtnNo) {
					rdbtnNo.setSelected(true);
					rdbtnSi.setSelected(false);
					rdbtnTodos.setSelected(false);
				}
				if (e.getSource() == rdbtnSi) {
					rdbtnNo.setSelected(false);
					rdbtnSi.setSelected(true);
					rdbtnTodos.setSelected(false);
				}
				if (e.getSource() == rdbtnTodos) {
					rdbtnNo.setSelected(false);
					rdbtnSi.setSelected(false);
					rdbtnTodos.setSelected(true);
				}
			}
		};
		rdbtnNo.addActionListener(actionListener);
		rdbtnSi.addActionListener(actionListener);
		rdbtnTodos.addActionListener(actionListener);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(298, 80, 89, 23);
		add(btnConsultar);

		btnConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNo.isSelected()) {

				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 115, 329, 174);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		tableModel = new TableModel();
		table.setModel(tableModel);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 450, 22);
		add(menuBar);

		JMenu mnMenu = new JMenu("Menú");
		menuBar.add(mnMenu);

		JMenuItem mntmAlta = new JMenuItem("Alta");
		mntmAlta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0));
		mnMenu.add(mntmAlta);

		mntmAlta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNo.isSelected()) {
					appView.consultarNo();
				} else if (rdbtnSi.isSelected()) {
					appView.consultarSi();
				} else if (rdbtnTodos.isSelected()) {
					appView.consultarTodosCoches();
				}
				actualizar();
			}
		});

		JMenuItem mntmCerrarSersion = new JMenuItem("Cerrar Sesión");
		mntmCerrarSersion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0));
		mnMenu.add(mntmCerrarSersion);

		mntmCerrarSersion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				appView.irBienvenida();
			}
		});

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0));
		mnMenu.add(mntmSalir);

		mntmSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (JOptionPane.showConfirmDialog(mntmSalir, "Estas seguro?", "¿Salir?",
						JOptionPane.YES_NO_OPTION) != 1) {
					System.exit(0);
				} else {

				}

			}
		});
	}

	public void actualizar() {
		tableModel.setListaCoches(appView.getListaCoches());
		tableModel.fireTableDataChanged();
	}
}
