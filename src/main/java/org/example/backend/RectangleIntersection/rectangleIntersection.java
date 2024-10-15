package org.example.backend.RectangleIntersection;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "rectangles")
public class rectangleIntersection {

    @PostMapping(value = "intersection")
    public boolean intersectionCheck(@RequestBody Rectangles rectangle) {

        int[] rectA = rectangle.getRectA();
        int[] rectB = rectangle.getRectB();

        if ((rectA[2] > rectB[0] && rectA[3] > rectB[1]) && (rectA[0] < rectB[2] && rectA[1] < rectB[3])) {
            return true;
        }
        return false;
    }
}