package com.epam.unideb.blackbox.atm.example.session.state;

import com.epam.unideb.blackbox.atm.example.session.ATMSession;
import com.epam.unideb.blackbox.atm.example.session.state.helper.IOHelper;

public class InitialState extends AtmState {
    private IOHelper ioHelper;

    public InitialState(IOHelper ioHelper) {
        this.ioHelper = ioHelper;
        printStatus();
    }

    public void nextState(ATMSession atmSession) {
        System.out.println("Inserting card.");
        atmSession.setState(new PasswordTryState(1, this.ioHelper));
    }

    public void printStatus() {
        System.out.println("Initial state of the ATM");
    }
}
