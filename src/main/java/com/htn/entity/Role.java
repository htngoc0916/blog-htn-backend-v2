package com.htn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ROLE_CODE")
    private String roleCode;
    @Column(name = "ROLE_NAME")
    private String roleName;
    @Column(name = "ROLE_DES")
    private String roleDes;
    @Column(name = "ROLE_ICON")
    private String roleIcon;
}
