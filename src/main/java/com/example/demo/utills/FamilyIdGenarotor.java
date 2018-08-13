package com.example.demo.utills;

import java.util.UUID;

public class FamilyIdGenarotor {

    public static String getId(){
        return "FAM"+ UUID.randomUUID().toString();
    }
}
