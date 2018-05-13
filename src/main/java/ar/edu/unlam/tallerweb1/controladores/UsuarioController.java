package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Controller
public class UsuarioController {

	@RequestMapping(path = "/crear-usuario", method = RequestMethod.POST)
	public ModelAndView crearusuario(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		model.put("email",usuario.getEmail());
		model.put("password", usuario.getPassword());
		model.put("rol", usuario.getRol());
		return new ModelAndView("creado", model);
	}
	
	@RequestMapping("/crear")
	public ModelAndView crear() {
		ModelMap model = new ModelMap();
		Usuario usuario = new Usuario();
		model.put("usuario",usuario);
		return new ModelAndView("crear",model);
	}
	
	
	@RequestMapping("/listar/{cantidad}")
		public ModelAndView listar(@PathVariable("cantidad") Integer cantidads)
		{
			
			ModelMap model = new ModelMap();
			List<Usuario> lista = new ArrayList<Usuario>();
			for (Integer i=1; i<=cantidads; i++)
			{
				Usuario nuevoUsuario = new Usuario();
				nuevoUsuario.setEmail("usuario");
				nuevoUsuario.setPassword("pass");
				nuevoUsuario.setRol("rol");
				lista.add(nuevoUsuario);
			}
			model.put("lista", lista);
			return new ModelAndView("listar",model);
		}
	
}
