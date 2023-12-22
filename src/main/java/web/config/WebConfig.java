package web.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import web.dao.CarDao;
import web.dao.CarDaoImpl;
import web.model.Car;

@Configuration
@EnableWebMvc
@ComponentScan("web")
public class WebConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

    public WebConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/pages/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }


    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
    }
    
    @Bean
    public List<Car> carsStorage(){
    	List<Car> cars = new ArrayList<>();
    	cars.add(new Car(13324, "Audi", LocalDate.of(1998, 7, 11)));
    	cars.add(new Car(12298, "Mercedez", LocalDate.of(2000, 3, 4)));
    	cars.add(new Car(77611, "BMW", LocalDate.of(1998, 12, 21)));
    	cars.add(new Car(12298, "Volvo", LocalDate.of(2005, 1, 10)));
    	cars.add(new Car(12298, "Honda", LocalDate.of(2007, 11, 28)));
    	return cars;
    }
    
    @Bean
    public CarDao carDao(){
    	return new CarDaoImpl(carsStorage());
    }
}