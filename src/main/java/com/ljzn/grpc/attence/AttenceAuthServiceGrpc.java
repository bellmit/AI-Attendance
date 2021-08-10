package com.ljzn.grpc.attence;

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
    comments = "Source: attence/attence.service.proto")
public final class AttenceAuthServiceGrpc {

  private AttenceAuthServiceGrpc() {}

  public static final String SERVICE_NAME = "AttenceSystem.AttenceAuthService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAttenceUploadMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.ljzn.grpc.attence.AttenceUploadDataRequest,
      com.ljzn.grpc.attence.AttenceUploadDataResponse> METHOD_ATTENCE_UPLOAD = getAttenceUploadMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.ljzn.grpc.attence.AttenceUploadDataRequest,
      com.ljzn.grpc.attence.AttenceUploadDataResponse> getAttenceUploadMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.ljzn.grpc.attence.AttenceUploadDataRequest,
      com.ljzn.grpc.attence.AttenceUploadDataResponse> getAttenceUploadMethod() {
    return getAttenceUploadMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.ljzn.grpc.attence.AttenceUploadDataRequest,
      com.ljzn.grpc.attence.AttenceUploadDataResponse> getAttenceUploadMethodHelper() {
    io.grpc.MethodDescriptor<com.ljzn.grpc.attence.AttenceUploadDataRequest, com.ljzn.grpc.attence.AttenceUploadDataResponse> getAttenceUploadMethod;
    if ((getAttenceUploadMethod = AttenceAuthServiceGrpc.getAttenceUploadMethod) == null) {
      synchronized (AttenceAuthServiceGrpc.class) {
        if ((getAttenceUploadMethod = AttenceAuthServiceGrpc.getAttenceUploadMethod) == null) {
          AttenceAuthServiceGrpc.getAttenceUploadMethod = getAttenceUploadMethod = 
              io.grpc.MethodDescriptor.<com.ljzn.grpc.attence.AttenceUploadDataRequest, com.ljzn.grpc.attence.AttenceUploadDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "AttenceSystem.AttenceAuthService", "AttenceUpload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.attence.AttenceUploadDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.attence.AttenceUploadDataResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AttenceAuthServiceMethodDescriptorSupplier("AttenceUpload"))
                  .build();
          }
        }
     }
     return getAttenceUploadMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetEmployeeInfoMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.ljzn.grpc.attence.EmployeeInfoRequest,
      com.ljzn.grpc.attence.EmployeeInfoResponse> METHOD_GET_EMPLOYEE_INFO = getGetEmployeeInfoMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.ljzn.grpc.attence.EmployeeInfoRequest,
      com.ljzn.grpc.attence.EmployeeInfoResponse> getGetEmployeeInfoMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.ljzn.grpc.attence.EmployeeInfoRequest,
      com.ljzn.grpc.attence.EmployeeInfoResponse> getGetEmployeeInfoMethod() {
    return getGetEmployeeInfoMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.ljzn.grpc.attence.EmployeeInfoRequest,
      com.ljzn.grpc.attence.EmployeeInfoResponse> getGetEmployeeInfoMethodHelper() {
    io.grpc.MethodDescriptor<com.ljzn.grpc.attence.EmployeeInfoRequest, com.ljzn.grpc.attence.EmployeeInfoResponse> getGetEmployeeInfoMethod;
    if ((getGetEmployeeInfoMethod = AttenceAuthServiceGrpc.getGetEmployeeInfoMethod) == null) {
      synchronized (AttenceAuthServiceGrpc.class) {
        if ((getGetEmployeeInfoMethod = AttenceAuthServiceGrpc.getGetEmployeeInfoMethod) == null) {
          AttenceAuthServiceGrpc.getGetEmployeeInfoMethod = getGetEmployeeInfoMethod = 
              io.grpc.MethodDescriptor.<com.ljzn.grpc.attence.EmployeeInfoRequest, com.ljzn.grpc.attence.EmployeeInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "AttenceSystem.AttenceAuthService", "GetEmployeeInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.attence.EmployeeInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.attence.EmployeeInfoResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AttenceAuthServiceMethodDescriptorSupplier("GetEmployeeInfo"))
                  .build();
          }
        }
     }
     return getGetEmployeeInfoMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetEmployeeVersionMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.ljzn.grpc.attence.EmployeeVersionRequest,
      com.ljzn.grpc.attence.EmployeeVersionResponse> METHOD_GET_EMPLOYEE_VERSION = getGetEmployeeVersionMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.ljzn.grpc.attence.EmployeeVersionRequest,
      com.ljzn.grpc.attence.EmployeeVersionResponse> getGetEmployeeVersionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.ljzn.grpc.attence.EmployeeVersionRequest,
      com.ljzn.grpc.attence.EmployeeVersionResponse> getGetEmployeeVersionMethod() {
    return getGetEmployeeVersionMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.ljzn.grpc.attence.EmployeeVersionRequest,
      com.ljzn.grpc.attence.EmployeeVersionResponse> getGetEmployeeVersionMethodHelper() {
    io.grpc.MethodDescriptor<com.ljzn.grpc.attence.EmployeeVersionRequest, com.ljzn.grpc.attence.EmployeeVersionResponse> getGetEmployeeVersionMethod;
    if ((getGetEmployeeVersionMethod = AttenceAuthServiceGrpc.getGetEmployeeVersionMethod) == null) {
      synchronized (AttenceAuthServiceGrpc.class) {
        if ((getGetEmployeeVersionMethod = AttenceAuthServiceGrpc.getGetEmployeeVersionMethod) == null) {
          AttenceAuthServiceGrpc.getGetEmployeeVersionMethod = getGetEmployeeVersionMethod = 
              io.grpc.MethodDescriptor.<com.ljzn.grpc.attence.EmployeeVersionRequest, com.ljzn.grpc.attence.EmployeeVersionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "AttenceSystem.AttenceAuthService", "GetEmployeeVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.attence.EmployeeVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.attence.EmployeeVersionResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AttenceAuthServiceMethodDescriptorSupplier("GetEmployeeVersion"))
                  .build();
          }
        }
     }
     return getGetEmployeeVersionMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetPhotoMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.ljzn.grpc.attence.getPhotoRequest,
      com.ljzn.grpc.attence.getPhotoResponse> METHOD_GET_PHOTO = getGetPhotoMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.ljzn.grpc.attence.getPhotoRequest,
      com.ljzn.grpc.attence.getPhotoResponse> getGetPhotoMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.ljzn.grpc.attence.getPhotoRequest,
      com.ljzn.grpc.attence.getPhotoResponse> getGetPhotoMethod() {
    return getGetPhotoMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.ljzn.grpc.attence.getPhotoRequest,
      com.ljzn.grpc.attence.getPhotoResponse> getGetPhotoMethodHelper() {
    io.grpc.MethodDescriptor<com.ljzn.grpc.attence.getPhotoRequest, com.ljzn.grpc.attence.getPhotoResponse> getGetPhotoMethod;
    if ((getGetPhotoMethod = AttenceAuthServiceGrpc.getGetPhotoMethod) == null) {
      synchronized (AttenceAuthServiceGrpc.class) {
        if ((getGetPhotoMethod = AttenceAuthServiceGrpc.getGetPhotoMethod) == null) {
          AttenceAuthServiceGrpc.getGetPhotoMethod = getGetPhotoMethod = 
              io.grpc.MethodDescriptor.<com.ljzn.grpc.attence.getPhotoRequest, com.ljzn.grpc.attence.getPhotoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "AttenceSystem.AttenceAuthService", "GetPhoto"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.attence.getPhotoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.attence.getPhotoResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AttenceAuthServiceMethodDescriptorSupplier("GetPhoto"))
                  .build();
          }
        }
     }
     return getGetPhotoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AttenceAuthServiceStub newStub(io.grpc.Channel channel) {
    return new AttenceAuthServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AttenceAuthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AttenceAuthServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AttenceAuthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AttenceAuthServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AttenceAuthServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void attenceUpload(com.ljzn.grpc.attence.AttenceUploadDataRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.attence.AttenceUploadDataResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAttenceUploadMethodHelper(), responseObserver);
    }

    /**
     */
    public void getEmployeeInfo(com.ljzn.grpc.attence.EmployeeInfoRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.attence.EmployeeInfoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetEmployeeInfoMethodHelper(), responseObserver);
    }

    /**
     */
    public void getEmployeeVersion(com.ljzn.grpc.attence.EmployeeVersionRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.attence.EmployeeVersionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetEmployeeVersionMethodHelper(), responseObserver);
    }

    /**
     */
    public void getPhoto(com.ljzn.grpc.attence.getPhotoRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.attence.getPhotoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPhotoMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAttenceUploadMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ljzn.grpc.attence.AttenceUploadDataRequest,
                com.ljzn.grpc.attence.AttenceUploadDataResponse>(
                  this, METHODID_ATTENCE_UPLOAD)))
          .addMethod(
            getGetEmployeeInfoMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ljzn.grpc.attence.EmployeeInfoRequest,
                com.ljzn.grpc.attence.EmployeeInfoResponse>(
                  this, METHODID_GET_EMPLOYEE_INFO)))
          .addMethod(
            getGetEmployeeVersionMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ljzn.grpc.attence.EmployeeVersionRequest,
                com.ljzn.grpc.attence.EmployeeVersionResponse>(
                  this, METHODID_GET_EMPLOYEE_VERSION)))
          .addMethod(
            getGetPhotoMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ljzn.grpc.attence.getPhotoRequest,
                com.ljzn.grpc.attence.getPhotoResponse>(
                  this, METHODID_GET_PHOTO)))
          .build();
    }
  }

  /**
   */
  public static final class AttenceAuthServiceStub extends io.grpc.stub.AbstractStub<AttenceAuthServiceStub> {
    private AttenceAuthServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AttenceAuthServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AttenceAuthServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AttenceAuthServiceStub(channel, callOptions);
    }

    /**
     */
    public void attenceUpload(com.ljzn.grpc.attence.AttenceUploadDataRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.attence.AttenceUploadDataResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAttenceUploadMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getEmployeeInfo(com.ljzn.grpc.attence.EmployeeInfoRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.attence.EmployeeInfoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetEmployeeInfoMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getEmployeeVersion(com.ljzn.grpc.attence.EmployeeVersionRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.attence.EmployeeVersionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetEmployeeVersionMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPhoto(com.ljzn.grpc.attence.getPhotoRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.attence.getPhotoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPhotoMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AttenceAuthServiceBlockingStub extends io.grpc.stub.AbstractStub<AttenceAuthServiceBlockingStub> {
    private AttenceAuthServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AttenceAuthServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AttenceAuthServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AttenceAuthServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ljzn.grpc.attence.AttenceUploadDataResponse attenceUpload(com.ljzn.grpc.attence.AttenceUploadDataRequest request) {
      return blockingUnaryCall(
          getChannel(), getAttenceUploadMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.ljzn.grpc.attence.EmployeeInfoResponse getEmployeeInfo(com.ljzn.grpc.attence.EmployeeInfoRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetEmployeeInfoMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.ljzn.grpc.attence.EmployeeVersionResponse getEmployeeVersion(com.ljzn.grpc.attence.EmployeeVersionRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetEmployeeVersionMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.ljzn.grpc.attence.getPhotoResponse getPhoto(com.ljzn.grpc.attence.getPhotoRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetPhotoMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AttenceAuthServiceFutureStub extends io.grpc.stub.AbstractStub<AttenceAuthServiceFutureStub> {
    private AttenceAuthServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AttenceAuthServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AttenceAuthServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AttenceAuthServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ljzn.grpc.attence.AttenceUploadDataResponse> attenceUpload(
        com.ljzn.grpc.attence.AttenceUploadDataRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAttenceUploadMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ljzn.grpc.attence.EmployeeInfoResponse> getEmployeeInfo(
        com.ljzn.grpc.attence.EmployeeInfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetEmployeeInfoMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ljzn.grpc.attence.EmployeeVersionResponse> getEmployeeVersion(
        com.ljzn.grpc.attence.EmployeeVersionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetEmployeeVersionMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ljzn.grpc.attence.getPhotoResponse> getPhoto(
        com.ljzn.grpc.attence.getPhotoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPhotoMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ATTENCE_UPLOAD = 0;
  private static final int METHODID_GET_EMPLOYEE_INFO = 1;
  private static final int METHODID_GET_EMPLOYEE_VERSION = 2;
  private static final int METHODID_GET_PHOTO = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AttenceAuthServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AttenceAuthServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ATTENCE_UPLOAD:
          serviceImpl.attenceUpload((com.ljzn.grpc.attence.AttenceUploadDataRequest) request,
              (io.grpc.stub.StreamObserver<com.ljzn.grpc.attence.AttenceUploadDataResponse>) responseObserver);
          break;
        case METHODID_GET_EMPLOYEE_INFO:
          serviceImpl.getEmployeeInfo((com.ljzn.grpc.attence.EmployeeInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.ljzn.grpc.attence.EmployeeInfoResponse>) responseObserver);
          break;
        case METHODID_GET_EMPLOYEE_VERSION:
          serviceImpl.getEmployeeVersion((com.ljzn.grpc.attence.EmployeeVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.ljzn.grpc.attence.EmployeeVersionResponse>) responseObserver);
          break;
        case METHODID_GET_PHOTO:
          serviceImpl.getPhoto((com.ljzn.grpc.attence.getPhotoRequest) request,
              (io.grpc.stub.StreamObserver<com.ljzn.grpc.attence.getPhotoResponse>) responseObserver);
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

  private static abstract class AttenceAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AttenceAuthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ljzn.grpc.attence.AttenceService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AttenceAuthService");
    }
  }

  private static final class AttenceAuthServiceFileDescriptorSupplier
      extends AttenceAuthServiceBaseDescriptorSupplier {
    AttenceAuthServiceFileDescriptorSupplier() {}
  }

  private static final class AttenceAuthServiceMethodDescriptorSupplier
      extends AttenceAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AttenceAuthServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AttenceAuthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AttenceAuthServiceFileDescriptorSupplier())
              .addMethod(getAttenceUploadMethodHelper())
              .addMethod(getGetEmployeeInfoMethodHelper())
              .addMethod(getGetEmployeeVersionMethodHelper())
              .addMethod(getGetPhotoMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
