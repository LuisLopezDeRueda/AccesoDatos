package examen.ejercicio1.gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import examen.ejercicio1.modelo.Coche;
import examen.ejercicio1.services.ExamenService;

public class AppController {

	private JFrame frame;
	private ExamenService service;
	private List<Coche> listaCoches;

	public List<Coche> getListaCoches() {
		return listaCoches;
	}

	public void setListaCoches(List<Coche> listaCoches) {
		this.listaCoches = listaCoches;
	}

	public ExamenService getService() {
		return service;
	}

	public JFrame getFrame() {
		return frame;
	}

	private ViewBienvenida bienvenidaView;
	private ConsultarView consultarView;
	private AltaView altaView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppController window = new AppController();
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
	public AppController() {
		listaCoches = new ArrayList<>();
		bienvenidaView = new ViewBienvenida(this);
		consultarView = new ConsultarView(this);
		altaView = new AltaView(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 400, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		irBienvenida();
	}

	public void irAltaView() {
		frame.setContentPane(altaView);
		frame.revalidate();
	}

	public void irConsultarView() {
		frame.setContentPane(consultarView);
		frame.revalidate();
	}

	public void irBienvenida() {
		frame.setContentPane(bienvenidaView);
		frame.revalidate();
	}

	public void consultarTodosCoches() {
		listaCoches = service.consultarCoches();
	}

	public void consultarSi() {
		listaCoches = service.consultarCochesDisponibles(true);
	}

	public void consultarNo() {
		listaCoches = service.consultarCochesDisponibles(false);
	}
}
