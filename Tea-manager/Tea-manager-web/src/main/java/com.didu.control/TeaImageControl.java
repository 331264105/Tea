package com.didu.control;

import com.didu.domain.TeaImage;
import com.didu.domain.Tealist;
import com.didu.service.TeaImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/10/17.
 */
@Controller
@Scope("prototype")
public class TeaImageControl {
    @Autowired
    private TeaImageService teaImageService;
    @ModelAttribute("dir")
    public File pre(HttpServletRequest request) {
        File dir = new File(new File(request.getServletContext().getRealPath("/")), "TeaImage");
        // 验证文件夹是否存在，不存在就新建
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }
    @RequestMapping("/upTeaCarousel")
    @ResponseBody
    public String upTeaCarousel(@RequestParam(name = "files", required = false) CommonsMultipartFile[] files, @ModelAttribute(value = "dir") File dir
            ,TeaImage teaImage)throws IOException{
            boolean u = upImage(files,dir,teaImage);
        if (u){
            teaImage.setCid(2);
            teaImage.setPid(1001);
            boolean t = teaImageService.addTeaCarousel(teaImage);
            return "true";
        }else{
            return "false";
        }
    }
    //查找单个茶详情
    @RequestMapping("/selectTeaImage")
    @ResponseBody
    public TeaImage selectTeaDitails(int id){
        TeaImage teaImage = teaImageService.selectTeaImage(id);
        System.out.println(teaImage);
        return teaImage;
    }
    //删除图片
    @RequestMapping("/removeTeaImage")
    public String removeTeaDitails(int id){
        TeaImage tealist1 = teaImageService.selectTeaImage(id);
        if(tealist1!=null){
            String url = tealist1.getUrl();
            File file = new File(url);
            file.delete();
            System.out.println("图片已经删除！");
            boolean b =teaImageService.removeTeaImage(id);
            System.out.println(b+"数据库已经删除");
            return "true";
        }else{
            return "false";
        }
    }
    //更新茶详情
    @RequestMapping("/updateTeaImage")
    public String updateTeaDitails(TeaImage tealist,@RequestParam(name = "files", required = false) CommonsMultipartFile[] files, @ModelAttribute(value = "dir") File dir)throws IOException{
//        int id = (int)request.getAttribute("id");
        TeaImage tealist1 = teaImageService.selectTeaImage(1);
        String url = tealist1.getUrl();
        File file = new File(url);
        file.delete();
        upImage(files,dir,tealist);
        tealist.setId(1);
        System.out.println(teaImageService.updateTeaImage(tealist));
        return "Tea";
    }



    //图片上传
    public static boolean upImage(CommonsMultipartFile[] files,File dir,TeaImage teaImage) throws IOException {

        for (int i = 0; i < files.length; i++) {
            System.out.print(files[i]);
            if (!files[i].isEmpty() && files[i].getSize() > 0) {
                // 获取上传的文件的名称
                String fileName = files[i].getOriginalFilename();
                String name =System.currentTimeMillis()+"_"+fileName;
                teaImage.setUrl(dir.toString()+File.separator+name);
                if (fileName.endsWith(".jpg") || fileName.endsWith(".png")) {
                    // 设置文件存储位置--->当前项目的平级目录下
                    // 限制文件名称最长位50，若超出截取后面部分
                    if (fileName.length() > 50) {
                        fileName = fileName.substring(fileName.length() - 51);
                    }
                    File file1 = new File(dir,name);
                    files[i].transferTo(file1);
                    return true;
                }
            }
        }
        return false;
    }
}

