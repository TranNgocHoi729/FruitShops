/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import model.Fruit;

/**
 *
 * @author dell
 */
public class Perform {

    ArrayList<Fruit> listOfFruit;
    Validate input = new Validate();
    HashMap<String, ArrayList<Fruit>> orders = new HashMap();

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
        System.out.print("Enter Price : ");
        double price = input.enterPrice();
        System.out.print("Enter Quantity : ");
        int quantity = input.getInt(0, Integer.MAX_VALUE);
        System.out.print("Enter Origin : ");
        String origin = input.enterOrigin();
        listOfFruit.add(new Fruit(id, name, price, quantity, origin));
    }

    public void shopping() {
        if (listOfFruit.isEmpty()) {
            System.out.println("        No fruit in Shop . Please come back latter !!");
        } else {
            String key = "";
            ArrayList<Fruit> lists = new ArrayList<>();
            while (true) {
                listAll();
                System.out.println("Enter Fruit Name : ");
                String fName = input.getValidateString();
                boolean checkName = input.checkNameExist(listOfFruit, fName);
                if (checkName == false) {
                    Fruit choosenFruit = findFruit(fName, listOfFruit);
                    System.out.println("Enter Quantity : ");
                    int quant = input.getInt(1, choosenFruit.getQuantity());
                    choosenFruit.setQuantity(choosenFruit.getQuantity() - quant);
                    String yesNo = input.yesNo();
                    lists.add(choosenFruit.coppyFruit(quant));
                    if (yesNo.equalsIgnoreCase("n")) {
                        System.out.println("Enter your name : ");
                        String customerName = input.getValidateString();
                        key = customerName + "#" + orders.size();
                        orders.put(key, lists);
                        break;
                    }
                } else {
                    System.out.println("        Sorry , we don't have that Fruit !!");
                }
            }
        }

    }

    private void listAll() {
        System.out.printf("%-10s|%-20s|%-20s|%-15s", "Item", "Fruit Name", "Origin", "Price");
        System.out.println("");
        for (Fruit fruit : listOfFruit) {
            fruit.listForShoping();
        }
    }

    private Fruit findFruit(String name, ArrayList<Fruit> list) {
        for (Fruit fruit : list) {
            if (fruit.getFruitName().equalsIgnoreCase(name)) {
                return fruit;
            }
        }
        return new Fruit();
    }

    public void readOrders() {
        if (orders.isEmpty()) {
            System.out.println("Don't have any Orders !!");
        } else {
            Set<String> listOfCus = orders.keySet();
            for (String listOfCu : listOfCus) {
                double total = 0;
                System.out.println("Customer : " + listOfCu.substring(0, listOfCu.indexOf("#")));
                for (Fruit fr : orders.get(listOfCu)) {
                    fr.listForOrders();
                    total += fr.totalPrice();
                }
                System.out.println("    Total Price : " + total);
                System.out.println("---------------------------");
            }
        }
    }

}
