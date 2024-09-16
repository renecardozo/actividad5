package com.tss.actividad5.excersice_3;

import com.tss.actividad5.common.NumberRandomPair;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Stack;

public class Utils {
    private double [] randomStackNumbers1Def = {0.6367, 0.064, 0.6685, 0.2177, 0.6229, 0.6813, 0.1551, 0.7678, 0.8208, 0.4394, 0.9858, 0.6969, 0.4822, 0.9188, 0.7084};
    private double [] randomStackNumbers2Def = {0.0887, 0.2574, 0.2031, 0.1525, 0.9888, 0.7149, 0.2019, 0.2213, 0.9547, 0.9271, 0.6493, 0.3526, 0.749, 0.6757, 0.8639};
    private double [] randomStackNumbers3Def = {0.3345, 0.2086, 0.2513, 0.0631, 0.9721, 0.4351, 0.691, 0.1118, 0.2845, 0.8603, 0.4857, 0.3081, 0.1997, 0.639, 0.394};
    private double [] randomStackNumbers4Def = {0.6019, 0.5317, 0.0923, 0.2564, 0.083, 0.7227, 0.3506, 0.6067, 0.0808, 0.3498, 0.9285, 0.6747, 0.0057, 0.7344, 0.0645};
    private double [] randomStackNumbers5Def = {0.5768, 0.8775, 0.7669, 0.8342, 0.4201, 0.6741, 0.9184, 0.7222, 0.9865, 0.9188, 0.0485, 0.595, 0.4014, 0.9229, 0.6055};

    private double [] randomStackNumbers1 = {0.6367, 0.064, 0.6685, 0.2177, 0.6229, 0.6813, 0.1551, 0.7678, 0.8208, 0.4394, 0.9858, 0.6969, 0.4822, 0.9188, 0.7084};
    private double [] randomStackNumbers2 = {0.0887, 0.2574, 0.2031, 0.1525, 0.9888, 0.7149, 0.2019, 0.2213, 0.9547, 0.9271, 0.6493, 0.3526, 0.749, 0.6757, 0.8639};
    private double [] randomStackNumbers3 = {0.3345, 0.2086, 0.2513, 0.0631, 0.9721, 0.4351, 0.691, 0.1118, 0.2845, 0.8603, 0.4857, 0.3081, 0.1997, 0.639, 0.394};
    private double [] randomStackNumbers4 = {0.6019, 0.5317, 0.0923, 0.2564, 0.083, 0.7227, 0.3506, 0.6067, 0.0808, 0.3498, 0.9285, 0.6747, 0.0057, 0.7344, 0.0645};
    private double [] randomStackNumbers5 = {0.5768, 0.8775, 0.7669, 0.8342, 0.4201, 0.6741, 0.9184, 0.7222, 0.9865, 0.9188, 0.0485, 0.595, 0.4014, 0.9229, 0.6055};


    public Utils() {
    }

    public double[] getRandomStackNumbers1Def() {
        return randomStackNumbers1Def;
    }

    public double[] getRandomStackNumbers2Def() {
        return randomStackNumbers2Def;
    }

    public double[] getRandomStackNumbers3Def() {
        return randomStackNumbers3Def;
    }

    public double[] getRandomStackNumbers4Def() {
        return randomStackNumbers4Def;
    }

    public double[] getRandomStackNumbers5Def() {
        return randomStackNumbers5Def;
    }

    public double[] getRandomStackNumbers1() {
        return randomStackNumbers1;
    }

    public double[] getRandomStackNumbers2() {
        return randomStackNumbers2;
    }

    public double[] getRandomStackNumbers3() {
        return randomStackNumbers3;
    }

    public double[] getRandomStackNumbers4() {
        return randomStackNumbers4;
    }

    public double[] getRandomStackNumbers5() {
        return randomStackNumbers5;
    }

    public void setRandomStackNumbers1(double[] randomStackNumbers1) {
        this.randomStackNumbers1 = randomStackNumbers1;
    }

    public void setRandomStackNumbers2(double[] randomStackNumbers2) {
        this.randomStackNumbers2 = randomStackNumbers2;
    }

    public void setRandomStackNumbers3(double[] randomStackNumbers3) {
        this.randomStackNumbers3 = randomStackNumbers3;
    }

    public void setRandomStackNumbers4(double[] randomStackNumbers4) {
        this.randomStackNumbers4 = randomStackNumbers4;
    }

    public void setRandomStackNumbers5(double[] randomStackNumbers5) {
        this.randomStackNumbers5 = randomStackNumbers5;
    }

    public ObservableList<DataItem> getDataSimulated() {
        ObservableList<DataItem> data = FXCollections.observableArrayList();

        int max = 45;
        int min = 55;
        int paramForm = 4;
        int expectedValue = 30;
        int limit = 15;
        int [] auxDefect = new int[limit];
        for(int i = 0; i < limit; i++) {
            int assembly = i + 1;
            double rand1 = randomStackNumbers1[i];
            double rand2 = randomStackNumbers2[i];
            double rand3 = randomStackNumbers3[i];
            double rand4 = randomStackNumbers4[i];
            double rand5 = randomStackNumbers5[i];

            double sizeSteelBarA = min + (max - min)*rand1;
            double sizeSteelBarB = -((double) expectedValue /paramForm) * Math.log((1-rand2)*(1-rand3)*(1-rand4)*(1-rand5));
            double totalSizeSteel = sizeSteelBarA + sizeSteelBarB;
            boolean isDefect = true;
            if(totalSizeSteel >= 70 && totalSizeSteel <= 90){
                isDefect = false;
            } else {
                auxDefect[i] = 1;
            }
            int cumulativeDefect = 0;
            if(i == 0){
                cumulativeDefect = auxDefect[i];
            }else{
                cumulativeDefect = auxDefect[i] + auxDefect[i-1];
            }
            double percentDefect = (double) cumulativeDefect /assembly;
            DataItem dataItem = new DataItem(assembly, rand1, sizeSteelBarA, rand2, rand3, rand4, rand5, sizeSteelBarB, totalSizeSteel, 70, 90, isDefect? 1 : 0,  cumulativeDefect, percentDefect + "%");
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
        double[] newRandomList = new double[15];
        for (int i = 0; i < 15; i++) {
            double randomValue = Math.random(); // Round to 2 decimal places
            newRandomList[i] = randomValue;
        }
        return newRandomList;
    }

}
