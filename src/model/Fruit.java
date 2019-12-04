/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dell
 */
public class Fruit {
    private String fruitId;
    private String fruitName;
    private double price;
    private int quantity;
    private String origin;

    public Fruit(String fruitId, String fruitName, double price, int quantity, String origin) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public Fruit() {
    }

    public String getFruitId() {
        return fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getOrigin() {
        return origin;
    }
    
    public void listForShoping(){
        System.out.printf("%-10s%-20s%-20s%-15.2f",fruitId,fruitName,origin,price);
        System.out.println("");
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    // create new Fruit but keep NAme , ID , Price but change Quantity
    public Fruit coppyFruit(int quant){
        return new Fruit(fruitId, fruitName, price, quant, origin);
    }
   public double totalPrice(){
       return quantity*price;
   }
    public void listForOrders(){
        System.out.printf("%-20s%-10d%-15.2f",fruitName,quantity,totalPrice());
        System.out.println("");
    }
}
