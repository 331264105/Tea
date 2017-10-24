package com.didu.control;

import com.didu.domain.Admin;
import com.didu.service.AdminService;
import com.didu.service.TeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/10/23.
 */
@Controller
@Scope("prototype")
public class AdminControl {
    @Autowired
    private AdminService adminService;
@RequestMapping("/login")
@ResponseBody
public String login(Admin admin,HttpServletRequest request){
    Admin u= adminService.login(admin);
    if (u==null){
        return "false";
    }else{
        if((u.getUsername()).equals(admin.getUsername())&&(u.getPassword()).equals(admin.getPassword())&&(u.getNum()).equals(admin.getNum())){
            request.setAttribute("admin",u);
            return "true";
        }else{
            return "false";
        }
    }
}


}
