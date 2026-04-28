
import java.util.ArrayList;
import java.util.List;

interface Command {
    void execute();
}

class Plugin {
    private final String name;

    Plugin(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void install() {
        System.out.println("Installing plugin: " + name);
    }
}

// Receiver that actually stores and installs plugins
class PluginManager {
    private final List<Plugin> plugins = new ArrayList<>();

    void addPlugin(Plugin p) {
        plugins.add(p);
        p.install();
        System.out.println("Plugin manager: added '" + p.getName() + "'");
    }

    void listPlugins() {
        System.out.println("Currently installed plugins:");
        if (plugins.isEmpty()) {
            System.out.println("  (none)");
            return;
        }
        for (Plugin p : plugins)
            System.out.println("  - " + p.getName());
    }
}

// Simple Command Pattern demo to add multiple "plugins" to Notepad++
public class AddPluginCommandPattern implements Command {
    private final PluginManager manager;
    private final Plugin plugin;

    AddPluginCommandPattern(PluginManager manager, Plugin plugin) {
        this.manager = manager;
        this.plugin = plugin;
    }

    @Override
    public void execute() {
        manager.addPlugin(plugin);
    }

    public static void main(String[] args) {
        PluginManager manager = new PluginManager();

        String[] pluginNames = { "JsonCompare", "ParserXML", "SupportFTP", "SqlPlugin" };
        List<Command> commands = new ArrayList<>();

        for (String name : pluginNames) {
            Plugin plugin = new Plugin(name);
            commands.add(new AddPluginCommandPattern(manager, plugin));
        }

        // Execute all add-plugin commands
        for (Command cmd : commands) {
            cmd.execute();
        }
        manager.listPlugins();
    }

}
