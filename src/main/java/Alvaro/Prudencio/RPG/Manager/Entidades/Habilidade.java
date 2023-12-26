package Alvaro.Prudencio.RPG.Manager.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table (name = "tb_habilidades")
public class Habilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idHabilidade;
    private String nomeHabilidade;
    private String descricaoHabilidade;
    private String origemHabilidade;
    @ManyToOne
    @JoinColumn(name = "personagem_id")
    @JsonIgnore
    private Personagem personagem;

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public long getIdHabilidade() {
        return idHabilidade;
    }

    public void setIdHabilidade(long idHabilidade) {
        this.idHabilidade = idHabilidade;
    }

    public String getNomeHabilidade() {
        return nomeHabilidade;
    }

    public void setNomeHabilidade(String nomeHabilidade) {
        this.nomeHabilidade = nomeHabilidade;
    }

    public String getDescricaoHabilidade() {
        return descricaoHabilidade;
    }

    public void setDescricaoHabilidade(String descricaoHabilidade) {
        this.descricaoHabilidade = descricaoHabilidade;
    }

    public String getOrigemHabilidade() {
        return origemHabilidade;
    }

    public void setOrigemHabilidade(String origemHabilidade) {
        this.origemHabilidade = origemHabilidade;
    }
}
