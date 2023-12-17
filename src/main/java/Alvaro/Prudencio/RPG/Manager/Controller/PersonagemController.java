package Alvaro.Prudencio.RPG.Manager.Controller;


import Alvaro.Prudencio.RPG.Manager.Entidades.Personagem;
import Alvaro.Prudencio.RPG.Manager.Service.PersonagemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Personagem")
public class PersonagemController {
    private final PersonagemService personagemService;

    public PersonagemController(PersonagemService personagemService){
        this.personagemService = personagemService;
    }
    @GetMapping
    public List<Personagem> listarPersonagens(){
        return personagemService.listarPersonagens();
    }
    @PostMapping
    public Personagem criarPersonagem(@RequestBody Personagem personagem){
        return personagemService.criarPersonagem(personagem);
    }
    @PutMapping("/{id}")
    public Personagem atualizarPersonagem(@PathVariable Long id, @RequestBody Personagem personagem){
        return personagemService.atualizarPersonagem(id, personagem);
    }
    @DeleteMapping("/{id}")
    public void apagarPersonagem(@PathVariable Long id){
        personagemService.apagarPersonagem(id);
    }
    @GetMapping("/{id}")
    public Personagem buscarPersonagemPorId(@PathVariable Long id){
        return personagemService.buscarPersonagemPorId(id);
    }
    @GetMapping("/BuscarPersonagemPorNome/{substringPersonagem}")
    public ResponseEntity<List<Personagem>> buscarPersonagemPorSubstring(@PathVariable String substringPersonagem){
        List<Personagem> listaPersonagensCorrespondentes = personagemService.buscarPersonagemPorSubstring(substringPersonagem);
        if (!listaPersonagensCorrespondentes.isEmpty()){
            return ResponseEntity.ok(listaPersonagensCorrespondentes);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}

