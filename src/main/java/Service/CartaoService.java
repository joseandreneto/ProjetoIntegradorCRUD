package Service;

import Model.Cartao;
import Repository.CartaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CartaoService {
    @Autowired
    private CartaoRepository cartaoRepository;

    public Cartao salvar(Cartao cartao) {
        return cartaoRepository.save(cartao);
    }

    public Cartao alterar(Cartao cartao) {
        if (cartaoRepository.existsById(cartao.getId())) {
            return cartaoRepository.save(cartao);
        } else {
            // Handle caso o Cartão não seja encontrado
            throw new RuntimeException("Cartão com ID " + cartao.getId() + " não encontrado.");
        }
    }

    public List<Cartao> listar() {
        return cartaoRepository.findAll();
    }

    public Cartao consultarPorId(Integer id) {
        return cartaoRepository.findById(id).orElse(null);
    }

    public Boolean excluir(Integer id) {
        try {
            cartaoRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Erro ao realizar Exclusão : {}", e.getMessage());
            return false;
        }
        return true;
    }
}