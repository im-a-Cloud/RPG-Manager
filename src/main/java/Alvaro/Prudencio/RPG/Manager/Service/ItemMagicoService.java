package Alvaro.Prudencio.RPG.Manager.Service;

import Alvaro.Prudencio.RPG.Manager.Entidades.ItemMagico;
import Alvaro.Prudencio.RPG.Manager.Repository.ItemMagicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemMagicoService {
    private final ItemMagicoRepository itemMagicoRepository;

    public ItemMagicoService(ItemMagicoRepository itemMagicoRepository){
        this.itemMagicoRepository = itemMagicoRepository;
    }
    public List<ItemMagico> listarItensMagicos(){
        return itemMagicoRepository.findAll();
    }
}
