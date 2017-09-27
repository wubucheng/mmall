package cn.devshare.common;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by cheng on 2017/8/4.
 * Class Description:Token缓存管理
 * Another:
 */
public class TokenCache {
    private static Logger logger= LoggerFactory.getLogger(TokenCache.class);
    public static final String TOKEN_PREFIX="token_";//token前缀

    //LRU算法,设置初始容量为1000，最大为10000，生存周期为12小时
    private static LoadingCache<String,String> localCache= CacheBuilder.newBuilder()
            .initialCapacity(1000).maximumSize(10000)
            .expireAfterAccess(12, TimeUnit.HOURS)
            .build(new CacheLoader<String, String>() {
                //默认的数据加载实现,当调用get取值的时候,如果key没有对应的值,就调用这个方法进行加载.
                @Override
                public String load(String s) throws Exception {
                    return "null";
                }
            });

    public static void setKey(String key,String value){
        localCache.put(key,value);
    }

    public static String getKey(String key){
        String value=null;
        try {
            value=localCache.get(key);
            if("null".equals(value)){
                return null;
            }
            return value;
        } catch (ExecutionException e) {
            logger.error("localCache get error",e);
        }
        return null;
    }


}
