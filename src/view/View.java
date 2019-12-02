/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.Perform;
import control.Validate;
import java.util.Scanner;

/**
 *
 * @author dell
 */
public class View {

    public static void main(String[] args) {
        Validate input = new Validate();
        Scanner sc = new Scanner(System.in);
        Perform perform = new Perform();
        while (true) {
            menu();
            System.out.print("Enter your choice : ");
            int choice = input.getInt(1, 4);
            switch (choice) {
                case 1:
                    perform.addFruit();
                    break;
                case 2:
                    perform.shopping();
                    break;
                case 3:
                    break;
                case 4:
                    return;
            }
        }
    }

    private static void menu() {
        System.out.println("---- Fruit Shop ----");
        System.out.println("1. Create Fruit");
        System.out.println("2. View Orders");
        System.out.println("3. Shoping (for buyer)");
        System.out.println("4. Exit");

    }
}
