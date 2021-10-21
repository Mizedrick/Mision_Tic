/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.service;

import com.bike.model.Admin;
import com.bike.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Misael
 */
@Service
public class AdminService {
    @Autowired
    private AdminRepository metodosCrud;

    public List<Admin> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Admin> getAdmin(int adminId) {
        return metodosCrud.getAdmin(adminId);
    }

    public Admin save(Admin admin) {
        if (admin.getIdAdmin() == null) {
            return metodosCrud.save(admin);
        } else {
            Optional<Admin> admin1 = metodosCrud.getAdmin(admin.getIdAdmin());
            if (admin1.isEmpty()) {
                return metodosCrud.save(admin);
            } else {
                return admin;
            }
        }
    }
}
