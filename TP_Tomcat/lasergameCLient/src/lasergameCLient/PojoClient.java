package lasergameCLient;

import javax.ws.rs.core.MediaType;

import com.iut.detente.lasergame.model.Couleur;
import com.iut.detente.lasergame.model.Joueur;
import com.iut.detente.lasergame.model.Score;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class PojoClient {

	public static void main(String[] args) {

		final ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);

		final Client client = Client.create(clientConfig);

		final Joueur joueur = new Joueur();
		joueur.setNumeroJoueur(3);
		joueur.setCouleur(Couleur.BLANC);
		joueur.setPseudo("Roumain");
		joueur.setScore(new Score());

		client.resource(
				"http://localhost:8080/lasergame/resource/pojo/creerJoueur")
				.post(joueur);
		Joueur j = client
				.resource(
						"http://localhost:8080/lasergame/resource/pojo/recupererJoueur/3")
				.accept(MediaType.APPLICATION_JSON).get(Joueur.class);
		System.out.println(j);
	}
}
