package nl.devistrap.velocityBroodkast;

import com.google.inject.Inject;
import com.velocitypowered.api.command.BrigadierCommand;
import com.velocitypowered.api.command.CommandManager;
import com.velocitypowered.api.command.CommandMeta;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import nl.devistrap.velocityBroodkast.commands.broodkast;
import nl.devistrap.velocityBroodkast.commands.globalStaffChat;
import org.slf4j.Logger;

@Plugin(id = "velocitybroodkast", name = "velocityBroodkast", version = "1.0")
public final class VelocityBroodkast {
    private final ProxyServer proxy;

    @Inject
    private Logger logger;

    @Inject
    public VelocityBroodkast(ProxyServer proxy) {
        this.proxy = proxy;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        CommandManager commandManager = proxy.getCommandManager();

        CommandMeta broodkastcommandMeta = commandManager.metaBuilder("broodkast").build();
        commandManager.register(broodkastcommandMeta, new broodkast(proxy));

        CommandMeta StaffChatMeta = commandManager.metaBuilder("gs")
                .aliases("globalstaffchat")
                .build();
        commandManager.register(StaffChatMeta, new globalStaffChat(proxy));


        System.out.println("[Broodkast] Velocity Broodkast plugin has been initialized!");
    }

    @Subscribe
    public void onProxyShutdown(ProxyInitializeEvent event) {
        System.out.println("[Broodkast] Velocity Broodkast plugin has been shut down!");
    }

}
