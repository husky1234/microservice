package com.husky.microservicegatewayzuul.rpc;

public class EchoServiceImp implements EchoService {
    @Override
    public String echo(String ping) {
        return ping != null ? ping + "--> I am ok.":"I am bad";
    }
}
