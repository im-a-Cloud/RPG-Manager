package Alvaro.Prudencio.RPG.Manager.Service;

import Alvaro.Prudencio.RPG.Manager.Entidades.Habilidade;
import Alvaro.Prudencio.RPG.Manager.Repository.HabilidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilidadeService {
    private final HabilidadeRepository habilidadeRepository;

    private HabilidadeService(HabilidadeRepository habilidadeRepository){
        this.habilidadeRepository = habilidadeRepository;
    }
    public List<Habilidade> lisarHabilidades() {
        return habilidadeRepository.findAll();
    }
    public Habilidade criarHabilidade(Habilidade novaHabilidade){
        return habilidadeRepository.save(novaHabilidade);
    }
    public Habilidade atualizarHabilidade(Long idHabilidade, Habilidade habilidadeAtualizado){
        if (habilidadeRepository.existsById(idHabilidade)){
            habilidadeAtualizado.setIdHabilidade(idHabilidade);
            return habilidadeRepository.save(habilidadeAtualizado);
        }
        return null;
    }
    public void apagarHabilidade(Long idHabilidade){
        habilidadeRepository.deleteById(idHabilidade);
    }
    public Habilidade buscarHabilidadePorId(Long idHabilidade){
        return habilidadeRepository.findById(idHabilidade).orElse(null);
    }
    public List<Habilidade> buscarHabilidadePorSubstring(String substringNomeHabilidade){
        return habilidadeRepository.findByNomeHabilidadeContaining(substringNomeHabilidade);
    }
    public List<Habilidade> buscarHabilidadePorOrigem(String origemHabilidade){
        return habilidadeRepository.findByOrigemHabilidadeContaining(origemHabilidade);
    }
}
