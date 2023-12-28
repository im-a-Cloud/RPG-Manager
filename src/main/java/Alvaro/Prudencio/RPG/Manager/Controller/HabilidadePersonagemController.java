package Alvaro.Prudencio.RPG.Manager.Controller;

import Alvaro.Prudencio.RPG.Manager.Entidades.Habilidade;
import Alvaro.Prudencio.RPG.Manager.Entidades.Personagem;
import Alvaro.Prudencio.RPG.Manager.Repository.HabilidadeRepository;
import Alvaro.Prudencio.RPG.Manager.Repository.PersonagemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Personagem/{idPersonagem}/habilidades")
public class HabilidadePersonagemController {
    private PersonagemRepository personagemRepository;

    private HabilidadeRepository habilidadeRepository;

    private HabilidadePersonagemController(PersonagemRepository personagemRepository, HabilidadeRepository habilidadeRepository) {
        this.personagemRepository = personagemRepository;
        this.habilidadeRepository = habilidadeRepository;
    }

    @GetMapping
    public ResponseEntity<List<Habilidade>> listarHabilidadesPersonagem(@PathVariable Long idPersonagem) {
        Personagem personagem = personagemRepository.findById(idPersonagem)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));

        List<Habilidade> habilidadesPersonagem = personagem.getHabilidadesPersonagem();
        return ResponseEntity.ok(habilidadesPersonagem);
    }

    @PostMapping("/adicionar/{idHabilidade}")
    public ResponseEntity<String> adicionarHabilidade(@PathVariable Long idPersonagem, @PathVariable Long idHabilidade) {
        Personagem personagem = personagemRepository.findById(idPersonagem)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));
        Habilidade habilidade = habilidadeRepository.findById(idHabilidade)
                .orElseThrow(() -> new RuntimeException("Habilidade não encontrada"));
        if (habilidade.getPersonagem() != null) {
            return ResponseEntity.badRequest().body("O personagem já possui essa habilidade");
        }
        habilidade.setPersonagem(personagem);
        habilidadeRepository.save(habilidade);

        personagem.getHabilidadesPersonagem().add(habilidade);
        personagemRepository.save(personagem);

        return ResponseEntity.ok("Habilidade adicionada ao personagem com sucesso.");
    }

    @DeleteMapping("/remover/{idHabilidade}")
    public ResponseEntity<String> removerHabilidade(@PathVariable Long idPersonagem, @PathVariable Long idHabilidade) {
        Personagem personagem = personagemRepository.findById(idPersonagem)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));
        Habilidade habilidade = habilidadeRepository.findById(idHabilidade)
                .orElseThrow(() -> new RuntimeException("Habilidade não encontrada"));
        if (!personagem.getHabilidadesPersonagem().contains(habilidade)) {
            return ResponseEntity.badRequest().body("O personagem não possui essa habilidade");
        }
        habilidade.setPersonagem(null);
        habilidadeRepository.save(habilidade);

        personagem.getHabilidadesPersonagem().remove(habilidade);
        personagemRepository.save(personagem);

        return ResponseEntity.ok("Habilidade removida com sucesso.");

    }
}