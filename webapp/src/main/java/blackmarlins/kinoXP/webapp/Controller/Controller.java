package blackmarlins.kinoXP.webapp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {


    @GetMapping(path = "/")
    public String index() {

//        Populate All Showings

        return "index";
    }

    @PostMapping(path = "/reseverside")
    public String searchForShowings(@RequestParam(name = "movie_id") Integer movie_id) {

//  ReadAll w/ Parameter Movie_ID

        return "reserverside";
    }
}

