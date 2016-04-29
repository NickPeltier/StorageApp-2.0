package com.example.nickp.storageapp;

/**
 * Created by nickp on 4/15/2016.
 */
public class InventoryGlob {

    private static InventoryGlob instance = new InventoryGlob();

    // Getter-Setters
    public static InventoryGlob getInstance() {
        return instance;
    }

    public static void setInstance(InventoryGlob instance) {
        InventoryGlob.instance = instance;
    }

    private String invName;


    private InventoryGlob() {

    }


    public String getValue() {
        return invName;
    }


    public void setValue(String invName) {
        this.invName = invName;
    }



}