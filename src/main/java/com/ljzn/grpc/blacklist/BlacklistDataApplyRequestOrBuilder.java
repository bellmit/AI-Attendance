// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: blacklist/blacklist.service.proto

package com.ljzn.grpc.blacklist;

public interface BlacklistDataApplyRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:VisitorSystem_cq.BlacklistDataApplyRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string client_id = 1;</code>
   */
  java.lang.String getClientId();
  /**
   * <code>string client_id = 1;</code>
   */
  com.google.protobuf.ByteString
      getClientIdBytes();

  /**
   * <pre>
   *设备编号的加盐MD5值，盐值由客户端与服务器端约定
   * </pre>
   *
   * <code>string client_secret = 2;</code>
   */
  java.lang.String getClientSecret();
  /**
   * <pre>
   *设备编号的加盐MD5值，盐值由客户端与服务器端约定
   * </pre>
   *
   * <code>string client_secret = 2;</code>
   */
  com.google.protobuf.ByteString
      getClientSecretBytes();

  /**
   * <code>int64 version = 3;</code>
   */
  long getVersion();

  /**
   * <code>int32 belongId = 4;</code>
   */
  int getBelongId();
}
