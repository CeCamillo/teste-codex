package org.example.backend.RectangleIntersection;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "intersection")
public class rectangleIntersection {

    @PostMapping
    public boolean intersectionCheck(@RequestBody String coordinates) {

        Rectangle rectA =
                Rectangle rectB =
                Rectangle rectC =


        if ((rect1.x1 <= rect2.x2) & (rect1.x2 >= rect2.x1) & (rect1.y1 <= rect2.y2) & (rect1.y2 >= rect2.y1)) {
            return true;
        } else {
            return false;
        }
    }
}