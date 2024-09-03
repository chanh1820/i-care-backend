package com.example.icare.sco.dto;

import com.example.icare.sco.BaseSCO;

import java.util.Collection;

public class SearchNumberDTO {

    private Number equal;

    private Collection<Number> between;

    private Number gt;

    private Number lt;

    public SearchNumberDTO() {
    }

    public Number getEqual() {
        return equal;
    }

    public void setEqual(Number equal) {
        this.equal = equal;
    }

    public Collection<Number> getBetween() {
        return between;
    }

    public void setBetween(Collection<Number> between) {
        this.between = between;
    }

    public Number getGt() {
        return gt;
    }

    public void setGt(Number gt) {
        this.gt = gt;
    }

    public Number getLt() {
        return lt;
    }

    public void setLt(Number lt) {
        this.lt = lt;
    }
}
