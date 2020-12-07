import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uni.eszterhazy.keretrendszer.service.TermekService;

public class MyApp {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
        TermekService service = (TermekService) context.getBean("termekService");
        System.out.println(service.getAllTermek());
    }
}
