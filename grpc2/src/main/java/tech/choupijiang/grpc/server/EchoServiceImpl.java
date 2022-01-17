package tech.choupijiang.grpc.server;


import com.codenotfound.grpc.echo.EchoServiceGrpc;
import com.codenotfound.grpc.echo.Greeting;
import io.grpc.stub.StreamObserver;
import lombok.extern.log4j.Log4j2;
import org.lognet.springboot.grpc.GRpcService;


@GRpcService
@Log4j2
public class EchoServiceImpl extends EchoServiceGrpc.EchoServiceImplBase {


    @Override
    public void echo(Greeting request, StreamObserver<Greeting> responseOberver) {
        log.info("server echo received {}", request);

        responseOberver.onNext(request);
        responseOberver.onCompleted();
    }


}
