package umc.study.Ateam.web.dto;

import lombok.Data;

@Data
public class ReviewRequestDTO {
    private String title;
    private Float score;
    private String body;
    private Long memberId;
}
