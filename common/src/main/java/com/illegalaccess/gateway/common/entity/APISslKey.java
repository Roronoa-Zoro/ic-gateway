package com.illegalaccess.gateway.common.entity;

import lombok.Data;

/**
 * 当api的认证方式为open ssl时
 * 该表存储对于组的公私钥 字符串
 *
 * 私钥签名，公钥验签
 */
@Data
public class APISslKey {

    private Long groupId;

    private String privateKey;

    private String publicKey;
}
