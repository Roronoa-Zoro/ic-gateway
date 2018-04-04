package com.illegalaccess.gateway.common.entity;

import lombok.Data;


/**
 * 配置的 API 信息
 */
@Data
public class APIInfo {

    public static final String tableName = "APIInfo";

    private String version;

    /**
     * 该 api 的传输协议,即 http接口  还是  dubbo接口
     * @see com.illegalaccess.gateway.common.enums.APIProtocolEnum
     */
    private String protocol;

    /**
     * 访问的路径, 通过网关暴露给其他系统的
     */
    private String url;

    /**
     * 实际提供服务的接口的路径
     */
    private String realUrl;

    /**
     * 接口提供者的 ip:port 列表，逗号分隔多个地址
     * 例：
     * 当protocol是dubbo时，该字段为zk的list
     * 当protocol是http时，该字段可以是一个Nginx地址，或者直接是目标机器的ip list
     */
    private String hostList;

    /**
     * 接口功能说明
     */
    private String apiDesc;

    /**
     * 所属的 组
     */
    private Long groupId;

    /**
     * 该接口的开发维护人员
     */
    private String apiOwner;

    /**
     * @see com.illegalaccess.gateway.common.enums.APIEnhancementTypeEnum
     * json 格式数据
     * 表示对该 api 进行哪些额外处理
     */
    private String enhancementData;
}
