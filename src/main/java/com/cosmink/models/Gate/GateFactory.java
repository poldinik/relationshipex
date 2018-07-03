package com.cosmink.models.Gate;

import com.cosmink.models.User.User;

import java.util.Date;
import java.util.UUID;

public class GateFactory {

    public static Gate createGate(){
        Gate gate = new Gate();
        gate.setUuid(UUID.randomUUID().toString());

        Date date = new Date();

        gate.setCreated(date);
        gate.setUpdate(date);

        return gate;
    }
}
