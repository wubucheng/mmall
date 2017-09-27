package cn.devshare.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by cheng on 2017/8/10.
 * Class Description:
 * Another:
 */
public class CartVo {

    private List<CartProductVo>cartProductVoList;//购物车中的商品内容,以购物车对象包裹商品
    private BigDecimal cartTotalPrice;
    private Boolean isAllChecked;//是否全选
    private String imageHost;

    public List<CartProductVo> getCartProductVoList() {
        return cartProductVoList;
    }

    public void setCartProductVoList(List<CartProductVo> cartProductVoList) {
        this.cartProductVoList = cartProductVoList;
    }

    public BigDecimal getCartTotalPrice() {
        return cartTotalPrice;
    }

    public void setCartTotalPrice(BigDecimal cartTotalPrice) {
        this.cartTotalPrice = cartTotalPrice;
    }

    public Boolean getAllChecked() {
        return isAllChecked;
    }

    public void setAllChecked(Boolean allChecked) {
        isAllChecked = allChecked;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }
}
