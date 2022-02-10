package com.example.oembed.preview.service;

import java.util.Map;

public interface PreviewService {
    Map<String, Object> getPreview(String url);
    String getHello();
}
