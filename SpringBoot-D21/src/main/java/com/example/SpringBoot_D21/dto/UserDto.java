package com.example.SpringBoot_D21.dto;



    public class UserDto {

        private String name;
        private String email;

        public UserDto() {
        }

        public UserDto(String name, String email) {
            this.name = name;
            this.email = email;
        }

        // Getter & Setter
        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }

