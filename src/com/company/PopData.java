package com.company;

public class PopData {

    private int state, under18, midage, over64, male, female, white, black, amerindAlaska, asian, hawaiiPacific, hispanic, twoNonHispanic;

    public PopData(String[] splitline) {
        state = Integer.parseInt(splitline[0]);
        under18 = Integer.parseInt(splitline[2]);
        midage = Integer.parseInt(splitline[3]);
        over64 = Integer.parseInt(splitline[4]);
        male = Integer.parseInt(splitline[5]);
        female = Integer.parseInt(splitline[6]);
        white = Integer.parseInt(splitline[7]);
        black = Integer.parseInt(splitline[8]);
        amerindAlaska = Integer.parseInt(splitline[9]);
        asian = Integer.parseInt(splitline[10]);
        hawaiiPacific = Integer.parseInt(splitline[11]);
        hispanic = Integer.parseInt(splitline[12]);
        twoNonHispanic = Integer.parseInt(splitline[13]);
    }

    public int getState() {
        return state;
    }

    public int getUnder18() {
        return under18;
    }

    public int getMidage() {
        return midage;
    }

    public int getOver64() {
        return over64;
    }

    public int getMale() {
        return male;
    }

    public int getFemale() {
        return female;
    }

    public int getWhite() {
        return white;
    }

    public int getBlack() {
        return black;
    }

    public int getAmerindAlaska() {
        return amerindAlaska;
    }

    public int getAsian() {
        return asian;
    }

    public int getHawaiiPacific() {
        return hawaiiPacific;
    }

    public int getHispanic() {
        return hispanic;
    }

    public int getTwoNonHispanic() {
        return twoNonHispanic;
    }

    @Override
    public String toString() {
        return "\n\tPopData{" +
                "state=" + state +
                ", under18=" + under18 +
                ", midage=" + midage +
                ", over64=" + over64 +
                ", male=" + male +
                ", female=" + female +
                ", white=" + white +
                ", black=" + black +
                ", amerindAlaska=" + amerindAlaska +
                ", asian=" + asian +
                ", hawaiiPacific=" + hawaiiPacific +
                ", hispanic=" + hispanic +
                ", twoNonHispanic=" + twoNonHispanic +
                '}';
    }
}
