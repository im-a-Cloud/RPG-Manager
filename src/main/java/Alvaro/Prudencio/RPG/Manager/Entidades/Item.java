package Alvaro.Prudencio.RPG.Manager.Entidades;

import jakarta.persistence.*;

@Entity
@Table (name = "tb_itens")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idItem;
    private String nomeItem;
    private String descricaoItem;
    private String tipoItem;
    private double pesoItem;
    private double custoItem;

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
        this.pesoItem = pesoItem;
    }

    public double getCustoItem() {
        return custoItem;
    }

    public void setCustoItem(double custoItem) {
        this.custoItem = custoItem;
    }
}
