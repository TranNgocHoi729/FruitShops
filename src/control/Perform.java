/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import model.Fruit;

/**
 *
 * @author dell
 */
public class Perform {

    ArrayList<Fruit> listOfFruit;
    Validate input = new Validate();

    public Perform() {
        listOfFruit = new ArrayList<>();
    }

    public ArrayList<Fruit> getListOfFruit() {
        return listOfFruit;
    }

    public void addFruit() {
        System.out.print("Enter Number of Fruit you want to Enter (maximum 10) : ");
        int number = input.getInt(1, 10);
        for (int i = 0; i < number; i++) {
            int numOfElement = listOfFruit.size();
            addToList();
            if (numOfElement == listOfFruit.size() - 1) {
                System.out.println("Add Suceesfuly !!");
            }
        }
    }

    private void addToList() {
        System.out.print("Enter Fruit Code : ");
        String id = input.EnterId(listOfFruit);
        System.out.print("Enter Fruit Name : ");
        String name = input.EnterName(listOfFruit);
        System.out.println("--------- : "+name);
        System.out.print("Enter Price : ");
        double price = input.enterPrice();
        System.out.print("Enter Quantity : ");
        int quantity = input.getInt(0, Integer.MAX_VALUE);
        System.out.print("Enter Origin : ");
        String origin = input.enterOrigin();
        listOfFruit.add(new Fruit(id, name, price, quantity, origin));
    }
    
    public void shopping(){
        listAll();
    }
    private void listAll(){
        System.out.printf("%-10s|%-20s|%-20s|%-15s","Item","Fruit Name","Origin" ,"Price");
        System.out.println("");
        for (Fruit fruit : listOfFruit) {
            fruit.listForShoping();
        }
    }
}
