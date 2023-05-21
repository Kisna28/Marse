package com.example.marse;

public class ImagesResponse {
    private int id;
    private String img_src;

    public ImagesResponse(int id, String img_src) {
        this.id = id;
        this.img_src = img_src;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }
}
