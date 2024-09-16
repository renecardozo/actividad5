package com.tss.actividad5.excersice_2;

public class DataItem {
    private Integer part;
    private Double randomOne;
    private Double timeBetweenArrived;
    private Double timeArrived;
    private Double timeStartedInspection;
    private Double randomTwo;
    private Double durationTimeInspection;
    private Double timeEndedInspection;
    private Double timeTotalInspection;
    private Double timeWaiting;

    public DataItem() {
        this.part = 0;
        this.randomOne = 0.0;
        this.timeBetweenArrived = 0.0;
        this.timeArrived = 0.0;
        this.timeStartedInspection = 0.0;
        this.randomTwo = 0.0;
        this.durationTimeInspection = 0.0;
        this.timeEndedInspection = 0.0;
        this.timeTotalInspection = 0.0;
        this.timeWaiting = 0.0;
    }

    public DataItem(Integer part, Double randomOne, Double timeBetweenArrived, Double timeArrived, Double timeStartedInspection, Double randomTwo, Double durationTimeInspection, Double timeEndedInspection, Double timeTotalInspection, Double timeWaiting) {
        this.part = part;
        this.randomOne = randomOne;
        this.timeBetweenArrived = timeBetweenArrived;
        this.timeArrived = timeArrived;
        this.timeStartedInspection = timeStartedInspection;
        this.randomTwo = randomTwo;
        this.durationTimeInspection = durationTimeInspection;
        this.timeEndedInspection = timeEndedInspection;
        this.timeTotalInspection = timeTotalInspection;
        this.timeWaiting = timeWaiting;
    }

    public Integer getPart() {
        return part;
    }

    public Double getRandomOne() {
        return randomOne;
    }

    public Double getTimeBetweenArrived() {
        return timeBetweenArrived;
    }

    public Double getTimeArrived() {
        return timeArrived;
    }

    public Double getTimeStartedInspection() {
        return timeStartedInspection;
    }

    public Double getRandomTwo() {
        return randomTwo;
    }

    public Double getDurationTimeInspection() {
        return durationTimeInspection;
    }

    public Double getTimeEndedInspection() {
        return timeEndedInspection;
    }

    public Double getTimeTotalInspection() {
        return timeTotalInspection;
    }

    public Double getTimeWaiting() {
        return timeWaiting;
    }
}
