package vn.teachmaster.jobhunt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.teachmaster.jobhunt.model.Employer;
import vn.teachmaster.jobhunt.repository.ConcurrentHashMap;

import java.util.List;

@Controller
public class EmployerController {
    @Autowired
    private ConcurrentHashMap repo;

    @GetMapping("/employers")
    public String getEmployers(Model model) {
        model.addAttribute("empls", repo.getEmployers());
        return "employers";
    }

    @GetMapping("/formemployer")
    public String getFromEmployer(Model model) {
        model.addAttribute("employer", new Employer());
        model.addAttribute("result", null);
        return "formemployer";
    }

    @PostMapping("/formemployer")
    public String addEmployer(@ModelAttribute("employer") Employer request, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("result", "Xảy ra lỗi!");
        }else {
            model.addAttribute("result", "Thêm thàng công!");
            repo.addEmployers(request);
        }
        return "formemployer";
    }
}

