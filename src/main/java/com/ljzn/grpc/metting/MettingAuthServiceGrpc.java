package com.ljzn.grpc.metting;

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
    comments = "Source: metting/metting.service.proto")
public final class MettingAuthServiceGrpc {

  private MettingAuthServiceGrpc() {}

  public static final String SERVICE_NAME = "MettingSystem.MettingAuthService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetMettingEmpInfoMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.ljzn.grpc.metting.MettingEmpInfoRequest,
      com.ljzn.grpc.metting.MettingEmpInfoResponse> METHOD_GET_METTING_EMP_INFO = getGetMettingEmpInfoMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.ljzn.grpc.metting.MettingEmpInfoRequest,
      com.ljzn.grpc.metting.MettingEmpInfoResponse> getGetMettingEmpInfoMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.ljzn.grpc.metting.MettingEmpInfoRequest,
      com.ljzn.grpc.metting.MettingEmpInfoResponse> getGetMettingEmpInfoMethod() {
    return getGetMettingEmpInfoMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.ljzn.grpc.metting.MettingEmpInfoRequest,
      com.ljzn.grpc.metting.MettingEmpInfoResponse> getGetMettingEmpInfoMethodHelper() {
    io.grpc.MethodDescriptor<com.ljzn.grpc.metting.MettingEmpInfoRequest, com.ljzn.grpc.metting.MettingEmpInfoResponse> getGetMettingEmpInfoMethod;
    if ((getGetMettingEmpInfoMethod = MettingAuthServiceGrpc.getGetMettingEmpInfoMethod) == null) {
      synchronized (MettingAuthServiceGrpc.class) {
        if ((getGetMettingEmpInfoMethod = MettingAuthServiceGrpc.getGetMettingEmpInfoMethod) == null) {
          MettingAuthServiceGrpc.getGetMettingEmpInfoMethod = getGetMettingEmpInfoMethod = 
              io.grpc.MethodDescriptor.<com.ljzn.grpc.metting.MettingEmpInfoRequest, com.ljzn.grpc.metting.MettingEmpInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MettingSystem.MettingAuthService", "GetMettingEmpInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.metting.MettingEmpInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.metting.MettingEmpInfoResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MettingAuthServiceMethodDescriptorSupplier("GetMettingEmpInfo"))
                  .build();
          }
        }
     }
     return getGetMettingEmpInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MettingAuthServiceStub newStub(io.grpc.Channel channel) {
    return new MettingAuthServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MettingAuthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MettingAuthServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MettingAuthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MettingAuthServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class MettingAuthServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getMettingEmpInfo(com.ljzn.grpc.metting.MettingEmpInfoRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.metting.MettingEmpInfoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMettingEmpInfoMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMettingEmpInfoMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ljzn.grpc.metting.MettingEmpInfoRequest,
                com.ljzn.grpc.metting.MettingEmpInfoResponse>(
                  this, METHODID_GET_METTING_EMP_INFO)))
          .build();
    }
  }

  /**
   */
  public static final class MettingAuthServiceStub extends io.grpc.stub.AbstractStub<MettingAuthServiceStub> {
    private MettingAuthServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MettingAuthServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MettingAuthServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MettingAuthServiceStub(channel, callOptions);
    }

    /**
     */
    public void getMettingEmpInfo(com.ljzn.grpc.metting.MettingEmpInfoRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.metting.MettingEmpInfoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMettingEmpInfoMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MettingAuthServiceBlockingStub extends io.grpc.stub.AbstractStub<MettingAuthServiceBlockingStub> {
    private MettingAuthServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MettingAuthServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MettingAuthServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MettingAuthServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ljzn.grpc.metting.MettingEmpInfoResponse getMettingEmpInfo(com.ljzn.grpc.metting.MettingEmpInfoRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetMettingEmpInfoMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MettingAuthServiceFutureStub extends io.grpc.stub.AbstractStub<MettingAuthServiceFutureStub> {
    private MettingAuthServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MettingAuthServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MettingAuthServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MettingAuthServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ljzn.grpc.metting.MettingEmpInfoResponse> getMettingEmpInfo(
        com.ljzn.grpc.metting.MettingEmpInfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMettingEmpInfoMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_METTING_EMP_INFO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MettingAuthServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MettingAuthServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_METTING_EMP_INFO:
          serviceImpl.getMettingEmpInfo((com.ljzn.grpc.metting.MettingEmpInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.ljzn.grpc.metting.MettingEmpInfoResponse>) responseObserver);
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

  private static abstract class MettingAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MettingAuthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ljzn.grpc.metting.MettingService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MettingAuthService");
    }
  }

  private static final class MettingAuthServiceFileDescriptorSupplier
      extends MettingAuthServiceBaseDescriptorSupplier {
    MettingAuthServiceFileDescriptorSupplier() {}
  }

  private static final class MettingAuthServiceMethodDescriptorSupplier
      extends MettingAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MettingAuthServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MettingAuthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MettingAuthServiceFileDescriptorSupplier())
              .addMethod(getGetMettingEmpInfoMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
