package com.epam.unideb.blackbox.atm.example;

import com.epam.unideb.blackbox.atm.example.session.ATMSession;
import com.epam.unideb.blackbox.atm.example.session.state.helper.IOHelper;

public class Application {

    public static void main(String[] args) {
        ATMSession atmSession = new ATMSession(new IOHelper());
        atmSession.nextState();
        atmSession.nextState();
        atmSession.nextState();
        atmSession.nextState();
    }

}
