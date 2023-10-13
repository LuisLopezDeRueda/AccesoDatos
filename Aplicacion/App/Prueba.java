package App;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Modelo.Fecha;
import Service.FechasService;
import Modelo.Registro;
import Modelo.Usuario;
import Service.RegistroException;
import Service.RegistroService;
import Service.UsuarioException;
import Service.UsuarioService;
import Service.fechasException;

public class Prueba {

	public static void main(String[] args) {
		UsuarioService us = new UsuarioService();
		Usuario user = new Usuario();
		user.setApellidos("lopez");
		user.setCiclo("DAM");
		user.setEmail("llopezderueda");
		user.setNombre("luis");
		user.setPassword("constraseña");
		/*try {
			us.registrarUsuario(user);
		} catch (UsuarioException e) {
			
			e.printStackTrace();
		}
		try {
			System.out.println(us.iniciarSesion(user.getEmail(), user.getPassword()));
		} catch (UsuarioException e) {
			
			e.printStackTrace();
		}
	

	try {
		System.out.println(us.iniciarSesion("llopezderueda","constraseña"));
	} catch (UsuarioException e) {
		
		e.printStackTrace();
	}

	FechasService fs = new FechasService();
	Fecha fecha = new Fecha();fecha.setAño(2023);fecha.setDisponibilidad(true);fecha.setEvaluación(3);fecha.setFecha(LocalDate.now());
	List<Fecha> listaFehcas = new ArrayList<>();try
	{
		listaFehcas = fs.consultarFechas();
		for (Fecha fecha2 : listaFehcas) {
			System.out.println(fecha2);
		}
	}catch(
	fechasException e)
	{

		e.printStackTrace();
	}*/
	
		Registro registro = new Registro();
		RegistroService rs = new RegistroService();
		
		registro.setDate(LocalDate.now());
		registro.setDescripcion("asd");
		registro.setId_usuario(4L);
		registro.setNumero_horas(4);
		
		try {
			//rs.insertarRegistros(registro);
			System.out.println(	rs.consultarRegistros(4L));
		} catch (RegistroException e) {
			
			e.printStackTrace();
		}
		
		
		
	
}}
