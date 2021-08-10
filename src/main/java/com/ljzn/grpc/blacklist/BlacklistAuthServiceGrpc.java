package com.ljzn.grpc.blacklist;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.11.0)",
    comments = "Source: blacklist/blacklist.service.proto")
public final class BlacklistAuthServiceGrpc {

  private BlacklistAuthServiceGrpc() {}

  public static final String SERVICE_NAME = "VisitorSystem_cq.BlacklistAuthService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBlacklistDataApplyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.ljzn.grpc.blacklist.BlacklistDataApplyRequest,
      com.ljzn.grpc.blacklist.BlacklistDataApplyResponse> METHOD_BLACKLIST_DATA_APPLY = getBlacklistDataApplyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.ljzn.grpc.blacklist.BlacklistDataApplyRequest,
      com.ljzn.grpc.blacklist.BlacklistDataApplyResponse> getBlacklistDataApplyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.ljzn.grpc.blacklist.BlacklistDataApplyRequest,
      com.ljzn.grpc.blacklist.BlacklistDataApplyResponse> getBlacklistDataApplyMethod() {
    return getBlacklistDataApplyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.ljzn.grpc.blacklist.BlacklistDataApplyRequest,
      com.ljzn.grpc.blacklist.BlacklistDataApplyResponse> getBlacklistDataApplyMethodHelper() {
    io.grpc.MethodDescriptor<com.ljzn.grpc.blacklist.BlacklistDataApplyRequest, com.ljzn.grpc.blacklist.BlacklistDataApplyResponse> getBlacklistDataApplyMethod;
    if ((getBlacklistDataApplyMethod = BlacklistAuthServiceGrpc.getBlacklistDataApplyMethod) == null) {
      synchronized (BlacklistAuthServiceGrpc.class) {
        if ((getBlacklistDataApplyMethod = BlacklistAuthServiceGrpc.getBlacklistDataApplyMethod) == null) {
          BlacklistAuthServiceGrpc.getBlacklistDataApplyMethod = getBlacklistDataApplyMethod = 
              io.grpc.MethodDescriptor.<com.ljzn.grpc.blacklist.BlacklistDataApplyRequest, com.ljzn.grpc.blacklist.BlacklistDataApplyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "VisitorSystem_cq.BlacklistAuthService", "BlacklistDataApply"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.blacklist.BlacklistDataApplyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.blacklist.BlacklistDataApplyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BlacklistAuthServiceMethodDescriptorSupplier("BlacklistDataApply"))
                  .build();
          }
        }
     }
     return getBlacklistDataApplyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BlacklistAuthServiceStub newStub(io.grpc.Channel channel) {
    return new BlacklistAuthServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BlacklistAuthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BlacklistAuthServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BlacklistAuthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BlacklistAuthServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class BlacklistAuthServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void blacklistDataApply(com.ljzn.grpc.blacklist.BlacklistDataApplyRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.blacklist.BlacklistDataApplyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getBlacklistDataApplyMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBlacklistDataApplyMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ljzn.grpc.blacklist.BlacklistDataApplyRequest,
                com.ljzn.grpc.blacklist.BlacklistDataApplyResponse>(
                  this, METHODID_BLACKLIST_DATA_APPLY)))
          .build();
    }
  }

  /**
   */
  public static final class BlacklistAuthServiceStub extends io.grpc.stub.AbstractStub<BlacklistAuthServiceStub> {
    private BlacklistAuthServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BlacklistAuthServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlacklistAuthServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BlacklistAuthServiceStub(channel, callOptions);
    }

    /**
     */
    public void blacklistDataApply(com.ljzn.grpc.blacklist.BlacklistDataApplyRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.blacklist.BlacklistDataApplyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBlacklistDataApplyMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BlacklistAuthServiceBlockingStub extends io.grpc.stub.AbstractStub<BlacklistAuthServiceBlockingStub> {
    private BlacklistAuthServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BlacklistAuthServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlacklistAuthServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BlacklistAuthServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ljzn.grpc.blacklist.BlacklistDataApplyResponse blacklistDataApply(com.ljzn.grpc.blacklist.BlacklistDataApplyRequest request) {
      return blockingUnaryCall(
          getChannel(), getBlacklistDataApplyMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BlacklistAuthServiceFutureStub extends io.grpc.stub.AbstractStub<BlacklistAuthServiceFutureStub> {
    private BlacklistAuthServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BlacklistAuthServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlacklistAuthServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BlacklistAuthServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ljzn.grpc.blacklist.BlacklistDataApplyResponse> blacklistDataApply(
        com.ljzn.grpc.blacklist.BlacklistDataApplyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBlacklistDataApplyMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BLACKLIST_DATA_APPLY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BlacklistAuthServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BlacklistAuthServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BLACKLIST_DATA_APPLY:
          serviceImpl.blacklistDataApply((com.ljzn.grpc.blacklist.BlacklistDataApplyRequest) request,
              (io.grpc.stub.StreamObserver<com.ljzn.grpc.blacklist.BlacklistDataApplyResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BlacklistAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BlacklistAuthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ljzn.grpc.blacklist.BlacklistService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BlacklistAuthService");
    }
  }

  private static final class BlacklistAuthServiceFileDescriptorSupplier
      extends BlacklistAuthServiceBaseDescriptorSupplier {
    BlacklistAuthServiceFileDescriptorSupplier() {}
  }

  private static final class BlacklistAuthServiceMethodDescriptorSupplier
      extends BlacklistAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BlacklistAuthServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BlacklistAuthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BlacklistAuthServiceFileDescriptorSupplier())
              .addMethod(getBlacklistDataApplyMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
