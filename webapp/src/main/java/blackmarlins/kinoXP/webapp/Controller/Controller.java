package blackmarlins.kinoXP.webapp.Controller;


import blackmarlins.kinoXP.webapp.Model.Reservation;
import blackmarlins.kinoXP.webapp.Model.Visning;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping(path = "/")
    public String index(){
        List<Visning> showingsList = new ArrayList<>();


    return "index";
    }



}
