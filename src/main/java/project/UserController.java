package project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/rest", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @Autowired
    public void setUserRepository(UserRepository temp){
        userRepository = temp;
    }
    private UserRepository userRepository;

    @GetMapping("/api")
    public String test(){
        List<User> userList = userRepository.findAll();
        userList.forEach(System.out::print);

        return "user";
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<UserDTO>> getAll(){
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = userList.stream()
                .map(user -> {
                    UserDTO userDTO = new UserDTO(user);
                    return userDTO;
                })
                .collect(Collectors.toList());

        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    @GetMapping("/get-by-variable-id/{id}")
    public ResponseEntity<UserDTO> getByVariableId(@PathVariable Integer id) throws RuntimeException {
        final Optional<User> user = userRepository.findById(id);
        user.orElseThrow(() -> {
                    throw new RuntimeException("Failed to find user with id " + id);
                });
        final UserDTO userDTO = new UserDTO(user.get());
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping("/get-by-param-id")
    public ResponseEntity<UserDTO> getByParamId(@RequestParam Integer id) throws RuntimeException{
        Optional<User> user = userRepository.findById(id);
        user.orElseThrow(() -> {
            throw new RuntimeException("Failed to find user with id " + id);
        });
        final UserDTO userDTO = new UserDTO(user.get());
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}
