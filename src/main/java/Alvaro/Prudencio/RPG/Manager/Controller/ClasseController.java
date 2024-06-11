package Alvaro.Prudencio.RPG.Manager.Controller;

import Alvaro.Prudencio.RPG.Manager.Entidades.Classe;
import Alvaro.Prudencio.RPG.Manager.Service.ClasseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Classe")
public class ClasseController {
    private final ClasseService classeService;

    public ClasseController(ClasseService classeService){
        this.classeService = classeService;
    }
    @GetMapping
    public List<Classe> listarClasses(){
        return classeService.listarClasses();
    }
    @PostMapping
    public void criarClasse(@RequestBody Classe novaClasse){
        classeService.criarClasse(novaClasse);
    }
}
