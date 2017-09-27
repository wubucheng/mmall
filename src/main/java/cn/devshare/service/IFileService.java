package cn.devshare.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by cheng on 2017/8/8.
 * Class Description:
 * Another:
 */
public interface IFileService {
    String upload(MultipartFile file, String path);
}
