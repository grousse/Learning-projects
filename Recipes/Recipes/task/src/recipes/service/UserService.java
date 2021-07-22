package recipes.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import recipes.model.User;
import recipes.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) throws ResponseStatusException {
        if (emailExists(user.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        User userEntity = new User();
        BeanUtils.copyProperties(user, userEntity);
        encodePassword(userEntity,user);
        userRepository.save(userEntity);


    }
    private void encodePassword(User userEntity, User user){
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    private boolean emailExists(String email) {
        return userRepository.findUserByEmail(email).isPresent();
    }

}
