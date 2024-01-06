package Alvaro.Prudencio.RPG.Manager.Service;

import Alvaro.Prudencio.RPG.Manager.Entidades.Personagem;
import Alvaro.Prudencio.RPG.Manager.Exception.NivelPersonagemException;
import Alvaro.Prudencio.RPG.Manager.Repository.PersonagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonagemService {
    private final PersonagemRepository personagemRepository;

    public PersonagemService(PersonagemRepository personagemRepository){
        this.personagemRepository = personagemRepository;
    }
    public List<Personagem> listarPersonagens() {
        return personagemRepository.findAll();
    }
    public Personagem criarPersonagem(Personagem novoPersonagem) {
        try {
            novoPersonagem.setNivelPersonagem(novoPersonagem.getNivelPersonagem());
            return personagemRepository.save(novoPersonagem);
        } catch (NivelPersonagemException nivelPersonagemException) {
            throw new NivelPersonagemException(nivelPersonagemException.getMessage());
        }
    }
    public Personagem atualizarPersonagem(Long idPersonagem, Personagem personagemAtualizado){
        if (personagemRepository.existsById(idPersonagem)){
            personagemAtualizado.setIdPersonagem(idPersonagem);
            return personagemRepository.save(personagemAtualizado);
        }
        return null;
    }
    public void apagarPersonagem(Long idPersonagem){
        personagemRepository.deleteById(idPersonagem);
    }
    public Personagem buscarPersonagemPorId(Long idPersonagem){
        return personagemRepository.findById(idPersonagem).orElse(null);
    }
    public List<Personagem> buscarPersonagemPorSubstring(String substrinNomePersonagem){
        return personagemRepository.findByNomePersonagemContaining(substrinNomePersonagem);
    }
}
