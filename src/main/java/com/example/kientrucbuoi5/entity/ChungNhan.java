package com.example.kientrucbuoi5.entity;

import jdk.jfr.Enabled;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Enabled
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "chungnhan")
@IdClass(com.example.kientrucbuoi5.entity.ChungNhanPK.class)
public class ChungNhan implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "manv", columnDefinition = "varchar(10)")
    public com.example.kientrucbuoi5.entity.NhanVien MaNV;

    @Id
    @ManyToOne
    @JoinColumn(name = "mamb", columnDefinition = "int")
    public com.example.kientrucbuoi5.entity.MayBay MaMB;
}
