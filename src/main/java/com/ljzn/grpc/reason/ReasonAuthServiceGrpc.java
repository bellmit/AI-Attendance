package com.ljzn.grpc.reason;

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
    comments = "Source: reason/reason.service.proto")
public final class ReasonAuthServiceGrpc {

  private ReasonAuthServiceGrpc() {}

  public static final String SERVICE_NAME = "VisitorSystem_cq.ReasonAuthService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReasonDataApplyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.ljzn.grpc.reason.ReasonDataApplyRequest,
      com.ljzn.grpc.reason.ReasonDataApplyResponse> METHOD_REASON_DATA_APPLY = getReasonDataApplyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.ljzn.grpc.reason.ReasonDataApplyRequest,
      com.ljzn.grpc.reason.ReasonDataApplyResponse> getReasonDataApplyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.ljzn.grpc.reason.ReasonDataApplyRequest,
      com.ljzn.grpc.reason.ReasonDataApplyResponse> getReasonDataApplyMethod() {
    return getReasonDataApplyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.ljzn.grpc.reason.ReasonDataApplyRequest,
      com.ljzn.grpc.reason.ReasonDataApplyResponse> getReasonDataApplyMethodHelper() {
    io.grpc.MethodDescriptor<com.ljzn.grpc.reason.ReasonDataApplyRequest, com.ljzn.grpc.reason.ReasonDataApplyResponse> getReasonDataApplyMethod;
    if ((getReasonDataApplyMethod = ReasonAuthServiceGrpc.getReasonDataApplyMethod) == null) {
      synchronized (ReasonAuthServiceGrpc.class) {
        if ((getReasonDataApplyMethod = ReasonAuthServiceGrpc.getReasonDataApplyMethod) == null) {
          ReasonAuthServiceGrpc.getReasonDataApplyMethod = getReasonDataApplyMethod = 
              io.grpc.MethodDescriptor.<com.ljzn.grpc.reason.ReasonDataApplyRequest, com.ljzn.grpc.reason.ReasonDataApplyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "VisitorSystem_cq.ReasonAuthService", "ReasonDataApply"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.reason.ReasonDataApplyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.reason.ReasonDataApplyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReasonAuthServiceMethodDescriptorSupplier("ReasonDataApply"))
                  .build();
          }
        }
     }
     return getReasonDataApplyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReasonAuthServiceStub newStub(io.grpc.Channel channel) {
    return new ReasonAuthServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReasonAuthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ReasonAuthServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReasonAuthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ReasonAuthServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ReasonAuthServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void reasonDataApply(com.ljzn.grpc.reason.ReasonDataApplyRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.reason.ReasonDataApplyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getReasonDataApplyMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getReasonDataApplyMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ljzn.grpc.reason.ReasonDataApplyRequest,
                com.ljzn.grpc.reason.ReasonDataApplyResponse>(
                  this, METHODID_REASON_DATA_APPLY)))
          .build();
    }
  }

  /**
   */
  public static final class ReasonAuthServiceStub extends io.grpc.stub.AbstractStub<ReasonAuthServiceStub> {
    private ReasonAuthServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReasonAuthServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReasonAuthServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReasonAuthServiceStub(channel, callOptions);
    }

    /**
     */
    public void reasonDataApply(com.ljzn.grpc.reason.ReasonDataApplyRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.reason.ReasonDataApplyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReasonDataApplyMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ReasonAuthServiceBlockingStub extends io.grpc.stub.AbstractStub<ReasonAuthServiceBlockingStub> {
    private ReasonAuthServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReasonAuthServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReasonAuthServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReasonAuthServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ljzn.grpc.reason.ReasonDataApplyResponse reasonDataApply(com.ljzn.grpc.reason.ReasonDataApplyRequest request) {
      return blockingUnaryCall(
          getChannel(), getReasonDataApplyMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ReasonAuthServiceFutureStub extends io.grpc.stub.AbstractStub<ReasonAuthServiceFutureStub> {
    private ReasonAuthServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReasonAuthServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReasonAuthServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReasonAuthServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ljzn.grpc.reason.ReasonDataApplyResponse> reasonDataApply(
        com.ljzn.grpc.reason.ReasonDataApplyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReasonDataApplyMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REASON_DATA_APPLY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ReasonAuthServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ReasonAuthServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REASON_DATA_APPLY:
          serviceImpl.reasonDataApply((com.ljzn.grpc.reason.ReasonDataApplyRequest) request,
              (io.grpc.stub.StreamObserver<com.ljzn.grpc.reason.ReasonDataApplyResponse>) responseObserver);
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

  private static abstract class ReasonAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReasonAuthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ljzn.grpc.reason.ReasonService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReasonAuthService");
    }
  }

  private static final class ReasonAuthServiceFileDescriptorSupplier
      extends ReasonAuthServiceBaseDescriptorSupplier {
    ReasonAuthServiceFileDescriptorSupplier() {}
  }

  private static final class ReasonAuthServiceMethodDescriptorSupplier
      extends ReasonAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ReasonAuthServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ReasonAuthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReasonAuthServiceFileDescriptorSupplier())
              .addMethod(getReasonDataApplyMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
