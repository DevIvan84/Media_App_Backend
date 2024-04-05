package com.hospital.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

@RestController
@RequestMapping("/languages")
@RequiredArgsConstructor
public class LanguageController {

    private final LocaleResolver localeResolver;
    private final HttpServletRequest httpServletRequest;
    private final HttpServletResponse httpServletResponse;


    @GetMapping("/locale/{loc}")
    public ResponseEntity<Void> changeLocale(@PathVariable("loc") String loc) {
        Locale userLocale = switch (loc) {
            case "es", "us" -> Locale.ENGLISH;
            case "fr" -> Locale.FRENCH;
            default -> Locale.ROOT;
        };

        localeResolver.setLocale(httpServletRequest,httpServletResponse,userLocale);

        return ResponseEntity.ok().build();
    }
}
