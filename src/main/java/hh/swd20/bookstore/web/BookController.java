package hh.swd20.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

import hh.swd20.bookstore.domain.Book;

@Controller
public class BookController {

	// http://localhost:8080/index
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getIndex(Model model) {
		model.addAttribute("book", new Book());
		return "index";
	}
}
