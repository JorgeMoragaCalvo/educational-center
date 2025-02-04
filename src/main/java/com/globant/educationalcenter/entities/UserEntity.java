package com.globant.educationalcenter.entities;

import com.globant.educationalcenter.auditories.Audit;
import com.globant.educationalcenter.roles.Role;
import jakarta.persistence.*;
import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Builder
public class UserEntity extends Audit implements Principal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String rut;
    private String email;
    private String password;
    private boolean active = true;
    private boolean accountLocked;
    private boolean enabled = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @Override
    public String getName(){
        return email;
    }

//    public Collection<? extends GrantedAuthority> getAuthorities(){
//        return this.roles
//                .stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
//                .collect(Collectors.toSet());
//    }

//    @Override
//    public String getPassword(){
//        return password;
//    }
//
//    @Override
//    public String getUsername(){
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired(){
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked(){
//        return !accountLocked;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired(){
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled(){
//        return enabled;
//    }

    public String fullName(){
        return firstname + " " + lastname;
    }
}
