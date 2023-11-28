package Controller;
import Model.Cartao;
import Service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/cartao")
public class CartaoController {
    @Autowired
    private CartaoService service;
    @PostMapping
    public ResponseEntity<Cartao> salvar(@RequestBody Cartao cartao) {
        cartao = service.salvar(cartao);
        return ResponseEntity.ok(cartao);
    }
    @PutMapping
    public ResponseEntity<Cartao> alterar(@RequestBody Cartao cartao) {
        cartao = service.alterar(cartao);
        return ResponseEntity.ok(cartao);
    }
    @GetMapping
    public ResponseEntity<List<Cartao>> listar() {
        return ResponseEntity.ok(service.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cartao> consultar(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.consultarPorId(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable("id") Integer id) {
        if (service.excluir(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


