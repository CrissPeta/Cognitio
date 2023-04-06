package com.construcc.cognitio.Controlador;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.construcc.cognitio.Logica.CitaServ;
import com.construcc.cognitio.Logica.ClienteServ;
import com.construcc.cognitio.Logica.EstadocitaServ;
import com.construcc.cognitio.Logica.TipocitaServ;
import com.construcc.cognitio.Logica.UsuarioServ;
import com.construcc.cognitio.Persistencia.Entidades.Cita;
import com.construcc.cognitio.Persistencia.Entidades.Cliente;
import com.construcc.cognitio.Persistencia.Entidades.Estadocita;
import com.construcc.cognitio.Persistencia.Entidades.Tipocita;
import com.construcc.cognitio.Persistencia.Entidades.Usuario;

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
    public String verCitas(Model model) {
        Cita nuevaCita = new Cita();

        model.addAttribute("listaClientes", clienteServ.verClientes());
        model.addAttribute("listaUsuarios", usuarioServ.verUsuarios());
        model.addAttribute("listaCitas", citaServ.verCitas());
        model.addAttribute("nuevaCita", nuevaCita);
        model.addAttribute("listaEstadocita", estadocita.verEstadocitas());
        model.addAttribute("listaTipoCita", tipocitaServ.verTipocitas());
        return "citas";
    }

    @PostMapping(value = "/agendarCita")
    public String agregarCitas(@RequestParam("fecha") Date fecha,
    @RequestParam("observacion") String observacion,
    @RequestParam("cliente") Cliente cliente,
    @RequestParam("estadoCita") Estadocita estadocita,
    @RequestParam("tipoCita") Tipocita tipocita,
    @RequestParam("usuario") Usuario usuario) {
        
        String url = "";
        try {
            Timestamp timestamp = new Timestamp(fecha.getTime());
            Cita nuevCita = new Cita(timestamp,observacion,cliente,estadocita,tipocita,usuario);

            citaServ.guardar(nuevCita);
            url += "?exito";
        } catch (Exception e) {
            url += "?error";
        }

        
        return "redirect:/verCitas" + url;
    }

    /*
     * @GetMapping (value = "/HacerCita")
     * public String hacerCita(Model model){
     * Cita cita = new Cita();
     * List<NewCita> newCita = new ArrayList<>();
     * model.addAttribute("ListarCita", cita)
     * }
     */
}
