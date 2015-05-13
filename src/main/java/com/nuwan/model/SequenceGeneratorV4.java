package com.nuwan.model;

public class SequenceGeneratorV4 {
    private PrefixGeneratorV2 prefixGenerator2;
    private String suffix;
    private int initial;
    private int counter;
    public SequenceGeneratorV4() {}
    public SequenceGeneratorV4(PrefixGeneratorV2 prefixGenerator2) {
        this.prefixGenerator2 = prefixGenerator2;
    }
    public SequenceGeneratorV4(PrefixGeneratorV2 prefixGenerator2, String suffix, int initial) {
        this.prefixGenerator2 = prefixGenerator2;
        this.suffix = suffix;
        this.initial = initial;
    }
    public void setPrefixGenerator(PrefixGeneratorV2 prefixGenerator2) {
        this.prefixGenerator2 = prefixGenerator2;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setInitial(int initial) {
        this.initial = initial;
    }
    public synchronized String getSequence() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(prefixGenerator2.getPrefix());
        buffer.append(initial + counter++);
        buffer.append(suffix);
        return buffer.toString();
    }
}