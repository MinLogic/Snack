package com.dataworld.snackworld;

import com.dataworld.db.Users;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Standard {
    private static Standard standard = new Standard();

    private int startDate;
    private int endDate;
    private int limitedAmount;

    private Standard(){}

    public static Standard getStandard() {
        return standard;
    }

    public void setStandard(Integer startDate, Integer endDate, Integer limitedAmount){
        if(!isNull(startDate)){
            this.startDate = startDate;
        }
        if(!isNull(endDate)){
            this.endDate = endDate;
        }
        if(!isNull(limitedAmount)){
            this.limitedAmount = limitedAmount;
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
}
