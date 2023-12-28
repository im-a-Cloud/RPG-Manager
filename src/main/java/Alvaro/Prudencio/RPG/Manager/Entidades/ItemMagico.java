package Alvaro.Prudencio.RPG.Manager.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_itens_magicos")
public class ItemMagico extends Item {
    private String raridadeItem;
    private boolean precisaSintonizacao;

    public String getRaridadeItem() {
        return raridadeItem;
    }

    public void setRaridadeItem(String raridadeItem) {
        this.raridadeItem = raridadeItem;
    }

    public boolean isPrecisaSintonizacao() {
        return precisaSintonizacao;
    }

    public void setPrecisaSintonizacao(boolean precisaSintonizacao) {
        this.precisaSintonizacao = precisaSintonizacao;
    }
}
