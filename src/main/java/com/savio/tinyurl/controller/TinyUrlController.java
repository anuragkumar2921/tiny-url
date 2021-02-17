package com.savio.tinyurl.controller;

import com.savio.tinyurl.dto.UrlResponseDto;
import com.savio.tinyurl.service.UrlService;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by anurag on 17/2/21.
 */
@Slf4j
@RestController
@RequestMapping(value = "/tinyurl")
public class TinyUrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("create/{input_url}")
    public ResponseEntity<UrlResponseDto> generateTinyUrl(@PathVariable(value = "input_url") @NotNull String inputUrl) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(urlService.generateTinyUrl(inputUrl));
    }

    @GetMapping("/{key}")
    public ResponseEntity<String> fetchToOriginalUrl(@PathVariable(value = "key") @NotNull String key, HttpServletResponse response) throws IOException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(urlService.fetchOriginalUrl(key));
    }
}
