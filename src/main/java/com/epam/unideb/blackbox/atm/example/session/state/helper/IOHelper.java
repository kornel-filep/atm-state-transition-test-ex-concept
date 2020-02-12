package com.epam.unideb.blackbox.atm.example.session.state.helper;

import java.util.Scanner;

public class IOHelper {
    public String promptPassword(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the card's passwod: ");
        return scanner.nextLine();
    }
}
