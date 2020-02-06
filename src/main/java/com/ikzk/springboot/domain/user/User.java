package com.ikzk.springboot.domain.user;

import com.ikzk.springboot.domain.BaseTimeEntity;

import javax.persistence.*;

@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User() {
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPicture() {
        return this.picture;
    }

    public Role getRole() {
        return this.role;
    }

    public static class UserBuilder {
        private String name;
        private String email;
        private String picture;
        private Role role;

        UserBuilder() {
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder picture(String picture) {
            this.picture = picture;
            return this;
        }

        public UserBuilder role(Role role) {
            this.role = role;
            return this;
        }

        public User build() {
            return new User(name, email, picture, role);
        }

        public String toString() {
            return "User.UserBuilder(name=" + this.name + ", email=" + this.email + ", picture=" + this.picture + ", role=" + this.role + ")";
        }
    }
}
