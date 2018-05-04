package dai.luis.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dai.luis.bbdd.daointerfaz.PokerInterface;
import dai.luis.controllers.poker.PokerController;
import dai.luis.models.Naipe;
import dai.luis.util.HibernateUtil;

@Service
public class PokerService {
	@Autowired 
	PokerInterface pokerInterface;
	
	public List<Naipe> buscarNaipes(List<Integer> listaNum) {
		Session session = HibernateUtil.getSessionFactory().openSession();	
		List<Naipe> naipes = pokerInterface.buscarNaipes(listaNum, session);
		session.close();
		return naipes;		
	}
	
	public List<Naipe> getCartasFinalesJugador(List<Integer> cartasRepartir, boolean swJugador){
		List<Integer> cartas = reparteCartas(cartasRepartir, swJugador);
		List<Naipe> cartasRes = buscarNaipes(cartas);
		return cartasRes;
	}
	
	public List<Integer> reparteCartas(List<Integer> cartasRepartir, boolean jugador1){
		List<Integer> cartas = new ArrayList<>();
		if(jugador1){
			for(int i=0;i<5;i++){
				cartas.add(cartasRepartir.get(i));				
			}
		}else{
			for(int i=0,j=5;i<5;i++,j++){
				cartas.add(cartasRepartir.get(j));
			}
		}
		return cartas;
	}
	
	public List<Integer> sacaDiezCartasAzar(){//Sin repeticiones
		List<Integer> cartasNumAzar = new ArrayList<>();
		
		for(int i=0;i<10;i++){
			int a = (int)Math.floor(Math.random()*52+1); //Numero del 1 al 52
			if(cartasNumAzar.contains(a)){
				a = (int)Math.floor(Math.random()*52+1); //Numero del 1 al 52
			}
			cartasNumAzar.add(a);
		}
		return cartasNumAzar;
	} 
	
	public boolean comprobarPareja(List<Naipe> cartas){
		boolean resultado=false;
		int[] contadores = cuentaRepeticionesEnArray(cartas);
		
		for(int item:contadores){
			if(item>1){
				resultado=true;
				break;
			}
		}
		return resultado;
	}
	
	public boolean comprobarDoblesParejas(List<Naipe> cartas){
		boolean resultado=false;
		int cuentaParejas=0;
		int[] contadores = cuentaRepeticionesEnArray(cartas);
				
		for(int item:contadores){
			if(item>1){
				cuentaParejas++;
			}
		}
		if(cuentaParejas>=4){
				resultado=true;
		}
		return resultado;
	}
	
	public boolean comprobarTrio(List<Naipe> cartas){
		boolean resultado=false;
		int[] contadores = cuentaRepeticionesEnArray(cartas);
		for(int item:contadores){
			if(item>2){
				resultado=true;
				break;
			}
		}
		return resultado;
	}
	
	public boolean comprobarEscalera(List<Naipe> cartas){
		boolean resultado=true;
		List<Integer> escalera = new ArrayList<>();
		
		for(Naipe item:cartas){
			escalera.add(item.getNumero());
		}
		
		Collections.sort(escalera);
		
		for(int i=0;i<escalera.size()-1;i++){
			int valorActual = escalera.get(i);
			int valorSiguiente = escalera.get(i+1);  
			if(valorActual!=valorSiguiente-1){						
				return false; //No es escalera
			}		
		}	
		
		return resultado;
	}
	
	public boolean comprobarEscaleraReal_(List<Naipe> cartas){
		boolean resultado=true;
		List<Integer> escalera = new ArrayList<>();
		
		for(Naipe item:cartas){
			if(item.getNumero()==1){
				escalera.add(14);
			}else{
				escalera.add(item.getNumero());
			}
		}
		
		Collections.sort(escalera);
		
		if(escalera.get(4)!=14){
			return false;
		}
		
		for(int i=0;i<escalera.size()-1;i++){
			int valorActual = escalera.get(i);
			int valorSiguiente = escalera.get(i+1);  
			if(valorActual!=valorSiguiente-1){						
				return false; //No es escalera
			}
		}	
		
		
		return resultado;
	}
	
	public boolean comprobarColor(List<Naipe> cartas){
		boolean resultado=false;
		int[] contadores = cuentaRepeticionesColor(cartas);
		for(int item:contadores){
			if(item>4){
				resultado=true;
				break;
			}
		}
		return resultado;
	}
	
	public boolean comprobarFullHouse(List<Naipe> cartas){
		boolean resultado=false;
		boolean swItem2=false;
		boolean swItem3=false;
		int[] contadores = cuentaRepeticionesEnArray(cartas);
		
		for(int item:contadores){
			if(item==3){
				swItem3=true;
			}
			if(item==2){
				swItem2=true;
			}
		}
		
		if(swItem2 && swItem3){
			resultado=true;
		}
		
		return resultado;
	}	
	
	public boolean comprobarPoker(List<Naipe> cartas){
		boolean resultado=false;
		int[] contadores = cuentaRepeticionesEnArray(cartas);
		for(int item:contadores){
			if(item>3){
				resultado=true;
				break;
			}
		}
		return resultado;
	}
	
