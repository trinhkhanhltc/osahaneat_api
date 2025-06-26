package com.khanhtt.osahaneat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.Set;
import lombok.Data;

@Data
@Entity(name = "orders")
public class Orders {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private Users users;
  @ManyToOne
  @JoinColumn(name = "res_id")
  private Restaurant restaurant;
  private Date createDate;
  @OneToMany(mappedBy = "orders")
  private Set<OrderItem> listOrderItem;
}
