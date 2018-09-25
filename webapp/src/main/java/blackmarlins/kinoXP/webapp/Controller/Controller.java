package blackmarlins.kinoXP.webapp.Controller;




import blackmarlins.kinoXP.webapp.Model.Visning;
import blackmarlins.kinoXP.webapp.Repository.ShowingsData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    ShowingsData showingsData = new ShowingsData();

    public Controller() throws SQLException {
        if(showingsData==null){
            showingsData = new ShowingsData();
        }
    }

    @GetMapping(path = "/")
    public String index(){

//        Populate All Showings


    return "index";
    }

    @PostMapping(path = "/reseverside")
    public String searchForShowings(@RequestParam(name = "movie_id") Integer movie_id)
    {

//  ReadAll w/ Parameter Movie_ID

        return "reserverside";
    }





}
