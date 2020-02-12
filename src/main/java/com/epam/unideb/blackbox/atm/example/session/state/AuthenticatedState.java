package com.epam.unideb.blackbox.atm.example.session.state;

import com.epam.unideb.blackbox.atm.example.session.ATMSession;

public class AuthenticatedState extends AtmState {

    public AuthenticatedState() {
        printStatus();
    }

    public void nextState(ATMSession atmSession) {
        System.out.println("No more states in this demo :(");
    }

    public void printStatus() {
        System.out.println("Authenticated!");
    }
}
