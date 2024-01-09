package Alvaro.Prudencio.RPG.Manager.Service.Implementation;

import Alvaro.Prudencio.RPG.Manager.Entidades.Item;
import Alvaro.Prudencio.RPG.Manager.Entidades.Magia;
import Alvaro.Prudencio.RPG.Manager.Entidades.Personagem;
import Alvaro.Prudencio.RPG.Manager.Exception.CustoItemException;
import Alvaro.Prudencio.RPG.Manager.Exception.NivelMagiaException;
import Alvaro.Prudencio.RPG.Manager.Exception.NivelPersonagemException;
import Alvaro.Prudencio.RPG.Manager.Exception.PesoItemException;
import Alvaro.Prudencio.RPG.Manager.Service.ValidationService;

public class ValidationServiceImplementation implements ValidationService {
    @Override
    public void ValidarNivelPersonagem(Personagem personagem) {
        if (personagem.getNivelPersonagem() >20 || personagem.getNivelPersonagem() <1){
            throw new NivelPersonagemException("O nível de personagem deve estar entre 1 e 20");
        }
    }
    public void ValidarNivelMagia(Magia magia){
        if (magia.getNivelMagia() > 9 || magia.getNivelMagia() < 0){
            throw new NivelMagiaException("O nível da magia deve estar entre 0 e 9");
        }
    }
    public void ValidarPesoItem(Item item){
        if (item.getPesoItem()< 0 || item.getPesoItem() > 250){
            throw new PesoItemException("O peso do item deve estar entre 0 e 250");
        }
    }
    @Override
    public void ValidarCustoItem(Item item) {
        if (item.getPesoItem()< 0 || item.getPesoItem() > 200000){
            throw new CustoItemException("O custo do item deve estar entre 0 e 200000");
        }
    }
}
