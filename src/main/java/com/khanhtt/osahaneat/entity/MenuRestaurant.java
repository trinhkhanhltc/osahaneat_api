package com.khanhtt.osahaneat.entity;

import com.khanhtt.osahaneat.entity.keys.KeyMenuRestaurant;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import lombok.Data;

@Data
@Entity(name = "menu_restaurant")
public class MenuRestaurant {
  @EmbeddedId
  KeyMenuRestaurant keys;
  @ManyToOne
  @JoinColumn(name = "cate_id", insertable = false, updatable = false)
  private Category category;
  @ManyToOne
  @JoinColumn(name = "res_id", insertable = false, updatable = false)
  private Restaurant restaurant;
  private Date createDate;
}
