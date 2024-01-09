package Alvaro.Prudencio.RPG.Manager.Entidades;

import Alvaro.Prudencio.RPG.Manager.Exception.CustoItemException;
import Alvaro.Prudencio.RPG.Manager.Exception.NivelMagiaException;
import Alvaro.Prudencio.RPG.Manager.Exception.PesoItemException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table (name = "tb_itens")
@Inheritance(strategy = InheritanceType.JOINED)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idItem;
    private String nomeItem;
    private String descricaoItem;
    private String tipoItem;
    private double pesoItem;
    private double custoItem;
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

    public long getIdItem() {
        return idItem;
    }

    public void setIdItem(long idItem) {
        this.idItem = idItem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }

    public double getPesoItem() {
        return pesoItem;
    }

    public void setPesoItem(double pesoItem) {
        if(pesoItem < 0 || pesoItem >250){
            throw new PesoItemException("O peso do item deve estar entre 0 e 250");
        }
        this.pesoItem = pesoItem;
    }

    public double getCustoItem() {
        return custoItem;
    }

    public void setCustoItem(double custoItem) {
        if (custoItem < 0 || custoItem > 200000){
            throw new CustoItemException("O custo do item deve estar entre 0 e 200000");
        }
        this.custoItem = custoItem;
    }
}
