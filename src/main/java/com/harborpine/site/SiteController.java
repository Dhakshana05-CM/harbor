package com.harborpine.site;

import jakarta.validation.Valid;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SiteController {

    private static final Logger log = LoggerFactory.getLogger(SiteController.class);

    /** Edit this list to change the services shown on the page. */
    private static final List<Service> SERVICES = List.of(
        new Service("Process review",
            "We map how work moves through your team and find where it stalls. You get a written report in two weeks."),
        new Service("Systems selection",
            "We compare software options against your real workflows and help you choose one you will still like in three years."),
        new Service("Team coaching",
            "Weekly sessions with your managers to put the new process into daily practice.")
    );

    public record Service(String title, String description) {}

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("services", SERVICES);
        model.addAttribute("contactForm", new ContactForm());
        return "index";
    }

    @PostMapping("/contact")
    public String contact(@Valid @ModelAttribute("contactForm") ContactForm form,
                          BindingResult result,
                          Model model,
                          RedirectAttributes redirect) {
        if (result.hasErrors()) {
            model.addAttribute("services", SERVICES);
            return "index";
        }
        // Replace this log line with an email service or database save.
        log.info("New enquiry from {} <{}>: {}", form.getName(), form.getEmail(), form.getMessage());
        redirect.addFlashAttribute("sent", true);
        return "redirect:/#contact";
    }
}
