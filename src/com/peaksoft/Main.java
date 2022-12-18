package com.peaksoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

import static java.lang.StrictMath.random;

public class Main {
    private static GsonBuilder gsonBuilder = new GsonBuilder();
    private static Gson gson = gsonBuilder.setPrettyPrinting().create();
    private static Path URL = Paths.get("MotorPro.txt");


    public static void main(String[] args) {
        /**
         * Welcome guis it is first project of second stage
         * good luck*/
        Truck[] truck = {
                Truck.truck(1, "Renault Magnum", new Driver(" "), State.BASE),
                Truck.truck(2, "Volvo", new Driver(" "), State.BASE),
                Truck.truck(3, "DAF XT", new Driver(" "), State.BASE)
        };
        String json = gson.toJson(truck);
        write(json);
      Truck [] trucks=gson.fromJson(read(),Truck[].class);
        System.out.println("       Info about trucks\n----------------------------------");
        System.out.println("#  | Bus  |  Driver |  State\n      —+———-+———+———");
      for(Truck trucks1: trucks){
          System.out.println(trucks1);
      }
    }

    public static void write(String json) {
        try {
            Files.writeString(URL, json, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public static String read(){
        String json=" ";
        int a;
        try{
            FileReader reader=new FileReader(String.valueOf(URL));
            while ((a=reader.read())!=-1){
                json+=(char)a;
            }
        }catch (IOException e){
            e.printStackTrace();
        }return json;
    }
}