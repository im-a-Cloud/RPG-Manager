package Alvaro.Prudencio.RPG.Manager.Service;

import Alvaro.Prudencio.RPG.Manager.Entidades.Magia;
import Alvaro.Prudencio.RPG.Manager.Entidades.Personagem;

public interface ValidationService {
    public void ValidarNivelPersonagem(Personagem personagem);
    public void ValidarNivelMagia(Magia magia);
}
