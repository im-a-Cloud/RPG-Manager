package Alvaro.Prudencio.RPG.Manager.Service;

import Alvaro.Prudencio.RPG.Manager.Entidades.Item;
import Alvaro.Prudencio.RPG.Manager.Exception.CustoItemException;
import Alvaro.Prudencio.RPG.Manager.Exception.PesoItemException;
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
        try{
            itemNovo.setPesoItem(itemNovo.getPesoItem());
        }catch (PesoItemException pesoItemException){
            throw new PesoItemException(pesoItemException.getMessage());
        }
        try{
            itemNovo.setCustoItem(itemNovo.getCustoItem());
        }catch (CustoItemException custoItemException){
            throw new CustoItemException(custoItemException.getMessage());
        }
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
}
