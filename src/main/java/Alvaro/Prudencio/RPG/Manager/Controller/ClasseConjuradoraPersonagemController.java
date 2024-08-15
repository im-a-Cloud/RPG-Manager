package Alvaro.Prudencio.RPG.Manager.Controller;

import Alvaro.Prudencio.RPG.Manager.Entidades.Classe;
import Alvaro.Prudencio.RPG.Manager.Entidades.ClasseConjuradora;
import Alvaro.Prudencio.RPG.Manager.Entidades.Personagem;
import Alvaro.Prudencio.RPG.Manager.Repository.ClasseConjuradoraRepository;
import Alvaro.Prudencio.RPG.Manager.Repository.ClasseRepository;
import Alvaro.Prudencio.RPG.Manager.Repository.PersonagemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Personagem/{idPersonagem}/ClasseConjuradora")
public class ClasseConjuradoraPersonagemController {
    private ClasseConjuradoraRepository classeConjuradoraRepository;
    private PersonagemRepository personagemRepository;

    private ClasseConjuradoraPersonagemController(ClasseConjuradoraRepository classeConjuradoraRepository, PersonagemRepository personagemRepository){
        this.classeConjuradoraRepository = classeConjuradoraRepository;
        this.personagemRepository = personagemRepository;
    }
    @PostMapping("/adicionar/{idClasse}")
    public ResponseEntity<String> adicionarHabilidade(@PathVariable Long idPersonagem, @PathVariable Long idClasse) {
        Personagem personagem = personagemRepository.findById(idPersonagem)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));
        ClasseConjuradora classeConjuradora = classeConjuradoraRepository.findById(idClasse)
                .orElseThrow(() -> new RuntimeException("Classe não encontrada"));
        if (personagem.getClassePersonagem() != null) {
            return ResponseEntity.badRequest().body("O personagem já possui uma classe(depois eu farei multiclasse, confia)");
        }

        if (classeConjuradora.isConjuradorCompleto()) {
            classeConjuradora.setNivelMagiaMaximo((int) Math.ceil(personagem.getNivelPersonagem() / 2.0));
        }else {
            classeConjuradora.setNivelMagiaMaximo((int) Math.ceil(personagem.getNivelPersonagem() / 4.0));
        }
        if (classeConjuradora.getAtributoConjuracao().equalsIgnoreCase("inteligência")) {
            classeConjuradora.setModAtaqueMagico(personagem.getBonusProficiencia() + personagem.getValorBonusInteligencia());
        }
        if (classeConjuradora.getAtributoConjuracao().equalsIgnoreCase("carisma")) {
            classeConjuradora.setModAtaqueMagico(personagem.getBonusProficiencia() + personagem.getValorBonusCarisma());
        }
        if (classeConjuradora.getAtributoConjuracao().equalsIgnoreCase("sabedoria")) {
            classeConjuradora.setModAtaqueMagico(personagem.getBonusProficiencia() + personagem.getValorBonusSabedoria());
        }
        classeConjuradora.setSalvamentoDC(classeConjuradora.getModAtaqueMagico() + 8);
        personagem.setClassePersonagem(classeConjuradora);
        personagem.getClassesPersonagem().add(classeConjuradora);
        personagemRepository.save(personagem);

        return ResponseEntity.ok("Classe conjuradora adicionada ao personagem com sucesso.");
    }
}
