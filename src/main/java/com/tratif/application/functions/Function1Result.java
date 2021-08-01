package com.tratif.application.functions;

import com.tratif.application.core.function.model.Function;
import com.tratif.application.core.value.model.Value;

public class Function1Result extends Value {

    private Integer f1Arg;
    private Function function;

    public Function1Result(Integer uniqueId, Integer value, Integer f1Arg) {
        super(uniqueId, value);
        this.f1Arg = f1Arg;
        this.function = Function.FUNCTION_1;
    }

    public Integer getF1Arg() {
        return f1Arg;
    }

    public Function getFunction() {
        return function;
    }
}
