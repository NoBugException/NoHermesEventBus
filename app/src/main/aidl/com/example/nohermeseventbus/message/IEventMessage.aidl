package com.example.nohermeseventbus.message;

import com.example.nohermeseventbus.message.EventMessage;

parcelable EventMessage;

interface IEventMessage {

    EventMessage getEventMessage();

}
