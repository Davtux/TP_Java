package com.iut.lasergame.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.iut.detente.lasergame.metier.LaserGameImpl;
import com.iut.detente.lasergame.model.Joueur;

@Path("/pojo")
public class Pojo {
	@GET
	@Produces("text/html")
	@Path("/bonjour")
	public String direBonjour(){
		return "Partie démarrée avec succès : ";
	}
	
	@GET
	@Produces("application/json")
	@Path("/recupererJoueur/{joueur}")
	public Joueur recupererJoueur(@PathParam("joueur")Integer idJoueur){
		Joueur j = LaserGameImpl.getLaserGame().getJoueur(idJoueur);
		return j;
	}
	
	@POST
	@Produces("application/json")
	@Path("/creerJoueur")
	public Joueur creerJoueur(Joueur joueur){
		LaserGameImpl.getLaserGame().ajouterJoueur(joueur);
		return joueur;
	}
}
