package com.tratif.application.functions;

import com.tratif.application.core.value.model.ValueEvaluator;

public class Function1Evaluator implements ValueEvaluator {

    private final Function1Result function1Result;

    public Function1Evaluator(Function1Result function1Result) {
        this.function1Result = function1Result;
    }

    @Override
    public Integer evaluate() {
        return function1Result.getF1Arg()+ function1Result.getValue();
    }

    //TODO: result of evaluation:  value + f1Arg
}
