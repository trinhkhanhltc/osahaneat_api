package com.khanhtt.osahaneat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.Set;
import lombok.Data;

@Data
@Entity(name = "restaurant")
public class Restaurant {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String title;
  private String subtitle;
  private String description;
  private String image;
  private boolean isFreeship;
  private String address;
  private Date openDate;
  @OneToMany(mappedBy = "restaurant")
  private Set<RatingRestaurant> listRatingRestaurant;
  @OneToMany(mappedBy = "restaurant")
  private Set<Orders> listOrders;
  @OneToMany(mappedBy = "restaurant")
  private Set<MenuRestaurant> listMenuRestaurant;
  @OneToMany(mappedBy = "restaurant")
  private Set<Promo> listPromo;
}
