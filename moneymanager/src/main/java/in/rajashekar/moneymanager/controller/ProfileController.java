package in.rajashekar.moneymanager.controller;

import in.rajashekar.moneymanager.dto.ProfileDTO;
import in.rajashekar.moneymanager.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @PostMapping("/register")
    public ResponseEntity<ProfileDTO> registeredProfile(@RequestBody ProfileDTO profileDTO){
        ProfileDTO registeredProfile=profileService.registeredProfile(profileDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredProfile);
    }

    @GetMapping("/active")
    public ResponseEntity<String> activateProfile(String token){
        boolean isActivated=profileService.activateProfile(token);

        if (isActivated){
            return ResponseEntity.ok("activated");

        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("activation token not found");
        }
    }

}
