package com.didu.domain;

/**
 * Created by Administrator on 2017/10/17.
 */
public class TeaImage {
    private int id;
    private  String name;
    private String url;
    private int pid;
    private int cid;
    private String createtime;

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

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public TeaImage(String name, String url, int pid, int cid, String createtime) {
        this.name = name;
        this.url = url;
        this.pid = pid;
        this.cid = cid;
        this.createtime = createtime;
    }

    public TeaImage(int id, String name, String url, int pid, int cid, String createtime) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.pid = pid;
        this.cid = cid;
        this.createtime = createtime;
    }

    public TeaImage() {
        super();
    }

    @Override
    public String toString() {
        return "TeaImage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", pid=" + pid +
                ", cid=" + cid +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
