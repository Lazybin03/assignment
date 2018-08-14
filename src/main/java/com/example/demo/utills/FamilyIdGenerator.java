package com.example.demo.utills;

import java.util.UUID;

public class FamilyIdGenerator {

    public static String getId(){
        return "FAM-"+ UUID.randomUUID().toString();
    }
}
