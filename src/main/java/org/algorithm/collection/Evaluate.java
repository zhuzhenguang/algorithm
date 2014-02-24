package org.algorithm.collection;

import org.algorithm.common.StdOut;

/**
 * 使用双栈进行运算
 * <p/>
 * Created by zhu on 14-2-25.
 */
public class Evaluate {
    private Stack<String> operators = new Stack<String>(100);
    private Stack<Double> values = new Stack<Double>(100);

    private String formula;

    public Evaluate(String formula) {
        this.formula = formula;
    }

    public Double evaluate() {
        String[] formulas = decodeFormula();
        String operatorString = "*/+-";

        for (String formula : formulas) {
            if ("(".equals(formula))
                continue;

            if (operatorString.contains(formula))
                operators.push(formula);
            else if (!")".equals(formula))
                values.push(Double.valueOf(formula));
            else {
                String operator = operators.pop();
                Double v1 = values.pop();
                Double v2 = values.pop();
                Double v3 = null;
                if ("+".equals(operator))
                    v3 = v1 + v2;
                else if ("-".equals(operator))
                    v3 = v2 - v1;
                else if ("*".equals(operator))
                    v3 = v2 * v1;
                else
                    v3 = v2 / v1;
                values.push(v3);
            }

        }
        return values.pop();
    }

    private String[] decodeFormula() {
        return this.formula.split(" ");
    }

    public static void main(String[] args) {
        Evaluate aEvaluate = new Evaluate("( ( ( 3 + 4 ) * 5 ) * ( 6 - 3 ) )");
        StdOut.println(aEvaluate.evaluate());
    }
}
