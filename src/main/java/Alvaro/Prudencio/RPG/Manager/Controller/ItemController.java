package Alvaro.Prudencio.RPG.Manager.Controller;


import Alvaro.Prudencio.RPG.Manager.Entidades.Item;
import Alvaro.Prudencio.RPG.Manager.Service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Item")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService ){
        this.itemService = itemService;
    }
    @GetMapping
    public List<Item> listarItem(){
        return itemService.listarItem();
    }
    @PostMapping
    public Item criarItem(@RequestBody Item itemNovo){
        return itemService.criarItem(itemNovo);
    }
    @DeleteMapping("/{id}")
    public void apagarItem(@PathVariable Long idItem){
        itemService.apagarItem(idItem);
    }
    @GetMapping("/{id}")
    public Item buscarItemPorId(@PathVariable Long idItem){
        return itemService.buscarItemPorId(idItem);
    }
    @GetMapping("/BuscarItemPorNome/{substringItem}")
    public ResponseEntity<List<Item>> buscarItemPorNome (@PathVariable String substringItem){
        List<Item> listaItemCorrespondentes = itemService.buscarItemPorNome(substringItem);
        if (!listaItemCorrespondentes.isEmpty()){
            return ResponseEntity.ok(listaItemCorrespondentes);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
