package Alvaro.Prudencio.RPG.Manager.Controller;

import Alvaro.Prudencio.RPG.Manager.Exception.CustoItemException;
import Alvaro.Prudencio.RPG.Manager.Exception.NivelMagiaException;
import Alvaro.Prudencio.RPG.Manager.Exception.NivelPersonagemException;
import Alvaro.Prudencio.RPG.Manager.Exception.PesoItemException;
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
    @ExceptionHandler(CustoItemException.class)
    public ResponseEntity<String>
    handleCustoItemException(CustoItemException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
    @ExceptionHandler(PesoItemException.class)
    public ResponseEntity<String>
    handlePesoItemException(PesoItemException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
}
