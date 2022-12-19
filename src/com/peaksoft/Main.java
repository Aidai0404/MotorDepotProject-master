package com.peaksoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static GsonBuilder gsonBuilder = new GsonBuilder();
    private static Gson gson = gsonBuilder.setPrettyPrinting().create();
    private static Path URL = Paths.get("MotorPro.json");

    private static Path URLDriver = Paths.get("MotorProDriver.json");
    public static void main(String[] args) throws Exception{
        /**
         * Welcome guis it is first project of second stage
         * good luck*/
        Truck[] truck = {
                Truck.truck(1, "Renault Magnum", new Driver(), State.BASE),
                Truck.truck(2, "Volvo", new Driver(), State.BASE),
                Truck.truck(3, "DAF XT", new Driver(), State.BASE)
        };
        String json = gson.toJson(truck);
        write(json);

      Truck [] trucks=gson.fromJson(read(),Truck[].class);
        System.out.println("       Info about trucks\n----------------------------------");
        System.out.println("#  | Bus  |  Driver |  State\n      —+———-+———+———");
      for(Truck trucks1: trucks){
          System.out.println(trucks1);
      }
     Driver [] drivers = {
             Driver.driver(1,"Petr",""),
             Driver.driver(2,"Fedor",""),
             Driver.driver(3,"Anton","")
     };

      String json2 = gson.toJson(drivers);
      writeDriver(json2);
      Driver []drivers1=gson.fromJson(readDriver(),Driver[].class);
        System.out.println("\n    Info about drivers    \n------------------------------");
        System.out.println("#  Driver    |  Bus");
        System.out.println("—+———-----------+———+");
      for(Driver driver: drivers1){
          System.out.println(driver);
      }
        Scanner sc=new Scanner(System.in);
      while (true) {
          try {
              TruckService truckService = new TruckService();
              System.out.println("Выберите грузовик или нажмите на 0,чтобы остановить программу");
              int truckId=sc.nextInt();
              truckService.changeTruck(trucks, truckId, drivers);
              if(truckId==0){
                  break;
              }
              for (Truck truck1:trucks){
                  if(truck1.getId()==truckId){
                      System.out.println("N "+truck1.getId());
                      System.out.println("Truck's name "+truck1.getName());
                      System.out.println("Driver "+truck1.getDriver());
                      System.out.println("Truck's state "+truck1.getState());
                  }
              }
          }catch (RuntimeException e) {
              e.printStackTrace();
          }

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
        String json =" ";
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
    public static void writeDriver(String json2){
        try {
            Files.writeString(URLDriver,json2,StandardOpenOption.CREATE,StandardOpenOption.WRITE);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String readDriver(){
        String json2=" ";
        int a;
        try{
            FileReader reader=new FileReader(String.valueOf(URLDriver));
            while ((a=reader.read())!=-1){
                json2+=(char)a;
            }
        }catch (IOException e){
            e.printStackTrace();
        }return json2;
    }
}