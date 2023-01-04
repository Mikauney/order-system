package com.yiqin.controller;

import com.yiqin.entity.Admin;
import com.yiqin.entity.User;
import com.yiqin.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private AccountFeign accountFeign;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type, HttpSession session) {
        Object object = accountFeign.login(username, password, type);
        LinkedHashMap<String, Object> hashMap = (LinkedHashMap)object;
        String result = null;
        String idStr = null;
        long id = 0L;
        // If object is not null, then log in succeed, else the username/password is wrong.
        if (object == null) {
            result = "login";
        }else {
            switch (type){
                case "user":
                    User user = new User();
                    // convert int id to string by adding ""
                    idStr = hashMap.get("id") + "";
                    id = Long.parseLong(idStr);
                    String nickname = (String) hashMap.get("nickname");
                    user.setId(id);
                    user.setNickname(nickname);
                    session.setAttribute("user", user);
                    result = "index";
                    break;
                case "admin":
                    Admin admin = new Admin();
                    idStr = hashMap.get("id") + "";
                    id = Long.parseLong(idStr);
                    String username2 = (String)hashMap.get("username");
                    admin.setId(id);
                    admin.setUsername(username2);
                    session.setAttribute("admin", admin);
                    result = "main";
                    break;
            }
        }
        return result;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.html";
    }

}
