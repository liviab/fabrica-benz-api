package br.com.fabrica.benz.config.validacao.dto;

public class ErroDeFormularioDTO {

    public String errors;

    public ErroDeFormularioDTO(String erro) {
        this.errors = erro;
    }

    public String getErrors(){
        return this.errors;
    }
}
