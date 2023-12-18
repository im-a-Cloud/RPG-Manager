package Alvaro.Prudencio.RPG.Manager.Controller;

import Alvaro.Prudencio.RPG.Manager.Entidades.Magia;
import Alvaro.Prudencio.RPG.Manager.Service.MagiaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/Magia")
public class MagiaController {
    private final MagiaService magiaService;

    public MagiaController(MagiaService magiaService){
        this.magiaService = magiaService;
    }
    @GetMapping
    public List<Magia> listarMagias(){
        return magiaService.listarMagias();
    }
    @PostMapping
    public Magia criarMagia(@RequestBody Magia magiaNova){
        return magiaService.criarmagia(magiaNova);
    }
    @DeleteMapping("/{id}")
    public void apagarMagia(@PathVariable Long idMagia){
        magiaService.apagarMagia(idMagia);
    }
    @GetMapping("/{id}") //não funciona
    public Magia buscarMagiaPorId(@PathVariable Long idMagia){
        return magiaService.buscarMagiaPorId(idMagia);
    }
    @GetMapping("/BuscarMagiaPorNome/{substringMagia}") //funciona
    public ResponseEntity<List<Magia>> buscarMagiaPorNome(@PathVariable String substringMagia){
        List<Magia> listaMagiaCorrespondentes = magiaService.buscarMagiaPorNome(substringMagia);
        if (!listaMagiaCorrespondentes.isEmpty()){
            return ResponseEntity.ok(listaMagiaCorrespondentes);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/BuscarMagiaPorEscola/{escolaMagia}") //funciona
    public ResponseEntity<List<Magia>> buscarMagiaPorEscola(@PathVariable String escolaMagia){
        List<Magia> listaMagiaCorrespondentes = magiaService.buscarMagiaPorEscola(escolaMagia);
        if (!listaMagiaCorrespondentes.isEmpty()){
            return ResponseEntity.ok(listaMagiaCorrespondentes);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/BuscarMagiaPorClasse/{classeConjurador}") //funciona
    public ResponseEntity<List<Magia>> buscarMagiaPorConjurador(@PathVariable String classeConjurador){
        List<Magia> listaMagiaCorrespondentes = magiaService.buscarMagiaPorConjurador(classeConjurador);
        if (!listaMagiaCorrespondentes.isEmpty()){
            return ResponseEntity.ok(listaMagiaCorrespondentes);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/BuscarMagiaPorNivel/{nivelMagia}") //funciona
    public ResponseEntity<List<Magia>> buscarMagiaPorNivel(@PathVariable int nivelMagia){
        List<Magia> listaMagiaCorrespondentes = magiaService.buscarMagiaPorNivel(nivelMagia);
        if (!listaMagiaCorrespondentes.isEmpty()){
            return ResponseEntity.ok(listaMagiaCorrespondentes);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
