// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: metting/metting.service.proto

package com.ljzn.grpc.metting;

public final class MettingService {
  private MettingService() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MettingSystem_MettingEmpInfoRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MettingSystem_MettingEmpInfoRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MettingSystem_MettingEmpInfoResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MettingSystem_MettingEmpInfoResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\035metting/metting.service.proto\022\rMetting" +
      "System\032\035metting/metting.message.proto\",\n" +
      "\025MettingEmpInfoRequest\022\023\n\013mettingName\030\001 " +
      "\001(\t\"n\n\026MettingEmpInfoResponse\022\014\n\004code\030\001 " +
      "\001(\005\022\017\n\007message\030\002 \001(\t\0225\n\016mettingEmpInfo\030\003" +
      " \003(\0132\035.MettingSystem.MettingEmpInfo2x\n\022M" +
      "ettingAuthService\022b\n\021GetMettingEmpInfo\022$" +
      ".MettingSystem.MettingEmpInfoRequest\032%.M" +
      "ettingSystem.MettingEmpInfoResponse\"\000B#\n" +
      "\025com.ljzn.grpc.mettingP\001\242\002\007METTINGb\006prot" +
      "o3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.ljzn.grpc.metting.MettingMessage.getDescriptor(),
        }, assigner);
    internal_static_MettingSystem_MettingEmpInfoRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_MettingSystem_MettingEmpInfoRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MettingSystem_MettingEmpInfoRequest_descriptor,
        new java.lang.String[] { "MettingName", });
    internal_static_MettingSystem_MettingEmpInfoResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_MettingSystem_MettingEmpInfoResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MettingSystem_MettingEmpInfoResponse_descriptor,
        new java.lang.String[] { "Code", "Message", "MettingEmpInfo", });
    com.ljzn.grpc.metting.MettingMessage.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
