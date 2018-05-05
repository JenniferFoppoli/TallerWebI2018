package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorSaludar {
	@RequestMapping("/Saludar")
	public ModelAndView Saludar(@RequestParam ("persona") String nombre, @RequestParam("apellido") String apellido)
	{
	ModelMap modelo = new ModelMap();
	modelo.put("Saludo","hola");
	modelo.put("personaSaludada", nombre);
	modelo.put("apellidoPersona", apellido);
    return new ModelAndView ("saludo", modelo);
	}
}
