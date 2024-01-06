package Alvaro.Prudencio.RPG.Manager.Controller;


import Alvaro.Prudencio.RPG.Manager.Entidades.Personagem;
import Alvaro.Prudencio.RPG.Manager.Exception.NivelPersonagemException;
import Alvaro.Prudencio.RPG.Manager.Service.PersonagemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Personagem")
@Validated
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
    public ResponseEntity<String> criarPersonagem(@RequestBody Personagem personagem){
        try {
            personagemService.criarPersonagem(personagem);
            return ResponseEntity.status(HttpStatus.CREATED).body("personagem criado com sucesso");

        }catch (NivelPersonagemException nivelPersonagemException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(nivelPersonagemException.getMessage());
        }
    }
    @PutMapping("/{id}")
    public Personagem atualizarPersonagem(@PathVariable Long id, @RequestBody Personagem personagem){
        return personagemService.atualizarPersonagem(id, personagem);
    }
    @DeleteMapping("/{id}")
    public void apagarPersonagem(@PathVariable Long idPersonagem){
        personagemService.apagarPersonagem(idPersonagem);
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