	public boolean comprobarEscaleraColor(List<Naipe> cartas){
		boolean resultado=true;
		int[] contadores = cuentaRepeticionesColor(cartas);
		
		if(contadores[0]!=5){
			return false;
		}
		if(!comprobarEscalera(cartas)){
			return false;
		}
		return resultado;		
	}
	
	public boolean comprobarEscaleraReal(List<Naipe> cartas){
		boolean resultado=true;
		int[] contadores = cuentaRepeticionesColor(cartas);
		if(contadores[0]!=5){
			return false;
		}
		if(!comprobarEscaleraReal_(cartas)){
			return false;
		}
		return resultado;
	}
	
	public int[] cuentaRepeticionesColor(List<Naipe> cartas){
		int[] contadores = new int[cartas.size()];
		for(int item:contadores){
			item=0;
		}
		String cadComparar="";
		
		for(int i=0;i<cartas.size();i++){
			cadComparar=cartas.get(i).getPalo();
			for(int j=0;j<cartas.size();j++){
				if(cadComparar.equalsIgnoreCase(cartas.get(j).getPalo())){
					contadores[j]=contadores[j]+1;
				}
			}
		}
		return contadores;
	}
	
	public int[] cuentaRepeticionesEnArray(List<Naipe> cartas){		
		int[] contadores = new int[cartas.size()];
		for(int item:contadores){
			item=0;
		}
		int cadComparar=0;
		
		for(int i=0;i<cartas.size();i++){
			cadComparar=cartas.get(i).getNumero();
			for(int j=0;j<cartas.size();j++){
				if(cadComparar==cartas.get(j).getNumero()){
					contadores[j]=contadores[j]+1;
				}
			}
		}
		return contadores;
	}
	
	public List<String> comprobaciones(List<Naipe> cartas){
		List<String> mensajes = new ArrayList<>();
		if(comprobarPareja(cartas)){
			mensajes.add(PokerController.HAY_PAREJA);
		}
		
		if(comprobarDoblesParejas(cartas)){
			mensajes.add(PokerController.HAY_DOBLES_PAREJAS);
		}
		
		if(comprobarTrio(cartas)){
			mensajes.add(PokerController.HAY_TRIO);
		}
		
		if(comprobarEscalera(cartas)){
			mensajes.add(PokerController.HAY_ESCALERA);
		}

		if(comprobarColor(cartas)){
			mensajes.add(PokerController.HAY_COLOR);
		}
				
		if(comprobarFullHouse(cartas)){
			mensajes.add(PokerController.HAY_FULL_HOUSE);
		}
		
		if(comprobarPoker(cartas)){
			mensajes.add(PokerController.HAY_POKER);
		}
		
		if(comprobarEscaleraColor(cartas)){
			mensajes.add(PokerController.HAY_ESCALERA_DE_COLOR);
		}
		
		if(comprobarEscaleraReal(cartas)){
			mensajes.add(PokerController.HAY_ESCALERA_DE_COLOR_REAL);
		}
		return mensajes;
	}

	/////MOCKS////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public  List<Naipe> mockGetListaCartasEscaleraColorReal(){
		List<Naipe> cartas = new ArrayList<>();
		
		Naipe carta = new Naipe();
		carta.setIdNaipe(1);
		carta.setNumero(1);
		carta.setPalo("c");
		cartas.add(carta);
		
		carta = new Naipe();
		carta.setIdNaipe(13);
		carta.setNumero(13);
		carta.setPalo("c");
		cartas.add(carta);
		
		carta = new Naipe();
		carta.setIdNaipe(12);
		carta.setNumero(12);
		carta.setPalo("c");
		cartas.add(carta);

		carta = new Naipe();
		carta.setIdNaipe(11);
		carta.setNumero(11);
		carta.setPalo("c");
		cartas.add(carta);
		
		carta = new Naipe();
		carta.setIdNaipe(10);
		carta.setNumero(10);
		carta.setPalo("c");		
		cartas.add(carta);
		
