package br.com.fabrica.benz.config.validacao;

import br.com.fabrica.benz.config.validacao.dto.ErroDeFormularioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroDeValidacaoHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus (code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDeFormularioDTO> handleErroDeValicacao(MethodArgumentNotValidException excecao){

        List<ErroDeFormularioDTO> errosDto = new ArrayList<>();
        List<FieldError> fieldErrors = excecao.getBindingResult().getFieldErrors();

        fieldErrors.forEach(fieldError -> {
            String mensagem = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            ErroDeFormularioDTO erroDto = new ErroDeFormularioDTO(fieldError.getField() + ": " + mensagem);
            errosDto.add(erroDto);
        });
        return errosDto;
    }

    @ResponseStatus (code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public void handleErroEntidadeNaoExistente(){
    }
}
