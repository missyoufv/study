package com.pattern.adapter.optimization;

public class Adapter implements DigitalProducts {

    private SmallBulb smallBulb = new SmallBulb();

    @Override
    public void charge() {
        smallBulb.electrify();
    }
}
