package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_cartao")
@Getter
@Setter
public class Cartao {
    @Id
    @GeneratedValue
    private Integer id;

    private String nomeCartao;
    private Integer numcartao;
    private Integer valiCartao;
}



