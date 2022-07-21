package com.dataworld.service.snackworld;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

@Getter
public class Standard {
    private static final Logger log = LoggerFactory.getLogger(Standard.class);
    private static Standard standard = new Standard();

    private int startDate;
    private int endDate;
    private int limitedAmount;

    private Standard(){
        this.startDate = 1;
        this.endDate = 31;
        this.limitedAmount = 20000;
    }

    public static Standard getStandard() {
        return standard;
    }

    public void setStandard(Integer startDate, Integer endDate, Integer limitedAmount) {
        if (!isNull(limitedAmount)) {
            this.limitedAmount = limitedAmount;
        }

        if (!validateDate(startDate, endDate)) {
            return;
        }

        if (!isNull(startDate)) {
            this.startDate = startDate;
        }

        if (!isNull(endDate)) {
            this.endDate = endDate;
        }
    }

    public boolean isNull(Object object){
        if(Objects.isNull(object)){
            return true;
        }
        return false;
    }

    public boolean checkDate(int day) {
        if(day >= startDate && day <= endDate){
            return true;
        }
        return false;
    }

    public boolean checkAmount(int amount) {
        if(amount <= limitedAmount){
            return true;
        }
        return false;
    }

    public boolean validateDate(Integer startDate, Integer endDate) {
        int s_Date;
        int e_Date;

        if (!isNull(startDate)) {
            s_Date = startDate;
        } else {
            s_Date = this.startDate;
        }

        if (!isNull(endDate)) {
            e_Date = endDate;
        } else {
            e_Date = this.endDate;
        }

        if (s_Date > e_Date) {
            log.info("시작일은 종료일보다 클 수 없습니다");
            return false;
        }

        return true;
    }
}
