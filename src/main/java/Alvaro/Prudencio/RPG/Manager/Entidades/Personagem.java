package Alvaro.Prudencio.RPG.Manager.Entidades;


import jakarta.persistence.*;

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

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL)
    private List<Habilidade> habilidadesPersonagem = new ArrayList<>();

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
        this.nivelPersonagem = nivelPersonagem;
    }
}