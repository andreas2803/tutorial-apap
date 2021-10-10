package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.FilmModel;
import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.service.BioskopService;
import apap.tutorial.cineplux.service.FilmService;
import apap.tutorial.cineplux.service.FilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
public class BioskopController {

    @Qualifier("filmServiceImpl")
    @Autowired
    private FilmService filmService;

    @Qualifier("bioskopServiceImpl")
    @Autowired
    private BioskopService bioskopService;

    @GetMapping("/bioskop/add")
    public String addBioskopForm(Model model) {
        FilmModel film = new FilmModel();
        BioskopModel bioskop = new BioskopModel();
        ArrayList<FilmModel> existingListFilm = (ArrayList<FilmModel>) filmService.getListFilm();
        ArrayList<FilmModel> listFilm = new ArrayList<FilmModel>();
        listFilm.add(new FilmModel());
        bioskop.setListFilm(listFilm);
        model.addAttribute("bioskop", bioskop);
        model.addAttribute("film", film);
        model.addAttribute("existingListFilm",existingListFilm);
        model.addAttribute("listFilm", listFilm);
        return "form-add-bioskop";
    }

    @PostMapping(value="/bioskop/add", params={"addRow"})
    public String addRow(
        @ModelAttribute BioskopModel bioskop,
        BindingResult bindingResult,
        Model model
    ) {
        if (bioskop.getListFilm() == null) {
            bioskop.setListFilm(new ArrayList<FilmModel>());
        }
        ArrayList<FilmModel> existingFilm = (ArrayList<FilmModel>) filmService.getListFilm();
        bioskop.getListFilm().add(new FilmModel());
        model.addAttribute("bioskop", bioskop);
        model.addAttribute("existingFilm", existingFilm);
        return "form-add-bioskop";
    }

    @PostMapping(value="/bioskop/add", params={"removeRow"})
    public String removeRow(@ModelAttribute BioskopModel bioskop, final BindingResult bindingResult,
                            final HttpServletRequest req, Model model){
    final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
    bioskop.getListFilm().remove(rowId.intValue());

    model.addAttribute("bioskop", bioskop);
    return "form-add-bioskop";
    }

    @RequestMapping(value="/bioskop/add", method= RequestMethod.POST, params = {"save"})
    public String addBioskopSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ){
        bioskopService.addBioskop(bioskop);
        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        return "add-bioskop";
    }

    @GetMapping("bioskop/viewall")
    public String listBioskop(Model model) {
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();
        model.addAttribute("listBioskop", listBioskop);
        return "viewall-bioskop";
    }

    @GetMapping("/bioskop/view")
    public String viewDetailBioskop(
            @RequestParam(value = "noBioskop") Long noBioskop,
            Model model
    ){
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        List<PenjagaModel> listPenjaga = bioskop.getListPenjaga();
        List<FilmModel> listFilm = bioskop.getListFilm();

        model.addAttribute("bioskop", bioskop);
        model.addAttribute("listPenjaga", listPenjaga);
        model.addAttribute("listFilm", listFilm);

        return "view-bioskop";
    }

    @GetMapping("/bioskop/update/{noBioskop}")
    public String updateBioskopForm(
            @PathVariable Long noBioskop,
            Model model
    ){
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        model.addAttribute("bioskop", bioskop);
        return "form-update-bioskop";
    }

    @PostMapping("/bioskop/update")
    public String updateBioskopSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ) {
        bioskopService.updateBioskop(bioskop);
        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        return "update-bioskop";
    }

}

