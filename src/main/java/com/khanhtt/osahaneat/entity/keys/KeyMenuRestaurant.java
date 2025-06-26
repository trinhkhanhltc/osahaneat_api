package com.khanhtt.osahaneat.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Data
public class KeyMenuRestaurant implements Serializable {
  @Column(name = "cate_id")
  private int cateId;
  @Column(name = "res_id")
  private int resId;
  public KeyMenuRestaurant(int cateId, int resId)
  {
    this.cateId = cateId;
    this.resId = resId;
  }
}
