package tn.esprit_3cinfogl1.revision3.DAO.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit_3cinfogl1.revision3.DAO.Entities.Division;
import tn.esprit_3cinfogl1.revision3.DAO.Entities.Joueur;
import tn.esprit_3cinfogl1.revision3.DAO.Entities.Poste;

import java.util.List;

@Repository

public interface JoueurRepository extends CrudRepository<Joueur,Integer> {




    @Query("select alias1 from Joueur alias1  where alias1.poste=?1 and alias1.taille=?2")
    List<Joueur> getJoueursByPosteAndTailleJPQL(Poste poste, Float taille);



    @Query(value = " select * from joueur alias where alias.poste = 'DEFFENSEUR' and alias.nb_buts_en_carriere>=20 and alias.blessure= 'false'",nativeQuery = true)
    List<Joueur> afficherJoueursPolyvalentsDisponiblesSQL();












}
