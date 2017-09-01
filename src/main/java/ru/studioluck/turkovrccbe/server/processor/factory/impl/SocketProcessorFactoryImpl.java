package ru.studioluck.turkovrccbe.server.processor.factory.impl;

import ru.studioluck.turkovrccbe.server.processor.SocketProcessor;
import ru.studioluck.turkovrccbe.server.processor.factory.SocketProcessorFactory;
import ru.studioluck.turkovrccbe.server.processor.impl.BasicSocketProcessor;

import java.net.Socket;

public class SocketProcessorFactoryImpl implements SocketProcessorFactory {
    @Override
    public SocketProcessor getSocketProcessor(Socket socket) {
        return new BasicSocketProcessor(socket);
    }
}
