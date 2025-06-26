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
@Entity(name = "users")
public class Users {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String userName;
  private String password;
  private String fullname;
  private Date createDate;
  @ManyToOne
  @JoinColumn(name = "role_id")
  private Roles roles;
  @OneToMany(mappedBy = "users")
  private Set<RatingFood> listRatingFood;
  @OneToMany(mappedBy = "users")
  private Set<RatingRestaurant> listRatingRestaurant;
  @OneToMany(mappedBy = "users")
  private Set<Orders> listOrders;
}
