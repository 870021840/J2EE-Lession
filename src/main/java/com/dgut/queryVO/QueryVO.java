package com.dgut.queryVO;

import java.util.List;

public class QueryVO {

    private String username;
    private List<Integer> ids;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
