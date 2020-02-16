package io.github.alishrf.travel_website.model;


import javax.persistence.*;

@Entity
@Table(name = "image_logo")
public class ImageLogoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;

    @Lob
    @Column(name = "logo")
    private byte[] bytes;

    @Column(name = "path")
    private String path;

    public ImageLogoEntity() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
