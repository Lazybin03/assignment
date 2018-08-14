package com.example.demo.utills;

import java.util.UUID;

public class UnivFamilyIdGenerator {
    public static String getId(){
        return "UF-"+ UUID.randomUUID().toString();
    }
}
