package ru.studioluck.turkovrccbe.server.impl;

import com.google.inject.Inject;
import org.apache.log4j.Logger;
import ru.studioluck.turkovrccbe.server.Server;
import ru.studioluck.turkovrccbe.server.listener.SocketListener;

public class TCPServerImpl implements Server {
    private static final Logger LOG = Logger.getLogger(TCPServerImpl.class);

    private final SocketListener socketListener;

    @Inject
    public TCPServerImpl(SocketListener socketListener) {
        this.socketListener = socketListener;
    }

    @Override
    public void start() {
        new Thread(socketListener).start();
    }
}
