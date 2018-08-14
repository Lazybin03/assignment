package com.example.demo.utills;

import java.util.UUID;

public class UniverseIdGenerator {
    public static String getId(){
        return "UNIV-"+ UUID.randomUUID().toString();
    }
}
