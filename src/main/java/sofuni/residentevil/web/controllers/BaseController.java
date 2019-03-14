package sofuni.residentevil.web.controllers;

import org.springframework.web.servlet.ModelAndView;

public abstract class BaseController {

    protected ModelAndView view(String view, ModelAndView modelandView){
        modelandView.setViewName(view);

        return modelandView;
    }

    protected ModelAndView view(String view){

        return this.view(view, new ModelAndView());
    }

    protected ModelAndView redirect(String url){

        return this.view("redirect:" + url);
    }
}
