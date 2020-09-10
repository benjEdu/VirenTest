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
public class Test extends person{

    
    
    public Test(String test){
        super(test);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("test");
        Test test = new Test("test");
        person p = new Test("person");
        test.setA(2);
        test.setB(2);
        int c = test.getA()+test.getB();
        System.out.println(c);
        test.setTestString("holidhuedue");
        System.out.println(test.getTestString());
        int a = 5;
        System.out.println(a);
    }
    
}
