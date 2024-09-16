package com.tss.actividad5.excersice_1;

import com.tss.actividad5.common.NumberRandomPair;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.commons.math3.distribution.NormalDistribution;

import java.util.Stack;

public class Utils {
    private double [] randomListOneDefault = new double[6];
    private double [] randomListTwDefault = new double[randomListOneDefault.length];
    private double [] randomListOne = new double[randomListOneDefault.length];
    private double [] randomListTwo = new double[randomListOneDefault.length];
    public Utils() {
        randomListOneDefault = generateRandomNumbers();
        randomListOne = randomListOneDefault;
        randomListTwDefault = generateRandomNumbers();
        randomListTwo = randomListTwDefault;
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

    public ObservableList<DataItem> getDataSimulated() {
        ObservableList<DataItem> data = FXCollections.observableArrayList();
        Double mean1 = 5.0;
        Double mean2 = 4.0;
        Double standarDeviation = 0.5;
        Double timeArrived = 0.0;
        Double timeStartInspection = 0.0;
        Double timeEndInspection = 0.0;
        Double timeOfInspection = 0.0;
        Double timeOnInspection = 0.0;
        Double timeOnWaitingInspection = 0.0;
        Double timeAverageOnInspection = 0.0;
        double[] timeAverageList = new double[randomListOne.length];
        for (int i = 0; i < randomListOne.length; i++) {
            Integer part = i + 1;
            double rand1 = randomListOne[i];
            double rand2 = randomListTwo[i];
            Double timeBetweenArrived = (Math.log10(rand1) * mean1) * (-1);
            if (i == 0) {
                timeArrived = timeBetweenArrived;
                timeStartInspection = timeArrived;
                timeOfInspection = calculateNormalInverse(rand2, mean2, standarDeviation);
                timeEndInspection = timeStartInspection + timeOfInspection;
                timeOnInspection = timeEndInspection - timeArrived;
                timeOnWaitingInspection = timeStartInspection - timeArrived;
                timeAverageOnInspection = timeOfInspection;
                timeAverageList[i] = timeAverageOnInspection;

            } else {
                timeArrived = timeArrived + timeBetweenArrived;
                timeStartInspection = Math.max(timeEndInspection, timeArrived);
                timeOfInspection = calculateNormalInverse(rand2, mean2, standarDeviation);
                timeOnInspection = timeEndInspection - timeArrived;
                timeOnWaitingInspection = timeStartInspection - timeArrived;
                timeAverageOnInspection = calculateRunningAverage(timeAverageList);
                timeAverageList[i] = timeAverageOnInspection;
            }
            DataItem dataItem = new DataItem(
                    part,
                    timeBetweenArrived,
                    timeArrived,
                    timeStartInspection,
                    timeOfInspection,
                    timeEndInspection,
                    timeOnInspection,
                    timeOnWaitingInspection,
                    timeAverageOnInspection
            );
            data.add(dataItem);
        }
        return data;
    }

    public ObservableList<NumberRandomPair> getRandomDataForTableView(double[] randomArrayNumbers) {
        ObservableList<NumberRandomPair> data = FXCollections.observableArrayList();
        for (int i = 0; i < randomArrayNumbers.length; i++) {
            data.add(new NumberRandomPair(i, randomArrayNumbers[i]));
        }
        return data;
    }

    public double[] generateRandomNumbers() {
        double[] newRandomList = new double[6];
        for (int i = 0; i < 6; i++) {
            double randomValue = Math.random(); // Round to 2 decimal places
            newRandomList[i] = randomValue;
        }
        return newRandomList;
    }

    public Double calculateNormalInverse(double probability, double mean, double  standarDeviation) {
        NormalDistribution normalDistribution = new NormalDistribution(mean, standarDeviation);
        return normalDistribution.inverseCumulativeProbability(probability);
    }

    public double calculateRunningAverage(double[] values) {
        double sum = 0.0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        // Return the average
        return sum / values.length;
    }
}
