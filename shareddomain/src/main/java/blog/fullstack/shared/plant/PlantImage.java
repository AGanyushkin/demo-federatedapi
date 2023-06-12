package blog.fullstack.shared.plant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlantImage {
    private UUID id;
    private int width;
    private int height;
    private String url;
}
