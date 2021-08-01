package com.tratif.application.core.value.service;

import com.tratif.application.core.value.model.Value;
import com.tratif.application.functions.Function1Result;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LruCacheTest {

    LruCache<Integer, Value> cache = new LruCache<>(3);

    @Test
    @DisplayName("should remove last recently used elements from cache")
    public void removeLastRecentlyUsed() {

        //given
        Value value1 = new Function1Result(1, 11, 3);
        Value value2 = new Function1Result(2, 12, 4);
        Value value3 = new Function1Result(3, 13, 5);
        Value value4 = new Function1Result(4, 14, 6);
        Value value5 = new Function1Result(5, 15, 7);
        Value value6 = new Function1Result(6, 16, 8);
        Value value7 = new Function1Result(7, 17, 9);

        //when
        cache.set(value1.getUniqueId(),value1);
        cache.set(value2.getUniqueId(),value2);
        cache.set(value3.getUniqueId(),value3);
        cache.set(value4.getUniqueId(),value4);

        //then
        Assertions.assertNull(cache.get(1));
        Assertions.assertEquals(value2, cache.get(2));
        Assertions.assertEquals(value3, cache.get(3));
        Assertions.assertEquals(value4, cache.get(4));


    }

    @Test
    @DisplayName("should remove last recently used elements from cache")
    public void removeLastRecentlyUsed2() {

        //given
        Value value1 = new Function1Result(1, 11, 3);
        Value value2 = new Function1Result(2, 12, 4);
        Value value3 = new Function1Result(3, 13, 5);
        Value value4 = new Function1Result(4, 14, 6);
        Value value5 = new Function1Result(5, 15, 7);

        //when
        cache.set(value1.getUniqueId(),value1);
        cache.set(value2.getUniqueId(),value2);
        cache.set(value3.getUniqueId(),value3);
        cache.set(value4.getUniqueId(),value4);
        cache.set(value5.getUniqueId(),value5);

        //then
        Assertions.assertNull(cache.get(1));
        Assertions.assertNull(cache.get(2));
        Assertions.assertEquals(value3, cache.get(3));
        Assertions.assertEquals(value4, cache.get(4));
        Assertions.assertEquals(value5, cache.get(5));
    }

}