package com.practice.reactive;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import rx.Observable;
import rx.functions.Action1;

public class SampleObserver {

    private static Action1<String> onNext = item -> {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.print("Interrupted");
        }
        System.out.println("Received " + item);
    };

    private static Action1<Throwable> onError = exp -> exp.printStackTrace();

    public static void main(String[] s) {
        Observable<String> source1 = rx.Observable.from(new String[]{"t1", "t2"});
        Observable<String> source2 = rx.Observable.from(new String[]{"t3", "t4"});
        Observable<String> source3 = rx.Observable.from(new String[]{"t5", "t6"});
        Observable<String> stringObservable =
                Observable.concat(source1, source2, source3).flatMap( (String item) -> {
                    List<String> generatedStringList = IntStream.rangeClosed(1, 10).boxed().map(position -> {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            System.err.print("Interrupted");
                        }
                        System.out.println("introduced some delay for " + item + position);
                        return item + position;
                    }).collect(Collectors.toList());
                    String[] generatedStrings = generatedStringList.toArray(new String[0]);
                    return Observable.from(generatedStrings);
                });
        stringObservable.subscribe(onNext, onError, System.out::println);
    }
}
