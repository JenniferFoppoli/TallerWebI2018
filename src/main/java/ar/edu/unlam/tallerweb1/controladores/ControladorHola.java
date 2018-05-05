package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorHola {
	@RequestMapping(path="saludo" , method=RequestMethod.GET)
	public ModelAndView saludo(){
		ModelMap modelo=new ModelMap();
		modelo.put("saludo", "hola");
		return new ModelAndView("saludo",modelo);
	}
}
