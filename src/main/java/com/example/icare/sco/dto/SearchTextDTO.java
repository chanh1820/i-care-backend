package com.example.icare.sco.dto;

import java.io.Serializable;
import java.util.Collection;

public class SearchTextDTO implements Serializable{
    private static final long serialVersionUID = -5375270910520186346L;

    private String equal;

    private String like;

    private Collection<String> in;

    public SearchTextDTO() {
    }

    public String getEqual() {
        return equal;
    }

    public void setEqual(String equal) {
        this.equal = equal;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public Collection<String> getIn() {
        return in;
    }

    public void setIn(Collection<String> in) {
        this.in = in;
    }
}
