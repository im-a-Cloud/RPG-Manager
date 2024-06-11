package Alvaro.Prudencio.RPG.Manager.Entidades;


import Alvaro.Prudencio.RPG.Manager.Exception.NivelPersonagemException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

@Entity
@Table (name = "tb_Personagem")
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPersonagem;
    private String nomePersonagem;
    private int nivelPersonagem;
    private String racaPersonagem;

    private int valorForca;
    private int valorBonusForca;

    private int valorDestreza;
    private int valorBonusDestreza;

    private int valorConstituicao;
    private int valorBonusConstituicao;

    private int valorInteligencia;
    private int valorBonusInteligencia;

    private int valorSabedoria;
    private int valorBonusSabedoria;

    private int valorCarisma;
    private int valorBonusCarisma;

    private int bonusProficiencia;

    @ManyToOne
    @JoinColumn(name = "classe_id")
    @JsonIgnore
    private Classe classePersonagem;

    public void setValorBonusForca(int valorBonusForca) {
        this.valorBonusForca = valorBonusForca;
    }

    public void setValorBonusDestreza(int valorBonusDestreza) {
        this.valorBonusDestreza = valorBonusDestreza;
    }

    public void setValorBonusConstituicao(int valorBonusConstituicao) {
        this.valorBonusConstituicao = valorBonusConstituicao;
    }

    public void setValorBonusInteligencia(int valorBonusInteligencia) {
        this.valorBonusInteligencia = valorBonusInteligencia;
    }

    public void setValorBonusSabedoria(int valorBonusSabedoria) {
        this.valorBonusSabedoria = valorBonusSabedoria;
    }

    public void setValorBonusCarisma(int valorBonusCarisma) {
        this.valorBonusCarisma = valorBonusCarisma;
    }

    public void setBonusProficiencia(int bonusProficiencia) {
        this.bonusProficiencia = bonusProficiencia;
    }

    public int getValorBonusDestreza() {
        return valorBonusDestreza;
    }

    public int getValorBonusConstituicao() {
        return valorBonusConstituicao;
    }

    public int getValorBonusInteligencia() {
        return valorBonusInteligencia;
    }

    public int getValorBonusSabedoria() {
        return valorBonusSabedoria;
    }

    public int getValorBonusCarisma() {
        return valorBonusCarisma;
    }

    public int getValorDestreza() {
        return valorDestreza;
    }

    public void setValorDestreza(int valorDestreza) {
        this.valorDestreza = valorDestreza;
    }

    public int getValorConstituicao() {
        return valorConstituicao;
    }

    public void setValorConstituicao(int valorConstituicao) {
        this.valorConstituicao = valorConstituicao;
    }

    public int getValorInteligencia() {
        return valorInteligencia;
    }

    public void setValorInteligencia(int valorInteligencia) {
        this.valorInteligencia = valorInteligencia;
    }

    public int getValorSabedoria() {
        return valorSabedoria;
    }

    public void setValorSabedoria(int valorSabedoria) {
        this.valorSabedoria = valorSabedoria;
    }

    public int getValorCarisma() {
        return valorCarisma;
    }

    public void setValorCarisma(int valorCarisma) {
        this.valorCarisma = valorCarisma;
    }

    public String getRacaPersonagem() {
        return racaPersonagem;
    }

    public void setRacaPersonagem(String racaPersonagem) {
        this.racaPersonagem = racaPersonagem;
    }

    public int getValorBonusForca() {
        return valorBonusForca;
    }

    public int getBonusProficiencia() {
        return bonusProficiencia;
    }
    public int getValorForca() {
        return valorForca;
    }

    public void setValorForca(int valorForca) {
        this.valorForca = valorForca;
    }

    public void calcularBonusProficiencia(){
        this.bonusProficiencia = (int) (Math.ceil(nivelPersonagem/4)) +2;
    }
    public void enviarBonusAtributo(){
        this.valorBonusForca = calcularBonusAtributo(valorForca);
        this.valorBonusConstituicao = calcularBonusAtributo(valorConstituicao);
        this.valorBonusDestreza = calcularBonusAtributo(valorDestreza);
        this.valorBonusInteligencia = calcularBonusAtributo(valorInteligencia);
        this.valorBonusSabedoria = calcularBonusAtributo(valorSabedoria);
        this.valorBonusCarisma = calcularBonusAtributo(valorCarisma);
    }

    public int calcularBonusAtributo(int valorAtributo){
        return (int)(Math.ceil(valorAtributo -10)/2);
    }
    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL)
    private List<Habilidade> habilidadesPersonagem = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "inventario",
            joinColumns = @JoinColumn(name = "personagem_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> inventarioPersonagem = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "grimorio",
            joinColumns = @JoinColumn(name = "personagem_id"),
            inverseJoinColumns = @JoinColumn(name = "magia_id")
    )
    private List<Magia> grimorioPersonagem = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "pericias",
            joinColumns = @JoinColumn(name = "personagem_id"),
            inverseJoinColumns = @JoinColumn(name = "pericia_id")
    )
    private List<Pericia> periciasPersonagem = new ArrayList<>();

    public List<Pericia> getPericiasPersonagem() {
        return periciasPersonagem;
    }

    public void setPericiasPersonagem(List<Pericia> periciasPersonagem) {
        this.periciasPersonagem = periciasPersonagem;
    }
    @ManyToMany
    @JoinTable(
            name = "classe",
            joinColumns = @JoinColumn(name = "personagem_id"),
            inverseJoinColumns = @JoinColumn(name = "classe_id")
    )
    private List<Classe> classesPersonagem = new ArrayList<>();

    public List<Classe> getClassesPersonagem(){
        return classesPersonagem;
    }

    public List<Magia> getGrimorioPersonagem() {
        return grimorioPersonagem;
    }

    public void setGrimorioPersonagem(List<Magia> grimorioPersonagem) {
        this.grimorioPersonagem = grimorioPersonagem;
    }

    public List<Item> getInventarioPersonagem() {
        return inventarioPersonagem;
    }

    public void setInventarioPersonagem(List<Item> inventarioPersonagem) {
        this.inventarioPersonagem = inventarioPersonagem;
    }

    public List<Habilidade> getHabilidadesPersonagem() {
        return habilidadesPersonagem;
    }

    public void setHabilidadesPersonagem(List<Habilidade> habilidadesPersonagem) {
        this.habilidadesPersonagem = habilidadesPersonagem;
    }

    public long getIdPersonagem() {
        return idPersonagem;
    }

    public void setIdPersonagem(long idPersonagem) {
        this.idPersonagem = idPersonagem;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }

    public int getNivelPersonagem() {
        return nivelPersonagem;
    }

    public void setNivelPersonagem(int nivelPersonagem) {
        if (nivelPersonagem < 1 || nivelPersonagem > 20){
            throw new NivelPersonagemException("O nível de personagem deve estar entre 1 e 20");
        }
        this.nivelPersonagem = nivelPersonagem;
        calcularBonusProficiencia();
        enviarBonusAtributo();
    }
    public Classe getClassePersonagem() {
        return classePersonagem;
    }

    public void setClassePersonagem(Classe classePersonagem) {
        this.classePersonagem = classePersonagem;
    }

    public void setClassesPersonagem(List<Classe> classesPersonagem) {
        this.classesPersonagem = classesPersonagem;
    }
    @JsonIgnore
    public String getNomeClassePersonagem(){
        return classePersonagem.getNomeClasse();
    }
}