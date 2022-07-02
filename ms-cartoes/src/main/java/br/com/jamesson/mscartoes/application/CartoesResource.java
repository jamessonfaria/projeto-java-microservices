package br.com.jamesson.mscartoes.application;

import br.com.jamesson.mscartoes.application.representation.CartaoPorClienteResponse;
import br.com.jamesson.mscartoes.application.representation.CartaoSaveRequest;
import br.com.jamesson.mscartoes.domain.Cartao;
import br.com.jamesson.mscartoes.domain.ClienteCartao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cartoes")
@RequiredArgsConstructor
public class CartoesResource {

    private final CartaoService cartaoService;
    private final ClienteCartaoService clienteCartaoService;

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity cadastra(@RequestBody CartaoSaveRequest request){
        var cartao = request.toModel();
        cartaoService.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaAte(@RequestParam("renda") Long renda){
        List<Cartao> cartaoList = cartaoService.getCartoesRendaMenorIgual(renda);
        return ResponseEntity.ok(cartaoList);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartaoPorClienteResponse>> getCartoesByCliente(@RequestParam("cpf") String cpf){
        List<ClienteCartao> list = clienteCartaoService.listCartoesByCpf(cpf);
        List<CartaoPorClienteResponse> listaResponse = list.stream().map(CartaoPorClienteResponse::fromModel).collect(Collectors.toList());
        return ResponseEntity.ok(listaResponse);
    }


}
