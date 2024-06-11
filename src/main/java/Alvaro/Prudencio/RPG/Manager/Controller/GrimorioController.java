package Alvaro.Prudencio.RPG.Manager.Controller;

import Alvaro.Prudencio.RPG.Manager.Entidades.Magia;
import Alvaro.Prudencio.RPG.Manager.Entidades.Personagem;
import Alvaro.Prudencio.RPG.Manager.Repository.MagiaRepository;
import Alvaro.Prudencio.RPG.Manager.Repository.PersonagemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Personagem/{idPersonagem}/Grimorio")
public class GrimorioController {
    private PersonagemRepository personagemRepository;
    private MagiaRepository magiaRepository;

    private GrimorioController(PersonagemRepository personagemRepository, MagiaRepository magiaRepository){
        this.personagemRepository = personagemRepository;
        this.magiaRepository = magiaRepository;
    }
    @GetMapping
    public ResponseEntity<List<Magia>> listarMagiasPersonagem(@PathVariable Long idPersonagem){
        Personagem personagem = personagemRepository.findById(idPersonagem)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));
        List<Magia> magiasPersonagem = personagem.getGrimorioPersonagem();
        return ResponseEntity.ok(magiasPersonagem);
    }
    @PostMapping("/adicionar/{idMagia}")
    public ResponseEntity<String> adicionarMagiaAoGrimorio(@PathVariable Long idPersonagem, @PathVariable Long idMagia){
        Personagem personagem = personagemRepository.findById(idPersonagem)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));
        Magia magia = magiaRepository.findById(idMagia)
                .orElseThrow(() -> new RuntimeException("Magia não encontrada"));
        if (magia.getPersonagem() != null){
            return ResponseEntity.badRequest().body("O personagem já possui essa magia");
        }
        String classePersonagem = personagem.getNomeClassePersonagem();
        if (!magia.getConjuradoresMagia().contains(classePersonagem)){
            return ResponseEntity.badRequest().body("O personagem não é da classe/subclasse que pode aprender essa magia");
        }
        magia.setPersonagem(personagem);
        magiaRepository.save(magia);

        personagem.getGrimorioPersonagem().add(magia);
        personagemRepository.save(personagem);

        return ResponseEntity.ok("Magia adicionada ao personagem com sucesso.");
    }
    @DeleteMapping("/remover/{idMagia}")
    public ResponseEntity<String> removerMagiaDoGrimorio(@PathVariable Long idPersonagem, @PathVariable Long idMagia){
        Personagem personagem = personagemRepository.findById(idPersonagem)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));
        Magia magia = magiaRepository.findById(idMagia)
                .orElseThrow(() -> new RuntimeException("Magia não encontrada"));
        if (!personagem.getGrimorioPersonagem().contains(magia)){
            return ResponseEntity.badRequest().body("O personagem não possui essa magia");
        }
        magia.setPersonagem(null);
        magiaRepository.save(magia);

        personagem.getGrimorioPersonagem().remove(magia);
        personagemRepository.save(personagem);
        return ResponseEntity.ok("Magia removida do personagem com sucesso.");
    }
}


