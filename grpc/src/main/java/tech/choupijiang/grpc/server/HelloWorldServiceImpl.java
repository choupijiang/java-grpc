package tech.choupijiang.grpc.server;

import com.codenotfound.grpc.helloworld.Greeting;
import com.codenotfound.grpc.helloworld.HelloWorldServiceGrpc;
import com.codenotfound.grpc.helloworld.Person;
import io.grpc.stub.StreamObserver;
import lombok.extern.log4j.Log4j2;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import tech.choupijiang.grpc.control.TestController;


@GRpcService
@Log4j2
public class HelloWorldServiceImpl extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {


    @Autowired
    TestController controller;


    @Override
    public void sayHello(Person request,
                         StreamObserver<Greeting> responseObserver) {
        log.info("server received {}", request);

        System.out.println(controller.test());

        String message = "Hello " + request.getFirstName() + " "
                + request.getLastName() + "!";
        Greeting greeting =
                Greeting.newBuilder().setMessage(message).build();
        log.info("server responded {}", greeting);

        responseObserver.onNext(greeting);
        responseObserver.onCompleted();
    }
}
