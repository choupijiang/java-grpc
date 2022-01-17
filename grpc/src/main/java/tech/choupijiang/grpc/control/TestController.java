package tech.choupijiang.grpc.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.choupijiang.grpc.server.EchoClient;


@RestController
public class TestController {

    @Autowired
    private EchoClient client;

    @GetMapping
    public String test(String message){
        String echo = client.echo(message);
        System.out.println(echo);
        return  echo;
    }
}
