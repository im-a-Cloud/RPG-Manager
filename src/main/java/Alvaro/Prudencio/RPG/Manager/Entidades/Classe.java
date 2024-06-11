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
    private String nomeSubClasse;
    private int dadoDeVida;
    private String profTestesDeResistencia;
    private String profArmas;
    private String profArmaduras;
    private String profFerramentas;
    private String periciasIniciais;

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

    public String getProfArmas() {
        return profArmas;
    }

    public void setProfArmas(String profArmas) {
        this.profArmas = profArmas;
    }

    public String getProfArmaduras() {
        return profArmaduras;
    }

    public void setProfArmaduras(String profArmaduras) {
        this.profArmaduras = profArmaduras;
    }

    public String getProfFerramentas() {
        return profFerramentas;
    }

    public void setProfFerramentas(String profFerramentas) {
        this.profFerramentas = profFerramentas;
    }

    public String getPericiasIniciais() {
        return periciasIniciais;
    }

    public void setPericiasIniciais(String periciasIniciais) {
        this.periciasIniciais = periciasIniciais;
    }

    public String getNomeSubClasse() {
        return nomeSubClasse;
    }

    public void setNomeSubClasse(String nomeSubClasse) {
        this.nomeSubClasse = nomeSubClasse;
    }
}
