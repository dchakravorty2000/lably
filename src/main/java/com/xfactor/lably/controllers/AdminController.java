package com.xfactor.lably.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.xfactor.lably.entity.Admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")

public class AdminController {

    ArrayList<Admin> admins = new ArrayList<>();

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping("/getadmins")
    public ArrayList<Admin> getadmin() {
        return admins;
    }

    @PostMapping("/addadmin")
    public Admin addadmin(@RequestBody Admin admin) {
        String name = admin.getName();

        admin.setName(name);

        String username = admin.getUsername();
        admin.setUsername(username);

        String password = admin.getPassword();
        admin.setPassword(password);
        admins.add(admin);
        return admin;
    }

    @GetMapping("/showadmins")
    public Admin showadmin(@RequestParam Admin name) {
        for(Admin l:admins){
            if(name.equals(l.getUsername())==true){
                return l;
            }
            return null;
        }
        return name;
    }
}