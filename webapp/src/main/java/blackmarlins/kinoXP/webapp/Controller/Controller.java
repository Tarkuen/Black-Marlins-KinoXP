package blackmarlins.kinoXP.webapp.Controller;




import blackmarlins.kinoXP.webapp.Repository.DataConnection;
import blackmarlins.kinoXP.webapp.Repository.ShowingsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.SQLException;

@org.springframework.stereotype.Controller
public class Controller {


    @GetMapping(path = "/")
    public String index() throws SQLException {
        return "Test";
    }

    @PostMapping(path = "/reseverside")
    public String searchForShowings(@RequestParam(name = "movie_id") Integer movie_id)
    {

//  ReadAll w/ Parameter Movie_ID

        return "reserverside";
    }





}
