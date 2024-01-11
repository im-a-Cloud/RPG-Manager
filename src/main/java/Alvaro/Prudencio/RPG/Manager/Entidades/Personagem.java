package Alvaro.Prudencio.RPG.Manager.Entidades;


import Alvaro.Prudencio.RPG.Manager.Exception.NivelPersonagemException;
import jakarta.persistence.*;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "tb_Personagem")
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPersonagem;
    private String nomePersonagem;
    private int nivelPersonagem;
    /*
    private String racaPersonagem;
    private int valorForca;
    private int valorDestreza;
    private int valorConstituicao;
    private int valorInteligencia;
    private int valorSabedoria;
    private int valorCarisma;

     */

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
    }
}