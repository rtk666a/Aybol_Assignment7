package com.coderscampus.arraylist;

public class CustomListApplication {
    public static void main(String[] args) {
        CustomArrayList<String> names = new CustomArrayList<>();

        for (int i = 0; i < 20; i++) {
            names.add("name" + i);
        }

        for (int i = 0; i < names.size; i++) {
            System.out.println(names.get(i));
        }

    }
}