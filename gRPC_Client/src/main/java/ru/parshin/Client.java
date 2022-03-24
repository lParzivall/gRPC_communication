package ru.parshin;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import ru.parshin.grpc.GreetingServiceGrpc;
import ru.parshin.grpc.GreetingServiceOuterClass;

public class Client {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext().build();

        GreetingServiceGrpc.GreetingServiceBlockingStub stub =
                GreetingServiceGrpc.newBlockingStub(channel);

        GreetingServiceOuterClass.HelloRequest request = GreetingServiceOuterClass.HelloRequest
                .newBuilder().setName("Nikita").build();

        GreetingServiceOuterClass.HelloResponse response = stub.greeting(request);

        System.out.println("response = " + response);

        channel.shutdownNow();
    }
}
