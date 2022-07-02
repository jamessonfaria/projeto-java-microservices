package br.com.jamesson.msavaliadorcredito.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class DadosCliente {

    private Long id;
    private String nome;
    private Integer idade;

}
