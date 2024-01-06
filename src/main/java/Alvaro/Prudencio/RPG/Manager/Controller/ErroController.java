package Alvaro.Prudencio.RPG.Manager.Controller;

import Alvaro.Prudencio.RPG.Manager.Exception.NivelMagiaException;
import Alvaro.Prudencio.RPG.Manager.Exception.NivelPersonagemException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErroController {
    @ExceptionHandler(NivelPersonagemException.class)
    public ResponseEntity<String>
    handleNivelPersonagemException(NivelPersonagemException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
    @ExceptionHandler(NivelMagiaException.class)
    public ResponseEntity<String>
    handleNivelMagiaException(NivelMagiaException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
}
