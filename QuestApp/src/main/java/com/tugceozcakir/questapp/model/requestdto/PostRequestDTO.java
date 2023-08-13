package com.tugceozcakir.questapp.model.requestdto;

import lombok.Data;

@Data
public class PostRequestDTO {
    Long id;
    String title;
    String text;
    Long userId;
}
