package com.example.oembed.preview.controller;

import com.example.oembed.global.dto.UnitResponse;
import com.example.oembed.preview.service.PreviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/preview")
@RequiredArgsConstructor
public class PreviewController {
    private final PreviewService previewService;

    @GetMapping("")
    public UnitResponse<Map<String, Object>> getPreview(String url) {
        return UnitResponse.of(previewService.getPreview(url));
    }

    @GetMapping("/hello")
    public String getHello() {
        return previewService.getHello();
    }
}
