package Alvaro.Prudencio.RPG.Manager.Service;

import Alvaro.Prudencio.RPG.Manager.Entidades.Classe;
import Alvaro.Prudencio.RPG.Manager.Repository.ClasseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseService {
    private ClasseRepository classeRepository;

    private ClasseService (ClasseRepository classeRepository){
        this.classeRepository = classeRepository;
    }
    public List<Classe> listarClasses(){
        return classeRepository.findAll();
    }
    public Classe criarClasse(Classe novaClasse){
        return classeRepository.save(novaClasse);
    }
    public void apagarClasse(Long idClasse){
        classeRepository.deleteById(idClasse);
    }
}
