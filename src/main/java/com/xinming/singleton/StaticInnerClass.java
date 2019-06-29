package com.xinming.singleton;

public class StaticInnerClass {

    private StaticInnerClass() {
    }

    private static class SingletonHodler {
        private static final StaticInnerClass instance = new StaticInnerClass();
    }

    public static StaticInnerClass getInstance() {
        return SingletonHodler.instance;
    }
}
