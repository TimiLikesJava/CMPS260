package com.company;

public class State {
    public String name;
    public String code;
    public int region;

    public State(String name, String code, int region) {
        this.name = name;
        this.code = code;
        this.region = region;
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", region=" + region +
                '}';
    }
}
