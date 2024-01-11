package Alvaro.Prudencio.RPG.Manager.Controller;

import Alvaro.Prudencio.RPG.Manager.Entidades.Pericia;
import Alvaro.Prudencio.RPG.Manager.Entidades.Personagem;
import Alvaro.Prudencio.RPG.Manager.Repository.PericiaRepository;
import Alvaro.Prudencio.RPG.Manager.Repository.PersonagemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Personagem/{idPersonagem}/pericias")
public class ListaPericiaPersonagemController {
    private final PersonagemRepository personagemRepository;

    private final PericiaRepository periciaRepository;

    private ListaPericiaPersonagemController(PersonagemRepository personagemRepository, PericiaRepository periciaRepository) {
        this.personagemRepository = personagemRepository;
        this.periciaRepository = periciaRepository;
    }

    @PostMapping("/adicionar/{idPericia}")
    public ResponseEntity<String> adicionarPericiaPersonagem(@PathVariable Long idPersonagem, @PathVariable Long idPericia) {
        Personagem personagem = personagemRepository.findById(idPersonagem)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));
        Pericia pericia = periciaRepository.findById(idPericia)
                .orElseThrow(() -> new RuntimeException("Pericia não encontrada"));
        if (pericia.getPersonagem() != null) {
            return ResponseEntity.badRequest().body("O personagem já possui essa pericia");
        }
        pericia.setPersonagem(personagem);
        periciaRepository.save(pericia);

        personagem.getPericiasPersonagem().add(pericia);
        personagemRepository.save(personagem);

        return ResponseEntity.ok("Pericia adicionada ao personagem com sucesso.");
    }

    @DeleteMapping("/remover/{idPericia}")
    public ResponseEntity<String> removerPericiaPersonagem(@PathVariable Long idPersonagem, @PathVariable Long idPericia) {
        Personagem personagem = personagemRepository.findById(idPersonagem)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));
        Pericia pericia = periciaRepository.findById(idPericia)
                .orElseThrow(() -> new RuntimeException("Pericia não encontrada"));
        if (!personagem.getPericiasPersonagem().contains(pericia)) {
            return ResponseEntity.badRequest().body("O personagem não possui essa pericia");
        }
        pericia.setPersonagem(null);
        periciaRepository.save(pericia);

        personagem.getPericiasPersonagem().remove(pericia);
        personagemRepository.save(personagem);

        return ResponseEntity.ok("Pericia removida com sucesso.");

    }
}
