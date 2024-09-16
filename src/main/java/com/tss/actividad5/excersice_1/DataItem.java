package com.tss.actividad5.excersice_1;

public class DataItem {
    private Integer part;
    private Double timeBetweenArrived;
    private Double timeArrived;
    private Double timeStartInspection;
    private Double timeOfInspection;
    private Double timeEndInspection;
    private Double timeOnInspection;
    private Double timeOnWaitingInspection;
    private Double timeAverageOnInspection;

    public DataItem() {
    }

    public DataItem(Integer part, Double timeBetweenArrived, Double timeArrived, Double timeStartInspection, Double timeOfInspection, Double timeEndInspection, Double timeOnInspection, Double timeOnWaitingInspection, Double timeAverageOnInspection) {
        this.part = part;
        this.timeBetweenArrived = timeBetweenArrived;
        this.timeArrived = timeArrived;
        this.timeStartInspection = timeStartInspection;
        this.timeOfInspection = timeOfInspection;
        this.timeEndInspection = timeEndInspection;
        this.timeOnInspection = timeOnInspection;
        this.timeOnWaitingInspection = timeOnWaitingInspection;
        this.timeAverageOnInspection = timeAverageOnInspection;
    }

    public Integer getPart() {
        return part;
    }

    public Double getTimeBetweenArrived() {
        return timeBetweenArrived;
    }

    public Double getTimeArrived() {
        return timeArrived;
    }

    public Double getTimeStartInspection() {
        return timeStartInspection;
    }

    public Double getTimeOfInspection() {
        return timeOfInspection;
    }

    public Double getTimeEndInspection() {
        return timeEndInspection;
    }

    public Double getTimeOnInspection() {
        return timeOnInspection;
    }

    public Double getTimeOnWaitingInspection() {
        return timeOnWaitingInspection;
    }

    public Double getTimeAverageOnInspection() {
        return timeAverageOnInspection;
    }
}
