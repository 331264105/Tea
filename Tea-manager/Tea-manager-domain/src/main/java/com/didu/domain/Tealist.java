package com.didu.domain;

/**
 * Created by Administrator on 2017/10/16.
 */
public class Tealist {
    private int id;
    private String teaname;
    private int num;
    private String price;
    private String url;
    private int cid;
    private int teag;
    private Double transport;
    private String discount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeaname() {
        return teaname;
    }

    public void setTeaname(String teaname) {
        this.teaname = teaname;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public int getTeag() {
        return teag;
    }

    public void setTeag(int teag) {
        this.teag = teag;
    }

    public Double getTransport() {
        return transport;
    }

    public void setTransport(Double transport) {
        this.transport = transport;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Tealist(String teaname, int num, String price, String url, int cid, int teag, Double transport, String discount) {
        this.teaname = teaname;
        this.num = num;
        this.price = price;
        this.url = url;
        this.cid = cid;
        this.teag = teag;
        this.transport = transport;
        this.discount = discount;
    }

    public Tealist(int id, String teaname, int num, String price, String url, int cid, int teag, Double transport, String discount) {
        this.id = id;
        this.teaname = teaname;
        this.num = num;
        this.price = price;
        this.url = url;
        this.cid = cid;
        this.teag = teag;
        this.transport = transport;
        this.discount = discount;
    }

    public Tealist() {
        super();
    }

    @Override
    public String toString() {
        return "Tealist{" +
                "id=" + id +
                ", teaname='" + teaname + '\'' +
                ", num=" + num +
                ", price='" + price + '\'' +
                ", url='" + url + '\'' +
                ", cid=" + cid +
                ", teag=" + teag +
                ", transport=" + transport +
                ", discount='" + discount + '\'' +
                '}';
    }
}
