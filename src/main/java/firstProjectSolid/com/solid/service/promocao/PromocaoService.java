package firstProjectSolid.com.solid.service.promocao;

import firstProjectSolid.com.solid.ValidacaoException;
import firstProjectSolid.com.solid.model.Cargo;
import firstProjectSolid.com.solid.model.Funcionario;

public class PromocaoService {
    public void promover(Funcionario funcionario, boolean metaBatida) {
        Cargo cargoAtual = funcionario.getCargo();
        if (Cargo.GERENTE == cargoAtual) {
            throw new ValidacaoException("Gerentes não podem ser promovidos!");
        }
        if (metaBatida) {
            Cargo novoCargo = cargoAtual.getProximoCargo();
            funcionario.promover(novoCargo);
        } else {
            throw new ValidacaoException("Funcionário não bateu a meta");
        }
    }

}
