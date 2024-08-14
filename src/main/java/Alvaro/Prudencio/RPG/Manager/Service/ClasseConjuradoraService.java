package Alvaro.Prudencio.RPG.Manager.Service;

import Alvaro.Prudencio.RPG.Manager.Entidades.Classe;
import Alvaro.Prudencio.RPG.Manager.Entidades.ClasseConjuradora;
import Alvaro.Prudencio.RPG.Manager.Repository.ClasseConjuradoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseConjuradoraService {
    private ClasseConjuradoraRepository classeConjuradoraRepository;

    private ClasseConjuradoraService(ClasseConjuradoraRepository classeConjuradoraRepository){
        this.classeConjuradoraRepository = classeConjuradoraRepository;
    }
    public List<ClasseConjuradora> listarClassesConjuradoras(){
        return classeConjuradoraRepository.findAll();
    }
}
