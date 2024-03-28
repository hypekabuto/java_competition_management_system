package cms.java_competition_management_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cms/java_competition_management_system/mapper")
public class JavaCompetitionManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaCompetitionManagementSystemApplication.class, args);
    }

}
