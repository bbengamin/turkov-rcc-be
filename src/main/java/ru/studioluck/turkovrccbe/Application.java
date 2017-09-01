package ru.studioluck.turkovrccbe;

import com.google.inject.Guice;
import com.google.inject.Injector;
import ru.studioluck.turkovrccbe.server.Server;
import ru.studioluck.turkovrccbe.server.ServerModule;

public class Application {

    public static void main(String[] args) {
        Injector serverModuleInjector = Guice.createInjector(new ServerModule());
        Server server = serverModuleInjector.getInstance(Server.class);
        server.start();
    }
}
