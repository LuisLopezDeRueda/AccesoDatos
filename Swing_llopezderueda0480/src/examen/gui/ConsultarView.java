package examen.gui;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import examen.modelo.Coche;

import java.awt.Color;

public class ConsultarView extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9194802005585754751L;
	private JTable table;
	private TableModel model;
	private JLabel lblListaVacia;
	private JComboBox<String> comboBox;

	public TableModel getModel() {
		return model;
	}

	public ConsultarView(AppController appView) {
		super(appView);
		setLayout(null);

		JLabel lblMarca = new JLabel("Indique la marca que está buscando:");
		lblMarca.setBounds(80, 50, 222, 14);
		add(lblMarca);

		lblListaVacia = new JLabel("");
		lblListaVacia.setForeground(new Color(255, 0, 0));
		lblListaVacia.setBounds(80, 75, 264, 14);
		add(lblListaVacia);

		comboBox = new JComboBox<String>();
		comboBox.setBounds(312, 46, 118, 22);
		add(comboBox);

		comboBox.addItem("Peugeot");
		comboBox.addItem("Renault");
		comboBox.addItem("Seat");
		comboBox.addItem("Toyota");

		

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(440, 46, 89, 23);
		add(btnNuevo);

		btnNuevo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				appView.irAlta();
			}
		});
		model = new TableModel();

		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem() == "Peugeot") {
					appView.consutlarCoche("Peugeot");
					limpiarlbl();
				} else if (comboBox.getSelectedItem() == "Renault") {
					appView.consutlarCoche("Renault");
					limpiarlbl();
				} else if (comboBox.getSelectedItem() == "Seat") {
					appView.consutlarCoche("Seat");
					limpiarlbl();
				} else if (comboBox.getSelectedItem() == "Toyota") {
					appView.consutlarCoche("Toyota");
					limpiarlbl();
				}
				if (appView.getListaCoches().isEmpty() && comboBox.getSelectedIndex() != -1) {
					lblListaVacia.setText("No hay registros para la marca indicada");
				}
				actualizar();
			}
		});
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 117, 409, 159);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		table.setModel(model);

		JButton btnCerrarSesion = new JButton("Cerrar sesión");
		btnCerrarSesion.setBounds(548, 322, 115, 23);
		add(btnCerrarSesion);

		btnCerrarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				appView.irBienvenida();
			}
		});

	}

	public void actualizar() {
		model.setListaCoches(appView.getListaCoches());
		model.fireTableDataChanged();
	}

	public void limpiar() {
		List<Coche> listaCoches = new ArrayList<Coche>();
		model.setListaCoches(listaCoches);
		lblListaVacia.setText("");
		comboBox.setSelectedIndex(-1);
	}

	public void limpiarlbl() {
		lblListaVacia.setText("");
	}
}
