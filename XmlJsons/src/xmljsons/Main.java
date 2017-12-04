/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmljsons;
import java.io.*;

import ShoppingCart.ShoppingCart;

/**
 *
 * @author andri
 */
public class Main {
    
    public static void main(String[] args){
        Product p1, p2, p3, p4, p5, p6;
        p1=new Product.Builder().setTitle("Butter").setType("Dairy").setPrice(100).
                setDateOfProduction(2017, 10, 5).
                setShiftTime(2017, 11,20).createProduct();
        p2=new Product.Builder().setTitle("Pork").setType("Meat").setPrice(100).
                setDateOfProduction(2017, 10, 25).
                setShiftTime(2017, 11,12).createProduct();
        p3=new Product.Builder().setTitle("Chocolate").setType("Sweets").setPrice(30).
                setDateOfProduction(2017, 9, 15).
                setShiftTime(2018, 2, 15).createProduct();
        p4=new Product.Builder().setTitle("Chocolate").setType("Sweets").setPrice(30).
                setDateOfProduction(2017, 9, 15).
                setShiftTime(2018, 2, 15).createProduct();
        p5=new Product.Builder().setTitle("Tomatoes").setType("Vegetables").setPrice(40).
                setDateOfProduction(2017, 11, 2).
                setShiftTime(2018, 11, 15).createProduct();
        p6=new Product.Builder().setTitle("Branbread").setType("Baked").setPrice(10).
                setDateOfProduction(2017, 11, 3).
                setShiftTime(2018, 11, 5).createProduct();
       ShoppingCart cart1 = new ShoppingCart();
           cart1.setTitle("Cart1");
        cart1.addProduct(p1);
        cart1.addProduct(p2);
        cart1.addProduct(p3);
        cart1.addProduct(p4); 
        cart1.addProduct(p5);
        cart1.addProduct(p6);
    
        
        // XML serialize
        File file1 = new File("cart.xml");
        try{
            file1.createNewFile();
        }
        catch(Exception e){}

        XmlJsons xml =new JAXB();
        System.out.println(p1);
        
        xml.serialize(p1, file1);
        
        // XML deserialize
        
        // JSON serialize
      /*  File file2 = new File("cart.json");
        try{
        file2.createNewFile();
        }
        catch(Exception e){}

        XmlJsons json =new FastJSON();
        json.serialize(cart1, file2);
        
               
        // JSON deserialize
        ShoppingCart cart2 = new ShoppingCart();
        cart2 = (ShoppingCart) (json.deserialize(ShoppingCart.class, file2));
        cart2.outputShoppingCart();*/
}
    
    
}
