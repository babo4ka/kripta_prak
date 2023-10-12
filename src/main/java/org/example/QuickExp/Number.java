package org.example.QuickExp;

import java.math.BigInteger;

public class Number {

    private BigInteger value;

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }

    public Number(BigInteger value){
        this.value = value;
    }

    public Number add(Number other){
        return new Number(this.value.add(other.value));
    }

    public Number sub(Number other){
        return new Number(this.value.subtract(other.value));
    }

    public Number mul(Number other){
        return new Number(this.value.multiply(other.value));
    }

}
