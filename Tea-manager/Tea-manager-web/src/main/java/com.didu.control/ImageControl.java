package com.didu.control;

import com.didu.domain.Image;
import com.didu.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/10/11.
 */
@Controller
@Scope("prototype")
public class ImageControl {
    @Autowired
    private ImageService imageservice;
    //图片的路径工具
    @ModelAttribute("dir")
    public File pre(HttpServletRequest request) {
        File dir = new File(new File(request.getServletContext().getRealPath("/")), "Image");
        // 验证文件夹是否存在，不存在就新建
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }
    //动态路径
    @RequestMapping("{jn}")
    public String t1(@PathVariable String jn){
        System.out.print(jn);
        return jn;
    }
    //上传图片
    @RequestMapping("/ImageUp")
    public String addVideo(@RequestParam(name = "files", required = false) CommonsMultipartFile[] files, @ModelAttribute(value = "dir") File dir
            , Image picture) throws IOException{
        /*List<String> list = new ArrayList<String>();
        list.add(".JPG");
        list.add(".PNG");
        list.add(".MP4");
        list.add(".JPEG");*/
        for (int i = 0; i < files.length; i++) {

            if (!files[i].isEmpty() && files[i].getSize() > 0) {
                // 获取上传的文件的名称
                String fileName = files[i].getOriginalFilename();
                if (fileName.endsWith(".jpg") || fileName.endsWith(".png")) {
                    // 设置文件存储位置--->当前项目的平级目录下
                    // 限制文件名称最长位50，若超出截取后面部分

                    if (fileName.length() > 50) {
                        fileName = fileName.substring(fileName.length() - 51);
                    }
                    File file1 = new File(dir, System.currentTimeMillis() +"_"+ fileName);
                    files[i].transferTo(file1);
                    picture.setName(file1.getName());
                    picture.setPath(dir.toString()+File.separator+file1.getName());
                    System.out.println(imageservice.addImage(picture));
                }
            }
        }
        return "upImage";
    }
    //查看轮播图片
   @RequestMapping("/queryImage")
   @ResponseBody
    public List<Image> query(){
         List<Image> list = imageservice.query();
        /* for(Image l:list){
             SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String date = l.getCreatetime();
             String s = format.format(date);
             l.setCreatetime(s);
         }*/
         System.out.println(list.toString());
      /*   List<String> list = new ArrayList<>();
       for (Image l:image){
           String path = l.getPath();
           String name = l.getName();
           String realpath = path+name;
           list.add(realpath);
       }*/
         return list;
    }
    //删除图片
    @RequestMapping("/removeImage")
    @ResponseBody
    public String removeImage(int id){
            Image image = imageservice.queryI(id);
        if(imageservice.removeImage(id)){
            String ipath = image.getPath();
            File file =  new File(ipath);
            file.delete();
            return "true";
        }else {
            return "false";
        }
    }
    @RequestMapping("/updateImage")
    @ResponseBody
    public void updateImage(@RequestParam(name = "files", required = false) CommonsMultipartFile[] files, @ModelAttribute(value = "dir") File dir
            , Image picture) throws IOException {
        for (int i = 0; i < files.length; i++) {
            if (!files[i].isEmpty() && files[i].getSize() > 0) {
                // 获取上传的文件的名称
                String fileName = files[i].getOriginalFilename();
                if (fileName.endsWith(".jpg") || fileName.endsWith(".png")) {
                    // 设置文件存储位置--->当前项目的平级目录下
                    // 限制文件名称最长位50，若超出截取后面部分

                    if (fileName.length() > 50) {
                        fileName = fileName.substring(fileName.length() - 51);
                    }
                    File file1 = new File(dir, System.currentTimeMillis() +"_"+ fileName);
                    files[i].transferTo(file1);
                    picture.setName(file1.getName());
                    picture.setPath(dir.toString()+File.separator+file1.getName());
                    System.out.println(imageservice.updateImage(picture));
                }
            }
        }
    }
}
