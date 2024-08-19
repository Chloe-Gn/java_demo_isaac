package eni.demo.demo.module4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("chocolatine")
    public String chocolatine() {

        return "todo";
    }
}
