package kz.tezdet.controllers;

import kz.tezdet.domains.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Locale;

@Controller
public class MainController {

    @Autowired
    private MessageSource messageSource ;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "index" ;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@ModelAttribute("user") User user){

        return "login" ;
    }

    @RequestMapping(value = "/check-user", method = RequestMethod.POST)
    public String checkUser(@Valid @ModelAttribute("user")User user,
                                  BindingResult result, Model model,
                            Locale locale){
        if(result.hasErrors())
            return "login" ;

        model.addAttribute("user", user) ;
        model.addAttribute("local", messageSource.getMessage("local", new String[]{locale.getDisplayName(locale)}, locale)) ;

        return "main" ;
    }

    @RequestMapping(value = "/get-json1", method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity<User> getJson1(@RequestParam("name")String name){
        User user = new User() ;
        user.setName(name);
        return new ResponseEntity<User>(user, HttpStatus.OK) ;

    }

    @RequestMapping(value = "/get-json2", method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public User getJson2(@RequestParam("name")String name){
        User user = new User() ;
        user.setName(name);
        return user ;
    }

    @RequestMapping(value = "/get-json3", method = RequestMethod.GET,
            produces = "application/xml")
    @ResponseBody
    public User getJson3(@RequestParam("name")String name){
        User user = new User() ;
        user.setName(name);
        return user ;
    }

    @RequestMapping(value = "/put-json1", method = RequestMethod.POST,
        consumes = "application/json")
    public ResponseEntity<Void> putJson1(@RequestBody User user){
        System.out.println(user.getName());
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED) ;
    }

    @RequestMapping(value = "/put-json2", method = RequestMethod.POST,
            consumes = "application/xml")
    public ResponseEntity<Void> putJson2(@RequestBody User user){
        System.out.println(user.getName());
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED) ;
    }
}
