package com.example.oembed.preview.pojo;

import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Getter
@Setter
public class VideoUrl {
    private final URL url;
    private String oembedEndPoint;

    public VideoUrl(URL url) {
        this.url = url;
    }

    public static VideoUrl of(URL url) {
        return new VideoUrl(url);
    }

    public boolean isYoutube() {
        return url.getHost().contains("youtube");
    }

    public boolean isTwitter() {
        return url.getHost().contains("twitter");
    }

    public boolean isInstagram() {
        return url.getHost().contains("instagram");
    }

    public boolean isVimeo() {
        return url.getHost().contains("vimeo");
    }

    public String toOembedUrl() {
        return oembedEndPoint + "?url=" + url.toString();
    }
}