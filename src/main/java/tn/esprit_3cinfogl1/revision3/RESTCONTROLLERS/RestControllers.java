package tn.esprit_3cinfogl1.revision3.RESTCONTROLLERS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit_3cinfogl1.revision3.DAO.Entities.*;
import tn.esprit_3cinfogl1.revision3.SERVICES.IServices;

import java.util.List;

@RequestMapping("Revision3Spring")
@RestController
public class RestControllers {

    @Autowired
    private IServices iserviceRest;


    @PostMapping("ajouterEquipe")
    Equipe ajouterEquipe(@RequestBody Equipe equipe){
        return iserviceRest.ajouterEquipe(equipe);

    }
  @PutMapping("ajouterJoueurEtAffecterEquipe")
  Joueur ajouterJoueurEtAffecterEquipe(@RequestBody Joueur joueur, @RequestParam Integer IdEquipe){

        return iserviceRest.ajouterJoueurEtAffecterEquipe(joueur,IdEquipe);

    }


    @GetMapping("afficherJoueursParPosteEtTaille")
    List<Joueur> afficherJoueursParPosteEtTaille(@RequestParam Poste poste, @RequestParam Float taille){

        return iserviceRest.afficherJoueursParPosteEtTaille(poste,taille);
    }

    @PostMapping("ajouterMatchFootballEtAffecterEquipe")
    MatchFootball ajouterMatchFootballEtAffecterEquipe(@RequestBody MatchFootball matchFootball, @RequestParam Integer IdEquipe1, @RequestParam Integer IdEquipe2)
    {
        return iserviceRest.ajouterMatchFootballEtAffecterEquipe(matchFootball,IdEquipe1,IdEquipe2);


    }

   @GetMapping("afficherJoueursDuMatchParDivisionEtPoste")
    List<Joueur> afficherJoueursDuMatchParDivisionEtPoste(@RequestParam Division division,@RequestParam Poste poste, @RequestParam Integer idMatch){
        return iserviceRest.afficherJoueursDuMatchParDivisionEtPoste(division,poste,idMatch);


    }
    /*@GetMapping("afficherJoueursPolyvalentsDisponibles")
    List<Joueur> afficherJoueursPolyvalentsDisponibles(){
        return iserviceRest.afficherJoueursPolyvalentsDisponibles();

    }*/














}










