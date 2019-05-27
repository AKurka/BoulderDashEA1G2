package entity;

import java.io.InputStream;

public class Mapping {

    private int id;

    private String path;

    public Mapping(final int id, final String path){
        this.setId(id);
        this.setPath(path);
    }

    public Mapping(){
        this(0,"");
    }

    public int getId(){
        return this.id;
    }

    public void setId(final int id){
        this.id = id;
    }

    public String getPath(){
        return path;
    }

    public void setPath(final String path){
        this.path = path;
    }
}
