package org.example.backend.RestServer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "WorldClock")
public class WorldClockController {

    @ResponseBody
    @GetMapping
    public LocalDateTime currentDateTime() {
        return LocalDateTime.now();
    }
}
