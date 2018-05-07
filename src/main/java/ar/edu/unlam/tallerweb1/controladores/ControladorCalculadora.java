package ar.edu.unlam.tallerweb1.controladores;

import java.text.DecimalFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorCalculadora {
	
	@RequestMapping("/calculadora/{operacion}/{n1}/{n2}") 
	public ModelAndView suma(@PathVariable("operacion") String operacions, @PathVariable("n1") String numero1s,@PathVariable("n2") String numero2s) {
		Double numero1,numero2,resultado;
		DecimalFormat formato = new DecimalFormat("0.####");
		ModelMap modelo = new ModelMap();
		try {
			numero1= Double.parseDouble(numero1s);
			numero2= Double.parseDouble(numero2s);
			switch (operacions) {
				case "suma": resultado=numero1+numero2; break;
				case "resta": resultado=numero1-numero2; break;
				case "multiplicacion": resultado=numero1*numero2; break;
				case "division": resultado=numero1/numero2; break;
				default: modelo.put("error","Operacion invalida"); return new ModelAndView("error",modelo);
			}
			modelo.put("operacion", operacions);
			modelo.put("numero1", formato.format(numero1));
			modelo.put("numero2", formato.format(numero2));
			modelo.put("resultado", formato.format(resultado));
			return new ModelAndView("calculadora",modelo);
		}catch(Exception e){
			modelo.put("error", e);
			return new ModelAndView("error",modelo);
		}
	}
}
