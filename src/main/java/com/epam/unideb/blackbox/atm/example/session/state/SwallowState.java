package com.epam.unideb.blackbox.atm.example.session.state;

import com.epam.unideb.blackbox.atm.example.session.ATMSession;
import com.epam.unideb.blackbox.atm.example.session.state.helper.IOHelper;

public class  SwallowState extends AtmState{

    public SwallowState() {
        printStatus();
    }

    public void nextState(ATMSession atmSession) {
        atmSession.setState(new InitialState(new IOHelper()));
    }

    public void printStatus() {
        System.out.println("Card swallowed after 3 unsuccessful tries");
    }
}
