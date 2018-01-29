package com.matrimony.Data;

/**
 * Created by SANTOSH on 09-10-2016.
 */
public class DataModel
{  String name;
    String address;
    String events;
    String packages;

    int id_;
    int image;

    public DataModel(String name, String version,  String address,String distance,int id_, int image) {
        this.name = name;
        this.events = version;
        this.address=address;
        this.packages=distance;
        this.id_ = id_;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public String getEvents() {
    return events;
}
    public String getAddress() {
        return address;
    }
    public String getPackages() {
        return packages;
    }
    public int getImage() {
        return image;
    }

    public int getId() {
        return id_;
    }
}
