package com.tss.actividad5.excersice_2;

import com.tss.actividad5.common.NumberRandomPair;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Random;
import java.util.Stack;

public class Utils {
    private double [] randomListOneDefault = {0.2962, 0.2883, 0.7287, 0.5568, 0.9641, 0.3651, 0.1524, 0.9198, 0.7633, 0.3989, 0.2594, 0.4217, 0.9523, 0.742, 0.4152, 0.8417, 0.6656, 0.1064};
    private double [] randomListTwDefault = {0.7831, 0.6601, 0.5286, 0.7129, 0.088, 0.8815, 0.0356, 0.4289, 0.7293, 0.8502, 0.4793, 0.0455, 0.3672, 0.7548, 0.1636, 0.3114, 0.9976, 0.9619};
    private double [] randomListOne = {0.2962, 0.2883, 0.7287, 0.5568, 0.9641, 0.3651, 0.1524, 0.9198, 0.7633, 0.3989, 0.2594, 0.4217, 0.9523, 0.742, 0.4152, 0.8417, 0.6656, 0.1064};
    private double [] randomListTwo = {0.7831, 0.6601, 0.5286, 0.7129, 0.088, 0.8815, 0.0356, 0.4289, 0.7293, 0.8502, 0.4793, 0.0455, 0.3672, 0.7548, 0.1636, 0.3114, 0.9976, 0.9619};
    private Stack<Double> randomStackNumbersOne = new Stack<>();
    private Stack<Double> randomStackNumbersTwo = new Stack<>();
    public Utils() {
    }

    public double[] getRandomListOneDefault() {
        return randomListOneDefault;
    }

    public double[] getRandomListTwDefault() {
        return randomListTwDefault;
    }

    public double[] getRandomListOne() {
        return randomListOne;
    }

    public double[] getRandomListTwo() {
        return randomListTwo;
    }

    public void setRandomListOne(double[] randomListOne) {
        this.randomListOne = randomListOne;
    }

    public void setRandomListTwo(double[] randomListTow) {
        this.randomListTwo = randomListTow;
    }

    public void buildStackRandom() {
        if (!randomStackNumbersOne.isEmpty()) {
            randomStackNumbersOne.clear();
        }
        for (int i = randomListOne.length - 1; i >= 0 ; i--) {
            randomStackNumbersOne.push(randomListOne[i]);
        }

        if (!randomStackNumbersTwo.isEmpty()) {
            randomStackNumbersTwo.clear();
        }
        for (int i = randomListTwo.length - 1; i >= 0 ; i--) {
            randomStackNumbersTwo.push(randomListOne[i]);
        }
    }

    public ObservableList<DataItem> getDataSimulated() {
        ObservableList<DataItem> data = FXCollections.observableArrayList();
        String reporte = "";
        Double averagePart = 5.0;
        Double averageInspection = 4.0;
        Double deviation =0.5;
        int limit = 18;
        Double timeWaiting = 0.0;
        double [] auxInspection = new double[limit];
        for(int i = 0; i < limit; i++) {
            int part = i + 1;
            double rand1 = 0.0;
            double rand2 = 0.0;
            rand1 = randomListOne[i];
            rand2 = randomListTwo[i];
            double timeBetweenArrived = (-Math.log(1-rand1)/(1/averagePart));
            double timeArrived = 0.0;
            if(i == 0){
                timeArrived = timeBetweenArrived;
            } else {
                timeArrived = timeBetweenArrived + (-Math.log(1-randomListOne[i-1])/(1/averagePart));

            }
            double timeStartedInspection = 0.0;
            double durationTimeInspection = 0.0;
            double timeEndedInspection = 0.0;
            durationTimeInspection = distribution(rand2, averageInspection, deviation);
            if(i == 0){
                timeStartedInspection = timeArrived;
                timeEndedInspection = timeStartedInspection + durationTimeInspection;
                auxInspection[i] = timeEndedInspection;
            }else{
                if(auxInspection[i-1] > timeArrived){
                    timeStartedInspection = auxInspection[i-1];
                }else{
                    timeStartedInspection = timeArrived;
                }
            }
            timeEndedInspection = timeStartedInspection + durationTimeInspection;
            double timeTotalInspection = timeEndedInspection - timeStartedInspection;
            double auxTimeWaiting = 0.0;
            if(timeArrived == timeStartedInspection){
                auxTimeWaiting = 0;
            }else{
                auxTimeWaiting = timeStartedInspection - timeArrived;
            }
            timeWaiting += auxTimeWaiting;

            DataItem dataItem = new DataItem(part, rand1, timeBetweenArrived, timeArrived, timeStartedInspection, rand2, durationTimeInspection, timeEndedInspection, timeTotalInspection, timeWaiting);
            data.add(dataItem);
        }
        return data;
    }

    public double erf(double z) {
        double t = 1.0 / (1.0 + 0.5 * Math.abs(z));
        double result = 1 - t * Math.exp(-z * z - 1.26551223 +
                t * (1.00002368 +
                        t * (0.37409196 +
                                t * (0.09678418 +
                                        t * (-0.18628806 +
                                                t * (0.27886807 +
                                                        t * (-1.13520398 +
                                                                t * (1.48851587 +
                                                                        t * (-0.82215223 +
                                                                                t * (0.17087277))))))))));
        return z >= 0 ? result : -result;
    }

    public ObservableList<NumberRandomPair> getRandomDataForTableView(double[] randomArrayNumbers) {
        ObservableList<NumberRandomPair> data = FXCollections.observableArrayList();
        for (int i = 0; i < randomArrayNumbers.length; i++) {
            data.add(new NumberRandomPair(i, randomArrayNumbers[i]));
        }
        return data;
    }

    public double[] generateRandomNumbers() {
        double[] newRandomList = new double[18];
        for (int i = 0; i < 18; i++) {
            double randomValue = Math.random(); // Round to 2 decimal places
            newRandomList[i] = randomValue;
        }
        return newRandomList;
    }

    public double distribution(Double random, Double average, Double deviation){
        double z = (random - average) / deviation;
        return 0.5 * (1 + erf(z / Math.sqrt(2)));

    }
}
