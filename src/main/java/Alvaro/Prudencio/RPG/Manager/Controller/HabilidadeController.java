package Alvaro.Prudencio.RPG.Manager.Controller;

import Alvaro.Prudencio.RPG.Manager.Entidades.Habilidade;
import Alvaro.Prudencio.RPG.Manager.Service.HabilidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/Habilidade")
public class HabilidadeController {
    private final HabilidadeService habilidadeService;

    public HabilidadeController(HabilidadeService habilidadeService){
        this.habilidadeService = habilidadeService;
    }
    @GetMapping
    public List<Habilidade> listarHabilidades(){
        return habilidadeService.listarHabilidades();
    }
    @PostMapping
    public Habilidade criarHabilidade(@RequestBody Habilidade novaHabilidade){
        return habilidadeService.criarHabilidade(novaHabilidade);
    }
    @PutMapping("/{id}")
    public Habilidade atualizarHabilidade(@PathVariable Long id, @RequestBody Habilidade habilidadeAtualizada){
        return habilidadeService.atualizarHabilidade(id, habilidadeAtualizada);
    }
    @DeleteMapping("/{id}")
    public void apagarHabilidade(@PathVariable Long idHabilidade){
        habilidadeService.apagarHabilidade(idHabilidade);
    }
    @GetMapping("/{id}")
    public Habilidade buscarHabilidadePorId(@PathVariable Long id){
        return habilidadeService.buscarHabilidadePorId(id);
    }
    @GetMapping("/BuscarHabilidadePorNome/{substringHabilidade}")
    public ResponseEntity<List<Habilidade>> buscarHabilidadePorSubstring(@PathVariable String substringHabilidade){
        List<Habilidade> listaHabilidadesCorrespondentes = habilidadeService.buscarHabilidadePorSubstring(substringHabilidade);
        if (!listaHabilidadesCorrespondentes.isEmpty()){
            return ResponseEntity.ok(listaHabilidadesCorrespondentes);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/BuscarHabilidadePorOrigem/{origemHabilidade}")
    public ResponseEntity<List<Habilidade>> buscarHabilidadePorOrigem(@PathVariable String origemHabilidade){
        List<Habilidade> listaHabilidadesCorrespondentes = habilidadeService.buscarHabilidadePorOrigem(origemHabilidade);
        if (!listaHabilidadesCorrespondentes.isEmpty()){
            return ResponseEntity.ok(listaHabilidadesCorrespondentes);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
