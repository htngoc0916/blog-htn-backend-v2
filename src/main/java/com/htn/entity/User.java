package com.htn.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Builder
public class User extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "USER_NAME",nullable = false)
    private String userName;
    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;
    @Column(name = "AVATAR")
    private String avatar;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "LAST_LOGIN_DT")
    private Date lastLoginDt;
    @Column(name = "SSO_ID")
    private String ssoId;
    @Column(name = "LOGIN_TYPE")
    private String loginType;
    @Column(name = "VERIFY_YN")
    private String verifyYn;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = "VERIFY_DT")
    private Date verifyDt;
    @Column(name = "VERIFY_CODE")
    private String verifyCode;
    @Column(name = "EMAIL_SEND_YN")
    private String emailSendYn;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = "EMAIL_SEND_DT")
    private Date emailSendDt;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "ID")
    )
    private List<Role> roles;
}
