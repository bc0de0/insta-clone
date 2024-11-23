package com.careerinsta.insta_clone.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDTO {

    private String name;
    private String id;
    private String username;
    private String email;
    private String bioImage;
    private String bio;

}
