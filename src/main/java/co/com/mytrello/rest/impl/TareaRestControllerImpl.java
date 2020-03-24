package co.com.mytrello.rest.impl;

import co.com.mytrello.repository.domain.Lista;
import co.com.mytrello.repository.domain.Tarea;
import co.com.mytrello.rest.TareaRestController;
import co.com.mytrello.service.ListaService;
import co.com.mytrello.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tareas")
public class TareaRestControllerImpl implements TareaRestController {

    @Autowired
    private ListaService listaService;

    @Autowired
    private TareaService tareaService;

    @GetMapping
    @Override
    public ResponseEntity findAll(@PathVariable("listaId") Long listaId) {
        if (listaService.exists(listaId)){
            return ResponseEntity.ok(tareaService.findByListaId(listaId));
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("El objeto lista no existe");
    }

    @PostMapping
    public ResponseEntity save(@Validated @RequestBody Tarea tarea, BindingResult result, @PathVariable("listaId") Long listaId){
        if (listaService.exists(listaId)){
            Lista lista = new Lista();
            lista.setId(listaId);
            tarea.setLista(lista);
            return ResponseEntity.ok(tareaService.save(tarea));
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("El objeto lista no existe");
    }

    //Crear resto de metodos
}
