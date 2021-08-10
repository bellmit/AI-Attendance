package com.ljzn.grpc.version;

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
    comments = "Source: version/version.service.proto")
public final class VersionAuthServiceGrpc {

  private VersionAuthServiceGrpc() {}

  public static final String SERVICE_NAME = "VisitorSystem_cq.VersionAuthService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getVersionUpdateMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.ljzn.grpc.version.VersionRequest,
      com.ljzn.grpc.version.VersionResponce> METHOD_VERSION_UPDATE = getVersionUpdateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.ljzn.grpc.version.VersionRequest,
      com.ljzn.grpc.version.VersionResponce> getVersionUpdateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.ljzn.grpc.version.VersionRequest,
      com.ljzn.grpc.version.VersionResponce> getVersionUpdateMethod() {
    return getVersionUpdateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.ljzn.grpc.version.VersionRequest,
      com.ljzn.grpc.version.VersionResponce> getVersionUpdateMethodHelper() {
    io.grpc.MethodDescriptor<com.ljzn.grpc.version.VersionRequest, com.ljzn.grpc.version.VersionResponce> getVersionUpdateMethod;
    if ((getVersionUpdateMethod = VersionAuthServiceGrpc.getVersionUpdateMethod) == null) {
      synchronized (VersionAuthServiceGrpc.class) {
        if ((getVersionUpdateMethod = VersionAuthServiceGrpc.getVersionUpdateMethod) == null) {
          VersionAuthServiceGrpc.getVersionUpdateMethod = getVersionUpdateMethod = 
              io.grpc.MethodDescriptor.<com.ljzn.grpc.version.VersionRequest, com.ljzn.grpc.version.VersionResponce>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "VisitorSystem_cq.VersionAuthService", "VersionUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.version.VersionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.version.VersionResponce.getDefaultInstance()))
                  .setSchemaDescriptor(new VersionAuthServiceMethodDescriptorSupplier("VersionUpdate"))
                  .build();
          }
        }
     }
     return getVersionUpdateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static VersionAuthServiceStub newStub(io.grpc.Channel channel) {
    return new VersionAuthServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VersionAuthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new VersionAuthServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static VersionAuthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new VersionAuthServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class VersionAuthServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void versionUpdate(com.ljzn.grpc.version.VersionRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.version.VersionResponce> responseObserver) {
      asyncUnimplementedUnaryCall(getVersionUpdateMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getVersionUpdateMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.ljzn.grpc.version.VersionRequest,
                com.ljzn.grpc.version.VersionResponce>(
                  this, METHODID_VERSION_UPDATE)))
          .build();
    }
  }

  /**
   */
  public static final class VersionAuthServiceStub extends io.grpc.stub.AbstractStub<VersionAuthServiceStub> {
    private VersionAuthServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VersionAuthServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VersionAuthServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VersionAuthServiceStub(channel, callOptions);
    }

    /**
     */
    public void versionUpdate(com.ljzn.grpc.version.VersionRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.version.VersionResponce> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getVersionUpdateMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class VersionAuthServiceBlockingStub extends io.grpc.stub.AbstractStub<VersionAuthServiceBlockingStub> {
    private VersionAuthServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VersionAuthServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VersionAuthServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VersionAuthServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.ljzn.grpc.version.VersionResponce> versionUpdate(
        com.ljzn.grpc.version.VersionRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getVersionUpdateMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class VersionAuthServiceFutureStub extends io.grpc.stub.AbstractStub<VersionAuthServiceFutureStub> {
    private VersionAuthServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VersionAuthServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VersionAuthServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VersionAuthServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_VERSION_UPDATE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final VersionAuthServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(VersionAuthServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_VERSION_UPDATE:
          serviceImpl.versionUpdate((com.ljzn.grpc.version.VersionRequest) request,
              (io.grpc.stub.StreamObserver<com.ljzn.grpc.version.VersionResponce>) responseObserver);
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

  private static abstract class VersionAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VersionAuthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ljzn.grpc.version.VersionService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VersionAuthService");
    }
  }

  private static final class VersionAuthServiceFileDescriptorSupplier
      extends VersionAuthServiceBaseDescriptorSupplier {
    VersionAuthServiceFileDescriptorSupplier() {}
  }

  private static final class VersionAuthServiceMethodDescriptorSupplier
      extends VersionAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    VersionAuthServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (VersionAuthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new VersionAuthServiceFileDescriptorSupplier())
              .addMethod(getVersionUpdateMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
