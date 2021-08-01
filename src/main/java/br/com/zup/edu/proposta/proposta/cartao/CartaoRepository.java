package br.com.zup.edu.proposta.proposta.cartao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartaoRepository extends JpaRepository<Cartao, String> {

    Optional<Cartao> findById(String numeroCartao);

}
