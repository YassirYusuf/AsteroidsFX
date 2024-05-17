package dk.sdu.mmmi.cbse.main;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.GameKeys;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

import java.lang.module.Configuration;
import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static java.util.stream.Collectors.toList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(Main.class);
    }
    @Override
    public void start(Stage stage) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ModuleConfig.class);
        for (String beanName : ctx.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
        Game game = ctx.getBean(Game.class);
        game.start(stage);
        game.render();
        }
    }


//        Path pluginDirPath = Paths.get("plugins");
////        Path pluginDirPath = (Path) Paths.get("plugins"); // Path to the directory containing plugin JARs
//
//        // Discover modules in the plugins directory
//        ModuleFinder pluginFinder = ModuleFinder.of(pluginDirPath);
//
//        // Retrieve all module names from the found plugin modules
//        List<String> pluginModuleNames = pluginFinder.findAll()
//                .stream()
//                .map(ModuleReference::descriptor)
//                .map(ModuleDescriptor::name)
//                .collect(Collectors.toList());
//
//        // Create a configuration to resolve plugin modules
//        Configuration pluginConfig = ModuleLayer.boot()
//                .configuration()
//                .resolve(pluginFinder, ModuleFinder.of(), pluginModuleNames);
//
//        // Define a new module layer for the plugins
//        ModuleLayer pluginLayer = ModuleLayer.boot()
//                .defineModulesWithOneLoader(pluginConfig, ClassLoader.getSystemClassLoader());
//
//        // Use ServiceLoader to load services from the plugin layer
//        ServiceLoader<IGamePluginService> serviceLoader = ServiceLoader.load(pluginLayer, IGamePluginService.class);
//        // Plugin loading logic if needed
//
//        launch(args);
//    }

