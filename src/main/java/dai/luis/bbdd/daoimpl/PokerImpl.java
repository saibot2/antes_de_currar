package dai.luis.bbdd.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import dai.luis.bbdd.daointerfaz.PokerInterface;
import dai.luis.models.Naipe;

public class PokerImpl implements PokerInterface {

	@SuppressWarnings("unchecked")
	@Override
	public List<Naipe> buscarNaipes(List<Integer> listaNum, Session session) {
		
		/*SELECT numero_palo
		FROM naipes
		WHERE id_naipe IN (3, 15, 19, 20, 39); */
		
		String hql = "select n from Naipe n";	
		hql+= " where n.idNaipe in :listaNum ";
		
		Query query = session.createQuery(hql);	
		
		query.setParameterList("listaNum", listaNum);
		//java.lang.ClassCastException: java.util.ArrayList cannot be cast to java.lang.Integer
		List<Naipe> naipes = query.list();
		
		return naipes;
	}

}
