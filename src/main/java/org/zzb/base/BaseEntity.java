package org.zzb.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.Date;

/**
 * Base entity.
 *
 */
@Data
@ToString
@EqualsAndHashCode
public class BaseEntity {

    /**
     * Create time.
     */
    private Date createTime;

    /**
     * Update time.
     */
    private Date updateTime;


}
