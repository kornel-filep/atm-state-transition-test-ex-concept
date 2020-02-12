package com.epam.unideb.blackbox.atm.example.session;

import com.epam.unideb.blackbox.atm.example.session.state.AuthenticatedState;
import com.epam.unideb.blackbox.atm.example.session.state.InitialState;
import com.epam.unideb.blackbox.atm.example.session.state.SwallowState;
import com.epam.unideb.blackbox.atm.example.session.state.helper.IOHelper;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsInstanceOf;
import org.mockito.Mockito;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ATMSessionTest {
    private ATMSession underTest;
    private IOHelper ioHelper;

    @BeforeClass
    public void beforeClass() {
        ioHelper = Mockito.mock(IOHelper.class);
    }

    @BeforeMethod
    private void beforeMethod(){
        underTest = new ATMSession(ioHelper);
    }

    @Test
    void asd1(){
        // Given
        Mockito.when(ioHelper.promptPassword()).thenReturn("1234");
        // When
        underTest.nextState();
        underTest.nextState();
        //Then
        MatcherAssert.assertThat(underTest.getState(), IsInstanceOf.instanceOf(AuthenticatedState.class));
    }

    @Test
    void asd2(){
        // Given
        Mockito.when(ioHelper.promptPassword()).thenReturn("Wrong1");
        Mockito.when(ioHelper.promptPassword()).thenReturn("1234");
        // When
        underTest.nextState();
        underTest.nextState();
        underTest.nextState();
        //Then
        MatcherAssert.assertThat(underTest.getState(), IsInstanceOf.instanceOf(AuthenticatedState.class));
    }

    @Test
    void asd3(){
        // Given
        Mockito.when(ioHelper.promptPassword()).thenReturn("Wrong1");
        Mockito.when(ioHelper.promptPassword()).thenReturn("Wrong2");
        Mockito.when(ioHelper.promptPassword()).thenReturn("1234");
        // When
        underTest.nextState();
        underTest.nextState();
        underTest.nextState();
        underTest.nextState();
        //Then
        MatcherAssert.assertThat(underTest.getState(), IsInstanceOf.instanceOf(AuthenticatedState.class));
    }

    @Test
    void asd4(){
        // Given
        Mockito.when(ioHelper.promptPassword()).thenReturn("Wrong1");
        Mockito.when(ioHelper.promptPassword()).thenReturn("Wrong2");
        Mockito.when(ioHelper.promptPassword()).thenReturn("Wrong3");
        // When
        underTest.nextState();
        underTest.nextState();
        underTest.nextState();
        underTest.nextState();
        underTest.nextState();
        //Then
        MatcherAssert.assertThat(underTest.getState(), IsInstanceOf.instanceOf(SwallowState.class));
    }

    @Test
    void asd5(){
        // Given
        Mockito.when(ioHelper.promptPassword()).thenReturn("Wrong1");
        Mockito.when(ioHelper.promptPassword()).thenReturn("Wrong2");
        Mockito.when(ioHelper.promptPassword()).thenReturn("Wrong3");
        // When
        underTest.nextState();
        underTest.nextState();
        underTest.nextState();
        underTest.nextState();
        underTest.nextState();
        underTest.nextState();
        //Then
        MatcherAssert.assertThat(underTest.getState(), IsInstanceOf.instanceOf(InitialState.class));
    }


}