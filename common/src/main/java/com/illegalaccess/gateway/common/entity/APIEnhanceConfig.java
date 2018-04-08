package com.illegalaccess.gateway.common.entity;

import com.illegalaccess.gateway.common.vo.APIEnhanceConfigValue;
import lombok.Data;

import java.util.List;

/**
 * 存到Redis里面， 使用hash
 * key 是url + requestId + version
 */
@Data
public class APIEnhanceConfig {

    public static final String tableName = "APIEnhanceConfig";

    private String url;
    private String requestId;
    private String version;

    private List<APIEnhanceConfigValue> configValue;

    public String getHashKey() {
        StringBuilder sb = new StringBuilder();
        sb.append(url)
                .append(requestId)
                .append(version);
        return sb.toString();
    }

}
