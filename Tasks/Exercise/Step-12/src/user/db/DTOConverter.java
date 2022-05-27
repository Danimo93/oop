package user.db;

import user.User;

public class DTOConverter {

    public static User parseUserDTO(UserDTO dto) {
        User newUser = new User();
        newUser.setUserId(dto.id);
        newUser.setPersonnummer(Long.parseLong(dto.personnummer));
        newUser.setName(dto.name);
        newUser.setDateOfBirth(dto.dob);
        newUser.setPrimaryCampus(dto.campus);

        return newUser;
    }
}
