package aug.mvcapp.controllers;



import aug.mvcapp.models.Content;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import aug.mvcapp.DAO.ContentDAO;


@Controller
@RequestMapping("/tfpage")
public class ContentsController {
    private final ContentDAO contentDAO;

    public ContentsController(ContentDAO contentDAO) {
        this.contentDAO = contentDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("weapons", contentDAO.index());
        return "tfpage/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("content", contentDAO.show(id));
        return "tfpage/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("content") Content content) {
        return "tfpage/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("content") @Valid Content content,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "tfpage/new";

        contentDAO.save(content);
        return "redirect:/tfpage";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("content", contentDAO.show(id));
        return "tfpage/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("content") @Valid Content content, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "tfpage/edit";

        contentDAO.update(id, content);
        return "redirect:/tfpage";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        contentDAO.delete(id);
        return "redirect:/tfpage";
    }

}
