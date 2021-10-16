package tech.choupijiang.caller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private HelloWorldClient helloWorldClient;


    @PostMapping("/")
    public String test(){
        return helloWorldClient.sayHello("John", "Doe");
    }
}
