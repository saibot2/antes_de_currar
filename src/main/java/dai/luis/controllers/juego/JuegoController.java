package dai.luis.controllers.juego;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dai.luis.view.JuegoView;

@Controller 
public class JuegoController {
	public static final int PIEDRA = 0;
	public static final int PAPEL = 1;
	public static final int TIJERA = 2;
	
	@RequestMapping("jugar")
	public ModelAndView irJuego(){
		return new ModelAndView("juego/juego","command",new JuegoView());		
	}

	@RequestMapping(value="jugar", method = RequestMethod.POST)
	public @ResponseBody String volverJugar(@RequestParam String dato) {
		System.out.println("var: "+dato);
		int resMaquina = maquinaSaca();
		String respuesta = quienGana(Integer.parseInt(dato),resMaquina);
		return respuesta; 
	}
	
	private String quienGana (int jugadorRes, int maquinaRes){
		String respùesta="";
		
		if(jugadorRes == 0){
			if(maquinaRes==0){ 
				respùesta="Jugador: PIEDRA | maquina: PIEDRA. ---> <b>EMPATE</b>";
			}else if(maquinaRes==1){
				respùesta="Jugador: PIEDRA | maquina: PAPEL. ---> <span class=\"errorblock\"><b>MAQUINA GANA</b></span>";
			}else{
				respùesta="Jugador: PIEDRA | maquina: TIJERA. ---> <span class=\"mensajeVerde\"><b>JUGADOR GANA</b></span>";
			}
		}else if(jugadorRes == 1){
			if(maquinaRes==0){
				respùesta="Jugador: PAPEL | maquina: PIEDRA. ---> <span class=\"mensajeVerde\"><b>JUGADOR GANA</b></span>";
			}else if(maquinaRes==1){
				respùesta="Jugador: PAPEL | maquina: PAPEL. ---> <b>EMPATE</b>";
			}else{
				respùesta="Jugador: PAPEL | maquina: TIJERA. ---> <span class=\"errorblock\"><b>MAQUINA GANA</b></span>";
			}
		}else{
			if(maquinaRes==0){
				respùesta="Jugador: TIJERA | maquina: PIEDRA. ---> <span class=\"errorblock\"><b>MAQUINA GANA</b></span>";
			}else if(maquinaRes==1){
				respùesta="Jugador: TIJERA | maquina: PAPEL. ---> <span class=\"mensajeVerde\"><b>JUGADOR GANA</b></span>";
			}else{
				respùesta="Jugador: TIJERA | maquina: TIJERA. ---> <b>EMPATE</b>";
			}
		}
		
		return respùesta;
	}
	
	private int maquinaSaca(){
		int resultado = -1;
		try {
			resultado = (int)Math.floor(Math.random()*3); //Numero del 0 al 99 
			int segundos = (int)Math.floor(Math.random()*3);
			if(segundos==0){
				Thread.sleep(3000);			
			}else if (segundos==1){
				Thread.sleep(2000);
			}else{
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	 @ModelAttribute("piedraPapelTijeraMap")
	 public Map<Integer,String> listaDeTiposTarjetaMap(){
		 Map <Integer,String> lista = new HashMap<>();
		 lista.put(PIEDRA,"Piedra");
		 lista.put(PAPEL,"Papel");
		 lista.put(TIJERA,"Tijera");
		 return lista;
	 }
	 
}
