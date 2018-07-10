package intervals;

import java.util.HashMap;
import java.util.Map;

public class TaxBrackets {
    /**
     * Question 1: Bracketed Tax Engine
     * Imagine an income tax rate schedule defined by the following rules:
     * - The first $10,000 is not taxed
     * - The portion over $10,000 but not over $20,000 is taxed at 10%
     * - The portion over $20,000 but not over $50,000 is taxed at 20%
     * - The portion over $50k is taxed at 30%
     * e.g. an income of $60,000 would have a tax of $10,000
     *
     * A. You’re an accountant and need to run this for 100 clients. Write a small program that accepts
     * income and returns the tax amount due. A single method or
     * function is fine. Acceptable languages: Go, Java, JavaScript, Python, or Ruby.
     */
    /**
     * Computes tax amount for each income
     * @param amount array of incomes
     * @return Map of income to income tax amount
     */
    public static Map<Double,Double> getTaxAmount(Double[] amount) {
        Map<Double, Double> map = new HashMap<>();

        for(double income : amount) {
            //No need to compute already seen incomes
            if(!map.containsKey(income)) {
                if(income > 50000) {
                    map.put(income, (income-50000.00) * .3 + 7000.00);
                } else if (income > 20000){
                    map.put(income, (income-20000.00) * .2 + 1000.00);
                } else if(income > 10000) {
                    map.put(income, (income-10000) * .1);
                } else {
                    map.put(income, 0.00);
                }
            }
        }
        return map;
    }
}
