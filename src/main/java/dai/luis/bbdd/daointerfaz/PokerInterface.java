package dai.luis.bbdd.daointerfaz;

import java.util.List;
import org.hibernate.Session;
import dai.luis.models.Naipe;

public interface PokerInterface {
	public List<Naipe> buscarNaipes(List<Integer> listaNum,Session session);
}
