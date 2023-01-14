package tn.esprit_3cinfogl1.revision3.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Joueur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idJoueur;
    String nomJoueur;
    Float taille;
    @Enumerated(EnumType.STRING)
    Poste poste;
   Boolean blessure;
   Integer nbButsEnCarriere;

     //Le parent de Equipe
    @JsonIgnore
    @ManyToOne
    Equipe equipe;


}
