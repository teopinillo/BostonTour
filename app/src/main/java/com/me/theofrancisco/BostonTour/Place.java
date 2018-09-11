package com.me.theofrancisco.BostonTour;

public class Place {

    //place name
    private String name;

    //place address,
    private String address;

    //image resource id
    int imageResourceId;

    // constructor for the new word object
    public Place(String name, String address, int imageResourceId){
       this.name = name;
       this.address=address;
       this.imageResourceId = imageResourceId;
    }

    public String getName(){
        return name==null?"":name;
    }

    public String getAddress() {
        return address;
    }
    //get the image resource Id
    public int getImageResourceId() {
        return imageResourceId;
    }

}
