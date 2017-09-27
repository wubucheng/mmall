package cn.devshare.service;

import cn.devshare.common.ServerResponse;
import cn.devshare.pojo.Shipping;
import com.github.pagehelper.PageInfo;

/**
 * Created by cheng on 2017/8/17.
 * Class Description:
 * Another:
 */
public interface IShippingService {
    ServerResponse add(Integer userId, Shipping shipping);
    ServerResponse<String> del(Integer userId,Integer shippingId);
    ServerResponse update(Integer userId, Shipping shipping);
    ServerResponse<Shipping> select(Integer userId, Integer shippingId);
    ServerResponse<PageInfo> getList(Integer userId, int pageNum, int pageSize);
}
