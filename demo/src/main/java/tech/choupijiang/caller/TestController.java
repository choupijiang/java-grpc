package tech.choupijiang.caller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private GrpcTraceClient helloWorldClient;

    @Autowired
    private HelloWorldClient helloWorldClient2;

    @PostMapping("/")
    public String test(){
        return helloWorldClient.sayHello("John", "Doe");
    }


    @PostMapping("/a/")
    public String test2(){
        return helloWorldClient2.sayHello("John", "Doe");
    }
}
