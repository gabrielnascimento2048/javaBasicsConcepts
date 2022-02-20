package firstProjectSolid.com.solid.model;

import java.math.BigDecimal;

public class Outsourcing {
    private DadosPessoais dadosPessoais;
    private String empresa;

    public Outsourcing(String nome, String cpf, Cargo cargo, BigDecimal salario) {
        this.dadosPessoais = new DadosPessoais(nome, cpf, cargo, salario);
        this.empresa = empresa;
    }
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getNome() {
        return dadosPessoais.getNome();
    }

    public String getCpf() {
        return dadosPessoais.getCpf();
    }

    public Cargo getCargo() {
        return dadosPessoais.getCargo();
    }

    public BigDecimal getSalario() {
        return dadosPessoais.getSalario();
    }


}
