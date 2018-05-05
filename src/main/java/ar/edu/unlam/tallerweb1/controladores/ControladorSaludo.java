package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorSaludo {
	@RequestMapping("/saludo/{nombre}/{apellido}")
	public ModelAndView saludar(@PathVariable("nombre") String pnombre,@PathVariable("apellido") String papellido) {
		ModelMap modelo = new ModelMap();
		modelo.put("saludo","hola");
		modelo.put("nombrePersona",pnombre);
		modelo.put("apellidoPersona", papellido);
		return new ModelAndView("saludo",modelo);
	}
}
