package com.me.theofrancisco.BostonTour;

import android.util.Log;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {



    public static ArrayList<Place> getPlaces(String tag){
        String regex = "(phname_\\S+_addr)(_\\S+_tab)(_" + tag+"$)";
        //Log.i("myApp","regex: "+regex);
        Pattern p = Pattern.compile(regex);
        ArrayList<Place> places = new ArrayList<>();
        Field[]  fields = R.drawable.class.getFields();
        final R.drawable drawableResources = new R.drawable();

         int[] resArray = new int[fields.length];
          for (int i=0; i<fields.length;i++){
              try{
                  String metadata = fields[i].getName();

                  // create matcher for pattern p and given string
                  Matcher m = p.matcher(metadata);

                  // if an occurrence if a pattern was found in a given string...
                  if (m.find()) {
                      // ...then you can use group() methods.
                      //System.out.println(m.group(0)); // whole matched expression
                      //Log.i("myApp","Resources Match: ");
                      String pictName = m.group(1).replace("phname_","").replace("_addr","").replace("_"," ");
                      String address = m.group(2).replace("_tab","").replace("_"," ");

                      //Log.i("myApp","Pict Name: " + pictName); // first expression pict name
                      //Log.i("myApp","address: " +address); // address
                      //Log.i("myApp",m.group(3)); // third one tab
                      final int resourceId = fields[i].getInt(drawableResources);
                      //Log.i("myApp", "Resource id: " + Integer.toString(resourceId)); // third one (Testing)
                      places.add (new Place (pictName,address, resourceId));

                  }else{
                      Log.i("myApp",metadata+ " Pattern doesnt match");
                  }

              }catch (Exception e){
                  Log.e ("myApp","Getting Resources Error: "+e.getMessage());
              }
          }


        return places;
    }


}
