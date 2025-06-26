package com.khanhtt.osahaneat.entity;

import com.khanhtt.osahaneat.entity.keys.KeyOrderItem;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import lombok.Data;

@Data
@Entity(name = "order_item")
public class OrderItem {
  @EmbeddedId
  KeyOrderItem keys;
  @ManyToOne
  @JoinColumn(name = "order_id", insertable = false, updatable = false)
  private Orders orders;
  @ManyToOne
  @JoinColumn(name = "food_id", insertable = false, updatable = false)
  private Food food;
  private Date createDate;
}
