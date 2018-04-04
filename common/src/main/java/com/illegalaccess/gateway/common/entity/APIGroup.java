package com.illegalaccess.gateway.common.entity;

import lombok.Data;

/**
 * 即项目组
 */
@Data
public class APIGroup {

    public static final String tableName = "APIGroup";

    private Long groupId;

    private String groupName;

    private String groupOwner; //该组负责人

    /**
     * @see com.illegalaccess.gateway.common.enums.APIAuthTypeEnum
     */
    private Integer authType;
}
