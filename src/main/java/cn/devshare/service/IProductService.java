package cn.devshare.service;

import cn.devshare.common.ServerResponse;
import cn.devshare.pojo.Product;
import cn.devshare.vo.ProductDetailVo;
import com.github.pagehelper.PageInfo;

/**
 * Created by cheng on 2017/8/6.
 * Class Description:
 * Another:
 */
public interface IProductService {
    ServerResponse saveOrUpdateProduce(Product product);
    ServerResponse<String> setSaleStatus(Integer productId, Integer status);
    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);
    ServerResponse<PageInfo>getProductList(int pageNum, int pageSize);
    ServerResponse<PageInfo> searchProduct(String productName,Integer productId,int pageNum,int pageSize);
    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);
    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword,Integer categoryId, int pageNum,int pageSize,String orderBy);
}
