package com.epam.unideb.blackbox.atm.example.session.state;

import com.epam.unideb.blackbox.atm.example.session.ATMSession;
import com.epam.unideb.blackbox.atm.example.session.state.helper.IOHelper;

import java.util.Scanner;

public class PasswordTryState extends AtmState {
    private int tryCount;
    private IOHelper ioHelper;

    public PasswordTryState(int tryCount, IOHelper ioHelper) {
        this.tryCount = tryCount;
        this.ioHelper = ioHelper;
        this.printStatus();
        // Do some business logic like preliminary checks...
    }

    public void nextState(ATMSession atmSession) {
        if (this.tryCount < 4) {
            if (ioHelper.promptPassword().equals("1234")) {
                System.out.println("Valid password");
                atmSession.setState(new AuthenticatedState());
            } else {
                System.out.println("Invalid password");
                atmSession.setState(new PasswordTryState(this.tryCount + 1, this.ioHelper));
            }
        } else {
            System.out.print("Cant try more");
            atmSession.setState(new SwallowState());
        }

    }

    public void printStatus() {
        System.out.println(String.format("Password try state, trycount = %s", tryCount));
    }
}
