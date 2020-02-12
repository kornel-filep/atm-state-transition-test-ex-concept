package com.epam.unideb.blackbox.atm.example.session.state;

import com.epam.unideb.blackbox.atm.example.session.ATMSession;

public abstract class AtmState {
    public abstract void nextState(ATMSession atmSession);

    public abstract void printStatus();
}
