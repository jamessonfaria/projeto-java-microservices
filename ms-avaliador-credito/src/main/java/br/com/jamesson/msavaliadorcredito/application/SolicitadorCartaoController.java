package br.com.jamesson.msavaliadorcredito.application;

import br.com.jamesson.msavaliadorcredito.application.exception.ErrorSolicitacaoCartaoException;
import br.com.jamesson.msavaliadorcredito.domain.model.DadosSolicitacaoEmissaoCartao;
import br.com.jamesson.msavaliadorcredito.domain.model.ProtocoloSolicitacaoCartao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("solicitacoes-cartao")
@RequiredArgsConstructor
public class SolicitadorCartaoController {

    private final AvaliadorCreditoService avaliadorCreditoService;

    @PostMapping
    public ResponseEntity solicitarCartao(@RequestBody DadosSolicitacaoEmissaoCartao dados){
        try{
            ProtocoloSolicitacaoCartao protocolo = avaliadorCreditoService.solicitarEmissaoCartao(dados);
            return ResponseEntity.ok(protocolo);
        }catch (ErrorSolicitacaoCartaoException e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}
