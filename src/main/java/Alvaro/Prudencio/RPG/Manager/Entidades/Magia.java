package Alvaro.Prudencio.RPG.Manager.Entidades;


import Alvaro.Prudencio.RPG.Manager.Exception.NivelMagiaException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_magias")
public class Magia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMagia;

    private String nomeMagia;
    private String escolaMagia; //evocação,necromancia,etc.
    private String descricaoMagia; //dano, efeito,etc.
    private double AlcanceMagiaEmMetros; //0 são magias de alcance pessoal ou toque
    private int nivelMagia; //valores entre 0 e 9, 0 são truques
    private String tempoConjuracao;
    private String componentesMagia; //formato de entrada '(V,S,M(NOME MATERIAL))'.
    private String conjuradoresMagia; //classes que podem aprender/usar essa magia
    private boolean requerConcentracao;
    private String duracaoMagia;
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

    public long getIdMagia() {
        return idMagia;
    }

    public void setIdMagia(long idMagia) {
        this.idMagia = idMagia;
    }

    public String getNomeMagia() {
        return nomeMagia;
    }

    public void setNomeMagia(String nomeMagia) {
        this.nomeMagia = nomeMagia;
    }

    public String getEscolaMagia() {
        return escolaMagia;
    }

    public void setEscolaMagia(String escolaMagia) {
        this.escolaMagia = escolaMagia;
    }

    public String getDescricaoMagia() {
        return descricaoMagia;
    }

    public void setDescricaoMagia(String descricaoMagia) {
        this.descricaoMagia = descricaoMagia;
    }

    public double getAlcanceMagiaEmMetros() {
        return AlcanceMagiaEmMetros;
    }

    public void setAlcanceMagiaEmMetros(double alcanceMagiaEmMetros) {
        AlcanceMagiaEmMetros = alcanceMagiaEmMetros;
    }

    public int getNivelMagia() {
        return nivelMagia;
    }

    public void setNivelMagia(int nivelMagia) {
        if(nivelMagia < 0 || nivelMagia >9){
            throw new NivelMagiaException("O nível da magia deve estar entre 0 e 9");
        }
        this.nivelMagia = nivelMagia;
    }

    public String getTempoConjuracao() {
        return tempoConjuracao;
    }

    public void setTempoConjuracao(String tempoConjuracao) {
        this.tempoConjuracao = tempoConjuracao;
    }

    public String getComponentesMagia() {
        return componentesMagia;
    }

    public void setComponentesMagia(String componentesMagia) {
        this.componentesMagia = componentesMagia;
    }

    public String getConjuradoresMagia() {
        return conjuradoresMagia;
    }

    public void setConjuradoresMagia(String conjuradoresMagia) {
        this.conjuradoresMagia = conjuradoresMagia;
    }

    public boolean isRequerConcentracao() {
        return requerConcentracao;
    }

    public void setRequerConcentracao(boolean requerConcentracao) {
        this.requerConcentracao = requerConcentracao;
    }

    public String getDuracaoMagia() {
        return duracaoMagia;
    }

    public void setDuracaoMagia(String duracaoMagia) {
        this.duracaoMagia = duracaoMagia;
    }
}
