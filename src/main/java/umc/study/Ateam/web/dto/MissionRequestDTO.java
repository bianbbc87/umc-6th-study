package umc.study.Ateam.web.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MissionRequestDTO {
    private Integer reward;
    private LocalDate deadline;
    private String missionSpec;
}
