package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorSuma {
	
	@RequestMapping("/suma/{n1}/{n2}")
	public ModelAndView suma(@PathVariable("n1") String numero1s,@PathVariable("n2") String numero2s) {
		Integer numero1,numero2;
		ModelMap modelo = new ModelMap();
		try {
			numero1= Integer.parseInt(numero1s);
			numero2= Integer.parseInt(numero2s);
			modelo.put("numero1", numero1);
			modelo.put("numero2", numero2);
			modelo.put("resultado", numero1+numero2);
			return new ModelAndView("suma",modelo);
		}catch(NumberFormatException e){
			modelo.put("error", e);
			return new ModelAndView("error",modelo);
		}
	}
}
