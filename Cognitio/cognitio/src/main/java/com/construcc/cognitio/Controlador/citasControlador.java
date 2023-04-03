package com.construcc.cognitio.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.construcc.cognitio.Logica.CitaServ;
import com.construcc.cognitio.Logica.ClienteServ;
import com.construcc.cognitio.Logica.EstadocitaServ;
import com.construcc.cognitio.Logica.TipocitaServ;
import com.construcc.cognitio.Logica.UsuarioServ;
import com.construcc.cognitio.Persistencia.Entidades.Cita;

@Controller
public class citasControlador {
    
    @Autowired
    private UsuarioServ usuarioServ;
    @Autowired
    private ClienteServ clienteServ;
    @Autowired
    private CitaServ citaServ;
    @Autowired
    private EstadocitaServ estadocita;
    @Autowired
    private TipocitaServ tipocitaServ;

    @GetMapping("/verCitas")
    public String verCitas(Model model){
        Cita nuevaCita = new Cita();
        
        model.addAttribute("listaClientes", clienteServ.verClientes());
        model.addAttribute("listaUsuarios", usuarioServ.verUsuarios());
        model.addAttribute("listaCitas", citaServ.verCitas());
        model.addAttribute("nuevaCita", nuevaCita);
        model.addAttribute("listaEstadocita", estadocita.verEstadocitas());
        model.addAttribute("listaTipoCita", tipocitaServ.verTipocitas());
        return "citas";
    }

    @PostMapping("/agendarCita")
    public String agregarCitas(@ModelAttribute("nuevaCita") Cita cita ){

        return "redirect:/verCitas";
    }

}
