package net.seehope.foodie.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`uuid_user`")
public class UuidUser implements Serializable {
    @Id
    @Column(name = "`uuid_id`")
    private String uuidId;

    @Column(name = "`uuid_detail`")
    private String uuidDetail;

    private static final long serialVersionUID = 1L;

    /**
     * @return uuid_id
     */
    public String getUuidId() {
        return uuidId;
    }

    /**
     * @param uuidId
     */
    public void setUuidId(String uuidId) {
        this.uuidId = uuidId;
    }

    /**
     * @return uuid_detail
     */
    public String getUuidDetail() {
        return uuidDetail;
    }

    /**
     * @param uuidDetail
     */
    public void setUuidDetail(String uuidDetail) {
        this.uuidDetail = uuidDetail;
    }
}