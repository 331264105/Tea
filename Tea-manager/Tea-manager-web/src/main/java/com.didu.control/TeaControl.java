package com.didu.control;

import com.didu.domain.Tea;
import com.didu.service.TeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/10/13.
 */
@Controller
@Scope("prototype")
public class TeaControl {
    @Autowired
    private TeaService teaservice;


    //茶类型图片的路径工具
    @ModelAttribute("dir")
    public File pre(HttpServletRequest request) {
        File dir = new File(new File(request.getServletContext().getRealPath("/")), "TeaImage");
        // 验证文件夹是否存在，不存在就新建
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }

    //上传茶类型的图片
    @RequestMapping("/TeaTypeImageUp")
    public String addVideo(@RequestParam(name = "files", required = false) CommonsMultipartFile[] files, @ModelAttribute(value = "dir") File dir
            ,Model model,Tea teaType) throws IOException {
        upImage(files,dir,teaType);
        teaservice.addImage(teaType);
        return "upImage";
    }
    //@RequestMapping("/addTea")
    public static boolean upImage(CommonsMultipartFile[] files,File dir,Tea teaType) throws IOException {

        for (int i = 0; i < files.length; i++) {
            System.out.print(files[i]);
            if (!files[i].isEmpty() && files[i].getSize() > 0) {
                // 获取上传的文件的名称
                String fileName = files[i].getOriginalFilename();
                teaType.setUrl(dir.toString()+File.separator+fileName);
                if (fileName.endsWith(".jpg") || fileName.endsWith(".png")) {
                    // 设置文件存储位置--->当前项目的平级目录下
                    // 限制文件名称最长位50，若超出截取后面部分

                    if (fileName.length() > 50) {
                        fileName = fileName.substring(fileName.length() - 51);
                    }
                    File file1 = new File(dir, System.currentTimeMillis() +"_"+ fileName);
                    files[i].transferTo(file1);
                    return true;
                }
            }
        }
        return false;
    }
}
