package intervals;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TaxBracketsTest {

    @Test
    void getTaxAmount() {

        Double[] incomes = {60000.00, 100000.00, 5000.00, 17000.00, 37000.00};
        Double[] incomeTaxes = {10000.00, 22000.00, 0.00, 700.00, 4400.00};
        Map<Double, Double> map = TaxBrackets.getTaxAmount(incomes);
        for(int i =0; i<incomes.length; i++) {
            assertEquals(incomeTaxes[i], map.get(incomes[i]));
        }
    }
}