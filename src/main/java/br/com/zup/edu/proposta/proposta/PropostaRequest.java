package br.com.zup.edu.proposta.proposta;

import br.com.zup.edu.proposta.proposta.validation.CEP;
import br.com.zup.edu.proposta.proposta.validation.CPFouCNPJ;
import br.com.zup.edu.proposta.proposta.validation.ProibiDuplicadoNoBanco;
import br.com.zup.edu.proposta.util.BuscaEndereco;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public class PropostaRequest {
    @NotBlank
    @ProibiDuplicadoNoBanco(aClass = Proposta.class,campo = "documento")
    @CPFouCNPJ
    private String documento;
    @NotBlank @Email
    @ProibiDuplicadoNoBanco(aClass = Proposta.class,campo = "email")
    private String email;
    @NotBlank
    private String nome;
    @PositiveOrZero
    private BigDecimal salario;
    @NotBlank @CEP
    private String cep;

    public PropostaRequest(String documento, String email, String nome,
                           BigDecimal salario, String cep) {
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.salario = salario;
        this.cep = cep;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getCep() {
        return cep;
    }

    public Proposta toProposta(Endereco enderecoSalvo){
        Endereco endereco  = new Endereco();
        return new Proposta(documento,email,nome,enderecoSalvo,salario, null);
    }
}
