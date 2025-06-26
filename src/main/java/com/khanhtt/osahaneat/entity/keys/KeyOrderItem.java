package com.khanhtt.osahaneat.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class KeyOrderItem implements Serializable {
  @Column(name = "order_id")
  private int orderId;
  @Column(name = "food_id")
  private int foodId;
}
