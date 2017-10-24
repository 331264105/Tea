package com.didu.control;

import com.didu.domain.TeaNew;
import com.didu.service.TeaNewService;
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
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/10/17.
 */
@Controller
@Scope("prototype")
public class TeaNewControl {
    @Autowired
    private TeaNewService teaNewService;
    @ModelAttribute("dir")
    public File pre(HttpServletRequest request) {
        File dir = new File(new File(request.getServletContext().getRealPath("/")), "TeaDitailsImage");
        // 验证文件夹是否存在，不存在就新建
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }
    //添加茶新闻
    @RequestMapping("/addTeaNew")
    @ResponseBody
    public String addTeaDitails(@RequestParam(name = "files", required = false) CommonsMultipartFile[] files, @ModelAttribute(value = "dir") File dir
            ,TeaNew tealist) throws IOException {
        boolean b = upImage(files,dir,tealist);
        if (b){
            boolean ba = teaNewService.addTeaNew(tealist);
            if (ba){
                return "true";
            }else{
                return "false";
            }
        }
        return "false";
    }
    //查找单个茶新闻
    @RequestMapping("/selectTeaNew")
    @ResponseBody
    public TeaNew selectTeaDitails(int id,HttpServletRequest request){
        request.setAttribute("id",id);
        System.out.println(id);
        TeaNew tlist = teaNewService.selectTeaNew(id);
        System.out.println(tlist);
        return tlist;
    }
    //删除茶新闻
    @RequestMapping("/removeTeaNew")
    @ResponseBody
    public String removeTeaDitails(int id){
        TeaNew tealist1 = teaNewService.selectTeaNew(id);
        if(tealist1!=null){
            String url = tealist1.getUrl();
            File file = new File(url);
            file.delete();
            System.out.println("图片已经删除！");
            boolean b =teaNewService.removeTeaNew(id);
            System.out.println(b+"数据库已经删除");
            return  "true";
        }else{
            return "false";
        }
    }
    //修改茶新闻
    @RequestMapping("/updateTeaNew")
    @ResponseBody
    public String updateTeaDitails(TeaNew tealist,@RequestParam(name = "files", required = false) CommonsMultipartFile[] files, @ModelAttribute(value = "dir") File dir
    )throws IOException{
//        int id = (int)request.getAttribute("id");
        TeaNew tealist1 = teaNewService.selectTeaNew(1);
        if (tealist1!=null){
            String url = tealist1.getUrl();
            File file = new File(url);
            file.delete();
            upImage(files,dir,tealist);
            tealist.setId(1);
            boolean b = teaNewService.updateTeaNew(tealist);
            if (b){
                return "true";
            }
            return "false";
        }else{
            return "false";
        }
    }
    //查看所有茶新闻
    @RequestMapping("/selectAllTeaNew")
    @ResponseBody
    public List<TeaNew> selectAllTea(){
        List<TeaNew> list = teaNewService.selectTeaNews();
        if (list.size()!=0){
            return list;
        }else{
            return null;
        }
    }
    //图片上传
    public static boolean upImage(CommonsMultipartFile[] files,File dir,TeaNew tealist) throws IOException {

        for (int i = 0; i < files.length; i++) {
            System.out.print(files[i]);
            if (!files[i].isEmpty() && files[i].getSize() > 0) {
                // 获取上传的文件的名称
                String fileName = files[i].getOriginalFilename();
                String name =System.currentTimeMillis()+"_"+fileName;
                tealist.setUrl(dir.toString()+File.separator+name);
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
