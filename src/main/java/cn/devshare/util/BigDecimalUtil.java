package cn.devshare.util;

import java.math.BigDecimal;

/**
 * Created by cheng on 2017/8/10.
 * Class Description:BigDecimal精度工具类
 * Another:为了BigDecimal不丢失精度，所以使用字符构造器
 */
public class BigDecimalUtil {

    public static BigDecimal add(double p1,double p2){
        BigDecimal a=new BigDecimal(Double.toString(p1));
        BigDecimal b=new BigDecimal(Double.toString(p2));
        return a.add(b);
    }

    public static BigDecimal sub(double p1,double p2){
        BigDecimal a=new BigDecimal(Double.toString(p1));
        BigDecimal b=new BigDecimal(Double.toString(p2));
        return a.subtract(b);
    }

    public static BigDecimal mul(double p1,double p2){
        BigDecimal a = new BigDecimal(Double.toString(p1));
        BigDecimal b= new BigDecimal(Double.toString(p2));
        return a.multiply(b);
    }

    public static BigDecimal div(double p1,double p2){
        BigDecimal a = new BigDecimal(Double.toString(p1));
        BigDecimal b = new BigDecimal(Double.toString(p2));
        return a.divide(b,2,BigDecimal.ROUND_HALF_UP);//四舍五入,保留2位小数
    }


}
