package dk.sdu.mmmi.cbse.main;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main extends Application {

    public static void main(String[] args) {
        launch(Main.class);
    }
    @Override
    public void start(Stage stage) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ModuleConfig.class);

        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
      App app = context.getBean(App.class);
      app.start(stage);
      app.render();
    }
}
