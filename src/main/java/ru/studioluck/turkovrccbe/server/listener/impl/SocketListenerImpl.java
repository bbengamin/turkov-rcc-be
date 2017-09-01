package ru.studioluck.turkovrccbe.server.listener.impl;

import com.google.inject.Inject;
import org.apache.log4j.Logger;
import ru.studioluck.turkovrccbe.bean.config.ApplicationConfig;
import ru.studioluck.turkovrccbe.exception.ApplicationException;
import ru.studioluck.turkovrccbe.server.listener.SocketListener;
import ru.studioluck.turkovrccbe.server.processor.SocketProcessor;
import ru.studioluck.turkovrccbe.server.processor.factory.SocketProcessorFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketListenerImpl implements SocketListener {
    private static final Logger LOG = Logger.getLogger(SocketListenerImpl.class);

    private static final String START_SERVER_ERROR = "Cant start server listener at port - ";
    private static final String LISTENER_STARTED = "Listener started at port - ";
    private static final String ACCEPT_CONNECTION = "Cant accept new connection";
    private static final String NEW_CLIENT = "Client accepted - ";

    private final ApplicationConfig applicationConfig;
    private SocketProcessorFactory socketProcessorFactory;

    @Inject
    public SocketListenerImpl(ApplicationConfig applicationConfig, SocketProcessorFactory socketProcessorFactory) {
        this.applicationConfig = applicationConfig;
        this.socketProcessorFactory = socketProcessorFactory;
    }

    @Override
    public void run() {
        int port = applicationConfig.getPort();
        startLister(port);
    }

    @Override
    public void startLister(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            LOG.info(LISTENER_STARTED + port);
            while (true) {
                accept(serverSocket);
            }
        } catch (IOException e) {
            LOG.error(START_SERVER_ERROR + port, e);
            throw new ApplicationException(START_SERVER_ERROR + port, e);
        }
    }

    @Override
    public void accept(ServerSocket serverSocket) {
        try {
            Socket socket = serverSocket.accept();
            LOG.info(NEW_CLIENT + socket.getInetAddress());
            SocketProcessor socketProcessor = socketProcessorFactory.getSocketProcessor(socket);
            new Thread(socketProcessor).start();
        } catch (IOException e) {
            LOG.error(ACCEPT_CONNECTION, e);
        }
    }

}
