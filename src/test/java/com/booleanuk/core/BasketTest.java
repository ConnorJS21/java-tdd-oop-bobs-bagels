package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class BasketTest {
    @Test
    public void testAddBagel(){
        Basket basket = new Basket();
         basket.addBagel("Poppy Seed", 2);
         basket.addBagel("Cinnamon",  3);
         basket.addBagel("Honey",  4);
         basket.addBagel("Cheese",  5);
         basket.addBagel("Garlic",  6);
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("Poppy Seed", 2);
        expectedMap.put("Cinnamon",  3);
        expectedMap.put("Honey",  4);
        expectedMap.put("Cheese",  5);
        expectedMap.put("Garlic",  6);
        Assertions.assertEquals(expectedMap, basket.getBasketItems());
    }
    @Test
    public void testExceededBasketLimit(){
        Basket basket = new Basket();
        basket.setBasketLimit(3);
        Assertions.assertEquals(basket.exceededBasketLimit(basket.getBasketLimit(), 5), true);
        basket.setBasketLimit(10);
        Assertions.assertEquals(basket.exceededBasketLimit(basket.getBasketLimit(), 7), false);
    }
    @Test
    public void testRemoveBagel(){
        Basket basket = new Basket();
        basket.addBagel("Poppy Seed", 5);
        basket.removeBagel("Poppy Seed", 5);
        Assertions.assertEquals(basket.getBasketItems().containsKey("Poppy Seed"), false);
        basket.addBagel("Poppy Seed", 5);
        basket.removeBagel("Poppy Seed", 3);
        Assertions.assertEquals(basket.getBasketItems().containsKey("Poppy Seed"), true);
        Assertions.assertEquals(basket.getBasketItems().get("Poppy Seed"), 2);
    }
    @Test
    public void testUserRequestFillingCost(){
        Basket basket = new Basket();
        basket.userRequestFillingPrice("FILC");

    }


    @Test
    public void testAddFillingToBasket(){
        Basket basket = new Basket();
        basket.addFillingToBasket("FILC", 5);
        Assertions.assertEquals(5, basket.getBasketItems().get("FILC"));
    }
    @Test
    public void testGetBasketPrice(){
        Basket basket = new Basket();
        basket.addFillingToBasket("FILC", 5);
        Assertions.assertEquals(0.60, basket.getBasketPrice());
    }
    @Test
    public void testUserRequestBagelCost(){
        Basket basket = new Basket();
        basket.userRequestBagelCost("BGLE");

    }
/*
    @Test
    public void testBasketFunction(){
        Basket basket = new Basket();
        basket.userRequestBagelCost("BGLE");

    }
*/
}
