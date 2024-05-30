package umc.study.Ateam.domain;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.*;
import umc.study.Ateam.domain.common.BaseEntity;
import umc.study.Ateam.domain.mapping.MemberAgree;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Terms extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String body;

    private Boolean optional;

    @OneToMany(mappedBy = "terms", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();
}