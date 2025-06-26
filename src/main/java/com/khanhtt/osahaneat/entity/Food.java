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
@Entity(name = "food")
public class Food {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String title;
  private String text;
  private String timeShip;
  private double price;
  @ManyToOne
  @JoinColumn(name = "cate_id")
  private Category category;
  @OneToMany(mappedBy = "food")
  private Set<RatingFood> listRatingFood;
  @OneToMany(mappedBy = "food")
  private Set<OrderItem> listOrderItem;
}
