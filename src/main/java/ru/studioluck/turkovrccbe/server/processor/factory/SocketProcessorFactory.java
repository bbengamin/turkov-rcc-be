package ru.studioluck.turkovrccbe.server.processor.factory;

import ru.studioluck.turkovrccbe.server.processor.SocketProcessor;

import java.net.Socket;

public interface SocketProcessorFactory {
    public SocketProcessor getSocketProcessor(Socket socket);
}
