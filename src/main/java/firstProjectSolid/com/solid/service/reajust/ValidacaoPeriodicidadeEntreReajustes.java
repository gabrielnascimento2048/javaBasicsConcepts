package firstProjectSolid.com.solid.service.reajust;

import firstProjectSolid.com.solid.ValidacaoException;
import firstProjectSolid.com.solid.model.Funcionario;
import firstProjectSolid.com.solid.service.ValidacaoReajuste;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeriodicidadeEntreReajustes implements ValidacaoReajuste {

    public void validar(Funcionario funcionario, BigDecimal aumento) {
        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();
        long mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
        if (mesesDesdeUltimoReajuste < 6) {
            throw new ValidacaoException("Intervalo de reajustes menor de 6 meses");
        }
    }
}
