package App;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Modelo.Fecha;
import Service.FechasService;
/*import Modelo.Registro;
import Modelo.Usuario;
import Service.RegistroException;
import Service.RegistroService;
import Service.UsuarioException;
import Service.UsuarioService;*/
import Service.fechasException;

public class Prueba {

	public static void main(String[] args) {
		/*
		 * UsuarioService us = new UsuarioService();
		 * 
		 * user.setApellidos("lopez"); user.setCiclo("DAM");
		 * user.setEmail("llopezderueda0480"); user.setNombre("luis");
		 * user.setPassword("constraseña"); try { //us.registrarUsuario(user);
		 * System.out.println(us.iniciarSesion(user.getEmail(), user.getPassword())); }
		 * catch (UsuarioException e) { System.err.println("El usuario ya existe " + e);
		 * }
		 * 
		 * Usuario user = new Usuario(); try { user =
		 * us.iniciarSesion("llopezderueda0480", "constraseña"); } catch
		 * (UsuarioException e) {
		 * 
		 * e.printStackTrace(); } RegistroService rs = new RegistroService(); Registro
		 * registro = new Registro(); registro.setDate(LocalDate.now());
		 * registro.setDescripcion("Bomba el dia de hoy");
		 * registro.setId_usuario(user.getId_usuario()); registro.setNumero_horas(2);
		 * try { // rs.insertarRegistros(registro);
		 * System.out.println(rs.consultarRegistros(user.getId_usuario())); } catch
		 * (RegistroException e) { System.out.println("Error con el registo " + e); }
		 */
		FechasService fs = new FechasService();
		Fecha fecha = new Fecha();
		fecha.setAño(2023);
		fecha.setDisponibilidad(true);
		fecha.setEvaluación(3);
		fecha.setFecha(LocalDate.now());
		List<Fecha> listaFehcas = new ArrayList<>();
		try {
			listaFehcas = fs.consultarFechas();
			for (Fecha fecha2 : listaFehcas) {
				System.out.println(fecha2);
			}
		} catch (fechasException e) {

			e.printStackTrace();
		}
	}
}
