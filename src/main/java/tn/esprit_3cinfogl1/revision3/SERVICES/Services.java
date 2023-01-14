package tn.esprit_3cinfogl1.revision3.SERVICES;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit_3cinfogl1.revision3.DAO.Entities.*;
import tn.esprit_3cinfogl1.revision3.DAO.Repositories.EquipeRepository;
import tn.esprit_3cinfogl1.revision3.DAO.Repositories.JoueurRepository;
import tn.esprit_3cinfogl1.revision3.DAO.Repositories.MatchRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class Services implements  IServices {
   @Autowired
   private JoueurRepository joueurRepo;
    @Autowired
    private MatchRepository matchRepo;
    @Autowired
    private EquipeRepository equipRepo;

    @Override
    public Equipe ajouterEquipe(Equipe equipe) {

        return equipRepo.save(equipe);
    }

    @Override
    public Joueur ajouterJoueurEtAffecterEquipe(Joueur joueur, Integer IdEquipe) {
        Equipe equipeaffectee=equipRepo.findById(IdEquipe).get();
        joueur.setEquipe(equipeaffectee);
        joueurRepo.save(joueur);
        return joueur;
    }

    @Override
    public List<Joueur> afficherJoueursParPosteEtTaille(Poste poste, Float taille) {
        return joueurRepo.getJoueursByPosteAndTailleJPQL(poste,taille);

       // return joueurRepo.getJoueursByPosteAndTailleSQL(poste,taille);
    }

    @Override
    public MatchFootball ajouterMatchFootballEtAffecterEquipe(MatchFootball matchFootball, Integer IdEquipe1, Integer IdEquipe2) {

        Equipe equip1=equipRepo.findById(IdEquipe1).get();
        Equipe equip2=equipRepo.findById(IdEquipe2).get();
       MatchFootball matchaffectee=matchFootball;
        if(IdEquipe1!=IdEquipe2){

            List<Equipe> lstmatch=new ArrayList<Equipe>();
            lstmatch.add(equip1);
            lstmatch.add(equip2);


       matchFootball.setEquipes(lstmatch);

            matchRepo.save(matchFootball);
        }
        else {
            log.info("deux equipes kif kif");
        }



        return matchFootball;
    }

    @Override
    public List<Joueur> afficherJoueursDuMatchParDivisionEtPoste(Division division, Poste poste, Integer idMatch) {

        MatchFootball match=matchRepo.findById(idMatch).get();

        List<Joueur> lstfinalj=new ArrayList<Joueur>();

        List<Equipe> listequipes=match.getEquipes();
                for(Equipe eq:listequipes){
                               if(eq.getDivision().equals(division)){

                                   List<Joueur> lstjoueurs=eq.getPlayers();
                                   for(Joueur joueur:lstjoueurs){
                                       if(joueur.getPoste().equals(poste)){
                                           lstfinalj.add(joueur);

                                       }
                                   }


                               }

                                 }

        return lstfinalj;
    }
    @Scheduled(cron = "4 * * * * *")
    @Override
    public void afficherJoueursPolyvalentsDisponibles() {
          List<Joueur> lstj= new ArrayList<Joueur>();
                  lstj=joueurRepo.afficherJoueursPolyvalentsDisponiblesSQL();
       for (Joueur joueur:lstj){
               log.info("Le joueur"+" "+joueur.getNomJoueur()+" "+"est polyvalent "+"\n");}


    }












}
