package com.example.oembed.preview.service;

import com.example.oembed.global.error.ErrorCode;
import com.example.oembed.global.error.exceptions.InvalidInputException;
import com.example.oembed.preview.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class PreviewServiceImpl implements PreviewService {
    public Map<String, Object> getPreview(String urlRequest) {
        URL url = null;

        try {
            url = new URL(urlRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (url == null) {
            throw new InvalidInputException(ErrorCode.INVALID_URL_FORM);
        }

        VideoUrl videoUrl = VideoUrl.of(url);
        if (videoUrl.isYoutube()) {
            videoUrl.setOembedEndPoint("https://youtube.com/oembed");
        } else if (videoUrl.isTwitter()) {
            videoUrl.setOembedEndPoint("https://publish.twitter.com/oembed");
        } else if (videoUrl.isVimeo()) {
            videoUrl.setOembedEndPoint("https://vimeo.com/api/oembed.json");
        } else {
            videoUrl.setOembedEndPoint("");
        }

        if (videoUrl.getOembedEndPoint().isEmpty()) {
            throw new InvalidInputException(ErrorCode.UNSUPPORTED_PLATFORM);
        }

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(videoUrl.toOembedUrl(), HashMap.class);
    }

    public String getHello() {
        return "Hello";
    }
}
