package org.example;

import java.beans.ConstructorProperties;

public class Dev {

    private int val;

    private Computer comp;

    public Dev(){
    }

//    @ConstructorProperties({"val" , "laptop"})
//    public Dev(Laptop laptop, int val) {
//        System.out.println("called");
//        this.laptop = laptop;
//        this.val = val;
//    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Computer getComp() {
        return comp;
    }

    public void setComp(Computer comp) {
        this.comp = comp;
    }

    public void build(){
        comp.compile();
    }
}
