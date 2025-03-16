package org.advancedjava.lld.designHashMap;

public class Main {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("Vishal", 88);
        map.put("Lakshay", 78);
        map.put("Shivam", 66);
        map.put("Raushan", 0);
        map.put("Harsh", 45);

        System.out.println(map.get("Vishal"));
        System.out.println(map.get("Himank"));
    }
}
