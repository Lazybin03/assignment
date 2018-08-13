package com.example.demo.utills;

import java.util.UUID;

public class PersonIdGenerator  {

 public static String getId(){
     return "PER"+UUID.randomUUID().toString();
 }
}
