package Alvaro.Prudencio.RPG.Manager.Service;

import Alvaro.Prudencio.RPG.Manager.Entidades.Pericia;
import Alvaro.Prudencio.RPG.Manager.Repository.PericiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PericiaService {
    private final PericiaRepository periciaRepository;

    public PericiaService(PericiaRepository periciaRepository){
        this.periciaRepository = periciaRepository;
    }
    public List<Pericia> listarPericiasPersonagem(){
        return periciaRepository.findAll();
    }
    public Pericia criarPericia(Pericia novaPericia){
        return periciaRepository.save(novaPericia);
    }
    public void apagarPericia(Long idPericiaApagada){
        periciaRepository.deleteById(idPericiaApagada);
    }
}
