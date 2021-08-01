package com.tratif.application.core.value.service;

import com.tratif.application.core.function.model.Function;
import com.tratif.application.core.function.service.FunctionServiceImpl;
import com.tratif.application.core.value.model.Value;
import com.tratif.application.functions.Function1Result;
import com.tratif.application.functions.Function2Result;
import com.tratif.application.functions.Function3Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ValueEvaluationServiceImplTest {
    private FunctionServiceImpl functionService;
    private ValueEvaluationService evaluationService;

    @BeforeEach
    void setup() {
        functionService = mock(FunctionServiceImpl.class);
        evaluationService = new ValueEvaluationServiceImpl(functionService);
    }

    // When writing unit tests it is a good practice to test the function themselves and not to raise the whole app context.
    // This is why I decided not to use @SpringBootTest and @Autowired annotations and, mock required Beans.

    @Test
    @DisplayName("Method evaluate() should return evaluated output (with function logic), when the function is enabled")
    void evaluateWhenEnabled() {
        //given

        //when
        Value result = new Function1Result(1, 7, 22);
        when(functionService.isActive(Function.FUNCTION_1)).thenReturn(true);

        //then
        Assertions.assertEquals(29, evaluationService.evaluate(result));
    }

    @Test
    @DisplayName("Method evaluate() should return evaluated output (with function logic), when the function is disabled")
    void evaluateWhenDisabled() {
        //given

        //when
        Value result = new Function1Result(1, 7, 22);
        when(functionService.isActive(Function.FUNCTION_1)).thenReturn(false);

        //then
        Assertions.assertEquals(7, evaluationService.evaluate(result));
    }



    @Test
    @DisplayName("Method evaluateAndSum() should return evaluated output (with function logic), all list elements are disabled")
    void evaluateAndSumWhenAllDisabled() {
        //given

        //when

        List<Value> functionList = new ArrayList<>(Arrays.asList(
                new Function1Result(1, 2, 22),
                new Function2Result(2, 7, 9),
                new Function3Result(3, 4, 3.6f)
                ));
        when(functionService.isActive(Function.FUNCTION_1)).thenReturn(false);
        when(functionService.isActive(Function.FUNCTION_2)).thenReturn(false);
        when(functionService.isActive(Function.FUNCTION_3)).thenReturn(false);

        //then
        Assertions.assertEquals(13, evaluationService.evaluateAndSum(functionList));
    }


    @Test
    @DisplayName("Method evaluateAndSum() should return evaluated output (with function logic), all list elements are disabled")
    void evaluateAndSumWhenAllEnabled() {
        //given

        //when

        List<Value> functionList = new ArrayList<>(Arrays.asList(
                new Function1Result(1, 2, 22),
                new Function2Result(2, 7, 9),
                new Function3Result(3, 4, 3.6f)
        ));
        when(functionService.isActive(Function.FUNCTION_1)).thenReturn(true);
        when(functionService.isActive(Function.FUNCTION_2)).thenReturn(true);
        when(functionService.isActive(Function.FUNCTION_3)).thenReturn(true);

        //then
        Assertions.assertEquals(89, evaluationService.evaluateAndSum(functionList));
    }



    @Test
    @DisplayName("Method evaluateAndSum() should return evaluated output (with function logic), list elements are mixed (enabled and disabled)")
    void evaluateAndSumWhenMixed() {
        //given

        //when

        List<Value> functionList = new ArrayList<>(Arrays.asList(
                new Function1Result(1, 2, 22),
                new Function2Result(2, 7, 9),
                new Function3Result(3, 4, 3.6f)
        ));
        when(functionService.isActive(Function.FUNCTION_1)).thenReturn(true);
        when(functionService.isActive(Function.FUNCTION_2)).thenReturn(false);
        when(functionService.isActive(Function.FUNCTION_3)).thenReturn(true);

        //then
        Assertions.assertEquals(33, evaluationService.evaluateAndSum(functionList));
    }
}
