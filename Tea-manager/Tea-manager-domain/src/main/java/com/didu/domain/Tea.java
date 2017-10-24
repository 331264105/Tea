package com.didu.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/16.
 */
public class Tea {
    private int id;
    private String Teatitle;
    private String url;
    private int cid;
    private String listshow;
    private List<Tealist> tealist;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeatitle() {
        return Teatitle;
    }

    public void setTeatitle(String teatitle) {
        Teatitle = teatitle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getListshow() {
        return listshow;
    }

    public void setListshow(String listshow) {
        this.listshow = listshow;
    }

    public List<Tealist> getTealist() {
        return tealist;
    }

    public void setTealist(List<Tealist> tealist) {
        this.tealist = tealist;
    }

    public Tea(String teatitle, String url, int cid, String listshow, List<Tealist> tealist) {
        Teatitle = teatitle;
        this.url = url;
        this.cid = cid;
        this.listshow = listshow;
        this.tealist = tealist;
    }

    public Tea(int id, String teatitle, String url, int cid, String listshow, List<Tealist> tealist) {
        this.id = id;
        Teatitle = teatitle;
        this.url = url;
        this.cid = cid;
        this.listshow = listshow;
        this.tealist = tealist;
    }

    public Tea() {
        super();
    }

    @Override
    public String toString() {
        return "Tea{" +
                "id=" + id +
                ", Teatitle='" + Teatitle + '\'' +
                ", url='" + url + '\'' +
                ", cid=" + cid +
                ", listshow='" + listshow + '\'' +
                ", tealist=" + tealist +
                '}';
    }
}
