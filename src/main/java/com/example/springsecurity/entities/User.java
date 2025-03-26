package com.example.springsecurity.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstname;
    private String secondname;
    private String email;
    private String password;
    private Role role;

    //getAuthorities(): ส่งคืนสิทธิ์ของผู้ใช้ (เช่น ROLE_USER, ROLE_ADMIN) ในรูปแบบของ GrantedAuthority
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    //ส่งคืนชื่อผู้ใช้ (ในที่นี้ใช้อีเมล)
    @Override
    public String getUsername() {
        return email;
    }

    // ตรวจสอบว่าบัญชีหมดอายุหรือไม่ (ในที่นี้คืนค่า true คือไม่หมดอายุ)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // ตรวจสอบว่าบัญชีถูกล็อคหรือไม่ (ในที่นี้คืนค่า true คือไม่ถูกล็อค)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // ตรวจสอบว่ารหัสผ่านหมดอายุหรือไม่ (ในที่นี้คืนค่า true คือไม่หมดอายุ)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //ตรวจสอบว่าบัญชีเปิดใช้งานหรือไม่ (ในที่นี้คืนค่า true คือเปิดใช้งาน)
    @Override
    public boolean isEnabled() {
        return true;
    }
}
