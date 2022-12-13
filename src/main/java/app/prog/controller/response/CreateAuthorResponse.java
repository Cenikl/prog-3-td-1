package app.prog.controller.response;

import app.prog.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class CreateAuthorResponse {
    private String name;
    private String particularity;
}
