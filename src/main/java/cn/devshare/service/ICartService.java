package cn.devshare.service;

import cn.devshare.common.ServerResponse;
import cn.devshare.vo.CartVo;

/**
 * Created by cheng on 2017/8/10.
 * Class Description:
 * Another:
 */
public interface ICartService {
    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);

    ServerResponse<CartVo> getList(Integer userId);

    ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count);

    ServerResponse<CartVo> deleteProduct(Integer userId, String productIds);

    ServerResponse<CartVo> selectOrUnSelect(Integer userId, Integer productId, Integer checked);

    ServerResponse<Integer> getCartProductCount(Integer userId);
}
