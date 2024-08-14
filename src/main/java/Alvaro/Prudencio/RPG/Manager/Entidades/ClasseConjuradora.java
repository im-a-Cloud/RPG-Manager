package Alvaro.Prudencio.RPG.Manager.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_classes_conjuradoras")

public class ClasseConjuradora extends Classe{
    private String atributoConjuracao;
    private int salvamentoDC;
    private int modAtaqueMagico;
    private int truquesConhecidos;
    private int nivelMagiaMaximo;

    public String getAtributoConjuracao() {
        return atributoConjuracao;
    }

    public void setAtributoConjuracao(String atributoConjuracao) {
        this.atributoConjuracao = atributoConjuracao;
    }

    public int getSalvamentoDC() {
        return salvamentoDC;
    }

    public void setSalvamentoDC(int salvamentoDC) {
        this.salvamentoDC = salvamentoDC;
    }

    public int getModAtaqueMagico() {
        return modAtaqueMagico;
    }

    public void setModAtaqueMagico(int modAtaqueMagico) {
        this.modAtaqueMagico = modAtaqueMagico;
    }

    public int getTruquesConhecidos() {
        return truquesConhecidos;
    }

    public void setTruquesConhecidos(int truquesConhecidos) {
        this.truquesConhecidos = truquesConhecidos;
    }

    public int getNivelMagiaMaximo() {
        return nivelMagiaMaximo;
    }

    public void setNivelMagiaMaximo(int nivelMagiaMaximo) {
        this.nivelMagiaMaximo = nivelMagiaMaximo;
    }
}
