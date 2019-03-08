package com.greenslate.codechallenge.userproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * Controller which handles request to the root of the Url path
 * This controller is not marked as RestController because it actually handles the construction of the
 * actual page that will be displayed, if needed we can also pass a model to the template engine (Thymeleaf in this case)
 * However for this exercise i will be handling all data requests needed in the view as AJAX requests in Javascript
 * @author Mario Segura Vargas
 *
 */
@Controller
public class UserProjectsViewController {
	/**
	 * This method is called when looking for the index page at the root of the URL Path, it returns a view name
	 * which Spring internally resolves and constructs using the index.html template I created, in this case there is no
	 * data used in the model because it was requested to handle data as async AJAX requests
	 * @param model This param is constructed by Spring and it represents the model that will be passed to the view
	 * @return name of the template needed in order to construct the requested view
	 */
	@GetMapping("/")
    public String index(Model model) {
        return "index";
    }
}
