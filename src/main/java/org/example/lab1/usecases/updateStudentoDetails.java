package org.example.lab1.usecases;

import lombok.Getter;
import lombok.Setter;
import org.example.lab1.entities.PasirenkamasisDalykas;
import org.example.lab1.entities.Studentas;
import org.example.lab1.interceptors.LoggedInvocation;
import org.example.lab1.persistence.PasirenkamasisDalykasDAO;
import org.example.lab1.persistence.StudentasDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class updateStudentoDetails implements Serializable {

    private Studentas studentas;
    private Integer pridedamasPasirenkamasisDalykasId;

    @Inject
    private StudentasDAO studentasDAO;

    @Inject
    private PasirenkamasisDalykasDAO pasirenkamasisDalykasDAO;

    @PostConstruct
    private void init() {
        System.out.println("updateStudentoDetails INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer studentoId = Integer.parseInt(requestParameters.get("studentoId"));
        this.studentas = studentasDAO.findOne(studentoId);
    }

    @Transactional
    @LoggedInvocation
    public String pridetiPasirenkamajiDalykaStudentui() {
        System.out.println("bandom pridet PasirenkamajiDalykaStudentui");
        try{
            PasirenkamasisDalykas pasirenkamasisDalykas = pasirenkamasisDalykasDAO.findOne(pridedamasPasirenkamasisDalykasId);
            studentas.getPasirenkamiejiDalykai().add(pasirenkamasisDalykas);
            studentasDAO.update(studentas);
        } catch (OptimisticLockException e) {
            return "/pasirenkamiejiDalykai.xhtml?faces-redirect=true&studentoId=" + this.studentas.getId() + "&error=optimistic-lock-exception";
        }
        return "pasirenkamiejiDalykai.xhtml?studentoId=" + this.studentas.getId() + "&faces-redirect=true";
    }
}
