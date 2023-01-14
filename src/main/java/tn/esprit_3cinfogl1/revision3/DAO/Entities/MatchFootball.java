package tn.esprit_3cinfogl1.revision3.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class MatchFootball implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idMatch;
    String libelle;
    String pays;
    @Temporal(TemporalType.DATE)
    Date dateMatch;
   //le parent de Equipe
    @JsonIgnore
    @ManyToMany
   List<Equipe> equipes;

}
