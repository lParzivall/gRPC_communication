package ru.parshin;

import io.grpc.stub.StreamObserver;
import ru.parshin.grpc.GreetingServiceGrpc;
import ru.parshin.grpc.GreetingServiceOuterClass;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(GreetingServiceOuterClass.HelloRequest request,
                         StreamObserver<GreetingServiceOuterClass.HelloResponse> responseObserver) {
        System.out.println("request = " + request);

        GreetingServiceOuterClass.HelloResponse response = GreetingServiceOuterClass.HelloResponse
                .newBuilder().
                setGreeting("Hello from server, " + request.getName())
                .build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();
    }
}
