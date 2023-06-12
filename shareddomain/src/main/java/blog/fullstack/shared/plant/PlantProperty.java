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
public class PlantProperty {
    private UUID id;
    private String name;
    private PropertyType type;
    private String value;

    public enum PropertyType {
        HEIGHT,
        COLOR
    }
}
