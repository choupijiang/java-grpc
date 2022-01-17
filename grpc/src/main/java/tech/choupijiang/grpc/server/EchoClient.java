package tech.choupijiang.grpc.server;


import brave.grpc.GrpcTracing;
import com.codenotfound.grpc.echo.EchoServiceGrpc;
import com.codenotfound.grpc.echo.Greeting;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.util.RoundRobinLoadBalancerFactory;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Log4j2
public class EchoClient {

    @Autowired
    GrpcTracing grpcTracing;

    private EchoServiceGrpc.EchoServiceBlockingStub echoServiceBlockStub;

    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress("localhost", 9091)
                .intercept(grpcTracing.newClientInterceptor())
                .loadBalancerFactory(RoundRobinLoadBalancerFactory.getInstance())
                .usePlaintext().build();

        echoServiceBlockStub =
                EchoServiceGrpc.newBlockingStub(managedChannel);
    }

    public String echo(String hi) {

        log.info("client sending {}", hi);

        Greeting greeting =
                echoServiceBlockStub.echo(Greeting.newBuilder().setMessage(hi).build());
        log.info("client received {}", greeting);

        return greeting.getMessage();
    }


}
