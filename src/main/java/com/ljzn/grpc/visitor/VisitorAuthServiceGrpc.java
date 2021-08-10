package com.ljzn.grpc.visitor;

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
    comments = "Source: visitor/visitor.service.proto")
public final class VisitorAuthServiceGrpc {

  private VisitorAuthServiceGrpc() {}

  public static final String SERVICE_NAME = "VisitorSystem_cq.VisitorAuthService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getVisitorUploadMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.ljzn.grpc.visitor.VisitorUploadRequest,
      com.ljzn.grpc.visitor.VisitorUploadResponce> METHOD_VISITOR_UPLOAD = getVisitorUploadMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.ljzn.grpc.visitor.VisitorUploadRequest,
      com.ljzn.grpc.visitor.VisitorUploadResponce> getVisitorUploadMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.ljzn.grpc.visitor.VisitorUploadRequest,
      com.ljzn.grpc.visitor.VisitorUploadResponce> getVisitorUploadMethod() {
    return getVisitorUploadMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.ljzn.grpc.visitor.VisitorUploadRequest,
      com.ljzn.grpc.visitor.VisitorUploadResponce> getVisitorUploadMethodHelper() {
    io.grpc.MethodDescriptor<com.ljzn.grpc.visitor.VisitorUploadRequest, com.ljzn.grpc.visitor.VisitorUploadResponce> getVisitorUploadMethod;
    if ((getVisitorUploadMethod = VisitorAuthServiceGrpc.getVisitorUploadMethod) == null) {
      synchronized (VisitorAuthServiceGrpc.class) {
        if ((getVisitorUploadMethod = VisitorAuthServiceGrpc.getVisitorUploadMethod) == null) {
          VisitorAuthServiceGrpc.getVisitorUploadMethod = getVisitorUploadMethod = 
              io.grpc.MethodDescriptor.<com.ljzn.grpc.visitor.VisitorUploadRequest, com.ljzn.grpc.visitor.VisitorUploadResponce>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "VisitorSystem_cq.VisitorAuthService", "VisitorUpload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.visitor.VisitorUploadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.visitor.VisitorUploadResponce.getDefaultInstance()))
                  .setSchemaDescriptor(new VisitorAuthServiceMethodDescriptorSupplier("VisitorUpload"))
                  .build();
          }
        }
     }
     return getVisitorUploadMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getVisitInfoUploadMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.ljzn.grpc.visitor.VisitInfoUploadRequest,
      com.ljzn.grpc.visitor.VisitInfoUploadResponce> METHOD_VISIT_INFO_UPLOAD = getVisitInfoUploadMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.ljzn.grpc.visitor.VisitInfoUploadRequest,
      com.ljzn.grpc.visitor.VisitInfoUploadResponce> getVisitInfoUploadMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.ljzn.grpc.visitor.VisitInfoUploadRequest,
      com.ljzn.grpc.visitor.VisitInfoUploadResponce> getVisitInfoUploadMethod() {
    return getVisitInfoUploadMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.ljzn.grpc.visitor.VisitInfoUploadRequest,
      com.ljzn.grpc.visitor.VisitInfoUploadResponce> getVisitInfoUploadMethodHelper() {
    io.grpc.MethodDescriptor<com.ljzn.grpc.visitor.VisitInfoUploadRequest, com.ljzn.grpc.visitor.VisitInfoUploadResponce> getVisitInfoUploadMethod;
    if ((getVisitInfoUploadMethod = VisitorAuthServiceGrpc.getVisitInfoUploadMethod) == null) {
      synchronized (VisitorAuthServiceGrpc.class) {
        if ((getVisitInfoUploadMethod = VisitorAuthServiceGrpc.getVisitInfoUploadMethod) == null) {
          VisitorAuthServiceGrpc.getVisitInfoUploadMethod = getVisitInfoUploadMethod = 
              io.grpc.MethodDescriptor.<com.ljzn.grpc.visitor.VisitInfoUploadRequest, com.ljzn.grpc.visitor.VisitInfoUploadResponce>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "VisitorSystem_cq.VisitorAuthService", "VisitInfoUpload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.visitor.VisitInfoUploadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.visitor.VisitInfoUploadResponce.getDefaultInstance()))
                  .setSchemaDescriptor(new VisitorAuthServiceMethodDescriptorSupplier("VisitInfoUpload"))
                  .build();
          }
        }
     }
     return getVisitInfoUploadMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getVisitInfoDownloadMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.ljzn.grpc.visitor.VisitInfoDownloadRequest,
      com.ljzn.grpc.visitor.VisitInfoDownloadResponce> METHOD_VISIT_INFO_DOWNLOAD = getVisitInfoDownloadMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.ljzn.grpc.visitor.VisitInfoDownloadRequest,
      com.ljzn.grpc.visitor.VisitInfoDownloadResponce> getVisitInfoDownloadMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.ljzn.grpc.visitor.VisitInfoDownloadRequest,
      com.ljzn.grpc.visitor.VisitInfoDownloadResponce> getVisitInfoDownloadMethod() {
    return getVisitInfoDownloadMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.ljzn.grpc.visitor.VisitInfoDownloadRequest,
      com.ljzn.grpc.visitor.VisitInfoDownloadResponce> getVisitInfoDownloadMethodHelper() {
    io.grpc.MethodDescriptor<com.ljzn.grpc.visitor.VisitInfoDownloadRequest, com.ljzn.grpc.visitor.VisitInfoDownloadResponce> getVisitInfoDownloadMethod;
    if ((getVisitInfoDownloadMethod = VisitorAuthServiceGrpc.getVisitInfoDownloadMethod) == null) {
      synchronized (VisitorAuthServiceGrpc.class) {
        if ((getVisitInfoDownloadMethod = VisitorAuthServiceGrpc.getVisitInfoDownloadMethod) == null) {
          VisitorAuthServiceGrpc.getVisitInfoDownloadMethod = getVisitInfoDownloadMethod = 
              io.grpc.MethodDescriptor.<com.ljzn.grpc.visitor.VisitInfoDownloadRequest, com.ljzn.grpc.visitor.VisitInfoDownloadResponce>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "VisitorSystem_cq.VisitorAuthService", "VisitInfoDownload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.visitor.VisitInfoDownloadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.visitor.VisitInfoDownloadResponce.getDefaultInstance()))
                  .setSchemaDescriptor(new VisitorAuthServiceMethodDescriptorSupplier("VisitInfoDownload"))
                  .build();
          }
        }
     }
     return getVisitInfoDownloadMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCheckOutMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.ljzn.grpc.visitor.CheckOutRequest,
      com.ljzn.grpc.visitor.CheckOutResponce> METHOD_CHECK_OUT = getCheckOutMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.ljzn.grpc.visitor.CheckOutRequest,
      com.ljzn.grpc.visitor.CheckOutResponce> getCheckOutMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.ljzn.grpc.visitor.CheckOutRequest,
      com.ljzn.grpc.visitor.CheckOutResponce> getCheckOutMethod() {
    return getCheckOutMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.ljzn.grpc.visitor.CheckOutRequest,
      com.ljzn.grpc.visitor.CheckOutResponce> getCheckOutMethodHelper() {
    io.grpc.MethodDescriptor<com.ljzn.grpc.visitor.CheckOutRequest, com.ljzn.grpc.visitor.CheckOutResponce> getCheckOutMethod;
    if ((getCheckOutMethod = VisitorAuthServiceGrpc.getCheckOutMethod) == null) {
      synchronized (VisitorAuthServiceGrpc.class) {
        if ((getCheckOutMethod = VisitorAuthServiceGrpc.getCheckOutMethod) == null) {
          VisitorAuthServiceGrpc.getCheckOutMethod = getCheckOutMethod = 
              io.grpc.MethodDescriptor.<com.ljzn.grpc.visitor.CheckOutRequest, com.ljzn.grpc.visitor.CheckOutResponce>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "VisitorSystem_cq.VisitorAuthService", "CheckOut"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.visitor.CheckOutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.visitor.CheckOutResponce.getDefaultInstance()))
                  .setSchemaDescriptor(new VisitorAuthServiceMethodDescriptorSupplier("CheckOut"))
                  .build();
          }
        }
     }
     return getCheckOutMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static VisitorAuthServiceStub newStub(io.grpc.Channel channel) {
    return new VisitorAuthServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VisitorAuthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new VisitorAuthServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static VisitorAuthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new VisitorAuthServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class VisitorAuthServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void visitorUpload(com.ljzn.grpc.visitor.VisitorUploadRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.visitor.VisitorUploadResponce> responseObserver) {
      asyncUnimplementedUnaryCall(getVisitorUploadMethodHelper(), responseObserver);
    }

    /**
     */
    public void visitInfoUpload(com.ljzn.grpc.visitor.VisitInfoUploadRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.visitor.VisitInfoUploadResponce> responseObserver) {
      asyncUnimplementedUnaryCall(getVisitInfoUploadMethodHelper(), responseObserver);
    }

    /**
     */
    public void visitInfoDownload(com.ljzn.grpc.visitor.VisitInfoDownloadRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.visitor.VisitInfoDownloadResponce> responseObserver) {
      asyncUnimplementedUnaryCall(getVisitInfoDownloadMethodHelper(), responseObserver);
    }

    /**
     */
    public void checkOut(com.ljzn.grpc.visitor.CheckOutRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.visitor.CheckOutResponce> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckOutMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getVisitorUploadMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ljzn.grpc.visitor.VisitorUploadRequest,
                com.ljzn.grpc.visitor.VisitorUploadResponce>(
                  this, METHODID_VISITOR_UPLOAD)))
          .addMethod(
            getVisitInfoUploadMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ljzn.grpc.visitor.VisitInfoUploadRequest,
                com.ljzn.grpc.visitor.VisitInfoUploadResponce>(
                  this, METHODID_VISIT_INFO_UPLOAD)))
          .addMethod(
            getVisitInfoDownloadMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ljzn.grpc.visitor.VisitInfoDownloadRequest,
                com.ljzn.grpc.visitor.VisitInfoDownloadResponce>(
                  this, METHODID_VISIT_INFO_DOWNLOAD)))
          .addMethod(
            getCheckOutMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ljzn.grpc.visitor.CheckOutRequest,
                com.ljzn.grpc.visitor.CheckOutResponce>(
                  this, METHODID_CHECK_OUT)))
          .build();
    }
  }

  /**
   */
  public static final class VisitorAuthServiceStub extends io.grpc.stub.AbstractStub<VisitorAuthServiceStub> {
    private VisitorAuthServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VisitorAuthServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VisitorAuthServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VisitorAuthServiceStub(channel, callOptions);
    }

    /**
     */
    public void visitorUpload(com.ljzn.grpc.visitor.VisitorUploadRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.visitor.VisitorUploadResponce> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getVisitorUploadMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void visitInfoUpload(com.ljzn.grpc.visitor.VisitInfoUploadRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.visitor.VisitInfoUploadResponce> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getVisitInfoUploadMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void visitInfoDownload(com.ljzn.grpc.visitor.VisitInfoDownloadRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.visitor.VisitInfoDownloadResponce> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getVisitInfoDownloadMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void checkOut(com.ljzn.grpc.visitor.CheckOutRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.visitor.CheckOutResponce> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckOutMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class VisitorAuthServiceBlockingStub extends io.grpc.stub.AbstractStub<VisitorAuthServiceBlockingStub> {
    private VisitorAuthServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VisitorAuthServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VisitorAuthServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VisitorAuthServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ljzn.grpc.visitor.VisitorUploadResponce visitorUpload(com.ljzn.grpc.visitor.VisitorUploadRequest request) {
      return blockingUnaryCall(
          getChannel(), getVisitorUploadMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.ljzn.grpc.visitor.VisitInfoUploadResponce visitInfoUpload(com.ljzn.grpc.visitor.VisitInfoUploadRequest request) {
      return blockingUnaryCall(
          getChannel(), getVisitInfoUploadMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.ljzn.grpc.visitor.VisitInfoDownloadResponce visitInfoDownload(com.ljzn.grpc.visitor.VisitInfoDownloadRequest request) {
      return blockingUnaryCall(
          getChannel(), getVisitInfoDownloadMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.ljzn.grpc.visitor.CheckOutResponce checkOut(com.ljzn.grpc.visitor.CheckOutRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckOutMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class VisitorAuthServiceFutureStub extends io.grpc.stub.AbstractStub<VisitorAuthServiceFutureStub> {
    private VisitorAuthServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VisitorAuthServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VisitorAuthServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VisitorAuthServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ljzn.grpc.visitor.VisitorUploadResponce> visitorUpload(
        com.ljzn.grpc.visitor.VisitorUploadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getVisitorUploadMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ljzn.grpc.visitor.VisitInfoUploadResponce> visitInfoUpload(
        com.ljzn.grpc.visitor.VisitInfoUploadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getVisitInfoUploadMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ljzn.grpc.visitor.VisitInfoDownloadResponce> visitInfoDownload(
        com.ljzn.grpc.visitor.VisitInfoDownloadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getVisitInfoDownloadMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ljzn.grpc.visitor.CheckOutResponce> checkOut(
        com.ljzn.grpc.visitor.CheckOutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckOutMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_VISITOR_UPLOAD = 0;
  private static final int METHODID_VISIT_INFO_UPLOAD = 1;
  private static final int METHODID_VISIT_INFO_DOWNLOAD = 2;
  private static final int METHODID_CHECK_OUT = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final VisitorAuthServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(VisitorAuthServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_VISITOR_UPLOAD:
          serviceImpl.visitorUpload((com.ljzn.grpc.visitor.VisitorUploadRequest) request,
              (io.grpc.stub.StreamObserver<com.ljzn.grpc.visitor.VisitorUploadResponce>) responseObserver);
          break;
        case METHODID_VISIT_INFO_UPLOAD:
          serviceImpl.visitInfoUpload((com.ljzn.grpc.visitor.VisitInfoUploadRequest) request,
              (io.grpc.stub.StreamObserver<com.ljzn.grpc.visitor.VisitInfoUploadResponce>) responseObserver);
          break;
        case METHODID_VISIT_INFO_DOWNLOAD:
          serviceImpl.visitInfoDownload((com.ljzn.grpc.visitor.VisitInfoDownloadRequest) request,
              (io.grpc.stub.StreamObserver<com.ljzn.grpc.visitor.VisitInfoDownloadResponce>) responseObserver);
          break;
        case METHODID_CHECK_OUT:
          serviceImpl.checkOut((com.ljzn.grpc.visitor.CheckOutRequest) request,
              (io.grpc.stub.StreamObserver<com.ljzn.grpc.visitor.CheckOutResponce>) responseObserver);
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

  private static abstract class VisitorAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VisitorAuthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ljzn.grpc.visitor.VisitorService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VisitorAuthService");
    }
  }

  private static final class VisitorAuthServiceFileDescriptorSupplier
      extends VisitorAuthServiceBaseDescriptorSupplier {
    VisitorAuthServiceFileDescriptorSupplier() {}
  }

  private static final class VisitorAuthServiceMethodDescriptorSupplier
      extends VisitorAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    VisitorAuthServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (VisitorAuthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new VisitorAuthServiceFileDescriptorSupplier())
              .addMethod(getVisitorUploadMethodHelper())
              .addMethod(getVisitInfoUploadMethodHelper())
              .addMethod(getVisitInfoDownloadMethodHelper())
              .addMethod(getCheckOutMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
