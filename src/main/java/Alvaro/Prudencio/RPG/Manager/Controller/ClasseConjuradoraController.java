package Alvaro.Prudencio.RPG.Manager.Controller;

import Alvaro.Prudencio.RPG.Manager.Entidades.ClasseConjuradora;
import Alvaro.Prudencio.RPG.Manager.Repository.ClasseConjuradoraRepository;
import Alvaro.Prudencio.RPG.Manager.Service.ClasseConjuradoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ClasseConjuradora")
public class ClasseConjuradoraController {
    private ClasseConjuradoraService classeConjuradoraService;
    private ClasseConjuradoraRepository classeConjuradoraRepository;

    public ClasseConjuradoraController(ClasseConjuradoraService classeConjuradoraService, ClasseConjuradoraRepository classeConjuradoraRepository){
        this.classeConjuradoraService = classeConjuradoraService;
        this.classeConjuradoraRepository = classeConjuradoraRepository;
    }
    @GetMapping
    public List<ClasseConjuradora> listarClassesConjuradoras(){
        return classeConjuradoraService.listarClassesConjuradoras();
    }
    @PostMapping("/criar")
    public ResponseEntity<String> criarClasseConjuradora(@RequestBody ClasseConjuradora classeConjuradora){
        ClasseConjuradora novaClasseConjuradora = classeConjuradoraRepository.save(classeConjuradora);
        return ResponseEntity.ok("Classe conjuradora criada com sucesso");
    }
}
