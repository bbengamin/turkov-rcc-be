package ru.studioluck.turkovrccbe.server.listener;

import java.net.ServerSocket;

public interface SocketListener extends Runnable{
    void startLister(int port);
    void accept(ServerSocket serverSocket);
}
