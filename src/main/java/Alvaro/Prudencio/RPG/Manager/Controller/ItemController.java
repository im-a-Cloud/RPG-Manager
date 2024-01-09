package Alvaro.Prudencio.RPG.Manager.Controller;


import Alvaro.Prudencio.RPG.Manager.Entidades.Item;
import Alvaro.Prudencio.RPG.Manager.Exception.CustoItemException;
import Alvaro.Prudencio.RPG.Manager.Exception.PesoItemException;
import Alvaro.Prudencio.RPG.Manager.Service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    public ResponseEntity<String> criarItem(@RequestBody Item itemNovo){
        try{
            itemService.criarItem(itemNovo);
        }catch (CustoItemException custoItemException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(custoItemException.getMessage());
        } catch (PesoItemException pesoItemException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(pesoItemException.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Item criado com sucesso");
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
