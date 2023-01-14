package tn.esprit_3cinfogl1.revision3.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idEquipe;
    String nomEquipe;
    String Pays;
    @Enumerated(EnumType.STRING)
    Division division;
   //le child de MatchFootball
    @JsonIgnore
    @ManyToMany(mappedBy = "equipes",cascade = CascadeType.ALL)
    List<MatchFootball> footmatch;

    //le child de Joueur
    @JsonIgnore
    @OneToMany(mappedBy = "equipe",cascade = CascadeType.ALL)
    List<Joueur> players;

}
