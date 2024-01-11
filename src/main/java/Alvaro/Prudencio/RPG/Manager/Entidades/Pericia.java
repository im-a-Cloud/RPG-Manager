package Alvaro.Prudencio.RPG.Manager.Entidades;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_pericias")
public class Pericia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPericia;

    private String nomePericia;

    private String atributoPericia; // atributo correspondente a pericia, por exemplo a pericia arcanismo usa o atributo inteligencia

    @ManyToOne
    @JoinColumn(name = "personagem_id")
    @JsonIgnore
    private Personagem personagem;

    public Long getIdPericia() {
        return idPericia;
    }

    public void setIdPericia(Long idPericia) {
        this.idPericia = idPericia;
    }

    public String getNomePericia() {
        return nomePericia;
    }

    public void setNomePericia(String nomePericia) {
        this.nomePericia = nomePericia;
    }

    public String getAtributoPericia() {
        return atributoPericia;
    }

    public void setAtributoPericia(String atributoPericia) {
        this.atributoPericia = atributoPericia;
    }
    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
}

