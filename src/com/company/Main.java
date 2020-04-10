package com.company;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // Oluwatiileyin Olaosebikan
        // C00422558
        // CMPS 260
        // Programming Assignment: #6
        // Due Date: Tuesday, 26 November 2019, 11:55 pm
        // Program Description: This code gives numerous data on the 51 states of the United States of America.
        // Certificate of Authenticity:
        // I certify that the code in this project is, other than code provided by the instructor or that was
        // created by IntelliJ, entirely my own work.


        ArrayList<State> state = new ArrayList<State>();

        File f = new File("states.txt");

        double total = 0;


        try (Scanner input = new Scanner(f)) {
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] array1 = line.split(",");
                try {
                    int x = Integer.parseInt(array1[2]);
                    State pick = new State(array1[0], array1[1], x);
                    state.add(pick);


                } catch (NumberFormatException ex) {
                    System.out.println("Error found: " + ex.getMessage());
                    ex.printStackTrace();
                }
                try {
                    total += Double.parseDouble(array1[0]);
                } catch (Exception e) {

                }
            }
        }

        File f2 = new File("newPopulationData.txt");

        ArrayList<YearData> year = new ArrayList<>();
        try (Scanner input2 = new Scanner(f2)) {


            int x = input2.nextInt();
            int y = input2.nextInt();

            for (int i = x; i <= y; i++) {
                YearData thing = new YearData(i);
                year.add(thing);
            }

            String pizza = input2.nextLine();

            while (input2.hasNext()) {
                String line2 = input2.nextLine();
                String[] array2 = line2.split(",");
                int z = Integer.parseInt(array2[1]);
                year.get(z - x).popdata.add(new PopData(array2));


            }


        } catch (Exception e) {
            System.out.println("Error found");
            e.printStackTrace();
            System.out.println(year);

        }

        Scanner input3 = new Scanner(System.in);

        String initial = null;


        System.out.println(("(Y)ear , (C)hange , (M)iscellaneous , (Q)uit:  "));
        initial = input3.nextLine();
        initial = initial.toUpperCase();

        while (initial != "Q") {


            if (initial.equalsIgnoreCase("Y")) {
                System.out.println("Enter year (7, 8, 9, 10, 11, 12, 13, 14): ");
                int action = input3.nextInt();

                System.out.println("AK AL AR AZ CA CO CT DC DE FL GA HI IA ID IL IN KS KY LA MA MD ME MI MN MO MS MT NC \n" +
                        "ND NE NH NJ NM NV NY OH OK OR PA RI SC SD TN TX UT VA VT WA WI WV WY \n" +
                        "Choose State ('US' for all states): ");
                String initial2 = input3.nextLine();


                input3.next();


                System.out.println("1. Total Population, 2. Population by Age, 3. Male/Female Count, 4. Race/Ethic Count: ");
                int initial3 = input3.nextInt();

                if (initial3 == 1) {
                    for (int i = action; i < 51; i++) {
                        String stack = state.get(i).name;
                        double males = year.get(action - 7).popdata.get(i).getMale();
                        double females = year.get(action - 7).popdata.get(i).getFemale();
                        double totalThing = males + females;


                        System.out.println("State: " + stack);
                        System.out.println("Year: " + action);
                        System.out.println("Total Population: " + totalThing);


                    }

                } else if (initial3 == 2) {
                    for (int i = action; i < 51; i++) {
                        double males = year.get(action - 7).popdata.get(i).getMale();
                        double females = year.get(action - 7).popdata.get(i).getFemale();
                        double totalThing = males + females;


                        double under = year.get(action - 7).popdata.get(i).getUnder18();
                        double underPcent = (under / totalThing) * 100;
                        double middle = year.get(action - 7).popdata.get(i).getMidage();
                        double middlePcent = (middle / totalThing) * 100;
                        double over = year.get(action - 7).popdata.get(i).getOver64();
                        double overPcent = (over / totalThing) * 100;


                        System.out.println("State: " + state.get(i).name);
                        System.out.println("Year: " + action);
                        System.out.println("Total/Percent Under 18: " + under + "/" + underPcent + ", 18-64: " + middle + "/" + middlePcent + ", Over 64: " + over + "/" + overPcent);


                    }

                } else if (initial3 == 3) {
                    for (int i = action; i < 51; i++) {
                        String stack = state.get(i).name;
                        double males = year.get(action - 7).popdata.get(i).getMale();
                        double females = year.get(action - 7).popdata.get(i).getFemale();
                        double totalThing = males + females;


                        System.out.println("State: " + stack);
                        System.out.println("Year: " + action);
                        System.out.println("Total/Percent Females: " + females + "/" + ((males / totalThing) * 100) + ", Total/Percent Males: " + males + ((females / totalThing) * 100));

                    }
                } else if (initial3 == 4) {
                    for (int i = action; i < 51; i++) {
                        String stack = state.get(i).name;
                        double males = year.get(action - 7).popdata.get(i).getMale();
                        double females = year.get(action - 7).popdata.get(i).getFemale();
                        double totalThing = males + females;
                        double white = year.get(action - 7).popdata.get(i).getWhite();
                        double black = year.get(action - 7).popdata.get(i).getBlack();
                        double indian = year.get(action - 7).popdata.get(i).getAmerindAlaska();
                        double asian = year.get(action - 7).popdata.get(i).getAsian();
                        double ha = year.get(action - 7).popdata.get(i).getHawaiiPacific();
                        double twhis = year.get(action - 7).popdata.get(i).getTwoNonHispanic();
                        double his = year.get(action - 7).popdata.get(i).getHispanic();


                        System.out.println("State: " + stack);
                        System.out.println("Year: " + action);
                        System.out.println("Total/Percent White: " + white + "/" + ((white / totalThing) * 100) + ", Black: " + black + "/" + ((black / totalThing) * 100) + "\n"
                                + ",American Indian & Alaska Native:  " + indian + ((indian / totalThing) * 100) + ",Asian: " + asian + ((asian / totalThing) * 100) + ", Hawaiian Native & Pacific Islander: " + ha + ((ha / totalThing) * 100) + ", Two Plus Non Hispanic: " + twhis + ((twhis / totalThing) * 100) + "\n"
                                + ", Hispanic: " + his + ((his / totalThing) * 100));

                    }
                } else if (initial2.equalsIgnoreCase("US")) {
                    double totalMales = 0;
                    double totalFemales = 0;
                    double totalUnder = 0;
                    double totalMiddle = 0;
                    double totalOver = 0;
                    double totalWhite = 0;
                    double totalBlack = 0;
                    double totalIndian = 0;
                    double totalAsian = 0;
                    double totalHa = 0;
                    double totalTwhis = 0;
                    double totalHis = 0;
                    for (int i = 0; i < 51; i++) {
                        double males = year.get(action - 7).popdata.get(i).getMale();
                        totalMales += males;
                        double females = year.get(action - 7).popdata.get(i).getFemale();
                        totalFemales += females;

                        double under = year.get(action - 7).popdata.get(i).getUnder18();
                        totalUnder += under;

                        double middle = year.get(action - 7).popdata.get(i).getMidage();
                        totalMiddle += middle;

                        double over = year.get(action - 7).popdata.get(i).getOver64();
                        totalOver += over;

                        double white = year.get(action - 7).popdata.get(i).getWhite();
                        totalWhite += white;
                        double black = year.get(action - 7).popdata.get(i).getBlack();
                        totalBlack += black;
                        double indian = year.get(action - 7).popdata.get(i).getAmerindAlaska();
                        totalIndian += indian;
                        double asian = year.get(action - 7).popdata.get(i).getAsian();
                        totalAsian += asian;
                        double ha = year.get(action - 7).popdata.get(i).getHawaiiPacific();
                        totalHa += ha;
                        double twhis = year.get(action - 7).popdata.get(i).getTwoNonHispanic();
                        totalTwhis += twhis;
                        double his = year.get(action - 7).popdata.get(i).getHispanic();
                        totalHis += his;
                    }

                    if (initial3 == 1) {
                        double totalThing = totalMales + totalFemales;
                        System.out.println(initial2);
                        System.out.println("Year: " + action);
                        System.out.println("Total Population: " + totalThing);
                    } else if (initial3 == 2) {
                        double totalThing = totalMales + totalFemales;
                        System.out.println(initial2);
                        System.out.println("Year: " + action);
                        System.out.println("Total/Percent Under 18: " + totalUnder + "/" + ((totalUnder / totalThing) * 100) + ", 18-64: " + totalMiddle + "/" + ((totalMiddle / totalThing) * 100) + ", Over 64: " + totalOver + "/" + ((totalOver / totalThing) * 100));


                    } else if (initial3 == 3) {
                        double totalThing = totalMales + totalFemales;
                        System.out.println(initial2);
                        System.out.println("Year: " + action);
                        System.out.println("Total/Percent Females: " + totalFemales + "/" + ((totalMales / totalThing) * 100) + ", Total/Percent Males: " + totalMales + ((totalFemales / totalThing) * 100));

                    } else if (initial3 == 4) {
                        double totalThing = totalMales + totalFemales;
                        System.out.println(initial2);
                        System.out.println("Year: " + action);
                        System.out.println("Total/Percent White: " + totalWhite + "/" + ((totalWhite / totalThing) * 100) + ", Black: " + totalBlack + "/" + ((totalBlack / totalThing) * 100) + "\n"
                                + ",American Indian & Alaska Native:  " + totalIndian + ((totalIndian / totalThing) * 100) + ",Asian: " + totalAsian + ((totalAsian / totalThing) * 100) + ", Hawaiian Native & Pacific Islander: " + totalHa + ((totalHa / totalThing) * 100) + ", Two Plus Non Hispanic: " + totalTwhis + ((totalTwhis / totalThing) * 100) + "\n"
                                + ", Hispanic: " + totalHis + ((totalHis / totalThing) * 100));

                    }
                } else {
                    System.out.println("Invalid input");
                }
            } else if (initial.equalsIgnoreCase("C")) {
                System.out.println("Enter year (7, 8, 9, 10, 11, 12, 13, 14): ");
                int action = input3.nextInt();

                System.out.println("Enter year (7, 8, 9, 10, 11, 12, 13, 14): ");
                int action2 = input3.nextInt();

                System.out.println("AK AL AR AZ CA CO CT DC DE FL GA HI IA ID IL IN KS KY LA MA MD ME MI MN MO MS MT NC \n" +
                        "ND NE NH NJ NM NV NY OH OK OR PA RI SC SD TN TX UT VA VT WA WI WV WY \n" +
                        "Choose State ('US' for all states): ");
                String initial2 = input3.nextLine();


                input3.next();


                System.out.println("1. Total Population, 2. Population by Age, 3. Male/Female Count, 4. Race/Ethic Count: ");
                int initial3 = input3.nextInt();


                if (initial3 == 1) {
                    for (int i = action; i < action2; i++) {
                        String stack = state.get(i).name;
                        double males = year.get(action - 7).popdata.get(i).getMale();
                        double females = year.get(action - 7).popdata.get(i).getFemale();
                        double totalThing = males + females;


                        System.out.println("State: " + initial2);
                        System.out.println("Start Year: " + action);
                        System.out.println("End Year: " + action2);
                        System.out.println("Total Population: " + totalThing);



                    }
                } else if (initial3 == 2) {
                    for (int i = action; i < action2; i++) {
                        double males = year.get(action - 7).popdata.get(i).getMale();
                        double females = year.get(action - 7).popdata.get(i).getFemale();
                        double totalThing = males + females;


                        String stack = state.get(i).name;
                        double under = year.get(action - 7).popdata.get(i).getUnder18();
                        double underPcent = (under / totalThing) * 100;
                        double middle = year.get(action - 7).popdata.get(i).getMidage();
                        double middlePcent = (middle / totalThing) * 100;
                        double over = year.get(action - 7).popdata.get(i).getOver64();
                        double overPcent = (over / totalThing) * 100;


                        System.out.println("State: " + initial2);
                        System.out.println("Start Year: " + action);
                        System.out.println("End Year: " + action2);
                        System.out.println("Total/Percent Under 18: " + under + "/" + underPcent + ", 18-64: " + middle + "/" + middlePcent + ", Over 64: " + over + "/" + overPcent);


                    }

                } else if (initial3 == 3) {
                    for (int i = action; i < action2; i++) {
                        String stack = state.get(i).name;
                        double males = year.get(action - 7).popdata.get(i).getMale();
                        double females = year.get(action - 7).popdata.get(i).getFemale();
                        double totalThing = males + females;


                        System.out.println("State: " + initial2);
                        System.out.println("Start Year: " + action);
                        System.out.println("End Year: " + action2);
                        System.out.println("Total/Percent Females: " + females + "/" + ((males / totalThing) * 100) + ", Total/Percent Males: " + males + ((females / totalThing) * 100));

                    }
                } else if (initial3 == 4) {
                    for (int i = action; i < action2; i++) {
                        String stack = state.get(i).name;
                        double males = year.get(action - 7).popdata.get(i).getMale();
                        double females = year.get(action - 7).popdata.get(i).getFemale();
                        double totalThing = males + females;
                        double white = year.get(action - 7).popdata.get(i).getWhite();
                        double black = year.get(action - 7).popdata.get(i).getBlack();
                        double indian = year.get(action - 7).popdata.get(i).getAmerindAlaska();
                        double asian = year.get(action - 7).popdata.get(i).getAsian();
                        double ha = year.get(action - 7).popdata.get(i).getHawaiiPacific();
                        double twhis = year.get(action - 7).popdata.get(i).getTwoNonHispanic();
                        double his = year.get(action - 7).popdata.get(i).getHispanic();



                        System.out.println("State: " + initial2);
                        System.out.println("Start Year: " + action);
                        System.out.println("End Year: " + action2);
                        System.out.println("Total/Percent White: " + white + "/" + ((white / totalThing) * 100) + ", Black: " + black + "/" + ((black / totalThing) * 100) + "\n"
                                + ",American Indian & Alaska Native:  " + indian + ((indian / totalThing) * 100) + ",Asian: " + asian + ((asian / totalThing) * 100) + ", Hawaiian Native & Pacific Islander: " + ha + ((ha / totalThing) * 100) + ", Two Plus Non Hispanic: " + twhis + ((twhis / totalThing) * 100) + "\n"
                                + ", Hispanic: " + his + ((his / totalThing) * 100));

                    }
                } else if (initial2.equalsIgnoreCase("US")) {
                    double totalMales = 0;
                    double totalFemales = 0;
                    double totalUnder = 0;
                    double totalMiddle = 0;
                    double totalOver = 0;
                    double totalWhite = 0;
                    double totalBlack = 0;
                    double totalIndian = 0;
                    double totalAsian = 0;
                    double totalHa = 0;
                    double totalTwhis = 0;
                    double totalHis = 0;
                    for (int i = 0; i < action2; i++) {
                        double males = year.get(action - 7).popdata.get(i).getMale();
                        totalMales += males;
                        double females = year.get(action - 7).popdata.get(i).getFemale();
                        totalFemales += females;

                        double under = year.get(action - 7).popdata.get(i).getUnder18();
                        totalUnder += under;

                        double middle = year.get(action - 7).popdata.get(i).getMidage();
                        totalMiddle += middle;

                        double over = year.get(action - 7).popdata.get(i).getOver64();
                        totalOver += over;

                        double white = year.get(action - 7).popdata.get(i).getWhite();
                        totalWhite += white;
                        double black = year.get(action - 7).popdata.get(i).getBlack();
                        totalBlack += black;
                        double indian = year.get(action - 7).popdata.get(i).getAmerindAlaska();
                        totalIndian += indian;
                        double asian = year.get(action - 7).popdata.get(i).getAsian();
                        totalAsian += asian;
                        double ha = year.get(action - 7).popdata.get(i).getHawaiiPacific();
                        totalHa += ha;
                        double twhis = year.get(action - 7).popdata.get(i).getTwoNonHispanic();
                        totalTwhis += twhis;
                        double his = year.get(action - 7).popdata.get(i).getHispanic();
                        totalHis += his;
                    }

                    if (initial3 == 1) {
                        double totalThing = totalMales + totalFemales;
                        System.out.println(initial2);
                        System.out.println("Start Year: " + action);
                        System.out.println("End Year: " + action2);
                        System.out.println("Total Population: " + totalThing);
                    } else if (initial3 == 2) {
                        double totalThing = totalMales + totalFemales;
                        System.out.println(initial2);
                        System.out.println("Start Year: " + action);
                        System.out.println("End Year: " + action2);
                        System.out.println("Total/Percent Under 18: " + totalUnder + "/" + ((totalUnder / totalThing) * 100) + ", 18-64: " + totalMiddle + "/" + ((totalMiddle / totalThing) * 100) + ", Over 64: " + totalOver + "/" + ((totalOver / totalThing) * 100));


                    } else if (initial3 == 3) {
                        double totalThing = totalMales + totalFemales;
                        System.out.println(initial2);
                        System.out.println("Start Year: " + action);
                        System.out.println("End Year: " + action2);
                        System.out.println("Total/Percent Females: " + totalFemales + "/" + ((totalMales / totalThing) * 100) + ", Total/Percent Males: " + totalMales + ((totalFemales / totalThing) * 100));

                    } else if (initial3 == 4) {
                        double totalThing = totalMales + totalFemales;
                        System.out.println(initial2);
                        System.out.println("Start Year: " + action);
                        System.out.println("End Year: " + action2);
                        System.out.println("Total/Percent White: " + totalWhite + "/" + ((totalWhite / totalThing) * 100) + ", Black: " + totalBlack + "/" + ((totalBlack / totalThing) * 100) + "\n"
                                + ",American Indian & Alaska Native:  " + totalIndian + ((totalIndian / totalThing) * 100) + ",Asian: " + totalAsian + ((totalAsian / totalThing) * 100) + ", Hawaiian Native & Pacific Islander: " + totalHa + ((totalHa / totalThing) * 100) + ", Two Plus Non Hispanic: " + totalTwhis + ((totalTwhis / totalThing) * 100) + "\n"
                                + ", Hispanic: " + totalHis + ((totalHis / totalThing) * 100));

                    }
                } else {
                    System.out.println("Invalid input");
                }
            } else if (initial.equalsIgnoreCase("M")) {
                System.out.println("(O)ldest State , (Y)oungest State , Highest Percentage (M)ales , Highest Percentage (F)emales: ");
                String missy = input3.nextLine();

                if (missy.equalsIgnoreCase("O")) {
                    int digit = year.get(0).popdata.get(0).getOver64();
                    for (int i = digit; i < 51; i++) {
                        int target = year.get(i).popdata.get(i).getOver64();
                        if (digit < target) {
                            digit = target;
                        }
                    }
                    int index = state.indexOf(digit);

                    System.out.println("Oldest State: " + state.get(index) + ", " + digit + " > 64");
                } else if (missy.equalsIgnoreCase("Y")) {
                    int digit = year.get(0).popdata.get(0).getOver64();
                    for (int i = digit; i < 51; i++) {
                        int target = year.get(i).popdata.get(i).getOver64();
                        if (digit > target) {
                            digit = target;
                        }
                    }
                    int index = state.indexOf(digit);

                    System.out.println("Youngest State: " + state.get(index) + ", " + digit + " < 18");

                } else if (missy.equalsIgnoreCase("M")) {
                    int digit = year.get(0).popdata.get(0).getMale();
                    for (int i = digit; i < 51; i++) {
                        int target = year.get(i).popdata.get(i).getMale();
                        if (digit < target) {
                            digit = target;
                        }
                    }
                    int index = state.indexOf(digit);

                    System.out.println("Most Male State: " + state.get(index) + ", " + digit);
                } else if (missy.equalsIgnoreCase("F")) {
                    int digit = year.get(0).popdata.get(0).getFemale();
                    for (int i = digit; i < 51; i++) {
                        int target = year.get(i).popdata.get(i).getFemale();
                        if (digit < target) {
                            digit = target;
                        }
                    }
                    int index = state.indexOf(digit);

                    System.out.println("Most Female State: " + state.get(index) + ", " + digit);
                }


            }
            System.out.println(("(Y)ear , (C)hange , (M)iscellaneous , (Q)uit:  "));
            initial = input3.nextLine();
            initial = initial.toUpperCase();

        }


        }


    }





