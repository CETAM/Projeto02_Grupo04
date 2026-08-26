package cetam.projeto02grupo04.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String dashboard() {
        return "dashboard";
    }
}


