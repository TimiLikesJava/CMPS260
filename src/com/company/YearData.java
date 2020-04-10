package com.company;

import java.util.ArrayList;

public class YearData {
    public int year = -1;
    public ArrayList<PopData> popdata = new ArrayList();

    public YearData(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "\nYearData{" +
                "year=" + year +
                ", popdata=" + popdata +
                '}';
    }
}
