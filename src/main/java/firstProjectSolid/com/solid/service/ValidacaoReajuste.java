package firstProjectSolid.com.solid.service;

import firstProjectSolid.com.solid.model.Funcionario;

import java.math.BigDecimal;

public interface ValidacaoReajuste {

    void validar(Funcionario funcionario, BigDecimal aumento);
}
