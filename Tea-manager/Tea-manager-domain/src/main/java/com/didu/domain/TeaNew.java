package com.didu.domain;

/**
 * Created by Administrator on 2017/10/17.
 */
public class TeaNew {
    private int id;
    private String name;
    private String url;
    private String time;
    private String text;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TeaNew(int id, String name, String url, String time, String text, String title) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.time = time;
        this.text = text;
        this.title = title;
    }

    public TeaNew() {
        super();
    }

    public TeaNew(String name, String url, String time, String text, String title) {
        this.name = name;
        this.url = url;
        this.time = time;
        this.text = text;
        this.title = title;
    }

    @Override
    public String toString() {
        return "TeaNew{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", time='" + time + '\'' +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
