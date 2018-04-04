package com.illegalaccess.gateway.common.service;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.illegalaccess.gateway.common.entity.APIGroup;
import com.illegalaccess.gateway.common.entity.APIInfo;
import com.illegalaccess.gateway.common.entity.APISslKey;
import com.illegalaccess.gateway.common.enums.APIAuthTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class APIService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    Cache<String, APIInfo> apiCache = CacheBuilder.newBuilder()
            .expireAfterWrite(1L, TimeUnit.HOURS)
            .build();

    Cache<Long, Integer> groupCache = CacheBuilder.newBuilder()
            .expireAfterWrite(1L, TimeUnit.HOURS)
            .build();

    Cache<Long, APISslKey> saltCache = CacheBuilder.newBuilder()
            .expireAfterWrite(1L, TimeUnit.HOURS)
            .build();
    /**
     *
     * @param apiKey  是url+version
     * @return
     */
    public APIInfo getAPI(final String apiKey) {
        try {
            return apiCache.get(apiKey, () -> {
                        Object value = stringRedisTemplate.opsForHash().get(APIInfo.tableName, apiKey);
                        APIInfo ai = JSON.parseObject(value.toString(), APIInfo.class);
                        return ai;
                    }
            );
        } catch (ExecutionException e) {
            log.error("get apiInfo fail, key:{}", apiKey, e);
        }
        return null;
    }

    /**
     * 获取 api 组的安全认证类型
     * @param groupId
     * @return
     */
    public Integer getGroupAuthType(Long groupId) {
        try {
            groupCache.get(groupId, () -> {
               Object value = stringRedisTemplate.opsForHash().get(APIGroup.tableName, groupId);
               return Integer.valueOf(value.toString());
            });
        } catch (ExecutionException e) {
            log.error("get group auth type fail, arg:{}, return invalid", groupId, e);
        }
        return APIAuthTypeEnum.Invalid.getAuthType();
    }


    /**
     * 获取 签名的 盐
     * @return
     */
    public APISslKey getSignatureSalt(Long groupId) {
        //TODO
        return null;
    }
}
