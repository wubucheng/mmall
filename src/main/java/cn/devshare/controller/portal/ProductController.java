package cn.devshare.controller.portal;

import cn.devshare.common.ServerResponse;
import cn.devshare.service.IProductService;
import cn.devshare.vo.ProductDetailVo;
import com.github.pagehelper.PageInfo;
import net.sf.jsqlparser.schema.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.directory.SearchResult;

/**
 * Created by cheng on 2017/8/9.
 * Class Description:
 * Another:
 */

@Controller
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    //前台获取商品详情
    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse<ProductDetailVo>detail(Integer productID){
        return iProductService.getProductDetail(productID);
    }

    //搜索商品
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<PageInfo>list(@RequestParam(value = "keyword" ,required = false)String keyword,
                                        @RequestParam(value ="categoryId",required=false )Integer categoryId,
                                        @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                        @RequestParam(value = "pageSize" ,defaultValue = "10")int pageSize,
                                        @RequestParam(value = "orderBy",defaultValue = "") String orderBy){
        return iProductService. getProductByKeywordCategory(keyword,categoryId, pageNum,pageSize, orderBy);
    }
}
