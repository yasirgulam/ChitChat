package com.example.chitchat.utils;

public class StringManipulation {

        public static String expandUsername(String username) {
            return username.replace(".", " ");
        }

        public static String condenseUsername(String username) {
            return username.replace(" ", ".");
        }
    }

