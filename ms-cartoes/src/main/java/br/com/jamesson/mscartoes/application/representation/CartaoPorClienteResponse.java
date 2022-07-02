package br.com.jamesson.mscartoes.application.representation;

import br.com.jamesson.mscartoes.domain.ClienteCartao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartaoPorClienteResponse {
    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;

    public static CartaoPorClienteResponse fromModel(ClienteCartao model){
        return new CartaoPorClienteResponse(model.getCartao().getNome(),
                model.getCartao().getBandeira().toString(), model.getLimite());
    }

}
