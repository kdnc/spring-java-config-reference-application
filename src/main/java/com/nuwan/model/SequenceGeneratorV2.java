package com.nuwan.model;

import java.beans.ConstructorProperties;

public class SequenceGeneratorV2 {
    private String prefix;
    private String suffix;
    private int initial;
    private int counter;
    public SequenceGeneratorV2() {}
    public SequenceGeneratorV2(String prefix, String suffix, int initial) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.initial = initial;
    }
    @ConstructorProperties({"prefix", "suffix"})
    public SequenceGeneratorV2(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }
    @ConstructorProperties({"prefix", "initial"})
    public SequenceGeneratorV2(String prefix, int initial) {
        this.prefix = prefix;
        this.initial = initial;
    }
    @ConstructorProperties({"initial", "suffix"})
    public SequenceGeneratorV2(int initial, String suffix) {
        this.initial = initial;
        this.suffix = suffix;
    }
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setInitial(int initial) {
        this.initial = initial;
    }
    public synchronized String getSequence() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(prefix);
        buffer.append(initial + counter++);
        buffer.append(suffix);
        return buffer.toString();
    }
}