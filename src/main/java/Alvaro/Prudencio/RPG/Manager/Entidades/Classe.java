package Alvaro.Prudencio.RPG.Manager.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_classes")

public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClasse;
    private String nomeClasse;
    private int dadoDeVida;
    private String profTestesDeResistencia;

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

    public long getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(long idClasse) {
        this.idClasse = idClasse;
    }

    public String getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public int getDadoDeVida() {
        return dadoDeVida;
    }

    public void setDadoDeVida(int dadoDeVida) {
        this.dadoDeVida = dadoDeVida;
    }

    public String getProfTestesDeResistencia() {
        return profTestesDeResistencia;
    }

    public void setProfTestesDeResistencia(String profTestesDeResistencia) {
        this.profTestesDeResistencia = profTestesDeResistencia;
    }
}
