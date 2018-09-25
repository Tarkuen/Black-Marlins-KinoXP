package blackmarlins.kinoXP.webapp.Controller;


import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping(path = "/")
    public String index(){


    return "index";
    }

}
