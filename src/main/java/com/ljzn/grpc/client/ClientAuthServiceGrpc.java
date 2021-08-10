package com.ljzn.grpc.client;

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
    comments = "Source: client/client.service.proto")
public final class ClientAuthServiceGrpc {

  private ClientAuthServiceGrpc() {}

  public static final String SERVICE_NAME = "VisitorSystem_cq.ClientAuthService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getLoginMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.ljzn.grpc.client.LoginRequest,
      com.ljzn.grpc.client.LoginResponse> METHOD_LOGIN = getLoginMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.ljzn.grpc.client.LoginRequest,
      com.ljzn.grpc.client.LoginResponse> getLoginMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.ljzn.grpc.client.LoginRequest,
      com.ljzn.grpc.client.LoginResponse> getLoginMethod() {
    return getLoginMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.ljzn.grpc.client.LoginRequest,
      com.ljzn.grpc.client.LoginResponse> getLoginMethodHelper() {
    io.grpc.MethodDescriptor<com.ljzn.grpc.client.LoginRequest, com.ljzn.grpc.client.LoginResponse> getLoginMethod;
    if ((getLoginMethod = ClientAuthServiceGrpc.getLoginMethod) == null) {
      synchronized (ClientAuthServiceGrpc.class) {
        if ((getLoginMethod = ClientAuthServiceGrpc.getLoginMethod) == null) {
          ClientAuthServiceGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<com.ljzn.grpc.client.LoginRequest, com.ljzn.grpc.client.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "VisitorSystem_cq.ClientAuthService", "Login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.client.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.client.LoginResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientAuthServiceMethodDescriptorSupplier("Login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getLogoutMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.ljzn.grpc.client.LogoutRequest,
      com.ljzn.grpc.client.LogoutResponse> METHOD_LOGOUT = getLogoutMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.ljzn.grpc.client.LogoutRequest,
      com.ljzn.grpc.client.LogoutResponse> getLogoutMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.ljzn.grpc.client.LogoutRequest,
      com.ljzn.grpc.client.LogoutResponse> getLogoutMethod() {
    return getLogoutMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.ljzn.grpc.client.LogoutRequest,
      com.ljzn.grpc.client.LogoutResponse> getLogoutMethodHelper() {
    io.grpc.MethodDescriptor<com.ljzn.grpc.client.LogoutRequest, com.ljzn.grpc.client.LogoutResponse> getLogoutMethod;
    if ((getLogoutMethod = ClientAuthServiceGrpc.getLogoutMethod) == null) {
      synchronized (ClientAuthServiceGrpc.class) {
        if ((getLogoutMethod = ClientAuthServiceGrpc.getLogoutMethod) == null) {
          ClientAuthServiceGrpc.getLogoutMethod = getLogoutMethod = 
              io.grpc.MethodDescriptor.<com.ljzn.grpc.client.LogoutRequest, com.ljzn.grpc.client.LogoutResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "VisitorSystem_cq.ClientAuthService", "Logout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.client.LogoutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.client.LogoutResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientAuthServiceMethodDescriptorSupplier("Logout"))
                  .build();
          }
        }
     }
     return getLogoutMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getHeartbeatMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.ljzn.grpc.client.HeartbeatRequest,
      com.ljzn.grpc.client.HeartbeatResponse> METHOD_HEARTBEAT = getHeartbeatMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.ljzn.grpc.client.HeartbeatRequest,
      com.ljzn.grpc.client.HeartbeatResponse> getHeartbeatMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.ljzn.grpc.client.HeartbeatRequest,
      com.ljzn.grpc.client.HeartbeatResponse> getHeartbeatMethod() {
    return getHeartbeatMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.ljzn.grpc.client.HeartbeatRequest,
      com.ljzn.grpc.client.HeartbeatResponse> getHeartbeatMethodHelper() {
    io.grpc.MethodDescriptor<com.ljzn.grpc.client.HeartbeatRequest, com.ljzn.grpc.client.HeartbeatResponse> getHeartbeatMethod;
    if ((getHeartbeatMethod = ClientAuthServiceGrpc.getHeartbeatMethod) == null) {
      synchronized (ClientAuthServiceGrpc.class) {
        if ((getHeartbeatMethod = ClientAuthServiceGrpc.getHeartbeatMethod) == null) {
          ClientAuthServiceGrpc.getHeartbeatMethod = getHeartbeatMethod = 
              io.grpc.MethodDescriptor.<com.ljzn.grpc.client.HeartbeatRequest, com.ljzn.grpc.client.HeartbeatResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "VisitorSystem_cq.ClientAuthService", "Heartbeat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.client.HeartbeatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.client.HeartbeatResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientAuthServiceMethodDescriptorSupplier("Heartbeat"))
                  .build();
          }
        }
     }
     return getHeartbeatMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getHeartbeatStreamMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.ljzn.grpc.client.HeartbeatRequest,
      com.ljzn.grpc.client.HeartbeatResponse> METHOD_HEARTBEAT_STREAM = getHeartbeatStreamMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.ljzn.grpc.client.HeartbeatRequest,
      com.ljzn.grpc.client.HeartbeatResponse> getHeartbeatStreamMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.ljzn.grpc.client.HeartbeatRequest,
      com.ljzn.grpc.client.HeartbeatResponse> getHeartbeatStreamMethod() {
    return getHeartbeatStreamMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.ljzn.grpc.client.HeartbeatRequest,
      com.ljzn.grpc.client.HeartbeatResponse> getHeartbeatStreamMethodHelper() {
    io.grpc.MethodDescriptor<com.ljzn.grpc.client.HeartbeatRequest, com.ljzn.grpc.client.HeartbeatResponse> getHeartbeatStreamMethod;
    if ((getHeartbeatStreamMethod = ClientAuthServiceGrpc.getHeartbeatStreamMethod) == null) {
      synchronized (ClientAuthServiceGrpc.class) {
        if ((getHeartbeatStreamMethod = ClientAuthServiceGrpc.getHeartbeatStreamMethod) == null) {
          ClientAuthServiceGrpc.getHeartbeatStreamMethod = getHeartbeatStreamMethod = 
              io.grpc.MethodDescriptor.<com.ljzn.grpc.client.HeartbeatRequest, com.ljzn.grpc.client.HeartbeatResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "VisitorSystem_cq.ClientAuthService", "HeartbeatStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.client.HeartbeatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.client.HeartbeatResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientAuthServiceMethodDescriptorSupplier("HeartbeatStream"))
                  .build();
          }
        }
     }
     return getHeartbeatStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClientAuthServiceStub newStub(io.grpc.Channel channel) {
    return new ClientAuthServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClientAuthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ClientAuthServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ClientAuthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ClientAuthServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ClientAuthServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void login(com.ljzn.grpc.client.LoginRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.client.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethodHelper(), responseObserver);
    }

    /**
     */
    public void logout(com.ljzn.grpc.client.LogoutRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.client.LogoutResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLogoutMethodHelper(), responseObserver);
    }

    /**
     */
    public void heartbeat(com.ljzn.grpc.client.HeartbeatRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.client.HeartbeatResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getHeartbeatMethodHelper(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.ljzn.grpc.client.HeartbeatRequest> heartbeatStream(
        io.grpc.stub.StreamObserver<com.ljzn.grpc.client.HeartbeatResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getHeartbeatStreamMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ljzn.grpc.client.LoginRequest,
                com.ljzn.grpc.client.LoginResponse>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getLogoutMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ljzn.grpc.client.LogoutRequest,
                com.ljzn.grpc.client.LogoutResponse>(
                  this, METHODID_LOGOUT)))
          .addMethod(
            getHeartbeatMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ljzn.grpc.client.HeartbeatRequest,
                com.ljzn.grpc.client.HeartbeatResponse>(
                  this, METHODID_HEARTBEAT)))
          .addMethod(
            getHeartbeatStreamMethodHelper(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.ljzn.grpc.client.HeartbeatRequest,
                com.ljzn.grpc.client.HeartbeatResponse>(
                  this, METHODID_HEARTBEAT_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class ClientAuthServiceStub extends io.grpc.stub.AbstractStub<ClientAuthServiceStub> {
    private ClientAuthServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientAuthServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientAuthServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientAuthServiceStub(channel, callOptions);
    }

    /**
     */
    public void login(com.ljzn.grpc.client.LoginRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.client.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logout(com.ljzn.grpc.client.LogoutRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.client.LogoutResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogoutMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void heartbeat(com.ljzn.grpc.client.HeartbeatRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.client.HeartbeatResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHeartbeatMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.ljzn.grpc.client.HeartbeatRequest> heartbeatStream(
        io.grpc.stub.StreamObserver<com.ljzn.grpc.client.HeartbeatResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getHeartbeatStreamMethodHelper(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class ClientAuthServiceBlockingStub extends io.grpc.stub.AbstractStub<ClientAuthServiceBlockingStub> {
    private ClientAuthServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientAuthServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientAuthServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientAuthServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ljzn.grpc.client.LoginResponse login(com.ljzn.grpc.client.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.ljzn.grpc.client.LogoutResponse logout(com.ljzn.grpc.client.LogoutRequest request) {
      return blockingUnaryCall(
          getChannel(), getLogoutMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.ljzn.grpc.client.HeartbeatResponse heartbeat(com.ljzn.grpc.client.HeartbeatRequest request) {
      return blockingUnaryCall(
          getChannel(), getHeartbeatMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ClientAuthServiceFutureStub extends io.grpc.stub.AbstractStub<ClientAuthServiceFutureStub> {
    private ClientAuthServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientAuthServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientAuthServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientAuthServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ljzn.grpc.client.LoginResponse> login(
        com.ljzn.grpc.client.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ljzn.grpc.client.LogoutResponse> logout(
        com.ljzn.grpc.client.LogoutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLogoutMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ljzn.grpc.client.HeartbeatResponse> heartbeat(
        com.ljzn.grpc.client.HeartbeatRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getHeartbeatMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_LOGOUT = 1;
  private static final int METHODID_HEARTBEAT = 2;
  private static final int METHODID_HEARTBEAT_STREAM = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ClientAuthServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ClientAuthServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((com.ljzn.grpc.client.LoginRequest) request,
              (io.grpc.stub.StreamObserver<com.ljzn.grpc.client.LoginResponse>) responseObserver);
          break;
        case METHODID_LOGOUT:
          serviceImpl.logout((com.ljzn.grpc.client.LogoutRequest) request,
              (io.grpc.stub.StreamObserver<com.ljzn.grpc.client.LogoutResponse>) responseObserver);
          break;
        case METHODID_HEARTBEAT:
          serviceImpl.heartbeat((com.ljzn.grpc.client.HeartbeatRequest) request,
              (io.grpc.stub.StreamObserver<com.ljzn.grpc.client.HeartbeatResponse>) responseObserver);
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
        case METHODID_HEARTBEAT_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.heartbeatStream(
              (io.grpc.stub.StreamObserver<com.ljzn.grpc.client.HeartbeatResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ClientAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ClientAuthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ljzn.grpc.client.ClientService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ClientAuthService");
    }
  }

  private static final class ClientAuthServiceFileDescriptorSupplier
      extends ClientAuthServiceBaseDescriptorSupplier {
    ClientAuthServiceFileDescriptorSupplier() {}
  }

  private static final class ClientAuthServiceMethodDescriptorSupplier
      extends ClientAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ClientAuthServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ClientAuthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClientAuthServiceFileDescriptorSupplier())
              .addMethod(getLoginMethodHelper())
              .addMethod(getLogoutMethodHelper())
              .addMethod(getHeartbeatMethodHelper())
              .addMethod(getHeartbeatStreamMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
