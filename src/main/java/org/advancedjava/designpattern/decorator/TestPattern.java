package org.advancedjava.designpattern.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestPattern {

    public static void main(String[] args) {

//        Margherita margherita = new Margherita();
//        Mushroom margheritaWithMushroom = new Mushroom(margherita);
//        log.info("Margherita with mushroom cost is - " + margheritaWithMushroom.cost());

        //Margherita+ExtraCheese
        BasePizza pizza1 = new ExtraCheese(new Margherita());
        log.info("Cost of Margherita+ExtraCheese is - {}", pizza1.cost());

        //Margherita+ExtraCheese+Mushroom
        BasePizza pizza2 = new Mushroom(pizza1);
        log.info("Cost of Margherita+ExtraCheese+Mushroom is - {}", pizza2.cost());

    }
}

/*
So in decorator pattern we have a base object and we have some features or properties in it now if we want to add any
additional features then we wrap this with a decorator and so it will add the additional features lets say f2 and the same
we can apply again and again.

obj1(f1) ---> obj2(f2+f1) ---> obj3(f3+f2+f1) ......

Why you need decorator pattern?

Issue is - class explosion
 */
