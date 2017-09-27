package cn.devshare.service.impl;

import cn.devshare.service.IFileService;
import cn.devshare.util.FTPUtil;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by cheng on 2017/8/8.
 * Class Description:
 * Another:
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService{
    private Logger logger= LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public String upload(MultipartFile file, String path) {
        String fileName=file.getOriginalFilename();//获取文件原始名(包含扩展名)
        String fileExtenstionName=fileName.substring(fileName.lastIndexOf("."+1));
        String uploadFileName= UUID.randomUUID().toString()+"."+fileExtenstionName;//处理后的文件上传后 的名字

        logger.info("开始上传文件,上传文件的文件名:{},上传的路径:{},新文件名:{}",fileName,path,uploadFileName);

        File fileDir=new File(path);
        if(!fileDir.exists()){//判断路径是否存在
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile=new File(path,uploadFileName);//创建上传的临时文件

        try {
            file.transferTo(targetFile);//传输

            FTPUtil.uploadFile(Lists.<File>newArrayList(targetFile));

            targetFile.delete();//上传成功后，删除临时表文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        return targetFile.getName();//返回文件名
    }
}
