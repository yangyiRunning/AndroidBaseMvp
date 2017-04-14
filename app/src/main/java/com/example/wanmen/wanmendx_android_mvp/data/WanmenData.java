package com.example.wanmen.wanmendx_android_mvp.data;

import java.io.Serializable;

/**
 * Created by yangyi on 2017/4/13.
 */

public class WanmenData implements Serializable {


    /**
     * _id : 58ae9d6986ccec1959e1fdb6
     * deletedAt : null
     * deleted : false
     * createdAt : 2017-02-23T08:29:29.846Z
     * updatedAt : 2017-02-23T08:30:09.630Z
     * course : {"name":"法语初级基础","description":"本课程通过对法国文化的介绍学习法语，针对法语水平是A2的朋友们。课程涉及的内容广泛，从在法国的生活到世界地理，可谓是博大精深。每课都以一段还原现实生活场景的对话开始，对话含有丰富的语言点，老师会详细的讲解语法。","teacherName":"Alexis Martin","smallImageUrl":"http://imgs.wanmen.org/c87e053b66ddf9826257901a3008bc8f.png","bigImageUrl":"http://imgs.wanmen.org/ebdbf8a6c9e6672e61856f38870bb9a6.png","smallMobileImageUrl":"http://img.wanmen.org/images/e7bb4f52-6c83-4204-9104-d84702975930.jpeg","id":"586d23485f07127674135d10"}
     * order : 3
     * app : uni
     * type : tv-new
     */

    private String _id;
    private Object deletedAt;
    private boolean deleted;
    private String createdAt;
    private String updatedAt;
    private CourseBean course;
    private int order;
    private String app;
    private String type;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public CourseBean getCourse() {
        return course;
    }

    public void setCourse(CourseBean course) {
        this.course = course;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class CourseBean {
        /**
         * name : 法语初级基础
         * description : 本课程通过对法国文化的介绍学习法语，针对法语水平是A2的朋友们。课程涉及的内容广泛，从在法国的生活到世界地理，可谓是博大精深。每课都以一段还原现实生活场景的对话开始，对话含有丰富的语言点，老师会详细的讲解语法。
         * teacherName : Alexis Martin
         * smallImageUrl : http://imgs.wanmen.org/c87e053b66ddf9826257901a3008bc8f.png
         * bigImageUrl : http://imgs.wanmen.org/ebdbf8a6c9e6672e61856f38870bb9a6.png
         * smallMobileImageUrl : http://img.wanmen.org/images/e7bb4f52-6c83-4204-9104-d84702975930.jpeg
         * id : 586d23485f07127674135d10
         */

        private String name;
        private String description;
        private String teacherName;
        private String smallImageUrl;
        private String bigImageUrl;
        private String smallMobileImageUrl;
        private String id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTeacherName() {
            return teacherName;
        }

        public void setTeacherName(String teacherName) {
            this.teacherName = teacherName;
        }

        public String getSmallImageUrl() {
            return smallImageUrl;
        }

        public void setSmallImageUrl(String smallImageUrl) {
            this.smallImageUrl = smallImageUrl;
        }

        public String getBigImageUrl() {
            return bigImageUrl;
        }

        public void setBigImageUrl(String bigImageUrl) {
            this.bigImageUrl = bigImageUrl;
        }

        public String getSmallMobileImageUrl() {
            return smallMobileImageUrl;
        }

        public void setSmallMobileImageUrl(String smallMobileImageUrl) {
            this.smallMobileImageUrl = smallMobileImageUrl;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
