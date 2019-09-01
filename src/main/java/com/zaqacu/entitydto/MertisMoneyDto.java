package com.zaqacu.entitydto;

public class MertisMoneyDto {

    private Integer mertisMoneyId;

    private Double mertisPercentage;

    private Double mertisMoneyNum;

    private String percontage;

    public Integer getMertisMoneyId() {
        return mertisMoneyId;
    }

    public void setMertisMoneyId(Integer mertisMoneyId) {
        this.mertisMoneyId = mertisMoneyId;
    }

    public Double getMertisPercentage() {
        return mertisPercentage;
    }

    public void setMertisPercentage(Double mertisPercentage) {
        this.mertisPercentage = mertisPercentage;
    }

    public Double getMertisMoneyNum() {
        return mertisMoneyNum;
    }

    public void setMertisMoneyNum(Double mertisMoneyNum) {
        this.mertisMoneyNum = mertisMoneyNum;
    }

    public String getPercontage() {
        return this.mertisPercentage*100+"%";
    }

    public void setPercontage(String percontage) {
        this.percontage = percontage;
    }

    @Override
    public String toString() {
        return "MertisMoneyDto{" +
                "mertisMoneyId=" + mertisMoneyId +
                ", mertisPercentage=" + mertisPercentage +
                ", mertisMoneyNum=" + mertisMoneyNum +
                ", percontage='" + percontage + '\'' +
                '}';
    }
}
