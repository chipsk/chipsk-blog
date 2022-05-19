import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Abraham
 * @since 2021-05-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("advisory")
public class OAdvisory implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @JsonProperty(value = "uId")
    private Long uId;

    @JsonProperty(value = "eId")
    private Long eId;

    private String message;

    public OAdvisory(Long id, Long uId, Long eId, String message) {
        this.id = id;
        this.uId = uId;
        this.eId = eId;
        this.message = message;
    }
}
