package com.khanhtt.osahaneat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "rating_restaurant")
public class RatingRestaurant {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private Users users;
  @ManyToOne
  @JoinColumn(name = "res_id")
  private Restaurant restaurant;
  private String content;
  private int ratePoint;

}
