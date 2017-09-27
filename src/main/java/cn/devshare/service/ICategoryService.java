package cn.devshare.service;

import cn.devshare.common.ServerResponse;
import cn.devshare.pojo.Category;

import java.util.List;

/**
 * Created by cheng on 2017/8/5.
 * Class Description:
 * Another:
 */
public interface ICategoryService {
    ServerResponse addCategory(String categoryName, Integer parentId);
    ServerResponse updateCategoryName(Integer categoryId,String categoryName);
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);
    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);
}
