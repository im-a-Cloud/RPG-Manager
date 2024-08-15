package Alvaro.Prudencio.RPG.Manager.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "tb_classes_conjuradoras")

public class ClasseConjuradora extends Classe{
    private String atributoConjuracao;
    private int salvamentoDC;
    private int modAtaqueMagico;
    private int truquesConhecidos;
    private int nivelMagiaMaximo;
    private boolean conjuradorCompleto = true;

    public boolean isConjuradorCompleto() {
        return conjuradorCompleto;
    }

    public void setConjuradorCompleto(boolean conjuradorCompleto) {
        this.conjuradorCompleto = conjuradorCompleto;
    }
    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    @ManyToOne // Ou @OneToOne, dependendo da sua modelagem
    @JoinColumn(name = "personagem_id")
    private Personagem personagem;

    public ClasseConjuradora() {
        // Construtor padrão necessário para JPA
    }

    @Autowired
    public ClasseConjuradora(Personagem personagem){
        this.personagem = personagem;
        calcularNivelMagiaMaximo();
    }


    public void calcularNivelMagiaMaximo(){
        if (personagem != null) {
            this.nivelMagiaMaximo = (int) (Math.ceil(personagem.getNivelPersonagem() / 2));
        }
    }
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
