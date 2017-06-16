package healthchecker.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by 1004w455 on 2017. 6. 16..
 */
@Data
@Entity
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 200)
    private String url;

}
