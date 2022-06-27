package com.github.akkashi.onlinedbviewer.controller;

import com.github.akkashi.onlinedbviewer.OnlineDbViewerApplication;
import com.github.akkashi.onlinedbviewer.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

	@Autowired
	private OnlineDbViewerApplication app;

	@RequestMapping(value = {"/countries"}, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("countries", this.app.getViewer().getCountries());

		return "countries";
	}
}