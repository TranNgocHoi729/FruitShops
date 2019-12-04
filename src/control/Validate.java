/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.Scanner;
import model.Fruit;

/**
 *
 * @author dell
 */
public class Validate {

    Scanner sc = new Scanner(System.in);

    public int getInt(int min, int max) {
        while (true) {
            try {
                int num = Integer.parseInt(sc.nextLine());
                if (num <= max && num >= min) {
                    return num;
                }
                System.out.println("Number must be in Range (" + min + "," + max + ")");
                System.out.println("Re-Enter : ");
            } catch (NumberFormatException e) {
                System.out.println("Input must be a number !");
                System.out.println("Re-Enter : ");
            }
        }
    }

    private boolean checkIDExist(ArrayList<Fruit> lis, String id) {
        if (lis.isEmpty()) {
            return true;
        } else {
            for (Fruit li : lis) {
                if (li.getFruitId().equalsIgnoreCase(id)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String EnterId(ArrayList<Fruit> listOfFruit) {
        while (true) {
            String id = sc.nextLine();
            if (checkIDExist(listOfFruit, id) == true) {
                return id;
            }
            System.out.println("Id already Exist !!");
            System.out.println("Please Re-Enter : ");
        }
    }

    // This function will be return False if ArrayList contain Fruit name, else return true. 
    public boolean checkNameExist(ArrayList<Fruit> lis, String name) {
        if (lis.isEmpty()) {
            return true;
        } else {
            for (Fruit li : lis) {
                if (li.getFruitName().equalsIgnoreCase(name)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String EnterName(ArrayList<Fruit> listOfFruit) {
        while (true) {
            String name = sc.nextLine();
            if (checkNameExist(listOfFruit, name) == true) {
                return name;
            }
            System.out.println("Name already Exist !!");
            System.out.println("Please Re-Enter : ");
        }
    }

    public double enterPrice() {
        while (true) {
            try {
                double price = Double.parseDouble(sc.nextLine());
                if (price > 0) {
                    return price;
                }
                System.out.println("Price must be bigger than 0 !!");
                System.out.println("Re-Enter : ");
            } catch (NumberFormatException e) {
                System.out.println("Price must be a number !!");
                System.out.println("Re-Enter : ");
            }
        }
    }

    public String enterOrigin() {
        while (true) {
            String org = sc.nextLine();
            if (!org.isEmpty()) {
                return org;
            }
            System.out.println("Origin must not be empty !!!");
            System.out.println("Please re-Enter : ");
        }

    }

    public String getValidateString() {
        while (true) {
            String s = sc.nextLine();
            if (s.isEmpty()) {
                System.out.println("Can not enter Nothing !!");
                System.out.println("Re-Enter : ");
            } else {
                return s;
            }
        }
    }

    public String yesNo() {
        while (true) {
            System.out.println("Do you want to continue Y/N ? ");
            String key = sc.nextLine();
            if ((key.length() == 1) && (key.charAt(0) == 'N' || key.charAt(0) == 'n' || key.charAt(0) == 'y' || key.charAt(0) == 'Y')) {
                return key;
            } else {
                System.out.println("Wrong input !! Input just contain Y/N !");
            }
        }
    }
}
