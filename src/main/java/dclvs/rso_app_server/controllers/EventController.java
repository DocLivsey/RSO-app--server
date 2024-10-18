package dclvs.rso_app_server.controllers;

import dclvs.rso_app_server.Constants;
import dclvs.rso_app_server.entities.Event;
import dclvs.rso_app_server.services.EventService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.NoSuchObjectException;
import java.util.Calendar;
import java.util.List;
import java.util.function.Supplier;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    @GetMapping("/all")
    public ResponseEntity<?> allEventsAtDate(@RequestParam Calendar date) {
        try {
            List<Event> events = eventService
                    .findAllEventsByDate(date)
                    .orElseThrow(
                            (Supplier<Throwable>) () -> new NoSuchObjectException(
                                    STR."\{Constants.ERROR}There are no events on this date: \{date}\{Constants.RESET}"
                            )
                    );
            return ResponseEntity.ok(events);
        } catch (NoSuchObjectException exception) {
            return ResponseEntity.badRequest().body(exception);
        } catch (Throwable exception) {
            return ResponseEntity.internalServerError().body(exception);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEvent(@RequestBody Event event) {
        try {
            eventService.createNewEvent(event);
            return ResponseEntity.ok().build();
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().body(exception);
        }
    }

    @DeleteMapping("remove")
    public ResponseEntity<?> removeEvent(@RequestParam Long eventId) {
        try {
            eventService.removeEvent(eventId);
            return ResponseEntity.ok().build();
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().body(exception);
        }
    }

}
