package nl.devistrap.velocityBroodkast.commands;

import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class broodkast implements SimpleCommand {
    private final ProxyServer proxy;

    public broodkast(ProxyServer proxy) {
        this.proxy = proxy;
    }

    @Override
    public void execute(Invocation invocation) {
        String[] args = invocation.arguments();
        Component message = Component.text("[BK] " + String.join(" ", args), NamedTextColor.GOLD);
        for (Player player : proxy.getAllPlayers()) {
            player.sendMessage(message);
        }
    }
}