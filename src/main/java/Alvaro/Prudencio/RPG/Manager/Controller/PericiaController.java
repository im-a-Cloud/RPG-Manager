package Alvaro.Prudencio.RPG.Manager.Controller;

import Alvaro.Prudencio.RPG.Manager.Entidades.Pericia;
import Alvaro.Prudencio.RPG.Manager.Service.PericiaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Pericia")
public class PericiaController {
    private final PericiaService periciaService;

    public PericiaController(PericiaService periciaService){
        this.periciaService = periciaService;
    }
    @GetMapping
    public List<Pericia> listarPericias(){
        return periciaService.listarPericiasPersonagem();
    }
    @PostMapping
    public ResponseEntity<String> criarPericia(@RequestBody Pericia novaPericia){
        periciaService.criarPericia(novaPericia);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pericia criada com sucesso");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagarPericia(@PathVariable Long idPericia){
        periciaService.apagarPericia(idPericia);
        return ResponseEntity.ok().body("Pericia apagada com sucesso");
    }
}