		return cartas;
	}
	
	public  List<Naipe> mockGetListaCartasEscaleraColor(){
		List<Naipe> cartas = new ArrayList<>();
		
		Naipe carta = new Naipe();
		carta.setIdNaipe(2);
		carta.setNumero(2);
		carta.setPalo("c");
		cartas.add(carta);
		
		carta = new Naipe();
		carta.setIdNaipe(3);
		carta.setNumero(3);
		carta.setPalo("c");
		cartas.add(carta);
		
		carta = new Naipe();
		carta.setIdNaipe(4);
		carta.setNumero(4);
		carta.setPalo("c");
		cartas.add(carta);

		carta = new Naipe();
		carta.setIdNaipe(5);
		carta.setNumero(5);
		carta.setPalo("c");
		cartas.add(carta);
		
		carta = new Naipe();
		carta.setIdNaipe(6);
		carta.setNumero(6);
		carta.setPalo("c");		
		cartas.add(carta);
		
		return cartas;
	}
	
	public  List<Naipe> mockGetListaPoker(){
		List<Naipe> cartas = new ArrayList<>();
		
		Naipe carta = new Naipe();
		carta.setIdNaipe(9);
		carta.setNumero(9);
		carta.setPalo("c");
		cartas.add(carta);
		
		carta = new Naipe();
		carta.setIdNaipe(48);
		carta.setNumero(9);
		carta.setPalo("p");
		cartas.add(carta);
		
		carta = new Naipe();
		carta.setIdNaipe(35);
		carta.setNumero(9);
		carta.setPalo("t");
		cartas.add(carta);

		carta = new Naipe();
		carta.setIdNaipe(22);
		carta.setNumero(9);
		carta.setPalo("d");
		cartas.add(carta);
		
		carta = new Naipe();
		carta.setIdNaipe(16);
		carta.setNumero(3);
		carta.setPalo("d");		
		cartas.add(carta);
		
		return cartas;
	}
	
	public  List<Naipe> mockGetListaFullHouse(){
		List<Naipe> cartas = new ArrayList<>();
		
		Naipe carta = new Naipe();
		carta.setIdNaipe(19);
		carta.setNumero(6);
		carta.setPalo("d");
		cartas.add(carta);
		
		carta = new Naipe();
		carta.setIdNaipe(45);
		carta.setNumero(6);
		carta.setPalo("p");
		cartas.add(carta);
		
		carta = new Naipe();
		carta.setIdNaipe(6);
		carta.setNumero(6);
		carta.setPalo("c");
		cartas.add(carta);

		carta = new Naipe();
		carta.setIdNaipe(29);
		carta.setNumero(3);
		carta.setPalo("t");
		cartas.add(carta);
		
		carta = new Naipe();
		carta.setIdNaipe(42);
		carta.setNumero(3);
		carta.setPalo("p");		
		cartas.add(carta);
		
		return cartas;
	}
	
	public  List<Naipe> mockGetListaCartasColor(){
		List<Naipe> cartas = new ArrayList<>();
		
		Naipe carta = new Naipe();
		carta.setIdNaipe(2);
		carta.setNumero(2);
		carta.setPalo("c");
		cartas.add(carta);
		
		carta = new Naipe();
		carta.setIdNaipe(7);
		carta.setNumero(7);
		carta.setPalo("c");
		cartas.add(carta);
		
		carta = new Naipe();
		carta.setIdNaipe(11);
		carta.setNumero(11);
		carta.setPalo("c");
		cartas.add(carta);

		carta = new Naipe();
		carta.setIdNaipe(1);
		carta.setNumero(1);
		carta.setPalo("c");
		cartas.add(carta);
		
		carta = new Naipe();
		carta.setIdNaipe(4);
		carta.setNumero(4);
		carta.setPalo("c");		
		cartas.add(carta);
		
		return cartas;
	}
	
	public  List<Naipe> mockGetListaCartasEscalera(){
		List<Naipe> cartas = new ArrayList<>();
		
		Naipe carta = new Naipe();
		carta.setIdNaipe(5);
		carta.setNumero(5);
		carta.setPalo("c");
		cartas.add(carta);
		
		carta = new Naipe();
		carta.setIdNaipe(3);
		carta.setNumero(3);
		carta.setPalo("c");
		cartas.add(carta);
		
		carta = new Naipe();
		carta.setIdNaipe(41);
		carta.setNumero(2);
		carta.setPalo("p");
		cartas.add(carta);

		carta = new Naipe();
		carta.setIdNaipe(4);
		carta.setNumero(4);
		carta.setPalo("c");
		cartas.add(carta);
		
		carta = new Naipe();
		carta.setIdNaipe(1);
		carta.setNumero(1);
		carta.setPalo("c");		
		cartas.add(carta);
		
		return cartas;
	}
	
	public  List<Naipe> mockGetListaCartasTrio(){
		List<Naipe> cartas = new ArrayList<>();
		
		Naipe carta = new Naipe();
		
		carta.setIdNaipe(1);
		carta.setNumero(1);
		carta.setPalo("c");		
		cartas.add(carta);
		
		carta = new Naipe();
		carta.setIdNaipe(14);
		carta.setNumero(1);
		carta.setPalo("d");
		cartas.add(carta);
		
		carta = new Naipe();
		carta.setIdNaipe(27);
		carta.setNumero(1);
		carta.setPalo("t");
		cartas.add(carta);
		
//		carta = new Naipe();
//		carta.setIdNaipe(44);
//		carta.setNumero(5);
//		carta.setPalo("p");
//		cartas.add(carta);
		
		carta = new Naipe();
		carta.setIdNaipe(22);
		carta.setNumero(9);
		carta.setPalo("d");
		cartas.add(carta);
		
		carta = new Naipe();
		carta.setIdNaipe(46);
		carta.setNumero(7);
		carta.setPalo("p");
		cartas.add(carta);
		
		return cartas;
	}
}
