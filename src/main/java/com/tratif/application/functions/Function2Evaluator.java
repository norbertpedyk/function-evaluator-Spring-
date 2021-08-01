package com.tratif.application.functions;

import com.tratif.application.core.value.model.ValueEvaluator;

public class Function2Evaluator implements ValueEvaluator {

    private final Function2Result function2Result;

    public Function2Evaluator(Function2Result function2Result) {
        this.function2Result = function2Result;
    }

    @Override
    public Integer evaluate() {
        return function2Result.getF2Arg()* function2Result.getValue();
    }


    //TODO: result of evaluation:  value * f2Arg
}
