package cn.devshare.service.impl;

import cn.devshare.common.ServerResponse;
import cn.devshare.dao.ShippingMapper;
import cn.devshare.pojo.Shipping;
import cn.devshare.service.IShippingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by cheng on 2017/8/17.
 * Class Description:收件信息Server
 * Another:
 */
@Service("iShippingService")
public class ShippingServiceImpl implements IShippingService {

   @Autowired
   private ShippingMapper shippingMapper;

    @Override
    public ServerResponse add(Integer userId, Shipping shipping) {
        shipping.setUserId(userId);//传过来的shipping对象没有userId的值，需另外赋值
        int rowCount=shippingMapper.insert(shipping);
        if (rowCount>0){
            Map result=Maps.newHashMap();
            result.put("shippingId",shipping.getId());//返回给前端的ID
            return ServerResponse.createBySuccess("新建地址成功",result);
        }
        return ServerResponse.createByErrorMessage("新建地址失败");
    }


    public ServerResponse del(Integer userId,Integer shippingId){
        int rowCount=shippingMapper.deleteByShippingIdUserId(userId,shippingId);
        if(rowCount>0){
            return ServerResponse.createBySuccess("删除地址成功");
        }
        return ServerResponse.createByErrorMessage("删除地址失败");
    }

    public ServerResponse update(Integer userId, Shipping shipping){
        shipping.setUserId(userId);
        int rowCount=shippingMapper.updateByShipping(shipping);
        if(rowCount > 0){
            return ServerResponse.createBySuccess("更新地址成功");
        }
        return ServerResponse.createByErrorMessage("更新地址失败");
    }


    public ServerResponse<Shipping>select(Integer userId,Integer shippingId){
        Shipping shipping = shippingMapper.selectByShippingIdUserId(userId,shippingId);
        if(shipping == null){
            return ServerResponse.createByErrorMessage("无法查询到该地址");
        }
        return ServerResponse.createBySuccess("查询地址成功",shipping);
    }

    //获取列表
    public ServerResponse<PageInfo>getList(Integer userId,int pageNum,int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Shipping>shippingList=shippingMapper.selectByUserId(userId);
        PageInfo pageInfo=new PageInfo(shippingList);
        return ServerResponse.createBySuccess(pageInfo);
    }
}
