package id.ac.umn.uts_38118_abdulghofaralhasyim;

import android.net.Uri;

import java.io.Serializable;

public class SourceVideo implements Serializable {
    private String title, description, videoURI;
    public SourceVideo(String title, String description, String videoURI){
        this.title = title;
        this.description = description;
        this.videoURI = videoURI;
    }
    public String getTitle(){return this.title;}
    public String getDescription(){return this.description;}
    public Uri getVideoURI(){return Uri.parse(this.videoURI);}
    public void setTitle(String title){this.title = title;}
    public void setVideoURI(String videoURI){this.videoURI = videoURI;}
    public void setDescription(String videoURI){this.description = description;}
    public String toString(){return this.getTitle();}
}
