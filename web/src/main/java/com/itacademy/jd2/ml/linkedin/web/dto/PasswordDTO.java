package com.itacademy.jd2.ml.linkedin.web.dto;

import org.hibernate.validator.constraints.Length;

public class PasswordDTO {

    @Length.List({
            @Length(min = 4, message = "The field must be at least 4 characters"),
            @Length(max = 20, message = "The field must be less than 20 characters")
    })
    private String oldPassword;
    @Length.List({
            @Length(min = 4, message = "The field must be at least 4 characters"),
            @Length(max = 20, message = "The field must be less than 20 characters")
    })
    private String newPassword;
    @Length.List({
            @Length(min = 4, message = "The field must be at least 4 characters"),
            @Length(max = 20, message = "The field must be less than 20 characters")
    })
    private String confirmPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
