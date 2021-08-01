package com.tratif.application.functions;

import com.tratif.application.core.value.model.ValueEvaluator;

public class Function3Evaluator implements ValueEvaluator {

    private final Function3Result function3Result;

    public Function3Evaluator(Function3Result function3Result) {
        this.function3Result = function3Result;
    }

    @Override
    public Integer evaluate() {
        return (int)(Math.ceil(function3Result.getValue()/ function3Result.getF3Arg()));
    }

    //TODO: result of evaluation:  ceil(value / f3Arg)
}
