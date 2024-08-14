package vandyke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vandyke.DataObjects.Star;
import vandyke.Generation.PrimaryGeneration;
import vandyke.Generation.SystemGenerator;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        //SpringApplication.run(Main.class, args);
        System.out.println("Generating System!");
        SystemGenerator.GenerateSystem();
    }
}