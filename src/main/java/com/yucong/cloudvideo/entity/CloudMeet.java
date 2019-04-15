package com.yucong.cloudvideo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vwt_cloud_meet")
public class CloudMeet implements Serializable {

    private static final long serialVersionUID = 3536855375264200130L;

    /** 主键 */
    /** 会议id，由第三方提供 */
    @Id
    private String id;

    /** 开会人员 */
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "meetId")
    private List<MeetMember> meetMembers;

    /** 会议创建人，关联CloudPower中的userId */
    @Column(name = "creator_id")
    private String creatorId;

    /** 企会议类型：1即时会议，2预约会议 */
    @Column(name = "meet_type")
    private String meetType;

    /** 预约时间 */
    @Column(name = "order_time")
    private Date orderTime;

    /** 预约会议是否发出通知：0未通知，1已通知 */
    @Column(name = "status")
    private String status;

    /** 创建时间 */
    @Column(name = "create_time")
    private Date createTime;
}