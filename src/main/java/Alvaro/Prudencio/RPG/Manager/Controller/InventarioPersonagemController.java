package Alvaro.Prudencio.RPG.Manager.Controller;


import Alvaro.Prudencio.RPG.Manager.Entidades.Item;
import Alvaro.Prudencio.RPG.Manager.Entidades.ItemMagico;
import Alvaro.Prudencio.RPG.Manager.Entidades.Personagem;
import Alvaro.Prudencio.RPG.Manager.Repository.ItemMagicoRepository;
import Alvaro.Prudencio.RPG.Manager.Repository.ItemRepository;
import Alvaro.Prudencio.RPG.Manager.Repository.PersonagemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Personagem/{idPersonagem}/inventario")
public class InventarioPersonagemController {
    private PersonagemRepository personagemRepository;
    private ItemRepository itemRepository;

    private ItemMagicoRepository itemMagicoRepository;

    private InventarioPersonagemController(PersonagemRepository personagemRepository, ItemRepository itemRepository, ItemMagicoRepository itemMagicoRepository){
        this.personagemRepository = personagemRepository;
        this.itemRepository = itemRepository;
        this.itemMagicoRepository = itemMagicoRepository;
    }
    @PostMapping("/adicionar/{idItem}")
    public ResponseEntity<String> adicionarItemAoInventario(@PathVariable Long idPersonagem, @PathVariable Long idItem){
        Personagem personagem = personagemRepository.findById(idPersonagem)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));

        Item item = itemRepository.findById(idItem)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        if (item instanceof ItemMagico){
            ItemMagico itemMagico = (ItemMagico) item;
            personagem.getInventarioPersonagem().add(itemMagico);
            personagemRepository.save(personagem);
            return ResponseEntity.ok("Item mágico adicionado com sucesso");
        }else {
            personagem.getInventarioPersonagem().add(item);
            personagemRepository.save(personagem);
            return ResponseEntity.ok("Item não mágico adicionado com sucesso");
        }
    }
    @DeleteMapping("/remover/{idItem}")
    public ResponseEntity<String> removerItemDoInventario(@PathVariable Long idPersonagem, @PathVariable Long idItem) {
        Personagem personagem = personagemRepository.findById(idPersonagem)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));

        Item item = itemRepository.findById(idItem)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));
        if (!personagem.getInventarioPersonagem().contains(item)){
            return ResponseEntity.badRequest().body("O personagem não possui esse item");
        }
        if (item instanceof ItemMagico){
            ItemMagico itemMagico = (ItemMagico) item;
            item.setPersonagem(null);
            itemRepository.save(itemMagico);

            personagem.getInventarioPersonagem().remove(itemMagico);
            personagemRepository.save(personagem);
        }else{
            item.setPersonagem(null);
            itemRepository.save(item);

            personagem.getInventarioPersonagem().remove(item);
            personagemRepository.save(personagem);
        }
        return ResponseEntity.ok("Item removido do inventário sucesso.");
    }
}
