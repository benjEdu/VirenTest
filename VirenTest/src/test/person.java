/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author z003ub8r
 */
public abstract class person {
    private String teststring;
    private int a;
    private int b;
    
    public person(String test){
        this.teststring = test;
    }
    
    public String getTestString(){
        return teststring;
    }
    public void setTestString(String test){
        this.teststring = test;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
    
}
