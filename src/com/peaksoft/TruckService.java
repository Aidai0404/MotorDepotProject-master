package com.peaksoft;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TruckService {


    Scanner sc=new Scanner(System.in);
    static Driver driver=new Driver();
    static  String dr;
    public void changeTruck(Truck[]trucks,int truckId,Driver[]drivers) throws MyException {
        for (int i = 0; i <trucks.length ; i++) {
            if (trucks[i].getId()==truckId){
                if(trucks[i].getDriver().getName()==null){
                    dr=" ";
                }else{
                    dr=trucks[i].getDriver().getName();
                }

                System.out.println("N "+trucks[i].getId());
                System.out.println("Truck "+trucks[i].getName());
                System.out.println("Driver "+dr);
                System.out.println("State "+trucks[i].getState());
                if(trucks[i].getState()==State.BASE){
                    System.out.println("Если хотите отправить в путь - нажмите 1");
                    System.out.println("Если хотите отправить на ремонт - нажмите 2");
                    System.out.println("Если хотите выбрать водителя - нажмите 3");
                    int change=sc.nextInt();
                    if(change==3){
                      changeDriver(drivers,trucks[i]);
                      trucks[i].setDriver(driver);
                        System.out.println("Хотите отправить его в путь? - Тогда нажмите на 1,если нет - тогда 0");
                        change= sc.nextInt();
                        if(change==1){
                            startDriving(driver,trucks[i]);
                        }else if(change==0){
                            System.out.println("Грузовик остался на базе");
                        }
                    }else if(change==1){
                        changeDriver(drivers,trucks[i]);
                        trucks[i].setDriver(driver);
                        startDriving(driver,trucks[i]);
                        trucks[i].setState(State.ROUT);
                        System.out.println();
                    }else if(change==2){
                        startRepair(trucks[i]);
                        trucks[i].setState(State.REPAIR);
                    }
                }else if(trucks[i].getState()==State.ROUT){
                    System.out.println("Вы выбрали грузовик "+trucks[i].getName()+", и он уже в пути");
                }else if(trucks[i].getState()==State.REPAIR){
                    System.out.println(trucks[i].getName()+" на ремонте");
                }
            }if(trucks[i].getId()>trucks.length){
                System.out.println("Выберите только один из 3");
            }
        }
    }
    public void changeDriver(Driver []drivers,Truck truck) {
        for (int i = 0; i < drivers.length; i++) {
            if(drivers[i].getId()== truck.getId()) {
                driver = drivers[i];
            }
        }
        System.out.println("Теперь у грузовика "+truck.getName()+", водитель"+driver);

    }
    public void startDriving(Driver driver,Truck truck){
        System.out.println("Грузовик "+truck.getName()+"ведет"+driver.getName());
    }
    public void startRepair(Truck truck){
        System.out.println("Теперь грузовик "+truck.getName()+" на ремонте");
    }
}
