package tn.esprit_3cinfogl1.revision3.DAO.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit_3cinfogl1.revision3.DAO.Entities.Equipe;

@Repository
public interface EquipeRepository extends CrudRepository<Equipe,Integer> {
}
