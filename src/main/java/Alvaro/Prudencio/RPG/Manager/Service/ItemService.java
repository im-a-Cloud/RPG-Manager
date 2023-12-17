package Alvaro.Prudencio.RPG.Manager.Service;

import Alvaro.Prudencio.RPG.Manager.Entidades.Item;
import Alvaro.Prudencio.RPG.Manager.Repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }
    public List<Item> listarItem(){
        return itemRepository.findAll();
    }
    public Item criarItem(Item itemNovo){
        return  itemRepository.save(itemNovo);
    }
    public void apagarItem(Long itemApagado){
        itemRepository.deleteById(itemApagado);
    }
    public Item buscarItemPorId(Long idItem){
        return itemRepository.findById(idItem).orElse(null);
    }
    public List<Item> buscarItemPorNome(String susbtringItem){
        return itemRepository.findByNomeItemContaining(susbtringItem);
    }
    /*public List<Item> buscarItemPorRaridade(String raridadeItem){
        return itemRepository.findByRariradeItem(raridadeItem);
    }*/
}
