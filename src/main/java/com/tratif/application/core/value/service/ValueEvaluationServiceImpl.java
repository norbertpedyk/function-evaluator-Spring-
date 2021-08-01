package com.tratif.application.core.value.service;

import com.tratif.application.core.function.service.FunctionServiceImpl;
import com.tratif.application.core.value.model.Value;
import com.tratif.application.functions.*;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ValueEvaluationServiceImpl implements ValueEvaluationService {

    private final FunctionServiceImpl functionService;

    public ValueEvaluationServiceImpl(FunctionServiceImpl functionService) {
        this.functionService = functionService;
    }

    @Override
    public Integer evaluateAndSum(Collection<Value> values) {
        Integer sum = 0;
        for (Value value : values) {
            sum += evaluate(value);
        }
        return sum;
    }

    @Override
    public Integer evaluate(Value value) {
        int result;
        if (value instanceof Function1Result) {
            if (functionService.isActive(((Function1Result) value).getFunction())) {
                Function1Evaluator evaluator = new Function1Evaluator((Function1Result) value);
                result = evaluator.evaluate();
            } else {
                result = value.getValue();
            }
        } else if (value instanceof Function2Result) {
            if (functionService.isActive(((Function2Result) value).getFunction())) {
                Function2Evaluator evaluator = new Function2Evaluator((Function2Result) value);
                result = evaluator.evaluate();
            } else {
                result = value.getValue();
            }
        } else if (value instanceof Function3Result) {
            if (functionService.isActive(((Function3Result) value).getFunction())) {
                Function3Evaluator evaluator = new Function3Evaluator((Function3Result) value);
                result = evaluator.evaluate();
            } else {
                result = value.getValue();
            }
        } else throw new IllegalArgumentException("Provided parameter have incorrect type!");
        return result;
    }
}
