package com.tss.actividad5.excersice_3;

public class DataItem {
    private Integer assembly;
    private Double rand1;
    private Double sizeSteelBarA;
    private Double rand2;
    private Double rand3;
    private Double rand4;
    private Double rand5;
    private Double sizeSteelBarB;
    private Double totalSizeSteel;
    private Integer lowSpecification;
    private Integer upSpecification;
    private Integer isDefect;
    private Integer cumulativeDefect;
    private String percentDefect;

    public DataItem() {
    }

    public DataItem(Integer assembly, Double rand1, Double sizeSteelBarA, Double rand2, Double rand3, Double rand4, Double rand5, Double sizeSteelBarB, Double totalSizeSteel, Integer lowSpecification, Integer upSpecification, Integer isDefect, Integer cumulativeDefect, String percentDefect) {
        this.assembly = assembly;
        this.rand1 = rand1;
        this.sizeSteelBarA = sizeSteelBarA;
        this.rand2 = rand2;
        this.rand3 = rand3;
        this.rand4 = rand4;
        this.rand5 = rand5;
        this.sizeSteelBarB = sizeSteelBarB;
        this.totalSizeSteel = totalSizeSteel;
        this.lowSpecification = lowSpecification;
        this.upSpecification = upSpecification;
        this.isDefect = isDefect;
        this.cumulativeDefect = cumulativeDefect;
        this.percentDefect = percentDefect;
    }

    public Integer getAssembly() {
        return assembly;
    }

    public Double getRand1() {
        return rand1;
    }

    public Double getSizeSteelBarA() {
        return sizeSteelBarA;
    }

    public Double getRand2() {
        return rand2;
    }

    public Double getRand3() {
        return rand3;
    }

    public Double getRand4() {
        return rand4;
    }

    public Double getRand5() {
        return rand5;
    }

    public Double getSizeSteelBarB() {
        return sizeSteelBarB;
    }

    public Double getTotalSizeSteel() {
        return totalSizeSteel;
    }

    public Integer getLowSpecification() {
        return lowSpecification;
    }

    public Integer getUpSpecification() {
        return upSpecification;
    }

    public Integer getIsDefect() {
        return isDefect;
    }

    public Integer getCumulativeDefect() {
        return cumulativeDefect;
    }

    public String getPercentDefect() {
        return percentDefect;
    }
}
