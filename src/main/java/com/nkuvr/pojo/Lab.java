package com.nkuvr.pojo;

/**
 * @Author: weizujie
 * @Date: 2020/4/25
 * @Version: 1.0
 * @Github: https://github.com/weizujie
 */
public class Lab {

    private Long id;

    private String name;

    private Integer galleryful;

    public Lab() {
    }

    public Lab(String name, Integer galleryful) {
        this.name = name;
        this.galleryful = galleryful;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGalleryful() {
        return galleryful;
    }

    public void setGalleryful(Integer galleryful) {
        this.galleryful = galleryful;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", galleryful=" + galleryful +
                '}';
    }
}
