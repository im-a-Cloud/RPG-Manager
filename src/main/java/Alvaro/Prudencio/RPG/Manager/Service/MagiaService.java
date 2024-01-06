package Alvaro.Prudencio.RPG.Manager.Service;

import Alvaro.Prudencio.RPG.Manager.Entidades.Magia;
import Alvaro.Prudencio.RPG.Manager.Exception.NivelMagiaException;
import Alvaro.Prudencio.RPG.Manager.Repository.MagiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagiaService {
    private final MagiaRepository magiaRepository;

    private MagiaService(MagiaRepository magiaRepository){
        this.magiaRepository = magiaRepository;
    }
    public List<Magia> listarMagias() {
        return magiaRepository.findAll();
    }
    public Magia criarmagia(Magia novaMagia){
        try {
            novaMagia.setNivelMagia(novaMagia.getNivelMagia());
            return magiaRepository.save(novaMagia);
        } catch (NivelMagiaException nivelMagiaException){
            throw new NivelMagiaException(nivelMagiaException.getMessage());
        }
    }
    public void apagarMagia(Long magiaApagada){
        magiaRepository.deleteById(magiaApagada);
    }
    public Magia buscarMagiaPorId(Long idMagia){
        return magiaRepository.findById(idMagia).orElse(null);
    }
    public List<Magia> buscarMagiaPorNome(String substringNomeMagia){
        return magiaRepository.findByNomeMagiaContaining(substringNomeMagia);
    }
    public List<Magia> buscarMagiaPorEscola(String escolaMagia){
        return magiaRepository.findByEscolaMagiaContaining(escolaMagia);
    }
    public List<Magia> buscarMagiaPorConjurador(String conjuradoresMagia){
        return magiaRepository.findByConjuradoresMagiaContaining(conjuradoresMagia);
    }
    public List<Magia> buscarMagiaPorNivel(int nivelMagia){
        return magiaRepository.findByNivelMagia(nivelMagia);
    }
}
