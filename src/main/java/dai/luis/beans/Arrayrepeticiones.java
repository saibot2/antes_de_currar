package dai.luis.beans;

import java.util.ArrayList;
import java.util.List;

public class Arrayrepeticiones {

	public static void main(String[] args) {
		List<Integer> cadena = new ArrayList<>();
		Integer num = 0;
		cadena.add(num);
		num = 1;
		cadena.add(num);
		num = 2;
		cadena.add(num);
		num = 0;
		cadena.add(num);
	
		System.out.println("CADENA: "+cadena);
	}

	private void metod(List<Integer> cadena){		
		int [] contadores = new int[cadena.size()];		
		for(int item:contadores){
			item=0;
		}
		
		int numComparar = 0;
		
		for(int i=0;i<cadena.size();i++){
			numComparar=cadena.get(i);
			for(int j=0;j<cadena.size();j++){
				if(numComparar==cadena.get(j).intValue()){
					contadores[j]=contadores[j]+1;
				}
			}
		}
		
		for(int i=0;i<contadores.length;i++){		
			System.out.println("El elemento "+i +" tiene "+(contadores[i]-1)+" repeticiones");
		}		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
