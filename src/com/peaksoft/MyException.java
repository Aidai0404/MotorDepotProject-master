package com.peaksoft;

public class MyException extends Exception {
    public void exception(){
        System.out.println("Грузовик в пути, невозможно сменить водителя");
    }
}
