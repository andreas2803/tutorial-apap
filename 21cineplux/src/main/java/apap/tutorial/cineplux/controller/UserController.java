package apap.tutorial.cineplux.controller;
import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.RoleModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.service.RoleService;
import apap.tutorial.cineplux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/add")
    private String addUserFormPage(Model model){
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.getListRole();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user" ;
    }

    @PostMapping(value = "/add")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model) {
        userService.addUser (user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping("/viewall")
    private String viewAllUser(Model model){
        List<UserModel> listUser = userService.getUserList();
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.GET)
    private String updatePasswordForm(Model model){
        model.addAttribute("teks", "");
        return "form-update-password";
    }

    @GetMapping("/user/delete/{username}")
    public String deleteUser(@PathVariable String username, Model model) {
        UserModel user = userService.getUserByUsername(username);
        userService.deleteUser(user);
        model.addAttribute("user", user);
        return "delete-user";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    private String updatePasswordSubmit(@RequestParam String oldPass, String newPass, String confirmPass, String username, Model model){
        UserModel user = userService.getUserByUsername(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(oldPass, user.getPassword())){
            if(newPass.equals(confirmPass)){
                userService.updatePassword(user, newPass);
                model.addAttribute("teks","Password berhasil diubah");
            }
            else{
                model.addAttribute("teks", "Password baru tidak sesuai");
            }
        }
        else{
            model.addAttribute("teks", "Password lama salah");
        }
        return "form-update-password";
    }
}