package com.zhiyou100.zy_video.model;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.zhiyou100.zy_video.utils.MD5Utils;

public class User {
    private Integer id;

    private String nickName;

    private Integer sex;
   
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    private String email;

    private String province;

    private String city;

    private String headUrl;

    private String password;
    
    private String oldPassword;
    
    private String newPassword;
   
    public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword == null ? null : MD5Utils.getMD5(oldPassword.trim());
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword == null ? null : MD5Utils.getMD5(newPassword.trim());
	}

	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date insertTime;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updateTime;

    private String captcha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl == null ? null : headUrl.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : MD5Utils.getMD5(password.trim());
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime == null ? new Timestamp(System.currentTimeMillis()):updateTime;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha == null ? null : captcha.trim();
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", nickName=" + nickName + ", sex=" + sex + ", birthday=" + birthday + ", email="
				+ email + ", province=" + province + ", city=" + city + ", headUrl=" + headUrl + ", password="
				+ password + ", oldPassword=" + oldPassword + ", newPassword=" + newPassword + ", insertTime="
				+ insertTime + ", updateTime=" + updateTime + ", captcha=" + captcha + "]";
	}
    
}