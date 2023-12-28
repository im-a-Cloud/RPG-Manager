package Alvaro.Prudencio.RPG.Manager.Controller;

import Alvaro.Prudencio.RPG.Manager.Entidades.ItemMagico;
import Alvaro.Prudencio.RPG.Manager.Repository.ItemMagicoRepository;
import Alvaro.Prudencio.RPG.Manager.Service.ItemMagicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ItemMagico")
public class ItemMagicoController {

    private ItemMagicoRepository itemMagicoRepository;
    private ItemMagicoService itemMagicoService;

    public ItemMagicoController(ItemMagicoRepository itemMagicoRepository){
        this.itemMagicoRepository = itemMagicoRepository;
    }
    @PostMapping("/criar")
    public ResponseEntity<String> criarItemMagico(@RequestBody ItemMagico itemMagico) {
        ItemMagico novoItemMagico = itemMagicoRepository.save(itemMagico);
        return ResponseEntity.ok("Item mágico criado com sucesso: ");
    }
    @GetMapping
    public List<ItemMagico> listarTodosItensMagicos(){
        return itemMagicoService.listarItensMagicos();
    }
}
