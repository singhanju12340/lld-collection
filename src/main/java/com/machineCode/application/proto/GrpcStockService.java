package com.machineCode.application.proto;

//public class GrpcStockService extends StockServiceGrpc.StockServiceImplBase {
//    @Override
//    public void getStockPrice(StockRequest request, StreamObserver<StockResponse> responseObserver) {
//        // Simulate stock price lookup
//        double price = Math.random() * 1000;
//        StockResponse response = StockResponse.newBuilder()
//                .setSymbol(request.getSymbol())
//                .setPrice(price)
//                .setTimestamp(System.currentTimeMillis())
//                .build();
//
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//}