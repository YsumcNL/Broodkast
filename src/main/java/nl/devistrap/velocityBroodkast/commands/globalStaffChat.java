package nl.devistrap.velocityBroodkast.commands;

import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class globalStaffChat implements SimpleCommand {
    private final ProxyServer proxy;


    public globalStaffChat(ProxyServer proxy) {
        this.proxy = proxy;
    }


    @Override
    public void execute(Invocation invocation) {
        String[] args = invocation.arguments();
        Player Sender = (Player) invocation.source();
        Component message = Component.text("[GS] " + Sender.getUsername() + ": " + String.join(" ", args), NamedTextColor.AQUA);
        for (Player player : proxy.getAllPlayers()) {
            if(player.hasPermission("broodkast.staffchat")) {
                player.sendMessage(message);
            }
        }
    }
}
