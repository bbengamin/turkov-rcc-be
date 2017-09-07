package ru.studioluck.turkovrccbe.server.processor.impl;

import ru.studioluck.turkovrccbe.server.processor.SocketProcessor;

import java.net.Socket;

public class BasicSocketProcessor implements SocketProcessor {

    private Socket socket;



    public BasicSocketProcessor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void process() {

    }

    @Override
    public void run() {
        process();
    }
}
