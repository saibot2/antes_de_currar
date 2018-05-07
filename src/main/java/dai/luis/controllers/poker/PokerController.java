package dai.luis.controllers.poker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import dai.luis.models.Naipe;
import dai.luis.service.PokerService;

@Controller
public class PokerController {

	public static final String HAY_PAREJA = "HAY PAREJA";
	public static final String HAY_DOBLES_PAREJAS = "HAY DOBLES PAREJAS";
	public static final String HAY_TRIO = "HAY TRIO";
	public static final String HAY_ESCALERA = "HAY ESCALERA";
	public static final String HAY_COLOR = "HAY COLOR";
	public static final String HAY_FULL_HOUSE = "HAY FULL";
	public static final String HAY_POKER = "HAY POKER";
	public static final String HAY_ESCALERA_DE_COLOR = "HAY ESCALERA DE COLOR";
	public static final String HAY_ESCALERA_DE_COLOR_REAL = "HAY ESCALERA DE COLOR REAL";
	
	@Autowired
	PokerService pokerService;
	
	@RequestMapping("poker")
	public String irPoker(ModelMap model){
		List<Integer> cartasRepartir = pokerService.sacaDiezCartasAzar();
		List<Naipe> cartasPlayer1 =  pokerService.getCartasFinalesJugador(cartasRepartir, true);
		List<Naipe> cartasComp = pokerService.getCartasFinalesJugador(cartasRepartir, false);
		
		model.addAttribute("cartasListP1", cartasPlayer1);
		model.addAttribute("cartasListComp", cartasComp);
		model.addAttribute("mensajesP1List", pokerService.comprobaciones(cartasPlayer1));
		model.addAttribute("mensajesCompList", pokerService.comprobaciones(cartasComp));
	
		return "poker/poker";		
	}
	
}
