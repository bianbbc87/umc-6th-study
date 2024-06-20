package umc.study.Ateam.web.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class MissionRequestDTO {
    private Integer reward;
    private LocalDate deadline;
    private String missionSpec;
}
