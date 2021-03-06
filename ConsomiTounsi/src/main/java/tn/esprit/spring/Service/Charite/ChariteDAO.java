package tn.esprit.spring.Service.Charite;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;

import tn.esprit.spring.Model.Commande;
import tn.esprit.spring.Model.Charite.Charite;
import tn.esprit.spring.Model.Charite.Endroit;
import tn.esprit.spring.Model.Charite.Events;

public interface ChariteDAO {
	boolean saveCharit(Charite Charite);
	List<Charite> getAllChariteList();
	public int saveCharite(Long idevents,Long iduser,Charite Charite);
	Charite findOne(Long id);
	public int saveCharite1(Long idevents,Long iduser,Charite Charite);
	public int saveCharitee(Long idevents,Long iduser,Long idcommande,Charite Charite);
	public List<Commande> getCommande(Long idCommande);
	public List<Charite> getCharite(Long iduser);
	Charite findOnes(Long id);
	public void facturepdf (int id_Charite);
	public boolean saveCharit2(long idevents,Charite Charite);
	public boolean saveCharit3(Events e1,Charite Charite);
	public int saveCharite5(Long idevents,Charite Charite);
	void deleteChariteById(long Id);
	public List<Charite> getChariteC(Long iduser);
	public List<Charite> getChariteM(Long iduser);
	List<Charite> getAllCharCom(Long id);
	public boolean saveCharitCom(Long idcommande,Charite Charite);
	public void Pay(Long idchar, String carta, int expMonth, int expYear, String cvc) throws AuthenticationException, InvalidRequestException, CardException, StripeException ;

	
}
