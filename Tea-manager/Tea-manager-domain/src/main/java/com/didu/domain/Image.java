package com.didu.domain;

import java.util.Date;

/**
 * Created by Administrator on 2017/10/11.
 */

public class Image {
    private int id;
    private String name;
    private String path;
    private String createtime;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Image( String name, String path) {
        this.name = name;
        this.path = path;
    }

    public Image() {
        super();
    }

    public Image(int id, String name, String path, String createtime) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
