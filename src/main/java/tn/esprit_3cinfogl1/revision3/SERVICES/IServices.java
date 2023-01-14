package tn.esprit_3cinfogl1.revision3.SERVICES;

import tn.esprit_3cinfogl1.revision3.DAO.Entities.*;

import java.util.List;

public interface IServices {
    public Equipe ajouterEquipe(Equipe equipe);

    public Joueur ajouterJoueurEtAffecterEquipe(Joueur joueur,Integer IdEquipe);

      public List<Joueur> afficherJoueursParPosteEtTaille(Poste poste, Float taille);

       public MatchFootball ajouterMatchFootballEtAffecterEquipe(MatchFootball matchFootball,Integer IdEquipe1,Integer IdEquipe2);

    public List <Joueur> afficherJoueursDuMatchParDivisionEtPoste (Division division, Poste poste, Integer idMatch);

    public void afficherJoueursPolyvalentsDisponibles ();












}
