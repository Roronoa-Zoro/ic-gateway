package com.illegalaccess.gateway.stateMachine;

public enum SecurityState {

    InvalidState{
        @Override
        void auth() {

        }
    };


    abstract void auth();
}

