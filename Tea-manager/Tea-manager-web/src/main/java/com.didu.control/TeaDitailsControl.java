package com.didu.control;

import com.didu.domain.Tea;
import com.didu.domain.Tealist;
import com.didu.service.TeaDitailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/10/16.
 */
@Controller
@Scope("prototype")
public class TeaDitailsControl {
    @Autowired
    private TeaDitailsService teaDitailsService;

    @ModelAttribute("dir")
    public File pre(HttpServletRequest request) {
        File dir = new File(new File(request.getServletContext().getRealPath("/")), "TeaDitailsImage");
        // 验证文件夹是否存在，不存在就新建
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }
    //添加茶详情
    @RequestMapping("/addTeaDitails")
    @ResponseBody
    public HashMap<String,String> addTeaDitails(@RequestParam(name = "files", required = false) CommonsMultipartFile[] files, @ModelAttribute(value = "dir") File dir
            ,Tealist tealist) throws IOException{
        boolean b = upImage(files,dir,tealist);
        HashMap<String,String> map = new HashMap();
        if(b){
            boolean t = teaDitailsService.addTeaDitails(tealist);
            map.put("success","true");
            int tea = teaDitailsService.selectTeaId();
            map.put("id",tea+"");
            return map;
        }else {
            map.put("success","false");
            map.put("id","null");
            return map;
        }
    }
    //删除茶详情
    @RequestMapping("/removeTeaDitails")
    public String removeTeaDitails(int id){
        Tealist tealist1 = teaDitailsService.selectTeaDitails(id);
        if(tealist1!=null){
            String url = tealist1.getUrl();
            File file = new File(url);
            file.delete();
            System.out.println("图片已经删除！");
        }
       boolean b =teaDitailsService.removeTeaDitails(id);
        System.out.println(b+"数据库已经删除");
        return "null";
    }
    //查找单个茶详情
    @RequestMapping("/selectTeaDitails")
    @ResponseBody
    public Tealist selectTeaDitails(int id,HttpServletRequest request){
        request.setAttribute("id",id);
        System.out.println(id);
        Tealist tlist = teaDitailsService.selectTeaDitails(id);
        System.out.println(tlist);
        return tlist;
    }
    //更新茶详情
    @RequestMapping("/updateTeaDitails")
    public String updateTeaDitails(Tealist tealist,@RequestParam(name = "files", required = false) CommonsMultipartFile[] files, @ModelAttribute(value = "dir") File dir,HttpServletRequest request)throws IOException{
//        int id = (int)request.getAttribute("id");
        Tealist tealist1 = teaDitailsService.selectTeaDitails(2);
        String url = tealist1.getUrl();
        File file = new File(url);
        file.delete();
        upImage(files,dir,tealist);
        tealist.setId(2);
        System.out.println(teaDitailsService.updateTeaDitails(tealist));
        return "Tea";
    }
    //查询所有茶详情
    @RequestMapping("/selectAllTea")
    @ResponseBody
    public List<Tea> selectAllTea(){
        List<Tea> cidlist = teaDitailsService.selectTea();
        for(Tea l:cidlist){
            int cid = l.getCid();
            List<Tealist> tealists = teaDitailsService.selectTealist(cid);
            l.setTealist(tealists);
            System.out.println(l);
        }
        return cidlist;
    }



    //图片上传
    public static boolean upImage(CommonsMultipartFile[] files,File dir,Tealist tealist) throws IOException {

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
