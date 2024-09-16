package com.tss.actividad5.excersice_4;

public class DataItem {
    private Integer day;
    private Double initialInventory;
    private Double supplierDelivery;
    private Double totalInventory;
    private Double rand;
    private Double demand;
    private Double sales;
    private Double finalInventory;
    private Double lostSales;
    private Double orderCost;
    private Double missingCost;
    private Double maintenanceCost;
    private Double totalCost;

    public DataItem() {
    }

    public DataItem(Integer day, Double initialInventory, Double supplierDelivery, Double totalInventory, Double rand, Double demand, Double sales, Double finalInventory, Double lostSales, Double orderCost, Double missingCost, Double maintenanceCost, Double totalCost) {
        this.day = day;
        this.initialInventory = initialInventory;
        this.supplierDelivery = supplierDelivery;
        this.totalInventory = totalInventory;
        this.rand = rand;
        this.demand = demand;
        this.sales = sales;
        this.finalInventory = finalInventory;
        this.lostSales = lostSales;
        this.orderCost = orderCost;
        this.missingCost = missingCost;
        this.maintenanceCost = maintenanceCost;
        this.totalCost = totalCost;
    }

    public Integer getDay() {
        return day;
    }

    public Double getInitialInventory() {
        return initialInventory;
    }

    public Double getSupplierDelivery() {
        return supplierDelivery;
    }

    public Double getTotalInventory() {
        return totalInventory;
    }

    public Double getRand() {
        return rand;
    }

    public Double getDemand() {
        return demand;
    }

    public Double getSales() {
        return sales;
    }

    public Double getFinalInventory() {
        return finalInventory;
    }

    public Double getLostSales() {
        return lostSales;
    }

    public Double getOrderCost() {
        return orderCost;
    }

    public Double getMissingCost() {
        return missingCost;
    }

    public Double getMaintenanceCost() {
        return maintenanceCost;
    }

    public Double getTotalCost() {
        return totalCost;
    }
}
