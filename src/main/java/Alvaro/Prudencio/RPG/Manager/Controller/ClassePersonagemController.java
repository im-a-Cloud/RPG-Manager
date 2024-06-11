package Alvaro.Prudencio.RPG.Manager.Controller;

import Alvaro.Prudencio.RPG.Manager.Entidades.Classe;
import Alvaro.Prudencio.RPG.Manager.Entidades.Personagem;
import Alvaro.Prudencio.RPG.Manager.Repository.ClasseRepository;
import Alvaro.Prudencio.RPG.Manager.Repository.PersonagemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Personagem/{idPersonagem}/Classe")
public class ClassePersonagemController {
    private ClasseRepository classeRepository;
    private PersonagemRepository personagemRepository;

    private ClassePersonagemController(ClasseRepository classeRepository, PersonagemRepository personagemRepository){
        this.classeRepository = classeRepository;
        this.personagemRepository = personagemRepository;
    }
    @GetMapping
    public ResponseEntity<List<Classe>> listarClassePersonagem(@PathVariable Long idPersonagem){
        Personagem personagem = personagemRepository.findById(idPersonagem)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));
        List<Classe> classesPersonagem = personagem.getClassesPersonagem();
        return ResponseEntity.ok(classesPersonagem);
    }
    @PostMapping("/adicionar/{idClasse}")
    public ResponseEntity<String> adicionarHabilidade(@PathVariable Long idPersonagem, @PathVariable Long idClasse) {
        Personagem personagem = personagemRepository.findById(idPersonagem)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));
        Classe classe = classeRepository.findById(idClasse)
                .orElseThrow(() -> new RuntimeException("Classe não encontrada"));
        if (personagem.getClassePersonagem() != null) {
            return ResponseEntity.badRequest().body("O personagem já possui uma classe(depois eu farei multiclasse, confia)");
        }
        personagem.setClassePersonagem(classe);
        personagem.getClassesPersonagem().add(classe);
        personagemRepository.save(personagem);

        return ResponseEntity.ok("Classe adicionada ao personagem com sucesso.");
    }
}
