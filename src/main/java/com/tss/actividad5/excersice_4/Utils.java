package com.tss.actividad5.excersice_4;

import com.tss.actividad5.common.NumberRandomPair;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Stack;

public class Utils {
    private double [] randomListOneDefault = {0.935, 0.1307, 0.8557, 0.4987, 0.2534, 0.8885, 0.2714, 0.562, 0.2332, 0.9065, 0.4334, 0.4872, 0.3084, 0.0584};
    private double [] randomListOne = {0.935, 0.1307, 0.8557, 0.4987, 0.2534, 0.8885, 0.2714, 0.562, 0.2332, 0.9065, 0.4334, 0.4872, 0.3084, 0.0584};


    public Utils() {
    }

    public double[] getRandomListOneDefault() {
        return randomListOneDefault;
    }

    public double[] getRandomListOne() {
        return randomListOne;
    }

    public void setRandomListOne(double[] randomListOne) {
        this.randomListOne = randomListOne;
    }

    public ObservableList<DataItem> getDataSimulated() {
        ObservableList<DataItem> data = FXCollections.observableArrayList();
        Double average = 100.0;
        Double capacity = 700.0;
        Double orderCost = 1000.0;
        Double missingCost = 6.0;
        Double maintenanceCost = 1.0;
        int limit = 14;
        double [] invFinList = new double[limit];
        for(int i = 0; i < limit; i++) {
            int day = i + 1;
            Double supplierDelivery = 0.0;
            Double initialInventory = 0.0;
            if(i != 0){
                initialInventory = invFinList[i-1];
            }
            if(initialInventory == 0){
                supplierDelivery = 700.0;
            } else {
                supplierDelivery = 0.0;
            }
            Double totalInventory = initialInventory + supplierDelivery;
            Double random = randomListOne[i];
            Double demand = (double) -Math.round(average * Math.log(1 - random));
            Double sales = 0.0;
            if(demand < initialInventory){
                sales = demand;
            } else {
                if(i == 0){
                    sales = demand;
                } else {
                    sales = invFinList[i-1];
                }
            }
            Double finalInventory = totalInventory - sales;
            invFinList[i] = finalInventory;

            Double lostSales = 0.0;
            if(demand > totalInventory){
                lostSales = demand - sales;
            } else {
                lostSales = 0.0;
            }

            Double order = 0.0;
            if(initialInventory == 0){
                order = orderCost;
            }
            Double missing = 0.0;
            if(totalInventory < demand){
                missing = missingCost * totalInventory;
            }
            Double maintenance = 0.0;
            if(finalInventory > 0){
                maintenance = finalInventory;
            }
            Double totalCost = order + missing + maintenance;
            DataItem dataItem =  new DataItem(day, initialInventory, supplierDelivery, totalInventory, random, demand, sales, finalInventory, lostSales, order, missing, maintenance, totalCost);
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
        double[] newRandomList = new double[18];
        for (int i = 0; i < 15; i++) {
            double randomValue = Math.random(); // Round to 2 decimal places
            newRandomList[i] = randomValue;
        }
        return newRandomList;
    }

}
