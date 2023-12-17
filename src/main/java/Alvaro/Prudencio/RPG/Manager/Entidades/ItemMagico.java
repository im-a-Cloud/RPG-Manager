package Alvaro.Prudencio.RPG.Manager.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_itens_magicos")
public class ItemMagico extends Item{
    private String raridadeItem;
    private boolean requerSintonizacao;

    public String getRaridadeItem() {
        return raridadeItem;
    }

    public void setRaridadeItem(String raridadeItem) {
        this.raridadeItem = raridadeItem;
    }

    public boolean isRequerSintonizacao() {
        return requerSintonizacao;
    }

    public void setRequerSintonizacao(boolean requerSintonizacao) {
        this.requerSintonizacao = requerSintonizacao;
    }
}
