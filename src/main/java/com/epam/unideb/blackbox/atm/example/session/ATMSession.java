package com.epam.unideb.blackbox.atm.example.session;

import com.epam.unideb.blackbox.atm.example.session.state.AtmState;
import com.epam.unideb.blackbox.atm.example.session.state.InitialState;
import com.epam.unideb.blackbox.atm.example.session.state.helper.IOHelper;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ATMSession {
    private AtmState state;

    public ATMSession(IOHelper ioHelper) {
        this.state = new InitialState(ioHelper);
    }

    public void nextState() {
        state.nextState(this);
    }
}
