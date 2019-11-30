package net.mednikov.futures;

import java.math.BigDecimal;

import io.vavr.concurrent.Future;

class FuturesExample {

    static BigDecimal calculate() {
        BigDecimal a = new BigDecimal(10000);
        BigDecimal b = new BigDecimal(30000);
       // throw new RuntimeException();
        return a.multiply(b);
    }

    public static void main(String[] args) {
        // basic usage
        Future<BigDecimal> future = Future.of(() -> calculate());

        // error handler
        future.onFailure(res-> System.out.println("ERROR!!!!"));

        BigDecimal result = future.get();
        System.out.println(result);

        //as option
    //    Option<Try<BigDecimal>> value = future.getValue();
        
        future.onComplete(res -> {
            BigDecimal res2 = res.get().multiply(new BigDecimal(15000));
            System.out.println(res2);
        });

    }
}