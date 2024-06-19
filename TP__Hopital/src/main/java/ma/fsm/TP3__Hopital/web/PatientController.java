package ma.fsm.TP3__Hopital.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.fsm.TP3__Hopital.entities.Patient;
import ma.fsm.TP3__Hopital.repositories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping(path = "/index")
    public String patients(Model model,
                           @RequestParam(name="page",defaultValue = "0") int page,
                           @RequestParam(name="size",defaultValue = "4") int size,
                           @RequestParam(name="keyword",defaultValue = "") String keyword
    ){
        Page<Patient> pagePatients = patientRepository.findByNomContains(keyword, PageRequest.of(page,size));
        model.addAttribute("listPatients", pagePatients.getContent());
        model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword", keyword);
        return "patients";
    }

    @GetMapping("/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String delete(@RequestParam(name = "id")Long id,
                         @RequestParam(name = "keyword",defaultValue = "") String keyword,
                         @RequestParam(name = "page",defaultValue = "0") int page ){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;

    }

    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }

    @GetMapping(path = "/patients")
    @ResponseBody
    public List<Patient> listPatients(){
        return patientRepository.findAll();
    }
    @GetMapping(path = "/formPatients")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String formPatients(Model model){
        model.addAttribute("patient",new Patient());
        return  "formPatients";
    }
    @PostMapping(path = "/save")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String save(Model model,
                       @Valid Patient patient, BindingResult bindingResult , @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = " ")String keyword){
        if(bindingResult.hasErrors()) return "formPatients" ;
        patientRepository.save(patient);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }


    @GetMapping(path = "/editPatient")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editPatient( Model model, Long id, String keyword, int page){
        Patient patient=patientRepository.getReferenceById(id);
        if (patient == null) throw new RuntimeException("Patient introuvable");
        model.addAttribute("patient",patient);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword", keyword);
        return  "editPatient";
    }

//    @PostMapping(path = "/profil")
//    @PreAuthorize("hasRole({'ROLE_ADMIN' , 'ROLE_USER'})")
//    public String profil( Model model,@RequestParam(value = "pation_id" ) Long pation_id){
//      Patient patient=patientRepository.getReferenceById(pation_id);
//        if (patient == null) throw new RuntimeException("Patient introuvable");
//        model.addAttribute("patient",patient);
//        return  "profil";
//    }

}
